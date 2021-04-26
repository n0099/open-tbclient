package d.a.h0.a.c0.d.d;

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
import d.a.h0.a.a2.g.h;
import d.a.h0.a.p.c.e;
import d.a.h0.a.r.a.f;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.u0.d;
import d.a.h0.a.y0.e.c;
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
    public static Set<String> f41607g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f41608h = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public c f41609c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f41610d;

    /* renamed from: e  reason: collision with root package name */
    public int f41611e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f41612f;

    /* renamed from: d.a.h0.a.c0.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0591a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41613a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f41614b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41615c;

        public C0591a(UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            this.f41613a = unitedSchemeEntity;
            this.f41614b = context;
            this.f41615c = callbackHandler;
        }

        @Override // d.a.h0.a.p.c.e.a
        public void a(Exception exc) {
            d.a.h0.a.c0.c.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
            this.f41613a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f41614b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }

        @Override // d.a.h0.a.p.c.e.a
        public void b(boolean z) {
            if (z) {
                d.a.h0.a.c0.c.b("DebuggerLaunchAction", "Authentication Success");
                a.f41608h.add(a.this.o(this.f41614b));
                a.this.p(this.f41614b, this.f41613a, this.f41615c);
                return;
            }
            d.a.h0.a.c0.c.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
            this.f41613a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f41614b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41618f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f41619g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41620h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41621i;

        public b(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f41617e = context;
            this.f41618f = str;
            this.f41619g = file;
            this.f41620h = unitedSchemeEntity;
            this.f41621i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w(this.f41617e, this.f41618f, this.f41619g, this.f41620h, this.f41621i);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        boolean equals = TextUtils.equals(h.a().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
            c b2 = c.b(optParamsAsJo);
            this.f41609c = b2;
            if (b2 == null) {
                if (a0.f44398b) {
                    Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!u()) {
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                return false;
            } else if (!f.f43778d.e() && !t().contains(d.a.h0.a.w0.a.O().e(context)) && !f41608h.contains(o(context))) {
                d.a.h0.a.m.b.b(this.f41609c.f41623a, new C0591a(unitedSchemeEntity, context, callbackHandler));
                return true;
            } else {
                p(context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        d.a.h0.a.c0.c.b("DebuggerLaunchAction", "param is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final String o(Context context) {
        return d.a.h0.a.w0.a.O().e(context) + this.f41609c.f41623a;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.j(r());
        File b2 = d.f.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f41610d = Executors.newFixedThreadPool(4);
        this.f41611e = 0;
        for (int i2 = 0; i2 < this.f41609c.f41624b.length(); i2++) {
            String a2 = this.f41609c.a(i2);
            if (TextUtils.isEmpty(a2)) {
                int i3 = this.f41611e + 1;
                this.f41611e = i3;
                if (i3 >= this.f41609c.f41624b.length()) {
                    d.a.h0.a.c0.c.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                }
            } else {
                this.f41610d.execute(new b(context, a2, b2, unitedSchemeEntity, callbackHandler));
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
        if (this.f41612f == null) {
            this.f41612f = (c.a) ((c.a) ((c.a) ((c.a) new c.a().q0(this.f41609c.f41623a)).v0(false)).J0(this.f41609c.f41626d)).H0("1");
        }
        return this.f41612f;
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
        if (f41607g == null) {
            f41607g = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f41607g.add(jSONArray.optString(i2));
                }
            } catch (JSONException unused) {
                if (a0.f44398b) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return f41607g;
    }

    public final boolean u() {
        JSONArray jSONArray = this.f41609c.f41624b;
        return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f41609c.f41625c)) ? false : true;
    }

    public final void v(Context context, String str) {
        String string = h.a().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            d.a.h0.a.q1.b.f.d.f(context, s(str)).C();
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
            d.a.h0.k.c.c request = d.a.h0.k.e.a.f().getRequest();
            Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                d.a.h0.p.f.a(executeSync.body().byteStream(), file);
                Intent W0 = d.a.h0.a.y0.e.c.W0(context, r);
                W0.putExtra("remoteDebugUrl", str);
                context.startActivity(W0);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.f41610d != null) {
                    this.f41610d.shutdownNow();
                    this.f41610d = null;
                }
                d.m(r);
                d.g().h("downloadsuccess");
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i2 = this.f41611e + 1;
            this.f41611e = i2;
            if (i2 >= this.f41609c.f41624b.length()) {
                d.a.h0.a.c0.c.b("DebuggerLaunchAction", "IPs are invalid");
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                d.g().h("downloadfail");
            }
        }
    }
}
