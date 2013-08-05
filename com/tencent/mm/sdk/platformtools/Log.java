package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.widget.Toast;
import com.tencent.mm.algorithm.b;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
/* loaded from: classes.dex */
public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static PrintStream ar;
    private static final String at;
    private static int level = 0;
    private static byte[] as = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb.append("] BOARD:[" + Build.BOARD);
        sb.append("] DEVICE:[" + Build.DEVICE);
        sb.append("] DISPLAY:[" + Build.DISPLAY);
        sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb.append("] HOST:[" + Build.HOST);
        sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb.append("] MODEL:[" + Build.MODEL);
        sb.append("] PRODUCT:[" + Build.PRODUCT);
        sb.append("] TAGS:[" + Build.TAGS);
        sb.append("] TYPE:[" + Build.TYPE);
        sb.append("] USER:[" + Build.USER + "]");
        at = sb.toString();
    }

    protected Log() {
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Object... objArr) {
        if (level <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.d(str, str2);
            LogHelper.writeToStream(ar, as, "D/" + str, str2);
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (level <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.e(str, str2);
            LogHelper.writeToStream(ar, as, "E/" + str, str2);
        }
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (level <= 5) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.e(str, str2);
            LogHelper.writeToStream(ar, as, "F/" + str, str2);
            Toast.makeText(MMApplicationContext.getContext(), str2, 1).show();
        }
    }

    public static int getLevel() {
        return level;
    }

    public static String getSysInfo() {
        return at;
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (level <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.i(str, str2);
            LogHelper.writeToStream(ar, as, "I/" + str, str2);
        }
    }

    public static void reset() {
        ar = null;
        as = null;
    }

    public static void setLevel(int i, boolean z) {
        level = i;
        android.util.Log.w("MicroMsg.SDK.Log", "new log level: " + i);
        if (z) {
            android.util.Log.e("MicroMsg.SDK.Log", "no jni log level support");
        }
    }

    public static void setOutputPath(String str, String str2, String str3, int i) {
        if (str == null || str.length() == 0 || str3 == null || str3.length() == 0) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                FileInputStream fileInputStream = file.length() > 0 ? new FileInputStream(str) : null;
                setOutputStream(fileInputStream, new FileOutputStream(str, true), str2, str3, i);
                fileInputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setOutputStream(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        long currentTimeMillis;
        try {
            ar = new PrintStream(new BufferedOutputStream(outputStream));
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String trim = bufferedReader.readLine().substring(2).trim();
                str2 = bufferedReader.readLine().substring(2).trim();
                currentTimeMillis = Util.getLong(bufferedReader.readLine().trim().substring(2), 0L);
                d("MicroMsg.SDK.Log", "using provided info, type=%s, user=%s, createtime=%d", trim, str2, Long.valueOf(currentTimeMillis));
            } else {
                currentTimeMillis = System.currentTimeMillis();
                LogHelper.initLogHeader(ar, str, str2, currentTimeMillis, i);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(currentTimeMillis);
            stringBuffer.append("dfdhgc");
            as = b.a(stringBuffer.toString().getBytes()).substring(7, 21).getBytes();
            android.util.Log.d("MicroMsg.SDK.Log", "set up out put stream");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void v(String str, String str2, Object... objArr) {
        if (level <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.v(str, str2);
            LogHelper.writeToStream(ar, as, "V/" + str, str2);
        }
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (level <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            android.util.Log.w(str, str2);
            LogHelper.writeToStream(ar, as, "W/" + str, str2);
        }
    }
}
