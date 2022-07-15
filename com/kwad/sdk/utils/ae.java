package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class ae {
    public static void a(Context context, boolean z) {
        try {
            Activity f = f(context);
            if (f == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    f.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    f.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                f.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                f.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a() {
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a == null || Wrapper.unwrapContextIfNeed(a).getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static boolean a(Context context) {
        Activity f = f(context);
        if (f != null) {
            Window window = f.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void b(Context context) {
        Activity f = f(context);
        if (f != null) {
            f.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void c(Context context) {
        Activity f = f(context);
        if (f != null) {
            f.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void d(Context context) {
        Activity f = f(context);
        if (f != null) {
            f.setRequestedOrientation(1);
        }
    }

    public static boolean e(Context context) {
        return bf.a(context).getResources().getConfiguration().orientation != 2;
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
