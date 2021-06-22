package d.a.m0.b.k;

import android.text.TextUtils;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import d.a.m0.a.v2.w;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends ActivityDelegation {

    /* renamed from: d.a.m0.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1001a implements d.a.m0.a.m.a {
        public C1001a() {
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                a.this.j();
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

        @Override // d.a.m0.b.k.a.d
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                a.this.mResult.putString("errorMsg", "addressId == null");
                a.this.finish();
            }
            a.this.k(str);
        }

        @Override // d.a.m0.b.k.a.d
        public void b() {
            a.this.mResult.putString("errorMsg", "choose addressId failed");
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
        public void onSuccess(JSONObject jSONObject, int i2) {
            JSONObject optJSONObject;
            if (jSONObject != null && jSONObject.optInt("errno", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                a.this.mResult.putString("address_info", optJSONObject.toString());
                a.this.finish();
                return;
            }
            a.this.mResult.putString("errorMsg", "GetAddressInfoResponse == null");
            a.this.finish();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return w.d(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.mResult.putString("errorMsg", exc.getMessage());
            a.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void b();
    }

    public static String i() {
        return String.format("%s/ma/address/detail", BaseUrlManager.ONLINE_URL);
    }

    public final void j() {
        d.a.m0.b.j.a.d(getAgent(), new b());
    }

    public final void k(String str) {
        d.a.m0.m.e.a.g().getRequest().url(d.a.m0.a.d0.c.v(i())).addUrlParam(AddressField.KEY_ADDR_ID, str).cookieManager(d.a.m0.a.c1.a.p().a()).build().executeAsync(new c());
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (!d.a.m0.b.j.a.F(getAgent())) {
            d.a.m0.b.j.a.M(getAgent(), null, new C1001a());
            return false;
        }
        j();
        return false;
    }
}
