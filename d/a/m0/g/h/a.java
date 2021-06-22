package d.a.m0.g.h;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.swan.gamecenter.network.models.ReservationGameResultData;
import com.baidu.swan.gamecenter.network.models.ResultData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.h;
import d.a.m0.a.z1.b.f.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Gson f50866a;

    /* renamed from: d.a.m0.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1061a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.g.h.b f50867a;

        /* renamed from: d.a.m0.g.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1062a extends TypeToken<ResultData<ReservationGameResultData>> {
            public C1062a(C1061a c1061a) {
            }
        }

        public C1061a(d.a.m0.g.h.b bVar) {
            this.f50867a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (TextUtils.isEmpty(str) || this.f50867a == null) {
                return;
            }
            ResultData resultData = (ResultData) a.this.f50866a.fromJson(str, new C1062a(this).getType());
            if (resultData == null) {
                this.f50867a.onFail("result is null");
            } else if (resultData.errno == 0) {
                T t = resultData.data;
                if (t != 0 && ((ReservationGameResultData) t).apps != null) {
                    this.f50867a.onSuccess(((ReservationGameResultData) t).apps);
                    return;
                }
                this.f50867a.onFail("result data is null");
            } else {
                d.a.m0.g.h.b bVar = this.f50867a;
                if (bVar != null) {
                    bVar.onFail(resultData.errmsg);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.m0.g.h.b bVar = this.f50867a;
            if (bVar != null) {
                bVar.onFail(exc.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends StringResponseCallback {
        public b(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f50869a = new a(null);
    }

    public /* synthetic */ a(C1061a c1061a) {
        this();
    }

    public static final a b() {
        return c.f50869a;
    }

    public void c(String str) {
        if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            e.f(AppRuntime.getAppContext(), h.aiapps_net_error).F();
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String l = d.a.m0.h.t.a.b().l();
            d.a.m0.a.e2.c.h a2 = d.a.m0.a.c1.a.p().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.APP_ID, Long.valueOf(str));
                d.a.m0.m.e.a.g().getRequest().cookieManager(a2).url(l).addUrlParam("data", jSONObject.toString()).build().executeAsync(new b(this));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(d.a.m0.g.h.b<List<ReservationGameInfo>> bVar) {
        if (SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            String b2 = d.a.m0.h.t.a.b().b();
            d.a.m0.a.e2.c.h a2 = d.a.m0.a.c1.a.p().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 2);
                d.a.m0.m.e.a.g().getRequest().cookieManager(a2).url(b2).addUrlParam("data", jSONObject.toString()).build().executeAsync(new C1061a(bVar));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public a() {
        this.f50866a = new Gson();
    }
}
