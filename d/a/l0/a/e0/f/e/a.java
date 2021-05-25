package d.a.l0.a.e0.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TbEnum;
import d.a.l0.a.a1.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.f1.e.c;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.p.d.n;
import d.a.l0.a.s.a.f;
import d.a.l0.t.g;
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
    public static Set<String> f41427g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f41428h = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public c f41429c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f41430d;

    /* renamed from: e  reason: collision with root package name */
    public int f41431e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f41432f;

    /* renamed from: d.a.l0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0600a implements n.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f41434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41435c;

        public C0600a(UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            this.f41433a = unitedSchemeEntity;
            this.f41434b = context;
            this.f41435c = callbackHandler;
        }

        @Override // d.a.l0.a.p.d.n.b
        public void a(boolean z) {
            if (z) {
                d.a.l0.a.e0.d.b("DebuggerLaunchAction", "Authentication Success");
                a.f41428h.add(a.this.o(this.f41434b));
                a.this.p(this.f41434b, this.f41433a, this.f41435c);
                return;
            }
            d.a.l0.a.e0.d.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
            this.f41433a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f41434b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }

        @Override // d.a.l0.a.p.d.n.b
        public void b(Exception exc) {
            d.a.l0.a.e0.d.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
            this.f41433a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f41434b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41438f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f41439g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41440h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41441i;

        public b(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41437e = context;
            this.f41438f = str;
            this.f41439g = file;
            this.f41440h = unitedSchemeEntity;
            this.f41441i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w(this.f41437e, this.f41438f, this.f41439g, this.f41440h, this.f41441i);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debuggerlaunch");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
            c b2 = c.b(optParamsAsJo);
            this.f41429c = b2;
            if (b2 == null) {
                if (a0.f40949b) {
                    Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!u()) {
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                return false;
            } else if (!f.f44582d.f() && !t().contains(d.a.l0.a.c1.a.a0().h(context)) && !f41428h.contains(o(context))) {
                d.a.l0.a.m.b.b(this.f41429c.f41443a, new C0600a(unitedSchemeEntity, context, callbackHandler));
                return true;
            } else {
                p(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        d.a.l0.a.e0.d.b("DebuggerLaunchAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final String o(Context context) {
        return d.a.l0.a.c1.a.a0().h(context) + this.f41429c.f41443a;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.j(r());
        File b2 = e.f.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f41430d = Executors.newFixedThreadPool(4);
        this.f41431e = 0;
        for (int i2 = 0; i2 < this.f41429c.f41444b.length(); i2++) {
            String a2 = this.f41429c.a(i2);
            if (TextUtils.isEmpty(a2)) {
                int i3 = this.f41431e + 1;
                this.f41431e = i3;
                if (i3 >= this.f41429c.f41444b.length()) {
                    d.a.l0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                }
            } else {
                this.f41430d.execute(new b(context, a2, b2, unitedSchemeEntity, callbackHandler));
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
        if (this.f41432f == null && this.f41429c != null) {
            this.f41432f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f41429c.f41443a)).z0(false)).Q0(this.f41429c.f41446d)).J0("baiduboxapp://swan/" + this.f41429c.f41443a)).O0("1");
        }
        return this.f41432f;
    }

    public final String s(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != 51509) {
            if (hashCode == 51512 && str.equals(XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH)) {
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
        if (f41427g == null) {
            f41427g = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f41427g.add(jSONArray.optString(i2));
                }
            } catch (JSONException unused) {
                if (a0.f40949b) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return f41427g;
    }

    public final boolean u() {
        JSONArray jSONArray = this.f41429c.f41444b;
        return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f41429c.f41445c)) ? false : true;
    }

    public final void v(Context context, String str) {
        String string = h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.a.l0.a.z1.b.f.e.g(context, s(str)).F();
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
            d.a.l0.m.c.c request = d.a.l0.m.e.a.g().getRequest();
            Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.a(executeSync.body().byteStream(), file);
                Intent d1 = d.a.l0.a.f1.e.c.d1(context, r);
                d1.putExtra("remoteDebugUrl", str);
                context.startActivity(d1);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f41430d != null) {
                    this.f41430d.shutdownNow();
                    this.f41430d = null;
                }
                d.m(r);
                d.g().h("downloadsuccess");
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i2 = this.f41431e + 1;
            this.f41431e = i2;
            if (i2 >= this.f41429c.f41444b.length()) {
                d.a.l0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                d.g().h("downloadfail");
            }
        }
    }
}
