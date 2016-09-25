package utils.activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import me.majiajie.codec.*;
import Xbox.a.*;
import java.io.*;
public class e extends Application
  {
    /*
     腾讯SDK官网初始化函数
     */
    public static final String APP_ID = "91341cf292"; // TODO 替换成bugly上注册的appid
    public static final String APP_CHANNEL = "DEBUG"; // TODO 自定义渠道
    public static String ad;
    @Override
    public void onCreate ( )
      {
        super.onCreate ( );
        System.out.println ( "--------------喵星人-------------" );
        ad =  "X509";
        //System.out.println ( ad );
         // StringBuffer buff=new StringBuffer();
        // StringBuffer buffa=new StringBuffer();
        for ( int i=0;i < d.dex.length;i++ )
          {
           // d.a[i]=Xbox.a.d.a(d.a[i],ad);
            d.dex [ i ] = Xbox.a.d.b ( d.dex [ i ], ad );
           // buff=buff.append("\""+d.a[i]+"\",\n");
            // buffa=buffa.append(Xbox.a.d.b(d.dex[i],"test")+"\n");
            //d.dex[i]=d.a.toString();
            //System.out.println(d.dex[i]);
          }
       // a.writeFile("mnt/sdcard/test.txt",buff.toString());
       // System.exit(0);
        // a.writeFile("mnt/sdcard/test1.txt",buffa.toString());
//        d.a [ 0 ] = Xbox.a.d.a ( d.a [ 0 ] );
//        System.out.println ( "加密" + d.a [ 0 ] );
//        d.a [ 0 ] = Xbox.a.d.b ( d.a [ 0 ] );
//        System.out.println ( "解密" + d.a [ 0 ] );
        //System.out.println ( Xbox.a.d.b ( d.a ) );
        System.out.println ( "------------喵星人-----------" );
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.initDelay = 1 * 1000;
        Beta.largeIconId = R.drawable.ic_launcher;
        Beta.smallIconId = R.drawable.ic_launcher;
        Beta.defaultBannerId = R.drawable.ic_launcher;
        Beta.storageDir = Environment.getExternalStoragePublicDirectory ( Environment.DIRECTORY_DOWNLOADS );
        Beta.showInterruptedStrategy = true;
        Beta.canShowUpgradeActs.add ( a.class );
        Beta.upgradeDialogLayoutId = R.layout.upgrade_dialog;
        Beta.tipsDialogLayoutId = R.layout.tips_dialog;
        Beta.upgradeDialogLifecycleListener = new UILifecycleListener<UpgradeInfo> ( ) {

            @Override
            public void onStart ( Context p1, View p2, UpgradeInfo p3 )
              {
                // TODO: Implement this method
              }

            @Override
            public void onResume ( Context p1, View p2, UpgradeInfo p3 )
              {
                // TODO: Implement this method
              }

            @Override
            public void onPause ( Context p1, View p2, UpgradeInfo p3 )
              {
                // TODO: Implement this method
              }

            @Override
            public void onStop ( Context p1, View p2, UpgradeInfo p3 )
              {
                // TODO: Implement this method
              }

            @Override
            public void onDestroy ( Context p1, View p2, UpgradeInfo p3 )
              {
                // TODO: Implement this method
              }

            //private String TAG="test";
            @Override
            public void onCreate ( Context context, View view, UpgradeInfo upgradeInfo )
              {
                //Log.d ( TAG, "onCreate" );
                //ImageView imageView = (ImageView) view.findViewWithTag ( Beta.TAG_IMG_BANNER );
              }

          };
        Bugly.init ( getApplicationContext ( ), APP_ID, true );
      }
  }

