package d.a.i0.r.a0;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f48762a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f48763b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f48764c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f48765d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f48766e = 1;

    public static int a() {
        a aVar = f48762a;
        if (aVar == null) {
            return -1;
        }
        return aVar.getCurrentTabType();
    }

    public static Class<?> b() {
        a aVar = f48762a;
        if (aVar == null) {
            return null;
        }
        return aVar.d();
    }

    public static String c() {
        a aVar = f48762a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public static void d(Context context) {
        a aVar = f48762a;
        if (aVar == null) {
            return;
        }
        aVar.a(context);
    }

    public static void e(Context context, int i2) {
        a aVar = f48762a;
        if (aVar == null) {
            return;
        }
        aVar.b(context, i2);
    }

    public static void f(Context context, int i2, boolean z) {
        a aVar = f48762a;
        if (aVar == null) {
            return;
        }
        aVar.c(context, i2, z);
    }

    public static void g(Context context, int i2, boolean z) {
        a aVar = f48762a;
        if (aVar == null) {
            return;
        }
        aVar.e(context, i2, z);
    }

    public static void h(a aVar) {
        f48762a = aVar;
    }
}
