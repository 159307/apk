package utils.activity;



import java.io.*;
import java.util.*;
import java.util.zip.*;
public class b
 {
  public static void zip ( File inputFile, String zipFileName )
   {
    try
     {
// 创建文件输出对象out,提示:注意中文支持
      FileOutputStream out = new FileOutputStream ( new String ( zipFileName.getBytes ( "UTF-8" ) ) );
// 將文件輸出ZIP输出流接起来
      ZipOutputStream zOut = new ZipOutputStream ( out );
      System.out.println ( "压缩-->开始" );

      zip ( zOut, inputFile, "" );

      System.out.println ( "压缩-->结束" );
      zOut.close ( );

     }
    catch (Exception e)
     {
      e.printStackTrace ( );
     }
   }

  public static void zip ( ZipOutputStream zOut, File file, String base )
   {
    try
     {
// 如果文件句柄是目录
      if ( file.isDirectory ( ) )
       {
// 获取目录下的文件
        File[] listFiles = file.listFiles ( );
// 建立ZIP条目
        zOut.putNextEntry ( new ZipEntry ( base + "/" ) );
        System.out.println ( "目录名:" + file.getName ( ) + "|加入ZIP条目:" + base
                            + "/" );

        base = ( base.length ( ) == 0 ? "" : base + "/" );

// 遍历目录下文件
        for ( int i = 0; i < listFiles.length; i++ )
         {
// 递归进入本方法
          zip ( zOut, listFiles [ i ], base + listFiles [ i ].getName ( ) );
         }
       }
// 如果文件句柄是文件
      else
       {
        if ( base == "" )
         {
          base = file.getName ( );
         }
// 填入文件句柄
        zOut.putNextEntry ( new ZipEntry ( base ) );
        System.out.println ( "文件名:" + file.getName ( ) + "|加入ZIP条目:" + base );

// 开始压缩
// 从文件入流读,写入ZIP 出流
        writeFile ( zOut, file );
       }
     }
    catch (Exception e)
     {
      e.printStackTrace ( );
     }
   }
  public static void writeFile ( ZipOutputStream zOut, File file )
   {
    System.out.println ( "开始压缩" + file.getName ( ) );
    FileInputStream in = null;
    try
     {
      in = new FileInputStream ( file );
      int len;
      while ( ( len = in.read ( ) ) != -1 )
       {
        zOut.write ( len );
       }
      System.out.println ( "压缩结束" + file.getName ( ) );
     }
    catch (FileNotFoundException e)
     {
      e.printStackTrace ( );
     }
    catch (IOException e)
     {
      e.printStackTrace ( );
     }
    finally
     {
      try
       {
        if ( in != null )
         {
          in.close ( );
         }
       }
      catch (IOException e)
       {
        e.printStackTrace ( );
       }
     }
   }



 }
    
