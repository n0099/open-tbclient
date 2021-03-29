package d.b.g0.a.c0.d.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TbEnum;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.p.c.e;
import d.b.g0.a.r.a.f;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.u0.d;
import d.b.g0.a.y0.e.c;
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
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: g  reason: collision with root package name */
    public static Set<String> f43602g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f43603h = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public c f43604c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f43605d;

    /* renamed from: e  reason: collision with root package name */
    public int f43606e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f43607f;

    /* renamed from: d.b.g0.a.c0.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0620a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43608a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f43609b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43610c;

        public C0620a(UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            this.f43608a = unitedSchemeEntity;
            this.f43609b = context;
            this.f43610c = callbackHandler;
        }

        @Override // d.b.g0.a.p.c.e.a
        public void a(boolean z) {
            if (z) {
                d.b.g0.a.c0.c.b("DebuggerLaunchAction", "Authentication Success");
                a.f43603h.add(a.this.o(this.f43609b));
                a.this.p(this.f43609b, this.f43608a, this.f43610c);
                return;
            }
            d.b.g0.a.c0.c.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
            this.f43608a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f43609b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }

        @Override // d.b.g0.a.p.c.e.a
        public void b(Exception exc) {
            d.b.g0.a.c0.c.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
            this.f43608a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f43609b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43613f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43614g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43615h;
        public final /* synthetic */ CallbackHandler i;

        public b(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f43612e = context;
            this.f43613f = str;
            this.f43614g = file;
            this.f43615h = unitedSchemeEntity;
            this.i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w(this.f43612e, this.f43613f, this.f43614g, this.f43615h, this.i);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
            c b2 = c.b(optParamsAsJo);
            this.f43604c = b2;
            if (b2 == null) {
                if (a0.f46288b) {
                    Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!u()) {
                v(context, "404");
                return false;
            } else if (!f.f45697d.e() && !t().contains(d.b.g0.a.w0.a.O().a(context)) && !f43603h.contains(o(context))) {
                d.b.g0.a.m.b.b(this.f43604c.f43617a, new C0620a(unitedSchemeEntity, context, callbackHandler));
                return true;
            } else {
                p(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        d.b.g0.a.c0.c.b("DebuggerLaunchAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final String o(Context context) {
        return d.b.g0.a.w0.a.O().a(context) + this.f43604c.f43617a;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.j(r());
        File b2 = d.f.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f43605d = Executors.newFixedThreadPool(4);
        this.f43606e = 0;
        for (int i = 0; i < this.f43604c.f43618b.length(); i++) {
            String a2 = this.f43604c.a(i);
            if (TextUtils.isEmpty(a2)) {
                int i2 = this.f43606e + 1;
                this.f43606e = i2;
                if (i2 >= this.f43604c.f43618b.length()) {
                    d.b.g0.a.c0.c.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, "404");
                }
            } else {
                this.f43605d.execute(new b(context, a2, b2, unitedSchemeEntity, callbackHandler));
            }
        }
    }

    public final String q(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final c.a r() {
        if (this.f43607f == null) {
            this.f43607f = (c.a) ((c.a) ((c.a) ((c.a) new c.a().q0(this.f43604c.f43617a)).v0(false)).J0(this.f43604c.f43620d)).H0("1");
        }
        return this.f43607f;
    }

    public final String s(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != 51509) {
            if (hashCode == 51512 && str.equals("404")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            return "authorization fail " + str;
        } else if (c2 != 1) {
            return "";
        } else {
            return "IPs are invalid " + str;
        }
    }

    public final Set<String> t() {
        if (f43602g == null) {
            f43602g = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    f43602g.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                if (a0.f46288b) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return f43602g;
    }

    public final boolean u() {
        JSONArray jSONArray = this.f43604c.f43618b;
        return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f43604c.f43619c)) ? false : true;
    }

    public final void v(Context context, String str) {
        String string = h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.b.g0.a.q1.b.f.d.f(context, s(str)).C();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SchemeConfig.getSchemeHead());
        sb.append("://v1/easybrowse/open?url=");
        sb.append(q(string + "?" + str));
        SchemeRouter.invoke(context, sb.toString());
    }

    public final void w(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        c.a r = r();
        d.l();
        d.g().h("downloadstart");
        try {
            d.b.g0.k.c.c request = d.b.g0.k.e.a.f().getRequest();
            Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                d.b.g0.p.f.a(executeSync.body().byteStream(), file);
                Intent W0 = d.b.g0.a.y0.e.c.W0(context, r);
                W0.putExtra("remoteDebugUrl", str);
                context.startActivity(W0);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f43605d != null) {
                    this.f43605d.shutdownNow();
                    this.f43605d = null;
                }
                d.m(r);
                d.g().h("downloadsuccess");
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i = this.f43606e + 1;
            this.f43606e = i;
            if (i >= this.f43604c.f43618b.length()) {
                d.b.g0.a.c0.c.b("DebuggerLaunchAction", "IPs are invalid");
                v(context, "404");
                d.g().h("downloadfail");
            }
        }
    }
}
