package d.a.h0.a.u1;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.k;
import d.a.h0.a.u1.c;
import d.a.h0.a.z0.f;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44766a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.h0.a.u1.a f44767b;

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.u1.a {
        @Override // d.a.h0.a.u1.a
        public void a(c.d dVar) {
            b.c();
            b.e(dVar);
        }
    }

    public static void c() {
        f.V().x(new d.a.h0.a.k0.b.b("onUserCaptureScreen"));
    }

    public static void d() {
        c.s(d.a.h0.a.w0.a.c());
        if (f44766a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f44767b == null) {
            f44767b = new a();
        }
        c.r(f44767b);
    }

    public static void e(c.d dVar) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.a.h0.a.w0.a.M().b(activity, dVar.f44785a, dVar.f44786b);
    }

    public static void f() {
        if (f44766a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        d.a.h0.a.u1.a aVar = f44767b;
        if (aVar != null) {
            c.u(aVar);
            f44767b = null;
        }
    }
}
