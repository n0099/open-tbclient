package d.b.g0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45471d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45472a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.b1.g.a f45473b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f45474c;

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Request f45475a;

        public a(b bVar, Request request) {
            this.f45475a = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (b.f45471d) {
                Log.d("AlsSender", "onFailure: " + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            if (b.f45471d) {
                Log.d("AlsSender", "onResponse: respCode:" + response.code() + ", url:" + this.f45475a.url().toString() + ", msg:" + response.message());
            }
            return response;
        }
    }

    public b(Context context, JSONObject jSONObject) {
        this.f45472a = context;
        this.f45474c = jSONObject;
    }

    public final void a(@NonNull Request request) {
        if (d.b.g0.a.r1.e.O() == null) {
            return;
        }
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(request.url().toString(), new a(this, request));
        aVar.f48884f = true;
        aVar.f48885g = false;
        aVar.f48886h = false;
        d.b.g0.k.e.a.f().d(aVar);
    }

    public final String b(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        d.b.g0.a.b1.g.a aVar = this.f45473b;
        if (aVar != null) {
            hashMap2.put("cur_time", String.valueOf(aVar.j() / 1000));
        }
        hashMap2.put("origin_time", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll(hashMap2);
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (f45471d) {
                e2.printStackTrace();
            }
        } catch (IllegalArgumentException e3) {
            if (f45471d) {
                e3.printStackTrace();
            }
        }
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll("%%" + str2 + "%%", hashMap.get(str2));
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
        hashMap.put("play_mode", String.valueOf((SwanAppNetworkUtils.i(this.f45472a) && TextUtils.equals(str, "vstart")) ? 0 : 1));
        JSONObject jSONObject = this.f45474c;
        JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray(str) : null;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (SwanAppNetworkUtils.h(this.f45472a) && !TextUtils.isEmpty(optString)) {
                    HttpUrl parse = HttpUrl.parse(b(optString, hashMap));
                    if (parse == null) {
                        return;
                    }
                    a(new Request.Builder().url(parse.newBuilder().build()).build());
                }
            }
        }
    }

    public b(Context context, JSONObject jSONObject, d.b.g0.a.b1.g.a aVar) {
        this.f45472a = context;
        this.f45474c = jSONObject;
        this.f45473b = aVar;
    }
}
