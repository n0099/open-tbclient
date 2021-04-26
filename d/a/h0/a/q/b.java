package d.a.h0.a.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.k;
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
    public static final boolean f43539d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f43540a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.b1.g.a f43541b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f43542c;

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Request f43543a;

        public a(b bVar, Request request) {
            this.f43543a = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (b.f43539d) {
                Log.d("AlsSender", "onFailure: " + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            if (b.f43539d) {
                Log.d("AlsSender", "onResponse: respCode:" + response.code() + ", url:" + this.f43543a.url().toString() + ", msg:" + response.message());
            }
            return response;
        }
    }

    public b(Context context, JSONObject jSONObject) {
        this.f43540a = context;
        this.f43542c = jSONObject;
    }

    public final void a(@NonNull Request request) {
        if (d.a.h0.a.r1.e.O() == null) {
            return;
        }
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(request.url().toString(), new a(this, request));
        aVar.f47111f = true;
        aVar.f47112g = false;
        aVar.f47113h = false;
        d.a.h0.k.e.a.f().d(aVar);
    }

    public final String b(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        d.a.h0.a.b1.g.a aVar = this.f43541b;
        if (aVar != null) {
            hashMap2.put("cur_time", String.valueOf(aVar.j() / 1000));
        }
        hashMap2.put("origin_time", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll(hashMap2);
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (f43539d) {
                e2.printStackTrace();
            }
        } catch (IllegalArgumentException e3) {
            if (f43539d) {
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
        hashMap.put("play_mode", String.valueOf((SwanAppNetworkUtils.i(this.f43540a) && TextUtils.equals(str, "vstart")) ? 0 : 1));
        JSONObject jSONObject = this.f43542c;
        JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray(str) : null;
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (SwanAppNetworkUtils.h(this.f43540a) && !TextUtils.isEmpty(optString)) {
                    HttpUrl parse = HttpUrl.parse(b(optString, hashMap));
                    if (parse == null) {
                        return;
                    }
                    a(new Request.Builder().url(parse.newBuilder().build()).build());
                }
            }
        }
    }

    public b(Context context, JSONObject jSONObject, d.a.h0.a.b1.g.a aVar) {
        this.f43540a = context;
        this.f43542c = jSONObject;
        this.f43541b = aVar;
    }
}
