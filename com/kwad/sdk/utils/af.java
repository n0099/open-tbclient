package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class af {
    public static void a(Context context, boolean z) {
        try {
            Activity f2 = f(context);
            if (f2 == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    f2.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                f2.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                f2.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a() {
        Context context = KsAdSDKImpl.get().getContext();
        return context == null || Wrapper.unwrapContextIfNeed(context).getApplicationContext().getResources().getConfiguration().orientation == 1;
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
        return Wrapper.unwrapContextIfNeed(KsAdSDKImpl.get().getContext()).getResources().getConfiguration().orientation != 2;
    }

    @Nullable
    public static Activity f(Context context) {
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(context);
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                return (Activity) context;
            } else {
                context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
            }
        } while (!hashSet.contains(context));
        return null;
    }
}
