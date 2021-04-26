package d.a.h0.b.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.h0.a.t.c.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends d.a.h0.a.v1.c.i.f {
    public static final boolean s = d.a.h0.a.k.f43101a;
    public String r;

    /* loaded from: classes3.dex */
    public class b extends d.a.h0.a.v1.c.d implements d.a.h0.a.m.a {
        public b() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            boolean d2 = d.a.h0.a.w0.a.O().d(s.this.l);
            if (s.s) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + d2 + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!d2) {
                s.this.G().i().f(s.this.l, s.this.o, this);
                return false;
            }
            s sVar = s.this;
            sVar.i(new c());
            return true;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            d.a.h0.a.v1.c.c.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.h0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                s sVar = s.this;
                sVar.i(new c());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.h0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.a.h0.a.i2.u0.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    d.a.h0.a.v1.c.c.j("null stoken", Boolean.TRUE);
                    c.this.e(new OAuthException(10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    s.this.r = string;
                    c.this.d();
                    return;
                }
                d.a.h0.a.v1.c.c.j("empty stoken", Boolean.TRUE);
                c.this.e(new OAuthException(10001));
            }
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            d.a.h0.b.i.a.t(s.this.l, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }

        public c() {
            b.c cVar;
            if (s.this.n == null || (cVar = s.this.m) == null || !cVar.f44038a) {
                return;
            }
            long j = cVar.f44039b;
            if (s.s) {
                Log.d("LoginRequest", "send timeout " + j + "ms msg");
            }
            s.this.n.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
        }
    }

    public s(Activity activity, b.c cVar, Bundle bundle) {
        super(activity, cVar, bundle);
        y();
        z();
    }

    @Override // d.a.h0.a.v1.c.i.f
    @NonNull
    public d.a.h0.a.v1.c.d J() {
        return new b();
    }

    @Override // d.a.h0.a.v1.c.i.f, d.a.h0.a.v1.c.b
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.p);
            jSONObject.put("ma_id", isEmpty ? G().f43823f : this.p);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1831h, isEmpty ? G().B() : this.p);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            jSONObject2.put("stoken", this.r);
            String j = d.a.h0.a.w0.a.l().j();
            if (!TextUtils.isEmpty(j)) {
                jSONObject2.put("host_api_key", j);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            if (s) {
                e2.printStackTrace();
            }
        }
        w("data", jSONObject.toString());
        return true;
    }
}
