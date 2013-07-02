package org.acra.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
/* loaded from: classes.dex */
public final class h {
    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static long b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (RuntimeException e) {
            Log.w(org.acra.a.a, "Couldn't retrieve DeviceId for : " + context.getPackageName(), e);
            return null;
        }
    }

    public static String b(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        Log.w(org.acra.a.a, "Couldn't retrieve ApplicationFilePath for : " + context.getPackageName());
        return "Couldn't retrieve ApplicationFilePath";
    }

    public static String c(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            StringBuilder sb = new StringBuilder();
            sb.append("width=").append(defaultDisplay.getWidth()).append('\n');
            sb.append("height=").append(defaultDisplay.getHeight()).append('\n');
            sb.append("pixelFormat=").append(defaultDisplay.getPixelFormat()).append('\n');
            sb.append("refreshRate=").append(defaultDisplay.getRefreshRate()).append("fps").append('\n');
            sb.append("metrics.density=x").append(displayMetrics.density).append('\n');
            sb.append("metrics.scaledDensity=x").append(displayMetrics.scaledDensity).append('\n');
            sb.append("metrics.widthPixels=").append(displayMetrics.widthPixels).append('\n');
            sb.append("metrics.heightPixels=").append(displayMetrics.heightPixels).append('\n');
            sb.append("metrics.xdpi=").append(displayMetrics.xdpi).append('\n');
            sb.append("metrics.ydpi=").append(displayMetrics.ydpi);
            return sb.toString();
        } catch (RuntimeException e) {
            Log.w(org.acra.a.a, "Couldn't retrieve DisplayDetails for : " + context.getPackageName(), e);
            return "Couldn't retrieve Display Details";
        }
    }
}
