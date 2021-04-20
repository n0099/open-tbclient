package d.b.g0.a.u1;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.k;
import d.b.g0.a.u1.c;
import d.b.g0.a.z0.f;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47024a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.g0.a.u1.a f47025b;

    /* loaded from: classes3.dex */
    public static class a implements d.b.g0.a.u1.a {
        @Override // d.b.g0.a.u1.a
        public void a(c.d dVar) {
            b.c();
            b.e(dVar);
        }
    }

    public static void c() {
        f.V().N(new d.b.g0.a.k0.b.b("onUserCaptureScreen"));
    }

    public static void d() {
        c.s(d.b.g0.a.w0.a.c());
        if (f47024a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f47025b == null) {
            f47025b = new a();
        }
        c.r(f47025b);
    }

    public static void e(c.d dVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.b.g0.a.w0.a.M().b(activity, dVar.f47042a, dVar.f47043b);
    }

    public static void f() {
        if (f47024a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        d.b.g0.a.u1.a aVar = f47025b;
        if (aVar != null) {
            c.u(aVar);
            f47025b = null;
        }
    }
}
