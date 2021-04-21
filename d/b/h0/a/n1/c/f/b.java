package d.b.h0.a.n1.c.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f46104b;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46103a = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f46105c = false;

    /* loaded from: classes2.dex */
    public static class a implements d.b.h0.a.e0.k.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46106a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f46107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f46108c;

        public a(Context context, c cVar, Bundle bundle) {
            this.f46106a = context;
            this.f46107b = cVar;
            this.f46108c = bundle;
        }

        @Override // d.b.h0.a.e0.k.d.b
        public void a() {
            boolean unused = b.f46105c = true;
            d.b.h0.g.i0.f.d.c();
            b.f(this.f46106a, this.f46107b, this.f46108c);
        }
    }

    /* renamed from: d.b.h0.a.n1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0778b implements d.b.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f46110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f46111g;

        public C0778b(Context context, c cVar, Bundle bundle) {
            this.f46109e = context;
            this.f46110f = cVar;
            this.f46111g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            b.e(this.f46109e, this.f46110f, this.f46111g);
        }
    }

    public static String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", d.b.h0.a.e0.w.d.L().Z());
            jSONObject.put("slave", d.b.h0.a.e0.w.d.L().b0());
        } catch (JSONException e2) {
            if (f46103a) {
                throw new RuntimeException(e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f46103a) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static void e(Context context, c cVar, Bundle bundle) {
        boolean j = d.b.h0.a.w0.a.N() != null ? d.b.h0.a.w0.a.N().j() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (j) {
            if (isMainProcess && TextUtils.isEmpty(f46104b)) {
                try {
                    f46104b = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e2) {
                    f46104b = "exception::" + e2.toString();
                    if (f46103a) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.f46112f.index);
                jSONObject.put("ua", f46104b);
            } catch (JSONException e3) {
                if (f46103a) {
                    e3.printStackTrace();
                }
            }
            i.d dVar = new i.d("812");
            dVar.g("swan");
            dVar.i(Config.LAUNCH);
            dVar.h(str);
            dVar.e(jSONObject);
            i.onEvent(dVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (j) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.f46112f.index);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e4) {
                if (f46103a) {
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
        if (d.b.h0.a.b2.b.i()) {
            d.b.h0.a.b2.d.a.e();
        }
        bundle.putParcelable("bundle_key_swan_core", d.b.h0.a.b2.b.d(0));
        bundle.putParcelable("bundle_key_extension_core", d.b.h0.a.l0.b.b(0));
        bundle.putInt("bundle_key_preload_switch", d.b.h0.a.w0.a.f().b());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        if (!d.b.h0.a.j1.m.c.c()) {
            bundle.putBoolean("bundle_key_v8_ab", d.b.h0.a.w0.a.N().q());
        }
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.f46112f.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        d.b.h0.g.i0.f.d.j(bundle);
        cVar.W(context, bundle);
    }

    public static void f(Context context, c cVar, Bundle bundle) {
        SwanLauncher.j().l(new C0778b(context, cVar, bundle));
    }

    public static void g(Context context, c cVar, Bundle bundle) {
        if (f46105c) {
            d.b.h0.g.i0.f.d.d();
            f(context, cVar, bundle);
            return;
        }
        d.b.h0.a.p.d.j.c.a().b().b().b(new a(context, cVar, bundle));
    }

    public static void h(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", d.b.h0.a.w0.a.N().q());
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
            if (f46103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void j(Context context, Bundle bundle) {
        k(context, e.j().e(), bundle);
    }

    public static void k(Context context, c cVar, Bundle bundle) {
        if (f46103a) {
            e j = e.j();
            j.t("b4 tryPreload client=" + cVar);
        }
        if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f46112f.isSwanAppProcess() || cVar.x()) {
            return;
        }
        g(context, cVar, bundle);
    }

    public static void l(Context context, Bundle bundle) {
        d.b.h0.a.p.c.d N = d.b.h0.a.w0.a.N();
        if (!d.b.h0.a.m1.a.a.S()) {
            N.getSwitch("swan_preload_keep_alive", true);
        }
        j(context, bundle);
    }
}
