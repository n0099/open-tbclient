package d.b.h0.b.j;

import android.text.TextUtils;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import d.b.h0.a.i2.v;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends ActivityDelegation {

    /* renamed from: d.b.h0.b.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0931a implements d.b.h0.a.m.a {
        public C0931a() {
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
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

        @Override // d.b.h0.b.j.a.d
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                a.this.mResult.putString("errorMsg", "addressId == null");
                a.this.finish();
            }
            a.this.k(str);
        }

        @Override // d.b.h0.b.j.a.d
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
        public void onSuccess(JSONObject jSONObject, int i) {
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
        void a(String str);

        void b();
    }

    public static String i() {
        return String.format("%s/ma/address/detail", BaseUrlManager.ONLINE_URL);
    }

    public final void j() {
        d.b.h0.b.i.a.d(getAgent(), new b());
    }

    public final void k(String str) {
        d.b.h0.k.e.a.f().getRequest().url(d.b.h0.a.b0.c.u(i())).addUrlParam(AddressField.KEY_ADDR_ID, str).cookieManager(d.b.h0.a.w0.a.m().a()).build().executeAsync(new c());
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        if (!d.b.h0.b.i.a.H(getAgent())) {
            d.b.h0.b.i.a.O(getAgent(), null, new C0931a());
            return false;
        }
        j();
        return false;
    }
}
