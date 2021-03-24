package d.b.g0.a.t.c.n;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import d.b.g0.a.i2.b0;
import d.b.g0.a.p.c.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f46198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46199f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46200g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46201h;
        public final /* synthetic */ JSONObject i;

        public a(ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            this.f46198e = arrayMap;
            this.f46199f = jSONArray;
            this.f46200g = jSONArray2;
            this.f46201h = jSONArray3;
            this.i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                if (d.b.g0.a.t.b.d.f45928c) {
                    e2.printStackTrace();
                }
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.f46198e.put(optString, optString2);
                }
            }
            c.this.z(this.f46198e, this.f46199f, "images");
            c.this.z(this.f46198e, this.f46200g, "urls");
            c.this.z(this.f46198e, this.f46201h, "url");
            try {
                this.i.put("images", this.f46199f);
                this.i.put("urls", this.f46200g);
                this.i.put("url", this.f46201h);
            } catch (JSONException e3) {
                if (d.b.g0.a.t.b.d.f45928c) {
                    e3.printStackTrace();
                }
            }
            d.b.g0.a.w0.a.s().b(c.this.h(), this.i);
        }
    }

    public c(@NonNull d.b.g0.a.t.b.b bVar) {
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
        for (int i = 0; i < length; i++) {
            if (TextUtils.equals(optString, jSONArray.getString(i))) {
                return i;
            }
        }
        return -1;
    }

    public final String t(JSONArray jSONArray, String str, int i) {
        if (str.equals("images")) {
            return jSONArray.optJSONObject(i).optString("url");
        }
        return jSONArray.optString(i);
    }

    public d.b.g0.a.t.e.b u(String str) {
        int i;
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("PreviewImageApi", "params = " + str);
        }
        if (k()) {
            d.b.g0.a.c0.c.b("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
            return new d.b.g0.a.t.e.b(1001, "PreviewImageApi does not supported when app is invisible.");
        } else if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(202);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.i(h())) {
                    return new d.b.g0.a.t.e.b(403);
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
                        int i2 = 0;
                        for (int length = optJSONArray.length(); i2 < length; length = i) {
                            JSONObject jSONObject2 = new JSONObject();
                            String optString3 = optJSONArray.optString(i2);
                            jSONObject2.put("url", optString3);
                            String b2 = b0.b();
                            if (b0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                jSONObject2.put(Config.LAUNCH_REFERER, b2);
                            }
                            String W = d.b.g0.a.e0.w.d.L().W();
                            if (d.b.g0.a.t.b.d.f45928c) {
                                StringBuilder sb = new StringBuilder();
                                i = length;
                                sb.append("userAgent: ");
                                sb.append(W);
                                Log.d("PreviewImageApi", sb.toString());
                            } else {
                                i = length;
                            }
                            if (!TextUtils.isEmpty(W)) {
                                jSONObject2.put(com.alipay.sdk.cons.b.f1852b, W);
                            }
                            jSONArray.put(jSONObject2);
                            i2++;
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
                            d.b.g0.a.w0.a.s().b(h(), jSONObject);
                        }
                        return new d.b.g0.a.t.e.b(0);
                    }
                    return new d.b.g0.a.t.e.b(202);
                }
                return new d.b.g0.a.t.e.b(202);
            } catch (JSONException e2) {
                if (d.b.g0.a.t.b.d.f45928c) {
                    e2.printStackTrace();
                }
                return new d.b.g0.a.t.e.b(202);
            }
        }
    }

    public final JSONArray v(JSONArray jSONArray) {
        d.b.g0.a.r1.e y;
        int length = jSONArray.length();
        if (jSONArray != null && length > 0 && (y = d.b.g0.a.r1.e.y()) != null && !TextUtils.isEmpty(y.f45739f) && !TextUtils.isEmpty(y.W())) {
            for (int i = 0; i < length; i++) {
                try {
                    String optString = jSONArray.optString(i);
                    PathType c2 = d.b.g0.a.a2.b.c(optString);
                    if (c2 == PathType.BD_FILE) {
                        optString = d.b.g0.a.a2.b.u(optString, y.f45739f);
                    } else if (c2 == PathType.RELATIVE) {
                        optString = d.b.g0.a.a2.b.t(optString, y, y.W());
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        jSONArray.put(i, optString);
                        if (d.b.g0.a.t.b.d.f45928c) {
                            Log.e("PreviewImageApi", "convert swan path success：" + optString);
                        }
                    }
                } catch (JSONException e2) {
                    if (d.b.g0.a.t.b.d.f45928c) {
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
        for (int i = 0; i < jSONArray.length(); i++) {
            String t = t(jSONArray, str, i);
            if (!TextUtils.isEmpty(t) && d.b.g0.a.a2.b.c(t) == PathType.CLOUD) {
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
        q j = d.b.g0.a.w0.a.j();
        if (j == null) {
            return;
        }
        j.b(h(), jSONArray4, new a(arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void y(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("url");
                    String b2 = b0.b();
                    if (b0.c(optString) && !TextUtils.isEmpty(b2)) {
                        optJSONObject.put(Config.LAUNCH_REFERER, b2);
                    }
                    String W = d.b.g0.a.e0.w.d.L().W();
                    if (d.b.g0.a.t.b.d.f45928c) {
                        Log.d("PreviewImageApi", "userAgent: " + W);
                    }
                    if (!TextUtils.isEmpty(W)) {
                        optJSONObject.put(com.alipay.sdk.cons.b.f1852b, W);
                    }
                }
            } catch (JSONException e2) {
                if (d.b.g0.a.t.b.d.f45928c) {
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
        for (int i = 0; i < jSONArray.length(); i++) {
            String str2 = arrayMap.get(t(jSONArray, str, i));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i).put("url", str2);
                    } else {
                        jSONArray.put(i, str2);
                    }
                } catch (JSONException e2) {
                    if (d.b.g0.a.t.b.d.f45928c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
