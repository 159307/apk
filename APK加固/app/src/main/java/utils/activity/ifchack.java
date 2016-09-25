package utils.activity;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
public class ifchack extends FragmentActivity
 {
  //6.0权限申请
  private final static int READ_PHONE_STATE_CODE = 101;
  private final static int WRITE_EXTERNAL_STORAGE_CODE = 102;
  private static PermissionModel[] models = new PermissionModel[] {
    new PermissionModel ( Manifest.permission.READ_PHONE_STATE, "我们需要读取手机信息的权限来标识您的身份", READ_PHONE_STATE_CODE ),
    new PermissionModel ( Manifest.permission.WRITE_EXTERNAL_STORAGE, "我们需要您允许我们读写你的存储卡，以方便我们临时保存一些数据",
                         WRITE_EXTERNAL_STORAGE_CODE ),
   };
  @Override
  protected void onCreate ( Bundle savedInstanceState )
   {
    super.onCreate ( savedInstanceState );
    if ( Build.VERSION.SDK_INT < 23 )
     {
      openDemo ( );
      return;
     }
   }
  private void openDemo ( )
   {
    startActivity ( new Intent ( this, a.class ) );
    this.finish ( );
   }
  private void checkPermissions ( )
   {
    try
     {

      for ( PermissionModel model : models )
       {
        if ( PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission ( this, model.permission ) )
         {
          ActivityCompat.requestPermissions ( this, new String[] { model.permission }, model.requestCode );
          return;
         }
       }
      openDemo ( );
     }
    catch (Throwable e)
     {
      Log.e ( "YoumiSdk", "", e );
     }
   }
  @Override
  public void onRequestPermissionsResult ( int requestCode, String[] permissions, int[] grantResults )
   {
    super.onRequestPermissionsResult ( requestCode, permissions, grantResults );
    switch ( requestCode )
     {
      case READ_PHONE_STATE_CODE:
      case WRITE_EXTERNAL_STORAGE_CODE:
       if ( PackageManager.PERMISSION_GRANTED != grantResults [ 0 ] )
        {
         if ( ActivityCompat.shouldShowRequestPermissionRationale ( this, permissions [ 0 ] ) )
          {
           new AlertDialog.Builder ( this ).setTitle ( "权限申请" ).setMessage ( findPermissionExplain ( permissions [ 0 ] ) )
            .setPositiveButton ( "确定", new DialogInterface.OnClickListener ( ) {
              @Override
              public void onClick ( DialogInterface dialog, int which )
               {
                checkPermissions ( );
               }
             } ).show ( );
          }
         else
          {
           Toast.makeText ( this, "部分权限被拒绝获取，将会会影响后续功能的使用，建议重新打开", Toast.LENGTH_LONG ).show ( );
           openAppPermissionSetting ( 123456789 );
          }
         return;
        }
       if ( isAllRequestedPermissionGranted ( ) )
        {
         openDemo ( );
        }
       else
        {
         checkPermissions ( );
        }
       break;
     }
   }
  private String findPermissionExplain ( String permission )
   {
    if ( models != null )
     {
      for ( PermissionModel model : models )
       {
        if ( model != null && model.permission != null && model.permission.equals ( permission ) )
         {
          return model.explain;
         }
       }
     }
    return null;
   }
  private boolean isAllRequestedPermissionGranted ( )
   {
    for ( final PermissionModel model : models )
     {
      if ( PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission ( this, model.permission ) )
       {
        return false;
       }
     }
    return true;
   }
  @Override
  protected void onActivityResult ( int requestCode, int resultCode, Intent data )
   {
    switch ( requestCode )
     {
      case 123456789:
       if ( isAllRequestedPermissionGranted ( ) )
        {
         openDemo ( );
        }
       else
        {
         Toast.makeText ( this, "部分权限被拒绝获取，退出", Toast.LENGTH_LONG ).show ( );
         this.finish ( );
        }
       break;
      default:
       super.onActivityResult ( requestCode, resultCode, data );
     }
   }
  private boolean openAppPermissionSetting ( int requestCode )
   {
    try
     {
      Intent intent =
       new Intent ( Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse ( "package:" + this.getPackageName ( ) ) );
      intent.addCategory ( Intent.CATEGORY_DEFAULT );
      startActivityForResult ( intent, requestCode );
      return true;
     }
    catch (Throwable e)
     {
      Log.e ( "YoumiSdk", "", e );
     }
    return false;
   }
  public static class PermissionModel
   {
    public String permission;
    public String explain;
    public int requestCode;
    public PermissionModel ( String permission, String explain, int requestCode )
     {
      this.permission = permission;
      this.explain = explain;
      this.requestCode = requestCode;
     }
   }
 }

