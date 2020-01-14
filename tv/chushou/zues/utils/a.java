package tv.chushou.zues.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.io.File;
import java.io.FileInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes4.dex */
public class a {
    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float a(int i, float f, Context context) {
        return TypedValue.applyDimension(i, f, context.getResources().getDisplayMetrics());
    }

    public static void e(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                e((ViewGroup) childAt, z);
            } else {
                childAt.setEnabled(z);
            }
        }
    }

    public static Point he(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    public static Point hf(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
            return point;
        }
        return he(context);
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || h.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean dPa() {
        Application dOE = h.dOE();
        if (dOE == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) dOE.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean hg(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                return networkInfo.getState() == NetworkInfo.State.CONNECTED;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hh(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean dPb() {
        FileInputStream fileInputStream;
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(new File("/system/etc/media_codecs.xml"));
        } catch (Exception e) {
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(fileInputStream, "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    String name = newPullParser.getName();
                    switch (eventType) {
                        case 2:
                            if ("MediaCodec".equals(name)) {
                                String attributeValue = newPullParser.getAttributeValue(0);
                                if (attributeValue.startsWith("OMX.") && !attributeValue.startsWith("OMX.google.")) {
                                    z = true;
                                    continue;
                                }
                            } else {
                                continue;
                            }
                            break;
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (z || !new File("/system/etc/media_codecs_mediatek_video.xml").exists()) {
            return z;
        }
        return true;
    }

    public static String Oh(@ColorInt int i) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        String hexString = Integer.toHexString(red);
        if (hexString.length() < 2) {
            sb.append("0").append(hexString);
        } else {
            sb.append(hexString);
        }
        String hexString2 = Integer.toHexString(green);
        if (hexString2.length() < 2) {
            sb.append("0").append(hexString2);
        } else {
            sb.append(hexString2);
        }
        String hexString3 = Integer.toHexString(blue);
        if (hexString3.length() < 2) {
            sb.append("0").append(hexString3);
        } else {
            sb.append(hexString3);
        }
        return sb.toString().toLowerCase();
    }
}
