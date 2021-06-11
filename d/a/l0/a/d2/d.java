package d.a.l0.a.d2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.d2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.u;
import d.a.l0.a.v2.w;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44999a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static c f45000b;

    /* loaded from: classes3.dex */
    public static class a implements c {
        @Override // d.a.l0.a.d2.c
        public void a(e.C0651e c0651e) {
            d.e(c0651e);
            if (!d.a.l0.a.d2.a.c()) {
                d.i(c0651e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.C0651e f45001e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                if (d.a.l0.a.v2.d.a()) {
                    decodeFile = u.e(b.this.f45001e.f45021b);
                } else {
                    decodeFile = BitmapFactory.decodeFile(b.this.f45001e.f45020a);
                }
                File k = u.k("screenshot.jpg");
                if (decodeFile != null) {
                    u.o(decodeFile, k.getAbsolutePath(), 20);
                }
                String h2 = f.V().I().h(k.getAbsolutePath());
                if (!k.exists()) {
                    h2 = "";
                }
                d.f(h2);
                if (d.f44999a) {
                    Log.d("SwanAppScreenshot", "saveScreenshot:" + TextUtils.isEmpty(h2) + ",path:" + k.getAbsolutePath());
                }
            }
        }

        public b(e.C0651e c0651e) {
            this.f45001e = c0651e;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (!bool.booleanValue()) {
                d.f("");
            } else {
                q.j(new a(), "dispatchCaptureScreenEvent");
            }
        }
    }

    public static void e(e.C0651e c0651e) {
        d.a.l0.a.d2.a.b(new b(c0651e));
    }

    public static void f(String str) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            w.f(jSONObject, "imagePath", str);
        }
        hashMap.put("data", jSONObject.toString());
        f.V().v(new d.a.l0.a.o0.d.b("onUserCaptureScreen", hashMap));
    }

    public static void g() {
        e.s(d.a.l0.a.c1.a.b());
        if (f44999a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f45000b == null) {
            f45000b = new a();
        }
        e.r(f45000b);
    }

    public static void h() {
        d.a.l0.a.d2.a.d();
    }

    public static void i(e.C0651e c0651e) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.a.l0.a.c1.a.Y().b(activity, c0651e.f45020a, c0651e.f45021b);
    }

    public static void j() {
        if (f44999a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        c cVar = f45000b;
        if (cVar != null) {
            e.u(cVar);
            f45000b = null;
        }
    }
}
