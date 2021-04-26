package d.a.h0.g.i0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidubce.AbstractBceClient;
import d.a.h0.a.k;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46417a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (200 == i2) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (!d.f46417a || jSONObject.optInt("errno") == 0) {
                        return;
                    }
                    Log.e("SwanGameNowUtils", "report game history error");
                } catch (JSONException unused) {
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static void b() {
        String str;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("game", h2.B());
            jSONObject2.put("type", 0);
            jSONObject2.put("upload_time", System.currentTimeMillis() / 1000);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("app_infos", jSONArray);
            str = jSONObject.toString();
        } catch (Exception unused) {
            str = "";
        }
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) h2.V().postRequest().cookieManager(d.a.h0.a.w0.a.m().a())).url(d.a.h0.a.w0.a.l().t())).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), str)).build().executeAsync(new a());
    }
}
