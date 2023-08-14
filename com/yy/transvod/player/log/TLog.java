package com.yy.transvod.player.log;

import android.util.Log;
import com.baidu.tieba.jwb;
import com.baidu.tieba.nxb;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class TLog {
    public static nxb a;
    public static Charset b;
    public static AtomicInteger c;

    public static void k(int i) {
    }

    public static native void nativeSetLevel(int i);

    static {
        Charset forName = Charset.forName("UTF-8");
        b = forName;
        forName.newDecoder();
        c = new AtomicInteger(3);
    }

    public static void a(Object obj, String str) {
        if (c.get() <= 3) {
            String f = f(obj.getClass().getSimpleName());
            String e = e(obj);
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.b(f, e + str);
                return;
            }
            Log.d(f, e + str);
        }
    }

    public static void c(Object obj, String str) {
        if (c.get() <= 6) {
            String e = e(obj);
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.a("[vod-java]", e + str);
                return;
            }
            Log.e("[vod-java]", e + str);
        }
    }

    public static void d(String str, String str2) {
        if (c.get() <= 6) {
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.a("[vod-java]", str + str2);
                return;
            }
            Log.e("[vod-java]", str + str2);
        }
    }

    public static void g(Object obj, String str) {
        if (c.get() <= 4) {
            String e = e(obj);
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.d("[vod-java]", e + str);
                return;
            }
            Log.i("[vod-java]", e + str);
        }
    }

    public static void h(String str, String str2) {
        if (c.get() <= 4) {
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.d("[vod-java]", str + str2);
                return;
            }
            Log.i("[vod-java]", str + str2);
        }
    }

    public static void l(Object obj, String str) {
        if (c.get() <= 5) {
            String e = e(obj);
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.c("[vod-java]", e + str);
                return;
            }
            Log.w("[vod-java]", e + str);
        }
    }

    public static void m(String str, String str2) {
        if (c.get() <= 5) {
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.c("[vod-java]", str + str2);
                return;
            }
            Log.w("[vod-java]", str + str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.get() <= 3) {
            String f = f(str);
            nxb nxbVar = a;
            if (nxbVar != null) {
                nxbVar.b(f, str2);
            } else {
                Log.d(f, str2);
            }
        }
    }

    public static String e(Object obj) {
        if (obj instanceof jwb) {
            return ((jwb) obj).g();
        }
        return "";
    }

    public static void i(int i) {
        c.set(i);
        nativeSetLevel(i);
    }

    public static void j(Object obj) {
        a = (nxb) obj;
    }

    public static String f(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        StringBuilder sb = new StringBuilder(60);
        sb.append("[vod-java][");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append("][");
        sb.append(str);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("()]");
        return sb.toString();
    }
}
