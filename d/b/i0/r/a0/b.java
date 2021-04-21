package d.b.i0.r.a0;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f51157a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f51158b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f51159c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f51160d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f51161e = 1;

    public static int a() {
        a aVar = f51157a;
        if (aVar == null) {
            return -1;
        }
        return aVar.getCurrentTabType();
    }

    public static Class<?> b() {
        a aVar = f51157a;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public static String c() {
        a aVar = f51157a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public static void d(Context context) {
        a aVar = f51157a;
        if (aVar == null) {
            return;
        }
        aVar.a(context);
    }

    public static void e(Context context, int i) {
        a aVar = f51157a;
        if (aVar == null) {
            return;
        }
        aVar.e(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        a aVar = f51157a;
        if (aVar == null) {
            return;
        }
        aVar.b(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        a aVar = f51157a;
        if (aVar == null) {
            return;
        }
        aVar.d(context, i, z);
    }

    public static void h(a aVar) {
        f51157a = aVar;
    }
}
