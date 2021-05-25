package d.a.l0.g.h;

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
import d.a.l0.a.h;
import d.a.l0.a.z1.b.f.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Gson f47084a;

    /* renamed from: d.a.l0.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1002a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.g.h.b f47085a;

        /* renamed from: d.a.l0.g.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1003a extends TypeToken<ResultData<ReservationGameResultData>> {
            public C1003a(C1002a c1002a) {
            }
        }

        public C1002a(d.a.l0.g.h.b bVar) {
            this.f47085a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (TextUtils.isEmpty(str) || this.f47085a == null) {
                return;
            }
            ResultData resultData = (ResultData) a.this.f47084a.fromJson(str, new C1003a(this).getType());
            if (resultData == null) {
                this.f47085a.a("result is null");
            } else if (resultData.errno == 0) {
                T t = resultData.data;
                if (t != 0 && ((ReservationGameResultData) t).apps != null) {
                    this.f47085a.onSuccess(((ReservationGameResultData) t).apps);
                    return;
                }
                this.f47085a.a("result data is null");
            } else {
                d.a.l0.g.h.b bVar = this.f47085a;
                if (bVar != null) {
                    bVar.a(resultData.errmsg);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.g.h.b bVar = this.f47085a;
            if (bVar != null) {
                bVar.a(exc.toString());
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
        public static final a f47087a = new a(null);
    }

    public /* synthetic */ a(C1002a c1002a) {
        this();
    }

    public static final a b() {
        return c.f47087a;
    }

    public void c(String str) {
        if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            e.f(AppRuntime.getAppContext(), h.aiapps_net_error).F();
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String l = d.a.l0.h.t.a.b().l();
            d.a.l0.a.e2.c.h a2 = d.a.l0.a.c1.a.p().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.APP_ID, Long.valueOf(str));
                d.a.l0.m.e.a.g().getRequest().cookieManager(a2).url(l).addUrlParam("data", jSONObject.toString()).build().executeAsync(new b(this));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(d.a.l0.g.h.b<List<ReservationGameInfo>> bVar) {
        if (SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            String b2 = d.a.l0.h.t.a.b().b();
            d.a.l0.a.e2.c.h a2 = d.a.l0.a.c1.a.p().a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 2);
                d.a.l0.m.e.a.g().getRequest().cookieManager(a2).url(b2).addUrlParam("data", jSONObject.toString()).build().executeAsync(new C1002a(bVar));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public a() {
        this.f47084a = new Gson();
    }
}
