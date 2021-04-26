package d.a.h0.a.t.c.n;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import d.a.h0.a.i2.b0;
import d.a.h0.a.p.c.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f44307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44308f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44309g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44310h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44311i;

        public a(ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            this.f44307e = arrayMap;
            this.f44308f = jSONArray;
            this.f44309g = jSONArray2;
            this.f44310h = jSONArray3;
            this.f44311i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                if (d.a.h0.a.t.b.d.f44021c) {
                    e2.printStackTrace();
                }
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.f44307e.put(optString, optString2);
                }
            }
            c.this.z(this.f44307e, this.f44308f, "images");
            c.this.z(this.f44307e, this.f44309g, "urls");
            c.this.z(this.f44307e, this.f44310h, "url");
            try {
                this.f44311i.put("images", this.f44308f);
                this.f44311i.put("urls", this.f44309g);
                this.f44311i.put("url", this.f44310h);
            } catch (JSONException e3) {
                if (d.a.h0.a.t.b.d.f44021c) {
                    e3.printStackTrace();
                }
            }
            d.a.h0.a.w0.a.s().a(c.this.h(), this.f44311i);
        }
    }

    public c(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final int s(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
        if (optInt >= 0) {
            return optInt;
        }
        String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public final String t(JSONArray jSONArray, String str, int i2) {
        if (str.equals("images")) {
            return jSONArray.optJSONObject(i2).optString("url");
        }
        return jSONArray.optString(i2);
    }

    public d.a.h0.a.t.e.b u(String str) {
        int i2;
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("PreviewImageApi", "params = " + str);
        }
        if (k()) {
            d.a.h0.a.c0.c.b("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
            return new d.a.h0.a.t.e.b(1001, "PreviewImageApi does not supported when app is invisible.");
        } else if (TextUtils.isEmpty(str)) {
            return new d.a.h0.a.t.e.b(202);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.i(h())) {
                    return new d.a.h0.a.t.e.b(403);
                }
                String optString = jSONObject.optString("source", "unitedscheme");
                String optString2 = jSONObject.optString("type", "0");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                    if (optJSONArray2 != null) {
                        y(optJSONArray2);
                        jSONObject.put("images", optJSONArray2);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        int i3 = 0;
                        for (int length = optJSONArray.length(); i3 < length; length = i2) {
                            JSONObject jSONObject2 = new JSONObject();
                            String optString3 = optJSONArray.optString(i3);
                            jSONObject2.put("url", optString3);
                            String b2 = b0.b();
                            if (b0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                jSONObject2.put(Config.LAUNCH_REFERER, b2);
                            }
                            String W = d.a.h0.a.e0.w.d.L().W();
                            if (d.a.h0.a.t.b.d.f44021c) {
                                StringBuilder sb = new StringBuilder();
                                i2 = length;
                                sb.append("userAgent: ");
                                sb.append(W);
                                Log.d("PreviewImageApi", sb.toString());
                            } else {
                                i2 = length;
                            }
                            if (!TextUtils.isEmpty(W)) {
                                jSONObject2.put(com.alipay.sdk.cons.b.f1825b, W);
                            }
                            jSONArray.put(jSONObject2);
                            i3++;
                        }
                        jSONObject.put("images", jSONArray);
                    }
                    if (TextUtils.equals(optString, "swan")) {
                        v(optJSONArray);
                    }
                    jSONObject.put("url", optJSONArray);
                    jSONObject.put("type", optString2);
                    int s = s(jSONObject, optJSONArray);
                    if (s >= 0 && s < optJSONArray.length()) {
                        jSONObject.put("index", String.valueOf(s));
                        ArrayMap<String, String> arrayMap = new ArrayMap<>();
                        JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                        JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                        JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                        w(arrayMap, optJSONArray3, "images");
                        w(arrayMap, optJSONArray4, "urls");
                        w(arrayMap, optJSONArray5, "url");
                        if (arrayMap.keySet().size() > 0) {
                            x(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                        } else {
                            d.a.h0.a.w0.a.s().a(h(), jSONObject);
                        }
                        return new d.a.h0.a.t.e.b(0);
                    }
                    return new d.a.h0.a.t.e.b(202);
                }
                return new d.a.h0.a.t.e.b(202);
            } catch (JSONException e2) {
                if (d.a.h0.a.t.b.d.f44021c) {
                    e2.printStackTrace();
                }
                return new d.a.h0.a.t.e.b(202);
            }
        }
    }

    public final JSONArray v(JSONArray jSONArray) {
        d.a.h0.a.r1.e h2;
        int length = jSONArray.length();
        if (jSONArray != null && length > 0 && (h2 = d.a.h0.a.r1.e.h()) != null && !TextUtils.isEmpty(h2.f43823f) && !TextUtils.isEmpty(h2.W())) {
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String optString = jSONArray.optString(i2);
                    PathType c2 = d.a.h0.a.a2.b.c(optString);
                    if (c2 == PathType.BD_FILE) {
                        optString = d.a.h0.a.a2.b.u(optString, h2.f43823f);
                    } else if (c2 == PathType.RELATIVE) {
                        optString = d.a.h0.a.a2.b.t(optString, h2, h2.W());
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        jSONArray.put(i2, optString);
                        if (d.a.h0.a.t.b.d.f44021c) {
                            Log.e("PreviewImageApi", "convert swan path success：" + optString);
                        }
                    }
                } catch (JSONException e2) {
                    if (d.a.h0.a.t.b.d.f44021c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    public final void w(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String t = t(jSONArray, str, i2);
            if (!TextUtils.isEmpty(t) && d.a.h0.a.a2.b.c(t) == PathType.CLOUD) {
                arrayMap.put(t, t);
            }
        }
    }

    public final void x(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        if (jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        q j = d.a.h0.a.w0.a.j();
        if (j == null) {
            return;
        }
        j.b(h(), jSONArray4, new a(arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void y(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("url");
                    String b2 = b0.b();
                    if (b0.c(optString) && !TextUtils.isEmpty(b2)) {
                        optJSONObject.put(Config.LAUNCH_REFERER, b2);
                    }
                    String W = d.a.h0.a.e0.w.d.L().W();
                    if (d.a.h0.a.t.b.d.f44021c) {
                        Log.d("PreviewImageApi", "userAgent: " + W);
                    }
                    if (!TextUtils.isEmpty(W)) {
                        optJSONObject.put(com.alipay.sdk.cons.b.f1825b, W);
                    }
                }
            } catch (JSONException e2) {
                if (d.a.h0.a.t.b.d.f44021c) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
    }

    public final void z(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String str2 = arrayMap.get(t(jSONArray, str, i2));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i2).put("url", str2);
                    } else {
                        jSONArray.put(i2, str2);
                    }
                } catch (JSONException e2) {
                    if (d.a.h0.a.t.b.d.f44021c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
