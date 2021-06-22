package d.a.m0.a.e0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.f1.e.c;
import d.a.m0.a.p.d.n;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: f  reason: collision with root package name */
    public static Set<String> f45143f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f45144g = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f45145c;

    /* renamed from: d  reason: collision with root package name */
    public int f45146d;

    /* renamed from: e  reason: collision with root package name */
    public c f45147e;

    /* renamed from: d.a.m0.a.e0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0657a implements n.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45149b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45150c;

        public C0657a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45148a = context;
            this.f45149b = unitedSchemeEntity;
            this.f45150c = callbackHandler;
        }

        @Override // d.a.m0.a.p.d.n.b
        public void a(boolean z) {
            if (z) {
                d.a.m0.a.e0.d.b("LocalDebugAction", "Authentication Success");
                a.f45144g.add(a.this.o(this.f45148a));
                a.this.p(this.f45148a, this.f45149b, this.f45150c);
                return;
            }
            d.a.m0.a.e0.d.b("LocalDebugAction", "Authentication Fail : Not developer");
            a.this.w(this.f45148a, this.f45149b, 401);
        }

        @Override // d.a.m0.a.p.d.n.b
        public void b(Exception exc) {
            d.a.m0.a.e0.d.c("LocalDebugAction", "onFail : Authentication exception :", exc);
            a.this.w(this.f45148a, this.f45149b, 401);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f45154g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45155h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45156i;

        public b(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45152e = context;
            this.f45153f = str;
            this.f45154g = file;
            this.f45155h = unitedSchemeEntity;
            this.f45156i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.x(this.f45152e, this.f45153f, this.f45154g, this.f45155h, this.f45156i);
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/localdebuglaunch");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (!t()) {
            d.a.m0.a.e0.d.b("LocalDebugAction", "switch is off");
            w(context, unitedSchemeEntity, 1003);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
            this.f45147e = c.c(optParamsAsJo);
            if (d.a.m0.a.m2.b.e(0).swanCoreVersionCode < this.f45147e.f45168h) {
                d.a.m0.a.e0.d.b("LocalDebugAction", "swan js version is low");
                w(context, unitedSchemeEntity, 1002);
                return false;
            } else if (!u()) {
                d.a.m0.a.e0.d.b("LocalDebugAction", "debug model invalid");
                w(context, unitedSchemeEntity, 202);
                return false;
            } else if (!d.a.m0.a.s.a.f.f48364d.f() && !s().contains(d.a.m0.a.c1.a.a0().h(context)) && !f45144g.contains(o(context))) {
                d.a.m0.a.m.b.b(this.f45147e.f45162b, new C0657a(context, unitedSchemeEntity, callbackHandler));
                return true;
            } else {
                p(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        d.a.m0.a.e0.d.b("LocalDebugAction", "param is null");
        w(context, unitedSchemeEntity, 202);
        return false;
    }

    public final String o(Context context) {
        return d.a.m0.a.c1.a.a0().h(context) + this.f45147e.f45162b;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        File b2 = d.a.m0.a.e0.f.d.b.b();
        if (b2.exists()) {
            boolean delete = b2.delete();
            d.a.m0.a.e0.d.g("LocalDebugAction", "debug bundle delete: " + delete);
        }
        this.f45145c = Executors.newFixedThreadPool(4);
        this.f45146d = 0;
        d.e().f("downloadstart");
        for (int i2 = 0; i2 < this.f45147e.f45163c.length(); i2++) {
            String a2 = this.f45147e.a(i2);
            if (TextUtils.isEmpty(a2)) {
                int i3 = this.f45146d + 1;
                this.f45146d = i3;
                if (i3 >= this.f45147e.f45163c.length()) {
                    d.a.m0.a.e0.d.b("LocalDebugAction", "IPs are invalid");
                    w(context, unitedSchemeEntity, 202);
                    d.e().f("downloadfail");
                }
            } else {
                this.f45145c.execute(new b(context, a2, b2, unitedSchemeEntity, callbackHandler));
            }
        }
    }

    public final void q() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        d.a.m0.a.v2.f.j(Q.x());
        System.exit(0);
    }

    public final String r(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (a0.f44733b) {
                Log.e("LocalDebugAction", "url encode fail", e2);
                return str;
            }
            return str;
        }
    }

    public final Set<String> s() {
        if (f45143f == null) {
            f45143f = new HashSet();
            d.a.m0.n.a b2 = d.a.m0.n.c.b();
            String string = b2 != null ? b2.j().getString("auth_white_list", "") : "";
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException unused) {
                if (a0.f44733b) {
                    Log.d("LocalDebugAction", "JSONException: parse cloud white list");
                }
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f45143f.add(jSONArray.optString(i2));
                }
            }
        }
        return f45143f;
    }

    public final boolean t() {
        d.a.m0.n.a b2 = d.a.m0.n.c.b();
        return TextUtils.equals(b2 != null ? b2.j().getString("enable_local_debug_switch", "1") : "1", "1");
    }

    public final boolean u() {
        JSONArray jSONArray;
        return (TextUtils.isEmpty(this.f45147e.f45161a) || TextUtils.isEmpty(this.f45147e.f45162b) || (jSONArray = this.f45147e.f45163c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f45147e.f45164d)) ? false : true;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
        d.a.m0.a.e0.d.g("LocalDebugAction", "local debug scheme = " + uri);
        return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f45147e.f45162b)).z0(false)).K0(true)).L0(this.f45147e.f45165e)).M0(this.f45147e.f45166f)).J0(uri)).O0(this.f45147e.f45167g);
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
        d.a.m0.n.a b2 = d.a.m0.n.c.b();
        String string = b2 != null ? b2.j().getString("error_url", "") : "";
        if (TextUtils.isEmpty(string)) {
            d.a.m0.a.z1.b.f.e.g(context, "IPs are invalid ：" + i2).F();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(r(string + "?" + i2));
        SchemeRouter.invoke(context, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (r6 >= r4.f45147e.f45163c.length()) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = d.a.m0.m.e.a.g().getRequest().url(this.f45147e.b(str)).connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                boolean a2 = d.a.m0.t.g.a(executeSync.body().byteStream(), file);
                d.a.m0.a.e0.d.g("LocalDebugAction", "save debug bundle: " + a2);
                d.e().f("downloadsuccess");
                this.f45147e.f45165e = str;
                context.startActivity(d.a.m0.a.f1.e.c.d1(context, v(unitedSchemeEntity)));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f45145c != null) {
                    this.f45145c.shutdownNow();
                    this.f45145c = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (a0.f44733b) {
                        Log.d("LocalDebugAction", "Suicide for reload.");
                    }
                    q();
                }
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            synchronized (this) {
                if (this.f45147e.f45163c != null) {
                    int i2 = this.f45146d + 1;
                    this.f45146d = i2;
                }
                d.a.m0.a.e0.d.b("LocalDebugAction", "Host IPs are invalid");
                w(context, unitedSchemeEntity, 1001);
                d.e().f("downloadfail");
            }
        }
    }
}
