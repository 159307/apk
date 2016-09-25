package utils.activity;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import java.lang.Process;
public class 无名指
  {
    public static final String COMMAND_SU       = "su";
    public static final String COMMAND_SH       = "sh";
    public static final String COMMAND_EXIT     = "exit\n";
    public static final String COMMAND_LINE_END = "\n";
    /*
     执行shell命令 实现APK优化
     */
    public static void m ( String[] commands, boolean isRoot )
      {
        Process process = null;
        DataOutputStream os = null;
        try
          {
            process = Runtime.getRuntime ( ).exec ( isRoot ? COMMAND_SU : COMMAND_SH );
            os = new DataOutputStream ( process.getOutputStream ( ) );
            for ( String command : commands )
              {
                if ( command == null )
                  {
                    continue;
                  }
                os.write ( command.getBytes ( ) );
                os.writeBytes ( COMMAND_LINE_END );
                os.flush ( );
              }
            os.writeBytes ( COMMAND_EXIT );
            os.flush ( );
          }
        catch (IOException e)
          {
            e.printStackTrace ( );
          }
        catch (Exception e)
          {
            e.printStackTrace ( );
          }
      }
    public static void k (  )
      {
        String[] ad=new String[]{"chmod 0755 " + a.odexPath + "/zipalign",a.odexPath + "/zipalign -c -v 4 " + a.path + "/半成品.apk"};
        无名指.m ( ad, false );
      }
  }

