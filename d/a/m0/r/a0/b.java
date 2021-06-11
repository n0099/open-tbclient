package d.a.m0.r.a0;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f53310a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f53311b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f53312c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f53313d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f53314e = 1;

    public static int a() {
        a aVar = f53310a;
        if (aVar == null) {
            return -1;
        }
        return aVar.getCurrentTabType();
    }

    public static Class<?> b() {
        a aVar = f53310a;
        if (aVar == null) {
            return null;
        }
        return aVar.d();
    }

    public static String c() {
        a aVar = f53310a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public static void d(Context context) {
        a aVar = f53310a;
        if (aVar == null) {
            return;
        }
        aVar.a(context);
    }

    public static void e(Context context, int i2) {
        a aVar = f53310a;
        if (aVar == null) {
            return;
        }
        aVar.b(context, i2);
    }

    public static void f(Context context, int i2, boolean z) {
        a aVar = f53310a;
        if (aVar == null) {
            return;
        }
        aVar.c(context, i2, z);
    }

    public static void g(Context context, int i2, boolean z) {
        a aVar = f53310a;
        if (aVar == null) {
            return;
        }
        aVar.e(context, i2, z);
    }

    public static void h(a aVar) {
        f53310a = aVar;
    }
}
