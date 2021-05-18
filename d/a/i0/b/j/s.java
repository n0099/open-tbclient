package d.a.i0.b.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.i0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends d.a.i0.a.e2.c.j.f {
    public static final boolean t = d.a.i0.a.k.f43025a;
    public String s;

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.a.e2.c.e implements d.a.i0.a.m.a {
        public b() {
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            boolean e2 = d.a.i0.a.c1.a.a0().e(s.this.m);
            if (s.t) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!e2) {
                s.this.N().j().f(s.this.m, s.this.p, this);
                return false;
            }
            s sVar = s.this;
            sVar.i(new c());
            return true;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            d.a.i0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.i0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.i0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.i0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                s sVar = s.this;
                sVar.i(new c());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.i0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.i0.a.v2.e1.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    d.a.i0.a.e2.c.d.j("null stoken", Boolean.TRUE);
                    c.this.e(new OAuthException(10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    s.this.s = string;
                    c.this.d();
                    return;
                }
                d.a.i0.a.e2.c.d.j("empty stoken", Boolean.TRUE);
                c.this.e(new OAuthException(10001));
            }
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            d.a.i0.b.j.a.t(s.this.m, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }

        public c() {
            c.C0821c c0821c;
            if (s.this.o == null || (c0821c = s.this.n) == null || !c0821c.f44658a) {
                return;
            }
            long j = c0821c.f44659b;
            if (s.t) {
                Log.d("LoginRequest", "send timeout " + j + "ms msg");
            }
            s.this.o.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
        }
    }

    public s(Activity activity, c.C0821c c0821c, Bundle bundle) {
        super(activity, c0821c, bundle);
        y();
        z();
    }

    @Override // d.a.i0.a.e2.c.j.f
    @NonNull
    public d.a.i0.a.e2.c.e R() {
        return new b();
    }

    @Override // d.a.i0.a.e2.c.j.f, d.a.i0.a.e2.c.c
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.q);
            jSONObject.put("ma_id", isEmpty ? N().D() : this.q);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? N().D() : this.q);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.i0.a.e2.c.d.g());
            jSONObject2.put("stoken", this.s);
            String l = d.a.i0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject2.put("host_api_key", l);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            if (t) {
                e2.printStackTrace();
            }
        }
        w("data", jSONObject.toString());
        return true;
    }
}
