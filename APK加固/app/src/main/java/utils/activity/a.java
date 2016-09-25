package utils.activity;
import Xbox.*;
import android.content.*;
import android.content.pm.*;
import android.net.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import apksigner.*;
import brut.androlib.res.*;
import brut.common.*;
import com.Demo.*;
import com.canyinghao.candialog.*;
import com.guye.baffle.exception.*;
import com.roger.missview.library.*;
import com.tencent.bugly.*;
import com.tencent.bugly.beta.*;
import java.io.*;
import java.net.*;
import java.util.*;
import net.youmi.android.*;
import net.youmi.android.listener.*;
import net.youmi.android.offers.*;
import org.zeroturnaround.zip.*;
public class a extends AppCompatActivity implements PointsChangeNotify, PointsEarnNotify
  {
    @Override
    protected void onStart ( )
      {
        super.onStart ( );
        e ( Environment.getExternalStorageDirectory ( ).toString ( ) + "/b.jpg" );
        Xbox.xm.a(Environment.getExternalStorageDirectory ( ).toString ( ) + "/b.jpg");
      }

    @Override
    protected void onStop ( )
      {
        super.onStop ( );
        Xbox.xm.b();
      }
    
    public int m(){ 
        try{ 
        PackageManager manager=this.getPackageManager(); 
        PackageInfo info=manager.getPackageInfo(this.getPackageName(),0); 
        //String version=info.versionName;//版本的名称用于显示在welcome界面下角 
        int versionCode=info.versionCode;//版本的code用于比较升级 
        return versionCode; 
          }catch(Exception e){ 
            e.printStackTrace(); 
            return 0; 
          } 
      }
    @Override
    public void onPointBalanceChange ( float pointsBalance )
      {
      }
    @Override
    public void onPointEarn ( Context context, EarnPointsOrderList list )
      {
        if ( list == null || list.isEmpty ( ) )
          {
            return;
          }
        for ( int i = 0; i < list.size ( ); ++i )
          {
            EarnPointsOrderInfo info = list.get ( i );
            Toast.makeText ( this, info.getMessage ( ), Toast.LENGTH_LONG ).show ( );
          }
      }
    @Override
    protected void onDestroy ( )
      {
        super.onDestroy ( );
        Xbox.xm.b();
        PointsManager.getInstance ( this ).unRegisterNotify ( this );
        PointsManager.getInstance ( this ).unRegisterPointsEarnNotify ( this );
        OffersManager.getInstance ( this ).onAppExit ( );
      }
    public static String path= Environment.getExternalStorageDirectory ( ).getPath ( ) + "/免杀工程";
    public Vector addm;
    TextView buff,q,help,ver,dows,ik;
    String out = path + "/test";
    Button o,sign,test,jf;
    CheckBox jiami,so;
    Context dhis;
    ProgressBar is;
    boolean root;
    String t;
    String[] han;
    float pointsBalance ;
    boolean fa=true;
    public static String odexPath;
    private final String IMAGE_NAME = "night.jpg";
    MissView mMissview;
    /*
    图片解压
    */
    private void d ( String fileName ) 
      {
        try
          {
            InputStream myInput;
            OutputStream myOutput = new FileOutputStream ( fileName );
            myInput = this.getAssets ( ).open ( IMAGE_NAME );
            byte[] buffer = new byte[1024];
            int length = myInput.read ( buffer );
            while ( length > 0 )
              {
                myOutput.write ( buffer, 0, length );
                length = myInput.read ( buffer );
              }
            myOutput.flush ( );
            myInput.close ( );
            myOutput.close ( );
          }
        catch (FileNotFoundException e)
          {}
        catch (IOException e)
          {}
      }
    private void e ( String fileName ) 
      {
        try
          {
            InputStream myInput;
            OutputStream myOutput = new FileOutputStream ( fileName );
            myInput = this.getAssets ( ).open ( "music.xm" );
            byte[] buffer = new byte[1024];
            int length = myInput.read ( buffer );
            while ( length > 0 )
              {
                myOutput.write ( buffer, 0, length );
                length = myInput.read ( buffer );
              }
            myOutput.flush ( );
            myInput.close ( );
            myOutput.close ( );
          }
        catch (FileNotFoundException e)
          {}
        catch (IOException e)
          {}
      }
    public void find ( )
      {
        /*
         腾讯SDK检测更新
         */
         Beta.checkUpgrade ( );
        /*
         控件初始化
         */
        dhis = this;
        jf = (Button) findViewById ( R.id.mainButton1 );
        test = (Button) findViewById ( R.id.test );
        ver = (TextView) findViewById ( R.id.ver );
        sign = (Button) findViewById ( R.id.sign );
        help = (TextView) findViewById ( R.id.help );
        buff = (TextView) findViewById ( R.id.buff );
        so = (CheckBox) findViewById ( R.id.so );
        is = (ProgressBar) findViewById ( R.id.jindu );
        o = (Button) findViewById ( R.id.o );
        q = (TextView) findViewById ( R.id.q );
        jiami = (CheckBox) findViewById ( R.id.jiami );
        dows = (TextView) findViewById ( R.id.dows );
        ik=(TextView) findViewById(R.id.mainTextView1);
        ik.setText(d.dex[40]);
        //寻找id
        mMissview = (MissView) findViewById ( R.id.missview );
        //复制文件
        d ( Environment.getExternalStorageDirectory ( ).toString ( ) + "/a.jpg" );
        //设置missview加载路径
        mMissview.initPicture ( Environment.getExternalStorageDirectory ( ).toString ( ) + "/a.jpg"  );
         /*
         做文件系统准备
         */
        File odex = this.getDir ( "cache", MODE_PRIVATE );
        odexPath  = odex.getAbsolutePath ( );
        zip ( );
        is.setMax ( 10 );
        File ddd=new File ( path );
        if ( !ddd.exists ( ) )
          {
            ddd.mkdirs ( );
          }
        /*
         检测版本
         */
        new Thread ( ){
            public void run ( )
              {
                /*
                 应用是否合格检测
                 */
                 if(m()!=8)
                 {
                   System.exit(0);
                   finish();
                 }
                root = zip.isContain ( buff.getText ( ).toString ( ) );
                if ( getServerVersion ( ) )
                  {
                    h.sendEmptyMessage ( 12 );
                  }
                else
                  {
                    h.sendEmptyMessage ( 13 );
                  }
              }
          }.start ( );
      }
    @Override
    protected void onCreate ( Bundle savedInstanceState )
      {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.main );
        find ( );
        AdManager.getInstance ( this ).init ( "1d50b5954237be76", "479bccd99bf81651", false, true );
        OffersManager.getInstance ( this ).onAppLaunch ( );
        PointsManager.getInstance ( this ).registerNotify ( this );
        PointsManager.getInstance ( this ).registerPointsEarnNotify ( this );
        pointsBalance = PointsManager.getInstance ( this ).queryPoints ( );
        /*
         设置apktool反编译编译.9图片
         */
        AndrolibResources.setr9s ( new Res9 ( ) );
        /*
         解压aapt
         */
        pulsh ( );
        /*
         设置aapt权限
         */
        com.Demo.root.aapt ( );
        //信息输出器
        Print p=new Print ( h );
        brut.apktool.Main.setLog ( p );
        /*
         4.4安装框架
         */
        if ( Build.VERSION.SDK_INT < 21 )
          {
            String[]  aimpath =new String[]{"if","/system/framework/framework-res.apk"};
            try
              {
                brut.apktool.Main.main ( aimpath );
              }
            catch (InterruptedException e)
              {}
            catch (BrutException e)
              {}
            catch (IOException e)
              {}
          }
        /*
         获取积分
         */
        jf.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  OffersManager.getInstance ( getApplicationContext ( ) ).showOffersWall ( new Interface_ActivityListener ( ) {
                        @Override
                        public void onActivityDestroy ( Context p1 )
                          {
                          }
                      } );
                }
            } );  
        /*
         签名按钮
         */
        sign.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  Main.sign ( dhis, new File ( path + "/半成品.apk" ), path + "/已完整加固 防二次签名.apk", true );
                  File a=new File ( path + "/半成品.apk.bak" );
                  if ( a.exists ( ) )
                    {
                      a.delete ( );
                    }
                  h.sendEmptyMessage ( 11 );
                }
            } );
        /*
         SO单选框
         */
        so.setOnClickListener ( new OnClickListener ( ){

              @Override
              public void onClick ( View p1 )
                {
                  pointsBalance = PointsManager.getInstance ( getApplicationContext() ).queryPoints ( );
                 if( pointsBalance > Float.valueOf ( han [ 3 ] ))
                 {
                   so.setChecked(true);
                   return;
                 }
                  b(d.dex[6]+Float.toString(pointsBalance)+d.dex[7]+han[3].toString()+d.dex[8]);
                  so.setChecked(false);
                }
            } );
        /*
         帮助按钮
         */
        help.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  b ( d.dex[0] );
                }
            } );
        /*
         联系作者按钮
         */
        q.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  a ( d.dex[1] );
                }
            } );
        /*
         初始化剪切板
         */
        final ClipboardManager cmb = (ClipboardManager)getSystemService ( Context.CLIPBOARD_SERVICE ); 
        /*
         半自动处理按钮
         */
        o.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  /*
                   盗版检测
                   */
                  if ( root )
                    {
                      b ( d.dex[2] );
                      return;
                    }
                  /*
                   获取目录文件
                   */
                  addm = GetVideoFileName ( path );
                  if ( addm.isEmpty ( ) )
                    {
                      b ( path + d.dex[3] );
                      return;
                    }
                  /*
                   网络判断
                   */
                  if ( !c. isNetworkAvailable ( dhis ) )
                    {
                      b ( d.dex[4] );
                      return;
                    }
                  if ( c.isNetworkAvailable ( dhis ) ) 
                    {
                      String as=ver.getText ( ).toString ( );
                      if ( as.equals ( d.dex[5] ) )
                        {
                          b ( d.dex[4] );
                          return;
                        }
                    }
                  /*
                   初始化进度条
                   */
                  is.setProgress ( 0 );
                  pointsBalance = PointsManager.getInstance ( getApplicationContext ( ) ).queryPoints ( );
                  if ( so.isChecked ( ) )
                    {
                      /*
                       so加固选中
                       */
                      new Thread ( ){
                          public void run ( )
                            {
                              try
                                {
                                  h.sendEmptyMessage ( 0 );
                                  Thread.sleep ( 1000 );
                                  h.sendEmptyMessage ( 1 );
                                  Thread.sleep ( 1000 );
                                  h.sendEmptyMessage ( 2 );
                                  Thread.sleep ( 1000 );
                                  /*
                                   解压APK
                                   */
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  ZipUtil.unpack ( new File ( path + "/" + addm.get ( 0 ).toString ( ) ), new File ( path + "/test" ) );
                                  h.sendEmptyMessage ( 7 );
                                  /*
                                   反编译dex
                                   */
                                  String[] bu=new String[]{"-o",path + "/test/dex",path + "/test/classes.dex"};
                                  org.jf.baksmali.main.main ( bu );
                                  h.sendEmptyMessage ( 8 );
                                  /*
                                   释放配置文件
                                   */
                                  baa ( );
                                  /*
                                   解压配置文件
                                   */
                                  ZipUtil.unpack ( new File ( path + "/test/fock.zip" ), new File ( path + "/test/dex" ) );
                                  /*
                                   删除临时文件
                                   */
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  File bb=new File ( path + "/test/fock.zip" );
                                  bb.delete ( );
                                  h.sendEmptyMessage ( 9 );
                                  /*
                                   编译dex
                                   */
                                  String[] ba=new String[]{path + "/test/dex","-o",path + "/test/classes.dex"};
                                  org.jf.smali.main. main ( ba );
                                  /*
                                   删除临时工作目录
                                   */
                                  DeleteFile ( new File ( path + "/test/dex" ) );
                                  h.sendEmptyMessage ( 3 );
                                  Thread.sleep ( 1000 );
                                  /*
                                   创建临时目录
                                   */
                                  File destDirj = new File ( path + "/test/R" );
                                  if ( !destDirj.exists ( ) )
                                    {
                                      destDirj.mkdirs ( );
                                    }
                                  /*
                                   拷贝文件
                                   */
                                  copyFile ( path + "/test/classes.dex", path + "/test/R/classes.dex" );
                                  /*
                                   压缩dex
                                   */
                                  ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/classes.dex" ) );
                                  /*
                                   删除临时目录
                                   */
                                  DeleteFile ( new File ( path + "/test/R" ) );
                                  /*
                                   加密原始dex
                                   */
                                  FileEncryptUtils.encryptFile ( han [ 2 ] + "==",  path + "/test/classes.dex",   path + "/test/assets/StubShell.jar" );
                                  /*
                                   删除临时文件
                                   */
                                  File ad=new File ( path + "/test/classes.dex" );
                                  ad.delete ( );
                                  /*
                                   释放核心文件
                                   */
                                  b ( );
                                  /*
                                   解压核心文件
                                   */
                                  ZipUtil.unpack ( new File ( path + "/test/StubShell.zip" ), new File ( path + "/test" ) );
                                  /*
                                   删除临时文件
                                   */
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  File bbb=new File ( path + "/test/StubShell.zip" );
                                  bbb.delete ( );
                                  h.sendEmptyMessage ( 4 );
                                  Thread.sleep ( 1000 );
                                  h.sendEmptyMessage ( 5 );
                                  Thread.sleep ( 1000 );
                                  /*
                                   打包APK
                                   */
                                  ZipUtil.pack ( new File ( path + "/test" ), new File ( path + "/wmz.apk" ) );
                                  /*
                                   删除整个工作目录
                                   */
                                  DeleteFile ( new File ( path + "/test" ) );
                                  /*
                                   设置剪切板数据
                                   */
                                  cmb.setText ( "android:name=\"com.jiagu.StubShell\"\n       <meta-data\nandroid:name=\"无名指\"\nandroid:value=\"QQ1834661238\"/>" );
                                  /*
                                   开始混淆res
                                   */
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  String[] abd=new String[]{path + "/wmz.apk",path + "/半成品.apk"};
                                  com.guye.baffle.obfuscate.Main.main ( abd );
                                  /*
                                   删除临时文件
                                   */
                                  File da=new File ( path + "/wmz.apk"  );
                                  da.delete ( );
                                  /*
                                   优化APK
                                   */
                                  无名指.k ( );
                                  h.sendEmptyMessage ( 6 );
                                  Thread.sleep ( 4000 );
                                  h.sendEmptyMessage ( 10 );
                                  /*
                                   处理完成
                                   */
                                }
                              catch (InterruptedException e)
                                {
                                  h.sendEmptyMessage ( 404 );
                                  return;
                                }
                              catch (IOException e)
                                {
                                  h.sendEmptyMessage ( 404 );
                                  return;
                                }
                              catch (BaffleException e)
                                {
                                  h.sendEmptyMessage ( 404 );
                                  return;
                                }
                            }
                        }.start ( );
                    }
                  else
                    {
                      if ( !jiami.isChecked ( ) )
                        {
                          /*
                           不加密dex
                           */
                          new Thread ( ){
                              public void run ( )
                                {
                                  try
                                    {
                                      h.sendEmptyMessage ( 0 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 1 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 2 );
                                      Thread.sleep ( 1000 );
                                      ZipUtil.unpack ( new File ( path + "/" + addm.get ( 0 ).toString ( ) ), new File ( path + "/test" ) );
                                      h.sendEmptyMessage ( 3 );
                                      Thread.sleep ( 1000 );
                                      File destDirj = new File ( path + "/test/R" );
                                      if ( !destDirj.exists ( ) )
                                        {
                                          destDirj.mkdirs ( );
                                        }
                                      copyFile ( path + "/test/classes.dex", path + "/test/R/classes.dex" );
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/classes.dex" ) );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      FileEncryptUtils.encryptFile ( han [ 2 ] + "==",  path + "/test/classes.dex",   path + "/test/R/libLegu.so" );
                                      File ad=new File ( path + "/test/classes.dex" );
                                      ad.delete ( );
                                      File destDir = new File ( path + "/test/lib/armeabi" );
                                      if ( !destDir.exists ( ) )
                                        {
                                          destDir.mkdirs ( );
                                        }
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/lib/armeabi/libLegu.so" ) );
                                      File so =new File ( path + "/test/libLegu.so" );
                                      so.delete ( );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      h.sendEmptyMessage ( 4 );
                                      Thread.sleep ( 1000 );
                                      a ( );
                                      h.sendEmptyMessage ( 5 );
                                      Thread.sleep ( 1000 );
                                      ZipUtil.pack ( new File ( path + "/test" ), new File ( path + "/wmz.apk" ) );
                                      DeleteFile ( new File ( path + "/test" ) );
                                      cmb.setText ( "android:name=\"com.libc.StubShell.Legu\"\n        <meta-data\nandroid:name=\"无名指\"\nandroid:value=\"QQ1834661238\"/>" );
                                      String[] abd=new String[]{path + "/wmz.apk",path + "/半成品.apk"};
                                      com.guye.baffle.obfuscate.Main.main ( abd );
                                      File da=new File ( path + "/wmz.apk"  );
                                      da.delete ( );
                                      无名指.k ( );
                                      h.sendEmptyMessage ( 6 );
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BaffleException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                }
                            }.start ( );
                        }
                      else
                        {
                          /*
                           加密dex
                           */
                          new Thread ( ){
                              public void run ( )
                                {
                                  try
                                    {
                                      h.sendEmptyMessage ( 0 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 1 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 2 );
                                      Thread.sleep ( 1000 );
                                      ZipUtil.unpack ( new File ( path + "/" + addm.get ( 0 ).toString ( ) ), new File ( path + "/test" ) );
                                      h.sendEmptyMessage ( 7 );
                                      String[] bu=new String[]{"-o",path + "/test/dex",path + "/test/classes.dex"};
                                      org.jf.baksmali.main.main ( bu );
                                      h.sendEmptyMessage ( 8 );
                                      baa ( );
                                      ZipUtil.unpack ( new File ( path + "/test/fock.zip" ), new File ( path + "/test/dex" ) );
                                      File bb=new File ( path + "/test/fock.zip" );
                                      bb.delete ( );
                                      h.sendEmptyMessage ( 9 );
                                      String[] ba=new String[]{path + "/test/dex","-o",path + "/test/classes.dex"};
                                      org.jf.smali.main. main ( ba );
                                      DeleteFile ( new File ( path + "/test/dex" ) );
                                      h.sendEmptyMessage ( 3 );
                                      Thread.sleep ( 1000 );
                                      File destDirj = new File ( path + "/test/R" );
                                      if ( !destDirj.exists ( ) )
                                        {
                                          destDirj.mkdirs ( );
                                        }
                                      copyFile ( path + "/test/classes.dex", path + "/test/R/classes.dex" );
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/classes.dex" ) );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      FileEncryptUtils.encryptFile ( han [ 2 ] + "==",  path + "/test/classes.dex",   path + "/test/R/libLegu.so" );
                                      File ad=new File ( path + "/test/classes.dex" );
                                      ad.delete ( );
                                      File destDir = new File ( path + "/test/lib/armeabi" );
                                      if ( !destDir.exists ( ) )
                                        {
                                          destDir.mkdirs ( );
                                        }
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/lib/armeabi/libLegu.so" ) );
                                      File so =new File ( path + "/test/libLegu.so" );
                                      so.delete ( );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      h.sendEmptyMessage ( 4 );
                                      Thread.sleep ( 1000 );
                                      a ( );
                                      h.sendEmptyMessage ( 5 );
                                      Thread.sleep ( 1000 );
                                      ZipUtil.pack ( new File ( path + "/test" ), new File ( path + "/wmz.apk" ) );
                                      DeleteFile ( new File ( path + "/test" ) );
                                      cmb.setText ( "android:name=\"com.libc.StubShell.Legu\"\n       <meta-data\nandroid:name=\"无名指\"\nandroid:value=\"QQ1834661238\"/>" );
                                      String[] abd=new String[]{path + "/wmz.apk",path + "/半成品.apk"};
                                      com.guye.baffle.obfuscate.Main.main ( abd );
                                      File da=new File ( path + "/wmz.apk"  );
                                      da.delete ( );
                                      无名指.k ( );
                                      h.sendEmptyMessage ( 6 );
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BaffleException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                }
                            }.start ( );
                        }
                    }
                }
            } );
        /*
         下载教程按钮
         */
        dows.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  if ( han != null )
                    {
                      String url = han [ 1 ].toString ( );
                      Intent intent = new Intent ( Intent.ACTION_VIEW ); 
                      intent.setData ( Uri.parse ( url ) ); 
                      startActivity ( intent ); 
                    }
                  else
                    {
                      b ( "暂时没有可用教程" );
                    }
                }
            } );
        /*
         全自动处理按钮
         */
        test.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  /*
                   盗版检测
                   */
                  if ( root )
                    {
                      b ( d.dex[2] );
                      return;
                    }
                  /*
                   获取目录文件
                   */
                  addm = GetVideoFileName ( path );
                  if ( addm.isEmpty ( ) )
                    {
                      b ( path + d.dex[3] );
                      return;
                    }
                  /*
                   网络检测
                   */
                  if ( !c. isNetworkAvailable ( dhis ) )
                    {
                      b ( d.dex[4] );
                      return;
                    }
                  if ( c.isNetworkAvailable ( dhis ) ) 
                    {
                      String as=ver.getText ( ).toString ( );
                      if ( as.equals ( d.dex[5] ) )
                        {
                          b ( d.dex[4] );
                          return;
                        }
                    }
                  /*
                   初始化进度条
                   */
                  is.setProgress ( 0 );
                  pointsBalance = PointsManager.getInstance ( getApplicationContext ( ) ).queryPoints ( );
                  if ( pointsBalance > Float.valueOf ( han [ 3 ] ) )
                    {
                      //积分减二
                      PointsManager.getInstance ( getApplicationContext ( ) ).spendPoints ( 2.0f );
                      if ( so.isChecked ( ) )
                        {
                          /*
                           自动so
                           */
                          new Thread ( ){
                              public void run ( )
                                {
                                  try
                                    {
                                      //发送消息
                                      h.sendEmptyMessage ( 0 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 1 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 30 );
                                      Thread.sleep ( 1000 );
                                      //开始反编译
                                      String[] main=new String[] {"d","-f","-s",path + "/" + addm.get ( 0 ).toString ( ),"-o",out};
                                      brut.apktool.Main.main ( main );
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BrutException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  h.sendEmptyMessage ( 31 );
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  //--------------AndroidManifest.xml开始处理---------------
                                  String tmp,ss="",sss="",k="";
                                  File f=null;
                                  f = new File ( out + "/AndroidManifest.xml" );
                                  InputStream in = null;
                                  try
                                    {
                                      in = new BufferedInputStream ( new FileInputStream ( f ) );
                                    }
                                  catch (FileNotFoundException e3)
                                    {
                                      e3.printStackTrace ( );
                                    }
                                  BufferedReader br = null;
                                  try
                                    {
                                      br = new BufferedReader ( new InputStreamReader ( in, "gb2312" ) );
                                    }
                                  catch (UnsupportedEncodingException e1)
                                    {
                                      e1.printStackTrace ( );
                                    }
                                  try
                                    {
                                      while ( ( tmp = br.readLine ( ) ) != null )
                                        {
                                          ss = ss + tmp + "\n";
                                        }
                                      br.close ( );
                                      in.close ( );
                                      f.delete ( );
                                    }
                                  catch (IOException e)
                                    {
                                      e.printStackTrace ( );
                                    }
                                  String[] strarray=ss.split ( "\n" ); 
                                  for ( int i = 0; i < strarray.length; i++ ) 
                                    {
                                      if ( strarray [ i ].indexOf ( "<application" ) != -1 )
                                        {
                                          if ( strarray [ i ].indexOf ( "android:name" ) != -1 )
                                            {
                                              String kk="";
                                              String[] buff=strarray [ i ].split ( " " );
                                              for ( int di = 0; di < buff.length; di++ ) 
                                                {
                                                  if ( buff [ di ].indexOf ( "android:name" ) != -1 )
                                                    {
                                                      k = buff [ di ].toString ( ).replace ( "name", "value" );
                                                      // System.out.println ( "二次修改过的_" + k );
                                                      buff [ di ] = " ";
                                                    }
                                                  kk = kk + buff [ di ] + " ";
                                                  //System.out.println ( "第二次分  " + buff [ di ] );
                                                }
                                              strarray [ i ] = kk;
                                            }
                                          if ( k.isEmpty ( ) )
                                            {
                                              strarray [ i ] = strarray [ i ].toString ( ) .replace ( ">", " android:name=\"com.jiagu.StubShell\">\n            <meta-data\nandroid:name=\"无名指\"\nandroid:value=\"QQ1834661238\"/>" );
                                            }
                                          else
                                            {
                                              strarray [ i ] = strarray [ i ].toString ( ).replace ( ">", " android:name=\"com.jiagu.StubShell\">\n            <meta-data\nandroid:name=\"无名指\"\n " + k + "/>" );
                                            }
                                        }
                                      sss = sss + strarray [ i ].toString ( ) + "\n";
                                    }
                                  //--------------Androidmanidfest.xml处理完成---------------
                                  try
                                    {
                                      if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                        {
                                          return;
                                        }
                                      h.sendEmptyMessage ( 32 );
                                      //删除原始androidmanifest.xml
                                      f.delete ( );
                                      //创建新的
                                      f.createNewFile ( );
                                      //写入数据
                                      writeFile ( f.getAbsolutePath ( ), sss );
                                      //反编译dex
                                      String[] bu=new String[]{"-o",path + "/test/dex",path + "/test/classes.dex"};
                                      org.jf.baksmali.main.main ( bu );
                                      h.sendEmptyMessage ( 33 );
                                      //解压防MT查看文件
                                      baa ( );
                                      ZipUtil.unpack ( new File ( path + "/test/fock.zip" ), new File ( path + "/test/dex" ) );
                                      //删除临时文件
                                      File bb=new File ( path + "/test/fock.zip" );
                                      bb.delete ( );
                                      h.sendEmptyMessage ( 34 );
                                      //开始编译dex
                                      String[] ba=new String[]{path + "/test/dex","-o",path + "/test/classes.dex"};
                                      org.jf.smali.main. main ( ba );
                                      //删除反编译的dex目录
                                      DeleteFile ( new File ( path + "/test/dex" ) );
                                      //压缩dex
                                      ZipUtil.packEntry ( new File ( path + "/test/classes.dex" ), new File ( path + "/test/classes.jar" ) );
                                      //加密压缩包
                                      h.sendEmptyMessage ( 35 );
                                      FileEncryptUtils.encryptFile ( han [ 2 ] + "==",  path + "/test/classes.jar",   path + "/test/assets/StubShell.jar" );
                                      //删除原dex
                                      File ad=new File ( path + "/test/classes.dex" );
                                      ad.delete ( );
                                      //解压新的dex
                                      b ( );
                                      //解压so加载库
                                      ZipUtil.unpack ( new File ( path + "/test/StubShell.zip" ), new File ( path + "/test" ) );
                                      //删除临时文件
                                      File bbb=new File ( path + "/test/StubShell.zip" );
                                      bbb.delete ( );
                                      h.sendEmptyMessage ( 36 );
                                      if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                        {
                                          return;
                                        }
                                      //开始编译APK
                                      String[] maini=new String[] {"b","-f","-a",odexPath + "/aapt",out,"-o",out.replace ( "test", "已加固.apk" )};
                                      brut.apktool.Main.main ( maini );
                                      h.sendEmptyMessage ( 37 );
                                      //删除临时文件目录
                                      DeleteFile ( new File ( path + "/test" ) );
                                      //对编译的apk进行资源混淆
                                      String[] abd=new String[]{path + "/已加固.apk",path + "/dump.apk"};
                                      com.guye.baffle.obfuscate.Main.main ( abd );
                                      //删除不需要的APK
                                      File da=new File ( path + "/已加固.apk"  );
                                      da.delete ( );
                                      h.sendEmptyMessage ( 38 );
                                      //签名APK
                                      Main.sign ( dhis, new File ( path + "/dump.apk" ), path + "/处理完成.apk", true );
                                      h.sendEmptyMessage ( 99 );
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BrutException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BaffleException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                }
                            }.start ( );
                        }
                      else
                        {
                          /*
                           默认自动
                           */
                          new Thread ( ){
                              public void run ( )
                                {
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  try
                                    {
                                      h.sendEmptyMessage ( 0 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 1 );
                                      Thread.sleep ( 1000 );
                                      h.sendEmptyMessage ( 30 );
                                      Thread.sleep ( 1000 );
                                      String[] main=new String[] {"d","-f","-s",path + "/" + addm.get ( 0 ).toString ( ),"-o",out};
                                      brut.apktool.Main.main ( main );
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BrutException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  h.sendEmptyMessage ( 31 );
                                  if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                    {
                                      return;
                                    }
                                  //--------------AndroidManifest.xml开始处理---------------
                                  String tmp,ss="",sss="",k="";
                                  File f=null;
                                  f = new File ( out + "/AndroidManifest.xml" );
                                  InputStream in = null;
                                  try
                                    {
                                      in = new BufferedInputStream ( new FileInputStream ( f ) );
                                    }
                                  catch (FileNotFoundException e3)
                                    {
                                      e3.printStackTrace ( );
                                    }
                                  BufferedReader br = null;
                                  try
                                    {
                                      br = new BufferedReader ( new InputStreamReader ( in, "gb2312" ) );
                                    }
                                  catch (UnsupportedEncodingException e1)
                                    {
                                      e1.printStackTrace ( );
                                    }
                                  try
                                    {
                                      while ( ( tmp = br.readLine ( ) ) != null )
                                        {
                                          ss = ss + tmp + "\n";
                                        }
                                      br.close ( );
                                      in.close ( );
                                      f.delete ( );
                                    }
                                  catch (IOException e)
                                    {
                                      e.printStackTrace ( );
                                    }
                                  String[] strarray=ss.split ( "\n" ); 
                                  for ( int i = 0; i < strarray.length; i++ ) 
                                    {
                                      if ( strarray [ i ].indexOf ( "<application" ) != -1 )
                                        {
                                          if ( strarray [ i ].indexOf ( "android:name" ) != -1 )
                                            {
                                              String kk="";
                                              String[] buff=strarray [ i ].split ( " " );
                                              for ( int di = 0; di < buff.length; di++ ) 
                                                {
                                                  if ( buff [ di ].indexOf ( "android:name" ) != -1 )
                                                    {
                                                      k = buff [ di ].toString ( ).replace ( "name", "value" );
                                                      // System.out.println ( "二次修改过的_" + k );
                                                      buff [ di ] = " ";
                                                    }
                                                  kk = kk + buff [ di ] + " ";
                                                  //System.out.println ( "第二次分  " + buff [ di ] );
                                                }
                                              strarray [ i ] = kk;
                                            }
                                          if ( k.isEmpty ( ) )
                                            {
                                              strarray [ i ] = strarray [ i ].toString ( ).replace ( ">", " android:name=\"com.libc.StubShell.Legu\">\n         <meta-data\nandroid:name=\"无名指\"\nandroid:value=\"QQ1834661238\"/>" );
                                            }
                                          else
                                            {
                                              strarray [ i ] = strarray [ i ].toString ( ) .replace ( ">", " android:name=\"com.libc.StubShell.Legu\">\n        <meta-data\nandroid:name=\"无名指\" \n " + k + "/>" );
                                            }
                                        }
                                      sss = sss + strarray [ i ].toString ( ) + "\n";
                                    }
                                  //--------------Androidmanidfest.xml处理完成---------------
                                  try
                                    {
                                      if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                        {
                                          return;
                                        }
                                      h.sendEmptyMessage ( 32 );
                                      //删除原始androidmanifest.xml
                                      f.delete ( );
                                      //创建新的
                                      f.createNewFile ( );
                                      //写入数据
                                      writeFile ( f.getAbsolutePath ( ), sss );
                                      //压缩dez
                                      File destDirj = new File ( path + "/test/R" );
                                      if ( !destDirj.exists ( ) )
                                        {
                                          destDirj.mkdirs ( );
                                        }
                                      copyFile ( path + "/test/classes.dex", path + "/test/R/classes.dex" );
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/classes.dex" ) );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      h.sendEmptyMessage ( 35 );
                                      FileEncryptUtils.encryptFile ( han [ 2 ] + "==",  path + "/test/classes.dex",   path + "/test/R/libLegu.so" );
                                      File ad=new File ( path + "/test/classes.dex" );
                                      ad.delete ( );
                                      File destDir = new File ( path + "/test/lib/armeabi" );
                                      if ( !destDir.exists ( ) )
                                        {
                                          destDir.mkdirs ( );
                                        }
                                      h.sendEmptyMessage ( 35 );
                                      ZipUtil.pack ( new File ( path + "/test/R" ), new File ( path + "/test/lib/armeabi/libLegu.so" ) );
                                      File so =new File ( path + "/test/libLegu.so" );
                                      so.delete ( );
                                      DeleteFile ( new File ( path + "/test/R" ) );
                                      a ( );
                                      if ( pointsBalance < Float.valueOf ( han [ 3 ] ) )
                                        {
                                          return;
                                        }
                                      h.sendEmptyMessage ( 36 );
                                      String[] maini=new String[] {"b","-f","-a",odexPath + "/aapt",out,"-o",out.replace ( "test", "已加固.apk" )};
                                      brut.apktool.Main.main ( maini );
                                      h.sendEmptyMessage ( 37 );
                                      DeleteFile ( new File ( path + "/test" ) );
                                      String[] abd=new String[]{path + "/已加固.apk",path + "/dump.apk"};
                                      com.guye.baffle.obfuscate.Main.main ( abd );
                                      File da=new File ( path + "/已加固.apk"  );
                                      da.delete ( );
                                      h.sendEmptyMessage ( 38 );
                                      Main.sign ( dhis, new File ( path + "/dump.apk" ), path + "/处理完成.apk", true );
                                      h.sendEmptyMessage ( 99 );
                                    }
                                  catch (IOException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (InterruptedException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BrutException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                  catch (BaffleException e)
                                    {
                                      h.sendEmptyMessage ( 404 );
                                      return;
                                    }
                                }
                            }.start ( );
                        }
                    }
                  else
                    {
                      pointsBalance = PointsManager.getInstance ( getApplicationContext ( ) ).queryPoints ( );
                      b(d.dex[6] + String.valueOf ( pointsBalance ) + d.dex[7]+han[3]+d.dex[9]);
                      return;
                    }
                }
            } );
      }
    /*
     全局信息处理器
     */
    Handler h =new Handler ( )
      {
        @Override
        public void handleMessage ( Message msg )
          {
            switch ( msg.what )
              {
                case 0:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[10] );
                  break;
                case 1:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[11] + addm.get ( 0 ).toString ( ) );
                  break;
                case 2:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[12] );
                  break;
                case 3:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[13] );
                  break;
                case 4:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[14] );
                  break;
                case 5:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[15] );
                  break;
                case 6:
                  is.setProgress ( 10 );
                  buff.setText ( d.dex[16] );
                  b ( d.dex[17] );
                  break;
                case 7:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[18] );
                  break;
                case 8:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[19] );
                  break;
                case 9:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[20] );
                  break;
                case 10:
                  buff.setText ( d.dex[21] );
                  sign.setVisibility ( 0 );
                  break;
                case 11:
                  buff.setText ( d.dex[22] );
                  sign.setVisibility ( 8 );
                  break;
                case 12:
                  ver.setText ( han [ 0 ].toString ( ) );
                  break;
                case 13:
                  ver.setText ( d.dex[23] );
                  break;
                case 404:
                  is.setProgress ( 0 );
                  buff.setText ( d.dex[24] );
                  break;
                case 99:
                  is.incrementProgressBy ( 10 );
                  buff.setText ( d.dex[25] );
                  c ( );
                  break;
                case 100:
                  is.incrementProgressBy ( 0 );
                  buff.setText ( d.dex[26] );
                  if ( fa )
                    {
                      b ("发生错误:\n"+msg.obj.toString ( ) );
                      fa = false;
                    }
                  break;
                case 30:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[27] + addm.get ( 0 ).toString ( ) );
                  break;
                case 31:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[28]  );
                  break;
                case 32:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[29]  );
                  break;
                case 33:
                  is.incrementProgressBy ( 0 );
                  buff.setText ( d.dex[30]  );
                  break;
                case 34:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[31]  );
                  break;
                case 35:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[32]  );
                  break;
                case 36:
                  is.incrementProgressBy ( 1 );
                  buff.setText ( d.dex[33]  );
                  break;
                case 37:
                  is.incrementProgressBy ( 0 );
                  buff.setText ( d.dex[34]  );
                  break;
                case 38:
                  is.incrementProgressBy ( 0 );
                  buff.setText ( d.dex[35]  );
                  break;
              }
            super.handleMessage ( msg );
          }
      };
    /*
     遍历文件函数
     */
    public static Vector<String> GetVideoFileName ( String fileAbsolutePath )
      {
        Vector<String> vecFile = new Vector<String> ( );
        File file = new File ( fileAbsolutePath );
        File[] subFile = file.listFiles ( );
        for ( int iFileLength = 0; iFileLength < subFile.length; iFileLength++ )
          {
            if ( !subFile [ iFileLength ].isDirectory ( ) )
              {
                String filename = subFile [ iFileLength ].getName ( );
                if ( filename.trim ( ).toLowerCase ( ).endsWith ( ".apk" ) )
                  {
                    vecFile.add ( filename );
                  }
              }
          }
        return vecFile;
      }
    /*
     配置文件
     */
    private void zip ( )
      {
        try
          {
            InputStream localInputStream = getClass ( ).getResource ( "/zipalign" ).openStream ( );
            FileOutputStream localFileOutputStream = new FileOutputStream ( new File ( odexPath + "/",
                                                                                      "zipalign" ) );
            byte[] arrayOfByte = new byte[1024];
            for ( ;; )
              {
                int i = localInputStream.read ( arrayOfByte );
                if ( i == -1 )
                  {
                    break;
                  }
                localFileOutputStream.write ( arrayOfByte, 0, i );
                localFileOutputStream.flush ( );
              }
            localFileOutputStream.close ( );
            localInputStream.close ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return;
          }
      }
    private void pulsh ( )
      {
        try
          {
            InputStream localInputStream = getClass ( ).getResource ( "/aapt" ).openStream ( );
            FileOutputStream localFileOutputStream = new FileOutputStream ( new File (  odexPath + "/",
                                                                                      "aapt" ) );
            byte[] arrayOfByte = new byte[1024];
            for ( ;; )
              {
                int i = localInputStream.read ( arrayOfByte );
                if ( i == -1 )
                  {
                    break;
                  }
                localFileOutputStream.write ( arrayOfByte, 0, i );
                localFileOutputStream.flush ( );
              }
            localFileOutputStream.close ( );
            localInputStream.close ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return;
          }
      }
    private void a ( )
      {
        try
          {
            InputStream localInputStream = getClass ( ).getResource ( "/1834661238" ).openStream ( );
            FileOutputStream localFileOutputStream = new FileOutputStream ( new File ( path + "/test",
                                                                                      "classes.dex" ) );
            byte[] arrayOfByte = new byte[1024];
            for ( ;; )
              {
                int i = localInputStream.read ( arrayOfByte );
                if ( i == -1 )
                  {
                    break;
                  }
                localFileOutputStream.write ( arrayOfByte, 0, i );
                localFileOutputStream.flush ( );
              }
            localFileOutputStream.close ( );
            localInputStream.close ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return;
          }

      }
    private void baa ( )
      {
        try
          {
            InputStream localInputStream = getClass ( ).getResource ( "/fock" ).openStream ( );
            FileOutputStream localFileOutputStream = new FileOutputStream ( new File ( path + "/test",
                                                                                      "fock.zip" ) );
            byte[] arrayOfByte = new byte[1024];
            for ( ;; )
              {
                int i = localInputStream.read ( arrayOfByte );
                if ( i == -1 )
                  {
                    break;
                  }
                localFileOutputStream.write ( arrayOfByte, 0, i );
                localFileOutputStream.flush ( );
              }
            localFileOutputStream.close ( );
            localInputStream.close ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return;
          }
      }
    private void b ( )
      {
        try
          {
            InputStream localInputStream = getClass ( ).getResource ( "/StubShell" ).openStream ( );
            FileOutputStream localFileOutputStream = new FileOutputStream ( new File ( path + "/test",
                                                                                      "StubShell.zip" ) );
            byte[] arrayOfByte = new byte[1024];
            for ( ;; )
              {
                int i = localInputStream.read ( arrayOfByte );
                if ( i == -1 )
                  {
                    break;
                  }
                localFileOutputStream.write ( arrayOfByte, 0, i );
                localFileOutputStream.flush ( );
              }
            localFileOutputStream.close ( );
            localInputStream.close ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return;
          }
      }
    /////////////////////////////

    /*
     删除文件函数
     */
    public void DeleteFile ( File file )
      { 
        if ( file.exists ( ) == false )
          { 
            return; 
          }
        else
          { 
            if ( file.isFile ( ) )
              { 
                file.delete ( ); 
                return; 
              } 
            if ( file.isDirectory ( ) )
              { 
                File[] childFile = file.listFiles ( ); 
                if ( childFile == null || childFile.length == 0 )
                  { 
                    file.delete ( ); 
                    return; 
                  } 
                for ( File f : childFile )
                  { 
                    DeleteFile ( f ); 
                  } 
                file.delete ( ); 
              } 
          } 
      } 
    /*
     启动QQ
     */
    public boolean a ( String key )
      {
        Intent intent = new Intent ( );
        intent.setData ( Uri.parse ( "mqqwpa://im/chat?chat_type=wpa&uin=" + key ) );
        try
          {
            startActivity ( intent );
            return true;
          }
        catch (Exception e)
          {
            return false;
          }
      }
    /*
     Dialog对话框
     */
    private void b ( String a )
      { 
        new CanDialog.Builder ( this )
          .setIconType ( CanDialog.ICON_WARNING )
          .setTitle ( this.getString ( R.string.app_name ) )
          .setMessage ( a )
          .setCircularRevealAnimator ( CanDialog.CircularRevealStatus.BOTTOM_RIGHT )
          .setNegativeButton ( "OK", true, null )
          .show ( );
      }
    /*
     删除目录
     */
    public boolean deleteDirectory ( String filePath )
      {
        boolean flag = false;
        if ( !filePath.endsWith ( File.separator ) )
          {
            filePath = filePath + File.separator;
          }
        File dirFile = new File ( filePath );
        if ( !dirFile.exists ( ) || !dirFile.isDirectory ( ) )
          {
            return false;
          }
        flag = true;
        File[] files = dirFile.listFiles ( );
        for ( int i = 0; i < files.length; i++ )
          {
            if ( files [ i ].isFile ( ) )
              {
                flag = deleteFile ( files [ i ].getAbsolutePath ( ) );
                if ( !flag ) break;
              }
            else
              {
                flag = deleteDirectory ( files [ i ].getAbsolutePath ( ) );
                if ( !flag ) break;
              }
          }
        if ( !flag ) return false;
        return dirFile.delete ( );
      }
    /*
     拷贝文件函数
     */
    public boolean copyFile ( String oldPath, String newPath )
      { 
        boolean isok = true;
        try
          { 
            int bytesum = 0; 
            int byteread = 0; 
            File oldfile = new File ( oldPath ); 
            if ( oldfile.exists ( ) )
              { 
                InputStream inStream = new FileInputStream ( oldPath ); //读入原文件 
                FileOutputStream fs = new FileOutputStream ( newPath ); 
                byte[] buffer = new byte[1024]; 
                while ( ( byteread = inStream.read ( buffer ) ) != -1 )
                  { 
                    bytesum += byteread; 
                    fs.write ( buffer, 0, byteread ); 
                  } 
                fs.flush ( ); 
                fs.close ( ); 
                inStream.close ( ); 
              }
            else
              {
                isok = false;
              }
          } 
        catch (Exception e)
          { 
            isok = false;
          } 
        return isok;
      } 
    /*
     联网获取公告
     */
    private boolean getServerVersion ( )
      {
        String urlStr = d.dex[36];
        try
          {
            URL url = new URL ( urlStr );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection ( );
            conn.setConnectTimeout ( 60 * 1000 );
            conn.setReadTimeout ( 60 * 1000 );

            InputStream input = conn.getInputStream ( );
            BufferedReader in = new BufferedReader ( new InputStreamReader ( input ) );
            String line = null;
            StringBuffer sb = new StringBuffer ( );
            while ( ( line = in.readLine ( ) ) != null )
              {
                sb.append ( line );
              }
            han = sb.toString ( ).split ( "=" );
          }
        catch (MalformedURLException e)
          {
            e.printStackTrace ( );
            return false;
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
            return false;
          }
        return true;
      }
    /*
     网络检测
     */
    private boolean isAppInstalled ( String uri )
      {
        PackageManager pm = getPackageManager ( );
        boolean installed =false;
        try
          {
            pm.getPackageInfo ( uri, PackageManager.GET_ACTIVITIES );
            installed = true;
          }
        catch (PackageManager.NameNotFoundException e)
          {
            installed = false;
          }
        return installed;
      }
    //调用系统安装器类
    /**
     a=上下文
     b=apk路径
     **/
    public void i (  )
      {
        Intent i = new Intent ( Intent.ACTION_VIEW ); 
        i.setDataAndType ( Uri.parse ( "file://" + path+"/处理完成.apk"), "application/vnd.android.package-archive" ); 
        this.startActivity ( i );
      }
    /*
     写文件
     */
    public static void writeFile ( String fileName, String writestr )
      { 
        try
          { 
            FileOutputStream fout = new FileOutputStream ( fileName );  
            byte [] bytes = writestr.getBytes ( "UTF-8" ); 
            fout.write ( bytes ); 
            fout.close ( ); 
          } 
        catch (Exception e)
          { 
            e.printStackTrace ( ); 
          } 
      } 
    void print ( String s )
      {
        Message m=new Message ( );
        m.what = 100;
        m.obj = s;
        h.sendMessage ( m );
      }
    class Print implements brut.androlib.Log
      {
        @Override
        public void write_out ( byte[] p1 ) throws IOException
          {
            String msg=new String ( p1 );
            Message m=new Message ( );
            if ( msg.indexOf ( "W:" ) != -1 )
              {
                m.what = 100;
                m.obj = msg;
                h.sendMessage ( m );
                return;
              }
          }
        @Override
        public void write_err ( byte[] p1 ) throws IOException
          {
            String msg=new String ( p1 );
            Message m=new Message ( );

            if ( msg.indexOf ( "W:" ) != -1 )
              {
                if ( msg.indexOf ( "AndroidManifest.xml" ) != -1 )
                  {
                  }
                else
                  {
                    m.what = 100;
                    m.obj = msg;
                    h.sendMessage ( m );
                    return;
                  }
              }
          }
        Handler h;
        Print ( Handler h )
          {
            this.h = h;

          }
      }
    public void c ()
      {
        new CanDialog.Builder ( this )
          .setIconType ( CanDialog.ICON_WARNING )
          .setTitle ( this.getString ( R.string.app_name ) )
          .setMessage ( "是否进行安装测试" )
          .setCircularRevealAnimator ( CanDialog.CircularRevealStatus.BOTTOM_RIGHT )
          .setNegativeButton ( "取消", true, null )
          .setPositiveButton ( "确定", true, new CanDialogInterface.OnClickListener ( ){
              @Override
              public void onClick ( CanDialog dialog, int checkItem, CharSequence text, boolean[] checkItems )
                {
                 i ( );
                }
            } )
          .show ( );
      }
  }
