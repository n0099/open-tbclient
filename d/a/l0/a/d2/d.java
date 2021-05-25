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
    public static final boolean f41323a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static c f41324b;

    /* loaded from: classes3.dex */
    public static class a implements c {
        @Override // d.a.l0.a.d2.c
        public void a(e.C0595e c0595e) {
            d.e(c0595e);
            if (!d.a.l0.a.d2.a.c()) {
                d.i(c0595e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.C0595e f41325e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                if (d.a.l0.a.v2.d.a()) {
                    decodeFile = u.e(b.this.f41325e.f41345b);
                } else {
                    decodeFile = BitmapFactory.decodeFile(b.this.f41325e.f41344a);
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
                if (d.f41323a) {
                    Log.d("SwanAppScreenshot", "saveScreenshot:" + TextUtils.isEmpty(h2) + ",path:" + k.getAbsolutePath());
                }
            }
        }

        public b(e.C0595e c0595e) {
            this.f41325e = c0595e;
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

    public static void e(e.C0595e c0595e) {
        d.a.l0.a.d2.a.b(new b(c0595e));
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
        if (f41323a) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (f41324b == null) {
            f41324b = new a();
        }
        e.r(f41324b);
    }

    public static void h() {
        d.a.l0.a.d2.a.d();
    }

    public static void i(e.C0595e c0595e) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            return;
        }
        d.a.l0.a.c1.a.Y().b(activity, c0595e.f41344a, c0595e.f41345b);
    }

    public static void j() {
        if (f41323a) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        c cVar = f41324b;
        if (cVar != null) {
            e.u(cVar);
            f41324b = null;
        }
    }
}
