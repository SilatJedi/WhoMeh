package com.silatsaktistudios.whomeh;

import android.util.Log;

/**
 * Created by SilatJedi on 9/29/17.
 *
 */

@SuppressWarnings("unused | WeakerAccess")
class LogHelper {

    public static String getLogTag() {
        StackTraceElement ste = new Exception().getStackTrace()[2];
        return ste.getClassName() + "." + ste.getMethodName() +" line #" + ste.getLineNumber();
    }

    public static void logThrowable(Throwable t) {
        Log.e(getLogTag(), t.getMessage(), t);
    }

    public static void logException(Exception e) {
        Log.e(getLogTag(), e.getMessage());
    }

    public static void logDebug(String s) {
        Log.d(getLogTag(), s);
    }

    public static void logInfo(String s) {
        Log.i(getLogTag(), s);
    }
}
