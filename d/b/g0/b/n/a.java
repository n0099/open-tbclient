package d.b.g0.b.n;

import android.text.TextUtils;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.i2.v;
import d.b.g0.b.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends ActivityDelegation {

    /* renamed from: d.b.g0.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0918a implements d.b.g0.a.m.a {
        public C0918a() {
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                a.this.l();
                return;
            }
            a.this.mResult.putString("errorMsg", "login failed");
            a.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public b() {
        }

        @Override // d.b.g0.b.n.a.d
        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                a.this.mResult.putString("errorMsg", "invoiceId == null or invoiceType == null");
                a.this.finish();
            }
            a.this.j(str, str2);
        }

        @Override // d.b.g0.b.n.a.d
        public void b() {
            a.this.mResult.putString("errorMsg", "choose invoiceId failed");
            a.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ResponseCallback<JSONObject> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                a.this.mResult.putString("errorMsg", "exchange plaintext from server, but no response");
                a.this.finish();
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                a.this.mResult.putString("invoiceInfo", optJSONObject.toString());
                a.this.finish();
                return;
            }
            a.this.mResult.putString("errorMsg", "exchange plaintext from server, but response exception");
            a.this.finish();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return v.b(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.mResult.putString("errorMsg", exc.getMessage());
            a.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, String str2);

        void b();
    }

    public static String k() {
        return String.format("%s/ma/invoice/detail", BaseUrlManager.ONLINE_URL);
    }

    public final void j(String str, String str2) {
        if (!SwanAppNetworkUtils.h(getAgent())) {
            d.b.g0.a.q1.b.f.d.e(getAgent(), g.invoice_network_none);
        } else {
            d.b.g0.k.e.a.g(AppRuntime.getAppContext()).getRequest().url(d.b.g0.a.b0.c.u(k())).addUrlParam(InvoiceBuildResult.KEY_INVOICE_ID, str).addUrlParam("invoice_type", str2).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsync(new c());
        }
    }

    public final void l() {
        d.b.g0.b.i.a.f(getAgent(), new b());
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (!d.b.g0.b.i.a.H(getAgent())) {
            d.b.g0.b.i.a.O(getAgent(), null, new C0918a());
            return false;
        }
        l();
        return false;
    }
}
