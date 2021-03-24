package d.b.g0.a.u1;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.k;
import d.b.g0.a.u1.c;
import d.b.g0.a.z0.f;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46631a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.g0.a.u1.a f46632b;

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
        if (f46631a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f46632b == null) {
            f46632b = new a();
        }
        c.r(f46632b);
    }

    public static void e(c.d dVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.b.g0.a.w0.a.M().b(activity, dVar.f46649a, dVar.f46650b);
    }

    public static void f() {
        if (f46631a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        d.b.g0.a.u1.a aVar = f46632b;
        if (aVar != null) {
            c.u(aVar);
            f46632b = null;
        }
    }
}
