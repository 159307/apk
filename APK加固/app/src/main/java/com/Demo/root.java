package com.Demo;
import java.io.*;
public class root
  {
    /*
    AAPT处理类
    */
    public static final String COMMAND_SU       = "su";
    public static final String COMMAND_SH       = "sh";
    public static final String COMMAND_EXIT     = "exit\n";
    public static final String COMMAND_LINE_END = "\n";
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
    public static void aapt (  )
      {
        String[] ad=new String[]{"chmod 0777 "+utils.activity.a.odexPath+"/aapt"};
        root.m(ad,false);
      }
  }


