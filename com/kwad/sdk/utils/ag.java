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
/* loaded from: classes7.dex */
public final class ag {
    public static void b(Context context, boolean z) {
        try {
            Activity cC = cC(context);
            if (cC == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    cC.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    cC.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                cC.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                cC.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cA(Context context) {
        Activity cC = cC(context);
        if (cC != null) {
            cC.setRequestedOrientation(1);
        }
    }

    public static boolean cB(Context context) {
        try {
            return bj.getApplicationContext(context).getResources().getConfiguration().orientation != 2;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return true;
        }
    }

    @Nullable
    public static Activity cC(Context context) {
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

    public static boolean cx(Context context) {
        Activity cC = cC(context);
        if (cC != null) {
            Window window = cC.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void cy(Context context) {
        Activity cC = cC(context);
        if (cC != null) {
            cC.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cz(Context context) {
        Activity cC = cC(context);
        if (cC != null) {
            cC.setRequestedOrientation(0);
        }
    }

    public static boolean zL() {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        return context == null || Wrapper.unwrapContextIfNeed(context).getApplicationContext().getResources().getConfiguration().orientation == 1;
    }
}
