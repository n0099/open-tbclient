package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.TypedValue;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class ak {
    public static float a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int a(Context context) {
        try {
            return (context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
        } catch (Exception e) {
            GDTLogger.d("Get device type encounter exception: " + e.getMessage());
            return 0;
        }
    }

    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static float b(Context context, float f) {
        return (f / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i) {
        return (int) ((i / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }
}
