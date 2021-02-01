package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.sdk.QbSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    private static int f12581a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f12582b;
    private static Method c;
    private static volatile boolean d;
    private static Boolean e;

    private static void a(boolean z) {
        if (as.b(GDTADManager.getInstance().getSM().getInteger("webViewTypeEventRate", 10), 10000)) {
            if (z) {
                com.qq.e.comm.plugin.y.u.a(90102, 0, null);
            } else {
                com.qq.e.comm.plugin.y.u.a(90112, 0, null);
            }
        }
    }

    public static boolean a() {
        if (GDTADManager.getInstance().getSM().getInteger("x5Switch", 1) == 0) {
            a(false);
            return false;
        }
        switch (f12581a) {
            case 0:
                try {
                    if (f12582b == null) {
                        f12582b = Class.forName("com.tencent.smtt.sdk.QbSdk");
                    }
                    if (c == null) {
                        c = f12582b.getDeclaredMethod("isTbsCoreInited", new Class[0]);
                    }
                    Object invoke = c.invoke(f12582b, new Object[0]);
                    if (!(invoke instanceof Boolean)) {
                        f12581a = 2;
                    } else if (((Boolean) invoke).booleanValue()) {
                        f12581a = 1;
                        ai.a("gdt_tag_x5", "isTbsCoreInited = true");
                        a(true);
                        return true;
                    } else {
                        c();
                    }
                } catch (ClassNotFoundException e2) {
                    f12581a = 2;
                } catch (IllegalAccessException e3) {
                    f12581a = 2;
                } catch (NoSuchMethodException e4) {
                    f12581a = 2;
                } catch (InvocationTargetException e5) {
                    f12581a = 2;
                }
                ai.a("gdt_tag_x5", "isTbsCoreInited = false");
                a(false);
                return false;
            case 1:
                ai.a("gdt_tag_x5", "isTbsCoreInited = true");
                a(true);
                return true;
            case 2:
                ai.a("gdt_tag_x5", "isTbsCoreInited = false");
                a(false);
                return false;
            default:
                ai.a("gdt_tag_x5", "isTbsCoreInited = false");
                a(false);
                return false;
        }
    }

    public static boolean b() {
        boolean booleanValue;
        synchronized (bi.class) {
            try {
                if (e == null) {
                    if (f12582b == null) {
                        try {
                            f12582b = Class.forName("com.tencent.smtt.sdk.QbSdk");
                        } catch (ClassNotFoundException e2) {
                            GDTLogger.i("no QbSdk Environment");
                        }
                    }
                    e = Boolean.valueOf(f12582b != null);
                }
                booleanValue = e.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static void c() {
        if (d) {
            return;
        }
        d = true;
        try {
            QbSdk.initX5Environment(GDTADManager.getInstance().getAppContext(), (QbSdk.PreInitCallback) null);
        } catch (Throwable th) {
            ai.b("gdt_tag_x5", "tryInitTbsCoreOnce fail : %s", th);
        }
    }
}
