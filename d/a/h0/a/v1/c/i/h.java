package d.a.h0.a.v1.c.i;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class h<ResultDataT> extends d.a.h0.a.v1.c.b<ResultDataT> {

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f44971g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f44972h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f44973i;
    public boolean j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.a.v1.c.b.f44890f) {
                Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
            }
            h.this.C();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {
        public b() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.h0.a.v1.c.c.j(exc.toString(), Boolean.FALSE);
            h.this.e(new OAuthException(10002));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            h.this.F(response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44976e;

        public c(String str) {
            this.f44976e = str;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                h.this.q();
                h.this.a();
                return;
            }
            h.this.B(this.f44976e);
        }
    }

    public Map<String, String> A() {
        return this.f44971g;
    }

    public void B(String str) {
        int optInt;
        this.f44972h = str;
        try {
            JSONObject jSONObject = new JSONObject(this.f44972h);
            this.f44973i = jSONObject;
            optInt = jSONObject.optInt("errno");
        } catch (OAuthException e2) {
            e(e2);
        } catch (Exception e3) {
            d.a.h0.a.v1.c.c.j(e3.toString(), Boolean.TRUE);
            e(new OAuthException(10005));
            d.a.h0.a.z1.h.q(10005, null);
        }
        if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
            this.j = false;
            this.k = false;
            if (d.a.h0.a.r.a.f.f43778d.e()) {
                d.a.h0.a.r.a.f.f43778d.a();
            }
            H(str);
        } else if (D(optInt)) {
            if (d.a.h0.a.r.a.f.f43778d.e()) {
                d.a.h0.a.r.a.f.f43778d.a();
                H(str);
            } else if (d.a.h0.a.v1.c.b.f44890f) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            r(n(this.f44973i));
            E();
            d();
        }
    }

    public final void C() {
        HttpRequest x = x(this);
        if (x == null) {
            return;
        }
        x.executeAsync(new b());
    }

    public final boolean D(int i2) {
        return i2 == 600101 || i2 == 600102 || i2 == 600103 || i2 == 402 || i2 == 401;
    }

    public void E() {
    }

    public final void F(Response response) throws IOException {
        if (!response.isSuccessful()) {
            d.a.h0.a.v1.c.c.j("bad response", Boolean.TRUE);
            e(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            d.a.h0.a.v1.c.c.j("empty response body", Boolean.TRUE);
            e(new OAuthException(10001));
            return;
        }
        B(body.string());
    }

    @NonNull
    public d.a.h0.a.r1.e G() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 != null) {
            return h2;
        }
        throw new IllegalStateException("null SwanApp");
    }

    public final void H(String str) {
        G().i().f(d.a.h0.a.z0.f.V().getActivity(), null, new c(str));
    }

    @Override // d.a.h0.a.v1.c.b
    public void j() {
        ExecutorUtilsExt.postOnElastic(new a(), "OAuthRequest-onExec", 2);
    }

    public String toString() {
        d.a.h0.a.v1.c.h<ResultDataT> hVar = this.f44891a;
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), f(), Integer.valueOf(this.f44891a.b()), this.f44972h, this.f44973i, hVar.f44952a, hVar.a());
    }

    public h<ResultDataT> w(String str, String str2) {
        this.f44971g.put(str, str2);
        return this;
    }

    public abstract HttpRequest x(h hVar);

    public void y() {
        this.k = true;
    }

    public void z() {
        this.j = true;
    }
}
