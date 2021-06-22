package d.a.m0.a.e2.c.j;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.m0.a.k;
import d.a.m0.a.u.e.a.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends h<d> {
    public static final boolean r = k.f46983a;
    public final Activity m;
    public c.C0891c n;
    public c o = new c(Looper.getMainLooper(), this);
    public Bundle p;
    public String q;

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.e2.c.e implements d.a.m0.a.m.a {
        public b() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            d.a.m0.a.m.b j = f.this.N().j();
            boolean e2 = j.e(f.this.m);
            if (f.r) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!e2) {
                d.a.m0.a.j2.k.N(f.this.l, "passLogin");
                f fVar = f.this;
                j.f(fVar.m, fVar.p, this);
            }
            return e2;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            d.a.m0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.m0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.m0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.m0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<f> f45537a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.f45537a.get();
            if (fVar != null && message.what == 1) {
                if (f.r) {
                    Log.d("LoginRequest", "handleMessage: timeout");
                }
                d.a.m0.a.e2.c.d.j("request timeout", Boolean.TRUE);
                fVar.e(new OAuthException(10002));
            }
        }

        public c(Looper looper, f fVar) {
            super(looper);
            this.f45537a = new WeakReference<>(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f45538a;

        public String toString() {
            return String.format("Result code(%s)", this.f45538a);
        }

        public d(String str) {
            this.f45538a = str == null ? "" : str;
        }
    }

    public f(Activity activity, c.C0891c c0891c, Bundle bundle) {
        this.m = activity;
        this.n = c0891c;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.q = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
            d.a.m0.a.e0.d.h("LoginRequest", "Info: Remove previous account.");
        }
        this.p = bundle;
    }

    @Override // d.a.m0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.LOGIN;
    }

    @NonNull
    public d.a.m0.a.e2.c.e R() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.e2.c.c
    /* renamed from: S */
    public d n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.a.m0.a.e2.c.d.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt != 0) {
            if (11001 == optInt) {
                d.a.m0.a.e2.c.d.l(c2);
                d.a.m0.a.e2.c.d.s("LoginRequest", c2.toString());
            }
            if (r) {
                throw new OAuthException(c2.optString("errmsg"), optInt);
            }
        }
        JSONObject jSONObject2 = c2.getJSONObject("data");
        return new d(jSONObject2 != null ? jSONObject2.optString("code", "") : "");
    }

    @Override // d.a.m0.a.e2.c.c
    public void e(@Nullable Exception exc) {
        super.e(exc);
        if (r) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.o.removeMessages(1);
    }

    @Override // d.a.m0.a.e2.c.c
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.q);
            jSONObject.put("ma_id", isEmpty ? N().D() : this.q);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? N().D() : this.q);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.m0.a.e2.c.d.g());
            String l = d.a.m0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject2.put("host_api_key", l);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.m0.a.e2.c.c
    public boolean l() {
        i(R());
        return super.l();
    }

    @Override // d.a.m0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.m0.a.c1.a.n().r(this.m, hVar.C());
    }
}
