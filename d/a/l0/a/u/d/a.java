package d.a.l0.a.u.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.l0.a.a2.e;
import d.a.l0.a.n1.f;
import d.a.l0.a.u.c.d;
import d.a.l0.a.u.h.b;
import d.a.l0.a.v2.w;
import okhttp3.FormBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.l0.a.u.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0831a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44818a;

        public C0831a(String str) {
            this.f44818a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (jSONObject == null) {
                a.this.d(this.f44818a, new b(1001, "server response fail"));
                return;
            }
            int optInt = jSONObject.optInt("errno", 10002);
            String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
            if (optInt != 0) {
                a.this.d(this.f44818a, new b(optInt, optString));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a.this.d(this.f44818a, new b(optInt, optString));
                return;
            }
            a.this.d(this.f44818a, new b(0, optString, optJSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            ResponseBody body;
            if (response == null || (body = response.body()) == null) {
                return null;
            }
            return w.d(body.string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar = a.this;
            String str = this.f44818a;
            aVar.d(str, new b(1001, "operation fail, msg = " + exc.getMessage()));
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public b r(String str) {
        if (d.f44812c) {
            Log.d("Api-Base", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new b(202, "SwanApp is null");
        }
        u("coupons_appkey", Q);
        if (!d.a.l0.a.u.e.a.a.s(i())) {
            return new b(10007, "is not baidu account");
        }
        Pair<b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        JSONObject jSONObject = (JSONObject) b2.second;
        if (((b) b2.first).a() && jSONObject != null) {
            String optString = jSONObject.optString("couponAppKey");
            if (TextUtils.isEmpty(optString)) {
                return new b(202, "couponAppKey is invalid");
            }
            boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
            if (optBoolean) {
                u("coupons_appkey_user", Q);
                if (!Q.j().e(i())) {
                    return new b(10004, "user not logged in");
                }
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new b(202, "cb is invalid");
            }
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("appKey", e.V());
            builder.add("couponAppKey", optString);
            builder.add("withUserCoupons", String.valueOf(optBoolean));
            return v("getPlatformCoupons", builder, optString2);
        }
        return new b(202);
    }

    public final String s(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -1741243770) {
            if (str.equals("takeCoupons")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 15750540) {
            if (hashCode == 1991726820 && str.equals("getPlatformCoupons")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (str.equals("getUserCoupons")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return null;
                }
                return d.a.l0.a.c1.a.n().j();
            }
            return d.a.l0.a.c1.a.n().f();
        }
        return d.a.l0.a.c1.a.n().H();
    }

    public b t(String str) {
        if (d.f44812c) {
            Log.d("Api-Base", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new b(1001, "SwanApp is null");
        }
        u("coupons_user", Q);
        if (!d.a.l0.a.u.e.a.a.s(i())) {
            return new b(10007, "is not baidu account");
        }
        if (!Q.j().e(i())) {
            return new b(10004, "user not logged in");
        }
        Pair<b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        JSONObject jSONObject = (JSONObject) b2.second;
        if (((b) b2.first).a() && jSONObject != null) {
            String optString = jSONObject.optString("couponAppKey");
            if (TextUtils.isEmpty(optString)) {
                return new b(202, "couponAppKey is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new b(202, "cb is invalid");
            }
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("appKey", e.V());
            builder.add("couponAppKey", optString);
            return v("getUserCoupons", builder, optString2);
        }
        return new b(202);
    }

    public final void u(String str, e eVar) {
        d.a.l0.a.j2.p.e eVar2 = new d.a.l0.a.j2.p.e();
        eVar2.f43185a = "swan";
        eVar2.f43186b = str;
        eVar2.f43190f = eVar.D();
        eVar2.a("host_app", d.a.l0.a.c1.a.m().a());
        d.a.l0.a.j2.b.i("2267", "83", eVar2.f());
    }

    public final b v(String str, FormBody.Builder builder, String str2) {
        d.a.l0.a.n1.d a2 = d.a.l0.a.n1.d.a(builder.build(), f.f43694b);
        String s = s(str);
        if (TextUtils.isEmpty(s)) {
            return new b(202);
        }
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(s, a2, new C0831a(str2));
        if (d.a.l0.m.e.a.g().c()) {
            aVar.f47974f = true;
        }
        aVar.f47975g = true;
        d.a.l0.m.e.a.g().e(aVar);
        return new b(0);
    }

    public b w(String str) {
        if (d.f44812c) {
            Log.d("Api-Base", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new b(1001, "SwanApp is null");
        }
        u("coupons_take", Q);
        if (!d.a.l0.a.u.e.a.a.s(i())) {
            return new b(10007, "is not baidu account");
        }
        if (!Q.j().e(i())) {
            return new b(10004, "user not logged in");
        }
        Pair<b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        JSONObject jSONObject = (JSONObject) b2.second;
        if (((b) b2.first).a() && jSONObject != null) {
            String optString = jSONObject.optString("promotionId");
            if (TextUtils.isEmpty(optString)) {
                return new b(202, "couponAppKey is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new b(202, "cb is invalid");
            }
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("appKey", e.V());
            builder.add("promotionId", optString);
            return v("takeCoupons", builder, optString2);
        }
        return new b(202);
    }
}
