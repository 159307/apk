package Xbox;
public class xm
  {
    public static native void a ( String path );
    public static native void b ( );
    static{
        System.loadLibrary ( "fmodex" );
        System.loadLibrary ( "hello" );
      }
  }
