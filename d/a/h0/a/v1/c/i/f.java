package d.a.h0.a.v1.c.i;

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
import d.a.h0.a.k;
import d.a.h0.a.t.c.a.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends h<d> {
    public static final boolean q = k.f43101a;
    public final Activity l;
    public b.c m;
    public c n = new c(Looper.getMainLooper(), this);
    public Bundle o;
    public String p;

    /* loaded from: classes3.dex */
    public class b extends d.a.h0.a.v1.c.d implements d.a.h0.a.m.a {
        public b() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            d.a.h0.a.m.b i2 = f.this.G().i();
            boolean e2 = i2.e(f.this.l);
            if (f.q) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!e2) {
                f fVar = f.this;
                i2.f(fVar.l, fVar.o, this);
            } else {
                b.c cVar = f.this.m;
                if (cVar != null && cVar.f44038a) {
                    long j = cVar.f44039b;
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
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<f> f44969a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.f44969a.get();
            if (fVar != null && message.what == 1) {
                if (f.q) {
                    Log.d("LoginRequest", "handleMessage: timeout");
                }
                d.a.h0.a.v1.c.c.j("request timeout", Boolean.TRUE);
                fVar.e(new OAuthException(10002));
            }
        }

        public c(Looper looper, f fVar) {
            super(looper);
            this.f44969a = new WeakReference<>(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f44970a;

        public String toString() {
            return String.format("Result code(%s)", this.f44970a);
        }

        public d(String str) {
            this.f44970a = str == null ? "" : str;
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
    public d.a.h0.a.v1.c.d J() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.v1.c.b
    /* renamed from: K */
    public d n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.a.h0.a.v1.c.c.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt == 0) {
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new d(jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        throw new OAuthException(c2.optString("errmsg"), optInt);
    }

    @Override // d.a.h0.a.v1.c.b
    public void e(@Nullable Exception exc) {
        super.e(exc);
        if (q) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.n.removeMessages(1);
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.p);
            jSONObject.put("ma_id", isEmpty ? G().f43823f : this.p);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1831h, isEmpty ? G().B() : this.p);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            String j = d.a.h0.a.w0.a.l().j();
            if (!TextUtils.isEmpty(j)) {
                jSONObject2.put("host_api_key", j);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean l() {
        i(J());
        return super.l();
    }

    @Override // d.a.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.a.h0.a.w0.a.l().s(this.l, hVar.A());
    }
}
