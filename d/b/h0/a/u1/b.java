package d.b.h0.a.u1;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.k;
import d.b.h0.a.u1.c;
import d.b.h0.a.z0.f;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47353a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.h0.a.u1.a f47354b;

    /* loaded from: classes3.dex */
    public static class a implements d.b.h0.a.u1.a {
        @Override // d.b.h0.a.u1.a
        public void a(c.d dVar) {
            b.c();
            b.e(dVar);
        }
    }

    public static void c() {
        f.V().N(new d.b.h0.a.k0.b.b("onUserCaptureScreen"));
    }

    public static void d() {
        c.s(d.b.h0.a.w0.a.c());
        if (f47353a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f47354b == null) {
            f47354b = new a();
        }
        c.r(f47354b);
    }

    public static void e(c.d dVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.b.h0.a.w0.a.M().b(activity, dVar.f47371a, dVar.f47372b);
    }

    public static void f() {
        if (f47353a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        d.b.h0.a.u1.a aVar = f47354b;
        if (aVar != null) {
            c.u(aVar);
            f47354b = null;
        }
    }
}
