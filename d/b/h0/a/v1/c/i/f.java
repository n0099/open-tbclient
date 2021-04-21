package d.b.h0.a.v1.c.i;

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
import d.b.h0.a.k;
import d.b.h0.a.t.c.a.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends h<d> {
    public static final boolean q = k.f45772a;
    public final Activity l;
    public b.c m;
    public c n = new c(Looper.getMainLooper(), this);
    public Bundle o;
    public String p;

    /* loaded from: classes3.dex */
    public class b extends d.b.h0.a.v1.c.d implements d.b.h0.a.m.a {
        public b() {
        }

        @Override // d.b.h0.a.v1.c.d
        public boolean f() throws Exception {
            d.b.h0.a.m.b z = f.this.G().z();
            boolean e2 = z.e(f.this.l);
            if (f.q) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!e2) {
                f fVar = f.this;
                z.f(fVar.l, fVar.o, this);
            } else {
                b.c cVar = f.this.m;
                if (cVar != null && cVar.f46666a) {
                    long j = cVar.f46667b;
                    if (f.q) {
                        Log.d("LoginRequest", "send timeout " + j + "ms msg");
                    }
                    if (j < 0) {
                        j = 0;
                    }
                    f.this.n.sendEmptyMessageDelayed(1, j);
                }
            }
            return e2;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            d.b.h0.a.v1.c.c.j("onResult :: " + i, Boolean.FALSE);
            if (i == -2) {
                d.b.h0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i != 0) {
                d.b.h0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.b.h0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<f> f47546a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.f47546a.get();
            if (fVar != null && message.what == 1) {
                if (f.q) {
                    Log.d("LoginRequest", "handleMessage: timeout");
                }
                d.b.h0.a.v1.c.c.j("request timeout", Boolean.TRUE);
                fVar.e(new OAuthException(10002));
            }
        }

        public c(Looper looper, f fVar) {
            super(looper);
            this.f47546a = new WeakReference<>(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f47547a;

        public String toString() {
            return String.format("Result code(%s)", this.f47547a);
        }

        public d(String str) {
            this.f47547a = str == null ? "" : str;
        }
    }

    public f(Activity activity, b.c cVar, Bundle bundle) {
        this.l = activity;
        this.m = cVar;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.p = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
        }
        this.o = bundle;
    }

    @NonNull
    public d.b.h0.a.v1.c.d J() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.v1.c.b
    /* renamed from: K */
    public d n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.b.h0.a.v1.c.c.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt == 0) {
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new d(jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        throw new OAuthException(c2.optString("errmsg"), optInt);
    }

    @Override // d.b.h0.a.v1.c.b
    public void e(@Nullable Exception exc) {
        super.e(exc);
        if (q) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.n.removeMessages(1);
    }

    @Override // d.b.h0.a.v1.c.b
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.p);
            jSONObject.put("ma_id", isEmpty ? G().f46461f : this.p);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1883h, isEmpty ? G().B() : this.p);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.b.h0.a.v1.c.c.g());
            String x = d.b.h0.a.w0.a.l().x();
            if (!TextUtils.isEmpty(x)) {
                jSONObject2.put("host_api_key", x);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.b.h0.a.v1.c.b
    public boolean l() {
        i(J());
        return super.l();
    }

    @Override // d.b.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.b.h0.a.w0.a.l().M(this.l, hVar.A());
    }
}
