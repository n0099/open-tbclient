package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;
/* loaded from: classes6.dex */
public class x {
    public static void a(Context context, boolean z) {
        try {
            Activity f2 = f(context);
            if (z) {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                f2.getWindow().getDecorView().setSystemUiVisibility(0);
            } else if (Build.VERSION.SDK_INT >= 19) {
                f2.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        Activity f2 = f(context);
        if (f2 != null) {
            Window window = f2.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void b(Context context) {
        Activity f2 = f(context);
        if (f2 != null) {
            f2.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void c(Context context) {
        Activity f2 = f(context);
        if (f2 != null) {
            f2.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void d(Context context) {
        Activity f2 = f(context);
        if (f2 != null) {
            f2.setRequestedOrientation(1);
        }
    }

    public static boolean e(Context context) {
        if (!(context instanceof Activity)) {
            return context.getResources().getConfiguration().orientation != 2;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels > displayMetrics.widthPixels;
    }

    public static Activity f(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return activity.getParent() != null ? activity.getParent() : activity;
        } else if (context instanceof ContextWrapper) {
            return f(((ContextWrapper) context).getBaseContext());
        } else {
            return null;
        }
    }
}
