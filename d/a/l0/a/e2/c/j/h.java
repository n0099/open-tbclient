package d.a.l0.a.e2.c.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.j2.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class h<ResultDataT> extends d.a.l0.a.e2.c.c<ResultDataT> {

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f45431g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f45432h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f45433i;
    public boolean j;
    public boolean k;
    public String l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.e2.c.c.f45350f) {
                Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
            }
            h.this.E();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpRequest f45435a;

        public b(HttpRequest httpRequest) {
            this.f45435a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (h.this.F()) {
                h.this.O(this.f45435a);
            } else {
                h.this.I(this.f45435a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            h.this.K(response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpRequest f45437a;

        public c(HttpRequest httpRequest) {
            this.f45437a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.e0.d.g("OAuthRequest", "retryRequest fail: ");
            h.this.I(this.f45437a, exc);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            d.a.l0.a.e0.d.g("OAuthRequest", "retryRequest success: ");
            h.this.K(response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45439e;

        public d(String str) {
            this.f45439e = str;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                h.this.q();
                h.this.a();
                return;
            }
            h.this.D(null, this.f45439e);
        }
    }

    public abstract SwanInterfaceType A();

    public int B() {
        return 1;
    }

    public Map<String, String> C() {
        return this.f45431g;
    }

    public void D(Response response, String str) {
        int optInt;
        this.f45432h = str;
        try {
            JSONObject jSONObject = new JSONObject(this.f45432h);
            this.f45433i = jSONObject;
            optInt = jSONObject.optInt("errno");
        } catch (OAuthException e2) {
            H(e2.mErrorCode, str, response);
            e(e2);
        } catch (Exception e3) {
            d.a.l0.a.e2.c.d.j(e3.toString(), Boolean.TRUE);
            M(str, e3);
            H(2103, str, response);
            e(new OAuthException(10005));
            k.p(10005, null);
        }
        if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
            this.j = false;
            this.k = false;
            if (d.a.l0.a.s.a.f.f48256d.f()) {
                d.a.l0.a.s.a.f.f48256d.b();
            }
            P(str);
        } else if (G(optInt)) {
            if (d.a.l0.a.s.a.f.f48256d.f()) {
                d.a.l0.a.s.a.f.f48256d.b();
                P(str);
            } else if (d.a.l0.a.e2.c.c.f45350f) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            if (response != null && optInt != 0) {
                H(optInt, str, response);
            }
            s(n(this.f45433i));
            J();
            d();
        }
    }

    public final void E() {
        HttpRequest x = x(this);
        if (x == null) {
            return;
        }
        x.executeAsync(new b(x));
        d.a.l0.a.j2.q.a.a(A());
    }

    public boolean F() {
        return false;
    }

    public final boolean G(int i2) {
        return i2 == 600101 || i2 == 600102 || i2 == 600103 || i2 == 402 || i2 == 401;
    }

    public final void H(int i2, String str, Response response) {
        d.a.l0.a.j2.q.a.c(A(), i2, str, response);
    }

    public void I(HttpRequest httpRequest, Exception exc) {
        d.a.l0.a.e2.c.d.j(exc.toString(), Boolean.FALSE);
        d.a.l0.a.j2.q.a.b(A(), 2101, httpRequest.getOkRequest() == null ? null : httpRequest.getOkRequest().url().toString(), null, exc.getMessage());
        e(new OAuthException(10002));
    }

    public void J() {
    }

    public final void K(Response response) {
        if (!response.isSuccessful()) {
            d.a.l0.a.e2.c.d.j("bad response", Boolean.TRUE);
            H(2104, null, null);
            e(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            d.a.l0.a.e2.c.d.j("empty response body", Boolean.TRUE);
            H(2103, null, null);
            e(new OAuthException(10001));
            return;
        }
        try {
            D(response, body.string());
        } catch (IOException e2) {
            if (d.a.l0.a.e2.c.c.f45350f) {
                e2.printStackTrace();
            }
        }
    }

    public void L() {
    }

    public final void M(String str, Exception exc) {
        if (this.f45433i == null) {
            d.a.l0.a.e2.c.d.s("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
            return;
        }
        d.a.l0.a.e2.c.d.s("OAuthRequest", "ex: " + exc.toString());
    }

    @NonNull
    public d.a.l0.a.a2.e N() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            if (!d.a.l0.a.e2.c.c.f45350f) {
                return d.a.l0.a.a2.d.g().r();
            }
            throw new IllegalStateException("null SwanApp");
        }
        return i2;
    }

    public void O(HttpRequest httpRequest) {
        d.a.l0.a.e0.d.g("OAuthRequest", "retryRequest: " + httpRequest.toString());
        L();
        httpRequest.executeAsync(new c(httpRequest));
    }

    public final void P(String str) {
        N().j().f(d.a.l0.a.g1.f.V().getActivity(), null, new d(str));
    }

    @Override // d.a.l0.a.e2.c.c
    public void j() {
        ExecutorUtilsExt.postOnElastic(new a(), "OAuthRequest-onExec", 2);
    }

    @Override // d.a.l0.a.e2.c.c
    public d.a.l0.a.e2.c.c<ResultDataT> r(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l = "loginApi";
        } else {
            this.l = str;
        }
        super.r(str);
        return this;
    }

    public String toString() {
        i<ResultDataT> iVar = this.f45351a;
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), f(), Integer.valueOf(this.f45351a.b()), this.f45432h, this.f45433i, iVar.f45412a, iVar.a());
    }

    public h<ResultDataT> w(String str, String str2) {
        this.f45431g.put(str, str2);
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
