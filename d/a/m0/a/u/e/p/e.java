package d.a.m0.a.u.e.p;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import d.a.m0.a.p.d.y;
import d.a.m0.a.v2.d0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f48982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48983f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48984g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48985h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48986i;

        public a(ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            this.f48982e = arrayMap;
            this.f48983f = jSONArray;
            this.f48984g = jSONArray2;
            this.f48985h = jSONArray3;
            this.f48986i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                if (d.a.m0.a.u.c.d.f48594c) {
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
                    this.f48982e.put(optString, optString2);
                }
            }
            e.this.A(this.f48982e, this.f48983f, "images");
            e.this.A(this.f48982e, this.f48984g, "urls");
            e.this.A(this.f48982e, this.f48985h, "url");
            try {
                this.f48986i.put("images", this.f48983f);
                this.f48986i.put("urls", this.f48984g);
                this.f48986i.put("url", this.f48985h);
            } catch (JSONException e3) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    e3.printStackTrace();
                }
            }
            d.a.m0.a.c1.a.y().b(e.this.i(), this.f48986i);
        }
    }

    public e(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void A(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String str2 = arrayMap.get(u(jSONArray, str, i2));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i2).put("url", str2);
                    } else {
                        jSONArray.put(i2, str2);
                    }
                } catch (JSONException e2) {
                    if (d.a.m0.a.u.c.d.f48594c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final int t(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
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

    public final String u(JSONArray jSONArray, String str, int i2) {
        if (str.equals("images")) {
            return jSONArray.optJSONObject(i2).optString("url");
        }
        return jSONArray.optString(i2);
    }

    public d.a.m0.a.u.h.b v(String str) {
        int i2;
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("PreviewImageApi", "params = " + str);
        }
        if (l()) {
            d.a.m0.a.e0.d.b("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
            return new d.a.m0.a.u.h.b(1001, "PreviewImageApi does not supported when app is invisible.");
        } else if (TextUtils.isEmpty(str)) {
            return new d.a.m0.a.u.h.b(202);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(i())) {
                    return new d.a.m0.a.u.h.b(403);
                }
                String optString = jSONObject.optString("source", "unitedscheme");
                String optString2 = jSONObject.optString("type", "0");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                    if (optJSONArray2 != null) {
                        z(optJSONArray2);
                        jSONObject.put("images", optJSONArray2);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        int i3 = 0;
                        for (int length = optJSONArray.length(); i3 < length; length = i2) {
                            JSONObject jSONObject2 = new JSONObject();
                            String optString3 = optJSONArray.optString(i3);
                            jSONObject2.put("url", optString3);
                            String b2 = d0.b();
                            if (d0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                jSONObject2.put(Config.LAUNCH_REFERER, b2);
                            }
                            String Y = d.a.m0.a.h0.u.g.N().Y();
                            if (d.a.m0.a.u.c.d.f48594c) {
                                StringBuilder sb = new StringBuilder();
                                i2 = length;
                                sb.append("userAgent: ");
                                sb.append(Y);
                                Log.d("PreviewImageApi", sb.toString());
                            } else {
                                i2 = length;
                            }
                            if (!TextUtils.isEmpty(Y)) {
                                jSONObject2.put(com.alipay.sdk.cons.b.f1838b, Y);
                            }
                            jSONArray.put(jSONObject2);
                            i3++;
                        }
                        jSONObject.put("images", jSONArray);
                    }
                    if (TextUtils.equals(optString, "swan")) {
                        w(optJSONArray);
                    }
                    jSONObject.put("url", optJSONArray);
                    jSONObject.put("type", optString2);
                    int t = t(jSONObject, optJSONArray);
                    if (t >= 0 && t < optJSONArray.length()) {
                        jSONObject.put("index", String.valueOf(t));
                        ArrayMap<String, String> arrayMap = new ArrayMap<>();
                        JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                        JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                        JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                        x(arrayMap, optJSONArray3, "images");
                        x(arrayMap, optJSONArray4, "urls");
                        x(arrayMap, optJSONArray5, "url");
                        if (arrayMap.keySet().size() > 0) {
                            y(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                        } else {
                            d.a.m0.a.c1.a.y().b(i(), jSONObject);
                        }
                        return new d.a.m0.a.u.h.b(0);
                    }
                    return new d.a.m0.a.u.h.b(202);
                }
                return new d.a.m0.a.u.h.b(202);
            } catch (JSONException e2) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    e2.printStackTrace();
                }
                return new d.a.m0.a.u.h.b(202);
            }
        }
    }

    public final JSONArray w(JSONArray jSONArray) {
        d.a.m0.a.a2.e i2;
        int length = jSONArray.length();
        if (jSONArray != null && length > 0 && (i2 = d.a.m0.a.a2.e.i()) != null && !TextUtils.isEmpty(i2.f44533f) && !TextUtils.isEmpty(i2.Z())) {
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    String optString = jSONArray.optString(i3);
                    PathType s = d.a.m0.a.k2.b.s(optString);
                    if (s == PathType.BD_FILE) {
                        optString = d.a.m0.a.k2.b.M(optString, i2.f44533f);
                    } else if (s == PathType.RELATIVE) {
                        optString = d.a.m0.a.k2.b.L(optString, i2, i2.Z());
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        jSONArray.put(i3, optString);
                        if (d.a.m0.a.u.c.d.f48594c) {
                            Log.e("PreviewImageApi", "convert swan path success：" + optString);
                        }
                    }
                } catch (JSONException e2) {
                    if (d.a.m0.a.u.c.d.f48594c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    public final void x(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String u = u(jSONArray, str, i2);
            if (!TextUtils.isEmpty(u) && d.a.m0.a.k2.b.s(u) == PathType.CLOUD) {
                arrayMap.put(u, u);
            }
        }
    }

    public final void y(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        if (jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        y k = d.a.m0.a.c1.a.k();
        if (k == null) {
            return;
        }
        k.c(i(), jSONArray4, new a(arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void z(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("url");
                    String b2 = d0.b();
                    if (d0.c(optString) && !TextUtils.isEmpty(b2)) {
                        optJSONObject.put(Config.LAUNCH_REFERER, b2);
                    }
                    String Y = d.a.m0.a.h0.u.g.N().Y();
                    if (d.a.m0.a.u.c.d.f48594c) {
                        Log.d("PreviewImageApi", "userAgent: " + Y);
                    }
                    if (!TextUtils.isEmpty(Y)) {
                        optJSONObject.put(com.alipay.sdk.cons.b.f1838b, Y);
                    }
                }
            } catch (JSONException e2) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
    }
}
