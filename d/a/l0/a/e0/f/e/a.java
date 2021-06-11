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
    public static Set<String> f45103g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f45104h = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public c f45105c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f45106d;

    /* renamed from: e  reason: collision with root package name */
    public int f45107e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f45108f;

    /* renamed from: d.a.l0.a.e0.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0656a implements n.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45111c;

        public C0656a(UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            this.f45109a = unitedSchemeEntity;
            this.f45110b = context;
            this.f45111c = callbackHandler;
        }

        @Override // d.a.l0.a.p.d.n.b
        public void a(boolean z) {
            if (z) {
                d.a.l0.a.e0.d.b("DebuggerLaunchAction", "Authentication Success");
                a.f45104h.add(a.this.o(this.f45110b));
                a.this.p(this.f45110b, this.f45109a, this.f45111c);
                return;
            }
            d.a.l0.a.e0.d.b("DebuggerLaunchAction", "Authentication Fail : Not developer");
            this.f45109a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f45110b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }

        @Override // d.a.l0.a.p.d.n.b
        public void b(Exception exc) {
            d.a.l0.a.e0.d.c("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
            this.f45109a.result = UnitedSchemeUtility.wrapCallbackParams(401);
            a.this.v(this.f45110b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f45115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45116h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45117i;

        public b(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45113e = context;
            this.f45114f = str;
            this.f45115g = file;
            this.f45116h = unitedSchemeEntity;
            this.f45117i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w(this.f45113e, this.f45114f, this.f45115g, this.f45116h, this.f45117i);
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
            this.f45105c = b2;
            if (b2 == null) {
                if (a0.f44625b) {
                    Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!u()) {
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                return false;
            } else if (!f.f48256d.f() && !t().contains(d.a.l0.a.c1.a.a0().h(context)) && !f45104h.contains(o(context))) {
                d.a.l0.a.m.b.b(this.f45105c.f45119a, new C0656a(unitedSchemeEntity, context, callbackHandler));
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
        return d.a.l0.a.c1.a.a0().h(context) + this.f45105c.f45119a;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.j(r());
        File b2 = e.f.b();
        if (b2.exists()) {
            b2.delete();
        }
        this.f45106d = Executors.newFixedThreadPool(4);
        this.f45107e = 0;
        for (int i2 = 0; i2 < this.f45105c.f45120b.length(); i2++) {
            String a2 = this.f45105c.a(i2);
            if (TextUtils.isEmpty(a2)) {
                int i3 = this.f45107e + 1;
                this.f45107e = i3;
                if (i3 >= this.f45105c.f45120b.length()) {
                    d.a.l0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                    v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                }
            } else {
                this.f45106d.execute(new b(context, a2, b2, unitedSchemeEntity, callbackHandler));
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
        if (this.f45108f == null && this.f45105c != null) {
            this.f45108f = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f45105c.f45119a)).z0(false)).Q0(this.f45105c.f45122d)).J0("baiduboxapp://swan/" + this.f45105c.f45119a)).O0("1");
        }
        return this.f45108f;
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
        if (f45103g == null) {
            f45103g = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.a().getString("authWlist", ""));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f45103g.add(jSONArray.optString(i2));
                }
            } catch (JSONException unused) {
                if (a0.f44625b) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return f45103g;
    }

    public final boolean u() {
        JSONArray jSONArray = this.f45105c.f45120b;
        return (jSONArray == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f45105c.f45121c)) ? false : true;
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
                if (this.f45106d != null) {
                    this.f45106d.shutdownNow();
                    this.f45106d = null;
                }
                d.m(r);
                d.g().h("downloadsuccess");
            }
            if (executeSync != null) {
                executeSync.close();
            }
        } catch (IOException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i2 = this.f45107e + 1;
            this.f45107e = i2;
            if (i2 >= this.f45105c.f45120b.length()) {
                d.a.l0.a.e0.d.b("DebuggerLaunchAction", "IPs are invalid");
                v(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                d.g().h("downloadfail");
            }
        }
    }
}
