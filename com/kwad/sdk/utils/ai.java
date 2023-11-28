package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class ai {
    public static boolean Kx() {
        return isOrientationPortrait();
    }

    public static boolean isOrientationPortrait() {
        if (ServiceProvider.Jn().getApplicationContext().getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public static void b(Context context, boolean z) {
        try {
            Activity m186do = com.kwad.sdk.m.l.m186do(context);
            if (m186do == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    m186do.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    m186do.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                m186do.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                m186do.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean cl(Context context) {
        Activity m186do = com.kwad.sdk.m.l.m186do(context);
        boolean z = false;
        if (m186do != null) {
            Window window = m186do.getWindow();
            if ((window.getAttributes().flags & 1024) == 1024) {
                z = true;
            }
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void cm(Context context) {
        Activity m186do = com.kwad.sdk.m.l.m186do(context);
        if (m186do != null) {
            m186do.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cn(Context context) {
        Activity m186do = com.kwad.sdk.m.l.m186do(context);
        if (m186do != null) {
            m186do.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void co(Context context) {
        Activity m186do = com.kwad.sdk.m.l.m186do(context);
        if (m186do != null) {
            m186do.setRequestedOrientation(1);
        }
    }
}
