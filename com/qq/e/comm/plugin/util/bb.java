package com.qq.e.comm.plugin.util;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class bb {
    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(11)
    public static void a(Context context, int i) {
        com.qq.e.comm.plugin.d.b a2 = com.qq.e.comm.plugin.d.b.a(context);
        if (a2 != null) {
            if ((i & 4) > 0) {
                a(a2, true);
            } else if ((i & 8) > 0) {
                a(a2, false);
            }
        }
        Activity a3 = a(context);
        if (a3 != null) {
            ActionBar actionBar = a3.getActionBar();
            if (actionBar != null) {
                if ((i & 2) > 0) {
                    actionBar.hide();
                } else if ((i & 1) > 0) {
                    actionBar.show();
                }
            }
            if ((i & 16) > 0) {
                a3.getWindow().clearFlags(1024);
            } else if ((i & 32) > 0) {
                a3.getWindow().addFlags(1024);
            }
        }
    }

    private static void a(com.qq.e.comm.plugin.d.b bVar, boolean z) {
        com.qq.e.comm.plugin.d.a a2 = bVar.a();
        if (a2 == null) {
            return;
        }
        a2.a(false);
        if (z) {
            a2.b();
        } else {
            a2.c();
        }
    }

    public static boolean a() {
        try {
            Class.forName("com.qq.e.ads.cfg.VideoOption");
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean a(com.qq.e.comm.plugin.d.b bVar) {
        com.qq.e.comm.plugin.d.a a2 = bVar.a();
        if (a2 == null) {
            return false;
        }
        return a2.a();
    }

    @TargetApi(11)
    public static void b(Context context) {
        com.qq.e.comm.plugin.d.b a2 = com.qq.e.comm.plugin.d.b.a(context);
        if (a2 != null) {
            a(a2, false);
        }
        Activity a3 = a(context);
        if (a3 != null) {
            ActionBar actionBar = a3.getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            a3.getWindow().setFlags(1024, 1024);
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    @TargetApi(11)
    public static int c(Context context) {
        int i;
        com.qq.e.comm.plugin.d.b a2 = com.qq.e.comm.plugin.d.b.a(context);
        if (a2 != null) {
            i = (a(a2) ? 4 : 8) | 0;
        } else {
            i = 0;
        }
        Activity a3 = a(context);
        if (a3 != null) {
            ActionBar actionBar = a3.getActionBar();
            if (actionBar != null) {
                i |= actionBar.isShowing() ? 1 : 2;
            }
            WindowManager.LayoutParams attributes = a3.getWindow().getAttributes();
            return attributes != null ? (attributes.flags & 1024) > 0 ? i | 32 : i | 16 : i;
        }
        return i;
    }

    public static boolean c() {
        try {
            Class.forName("com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener");
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
