package d.a.i0.f.i.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f46648a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f46649b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {
        public a(c cVar) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            return response;
        }
    }

    public c(Context context, JSONObject jSONObject) {
        this.f46648a = context;
        this.f46649b = jSONObject;
    }

    public final void a(@NonNull Request request) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(request.url().toString(), new a(this));
        aVar.f47798f = true;
        aVar.f47799g = false;
        aVar.f47800h = false;
        d.a.i0.m.e.a.g().d(aVar);
    }

    public final String b(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("origin_time", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll(hashMap2);
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            str = str.replaceAll("%%" + entry.getKey() + "%%", entry.getValue());
        }
        return str;
    }

    public void c(String str) {
        d(str, new HashMap<>());
    }

    public void d(String str, HashMap<String, String> hashMap) {
        if (TextUtils.equals(str, "da_area")) {
            hashMap.put("da_page", "VIDEODETAIL_TAIL");
        } else if (!TextUtils.equals(str, "lpin") && !TextUtils.equals(str, "lpout")) {
            hashMap.put("da_page", "VIDEOADDETAI");
        } else {
            hashMap.put("da_page", "MINIAPP");
        }
        hashMap.put("play_mode", String.valueOf((NetworkUtils.g(this.f46648a) && TextUtils.equals(str, "vstart")) ? 0 : 1));
        JSONObject jSONObject = this.f46649b;
        JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray(str) : null;
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (NetworkUtils.f(this.f46648a) && !TextUtils.isEmpty(optString)) {
                    HttpUrl parse = HttpUrl.parse(b(optString, hashMap));
                    if (parse == null) {
                        return;
                    }
                    a(new Request.Builder().url(parse.newBuilder().build()).build());
                }
            }
        }
    }

    public void e(String str) {
        HttpUrl parse;
        if (!NetworkUtils.f(this.f46648a) || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return;
        }
        a(new Request.Builder().url(parse.newBuilder().build()).build());
    }
}
