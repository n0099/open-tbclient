package d.a.l0.a.b0;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.google.gson.Gson;
import d.a.l0.a.k;
import d.a.l0.a.n1.f;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40801a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static int f40802b = 0;

    /* renamed from: d.a.l0.a.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0567a extends ResponseCallback<CommonSyncServerData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.b0.c.a f40803a;

        public C0567a(d.a.l0.a.b0.c.a aVar) {
            this.f40803a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(CommonSyncServerData commonSyncServerData, int i2) {
            d.a.l0.a.b0.c.a aVar = this.f40803a;
            if (aVar != null) {
                aVar.a(commonSyncServerData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public CommonSyncServerData parseResponse(Response response, int i2) throws Exception {
            if (response != null && response.body() != null) {
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(string);
                int optInt = jSONObject.optInt("errno");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optInt == a.f40802b && optJSONObject != null) {
                    return (CommonSyncServerData) new Gson().fromJson(optJSONObject.toString(), (Class<Object>) CommonSyncServerData.class);
                }
            }
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.b0.c.a aVar = this.f40803a;
            if (aVar != null) {
                aVar.onFail();
            }
        }
    }

    public static void b(d.a.l0.a.b0.c.a aVar) {
        if (!SwanAppNetworkUtils.h()) {
            if (aVar != null) {
                aVar.onFail();
                return;
            }
            return;
        }
        d.a.l0.m.e.a.g().getRequest().cookieManager(d.a.l0.a.c1.a.p().a()).url(d.a.l0.a.c1.a.l().processUrl(b.a())).build().executeAsync(new C0567a(aVar));
    }

    public static RequestBody c(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e2) {
                    if (f40801a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return RequestBody.create(f.f43693a, jSONObject.toString());
    }

    public static void d(Map<String, Object> map) {
        if (SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.l0.m.e.a.g().postRequest().cookieManager(d.a.l0.a.c1.a.p().a())).url(d.a.l0.a.c1.a.l().processUrl(b.b()))).requestBody(c(map)).build().executeAsync(null);
        }
    }

    public static void e(Map<String, Object> map) {
        if (SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.l0.m.e.a.g().postRequest().cookieManager(d.a.l0.a.c1.a.p().a())).url(d.a.l0.a.c1.a.l().processUrl(b.c()))).requestBody(c(map)).build().executeAsync(null);
        }
    }
}
