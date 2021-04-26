package d.a.h0.a.n1.c.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f43449b;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43448a = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43450c = false;

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.e0.k.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f43452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f43453c;

        public a(Context context, c cVar, Bundle bundle) {
            this.f43451a = context;
            this.f43452b = cVar;
            this.f43453c = bundle;
        }

        @Override // d.a.h0.a.e0.k.d.b
        public void a() {
            boolean unused = b.f43450c = true;
            d.a.h0.g.i0.f.d.c();
            b.f(this.f43451a, this.f43452b, this.f43453c);
        }
    }

    /* renamed from: d.a.h0.a.n1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0717b implements d.a.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f43455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f43456g;

        public C0717b(Context context, c cVar, Bundle bundle) {
            this.f43454e = context;
            this.f43455f = cVar;
            this.f43456g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            b.e(this.f43454e, this.f43455f, this.f43456g);
        }
    }

    public static String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", d.a.h0.a.e0.w.d.L().Z());
            jSONObject.put("slave", d.a.h0.a.e0.w.d.L().b0());
        } catch (JSONException e2) {
            if (f43448a) {
                throw new RuntimeException(e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f43448a) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static void e(Context context, c cVar, Bundle bundle) {
        boolean A = d.a.h0.a.w0.a.N() != null ? d.a.h0.a.w0.a.N().A() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (A) {
            if (isMainProcess && TextUtils.isEmpty(f43449b)) {
                try {
                    f43449b = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e2) {
                    f43449b = "exception::" + e2.toString();
                    if (f43448a) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.f43457f.index);
                jSONObject.put("ua", f43449b);
            } catch (JSONException e3) {
                if (f43448a) {
                    e3.printStackTrace();
                }
            }
            i.d dVar = new i.d("812");
            dVar.g("swan");
            dVar.i("launch");
            dVar.h(str);
            dVar.e(jSONObject);
            i.onEvent(dVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (A) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.f43457f.index);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e4) {
                if (f43448a) {
                    e4.printStackTrace();
                }
            }
            i.d dVar2 = new i.d("812");
            dVar2.g("swan");
            dVar2.i("swan_updated");
            dVar2.h(str);
            dVar2.e(jSONObject2);
            i.onEvent(dVar2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (d.a.h0.a.b2.b.i()) {
            d.a.h0.a.b2.d.a.e();
        }
        bundle.putParcelable("bundle_key_swan_core", d.a.h0.a.b2.b.d(0));
        bundle.putParcelable("bundle_key_extension_core", d.a.h0.a.l0.b.b(0));
        bundle.putInt("bundle_key_preload_switch", d.a.h0.a.w0.a.f().a());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        if (!d.a.h0.a.j1.m.c.c()) {
            bundle.putBoolean("bundle_key_v8_ab", d.a.h0.a.w0.a.N().D());
        }
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.f43457f.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        d.a.h0.g.i0.f.d.j(bundle);
        cVar.W(context, bundle);
    }

    public static void f(Context context, c cVar, Bundle bundle) {
        SwanLauncher.j().l(new C0717b(context, cVar, bundle));
    }

    public static void g(Context context, c cVar, Bundle bundle) {
        if (f43450c) {
            d.a.h0.g.i0.f.d.d();
            f(context, cVar, bundle);
            return;
        }
        d.a.h0.a.p.d.j.c.a().b().a().b(new a(context, cVar, bundle));
    }

    public static void h(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", d.a.h0.a.w0.a.N().D());
    }

    public static void i(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SwanAppMessengerService.class);
        intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            context.startService(intent);
        } catch (Exception e2) {
            if (f43448a) {
                e2.printStackTrace();
            }
        }
    }

    public static void j(Context context, Bundle bundle) {
        k(context, e.j().e(), bundle);
    }

    public static void k(Context context, c cVar, Bundle bundle) {
        if (f43448a) {
            e j = e.j();
            j.t("b4 tryPreload client=" + cVar);
        }
        if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f43457f.isSwanAppProcess() || cVar.z()) {
            return;
        }
        g(context, cVar, bundle);
    }

    public static void l(Context context, Bundle bundle) {
        d.a.h0.a.p.c.d N = d.a.h0.a.w0.a.N();
        if (!d.a.h0.a.m1.a.a.S()) {
            N.getSwitch("swan_preload_keep_alive", true);
        }
        j(context, bundle);
    }
}
