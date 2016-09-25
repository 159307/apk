package utils.activity;

import android.content.*;
import android.net.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;

public class c
 {
  public static boolean isNetworkAvailable ( Context context )
   {   
    ConnectivityManager cm = (ConnectivityManager) context   
     .getSystemService ( Context.CONNECTIVITY_SERVICE );   
    if ( cm == null )
     {   
     }
    else
     {
      NetworkInfo[] info = cm.getAllNetworkInfo ( );   
      if ( info != null )
       {   
        for ( int i = 0; i < info.length; i++ )
         {   
          if ( info [ i ].getState ( ) == NetworkInfo.State.CONNECTED )
           {   
            return true;   
           }   
         }   
       }   
     }   
    return false;   
   } 
 }
