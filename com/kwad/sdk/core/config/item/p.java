package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p extends b<a> {
    public String a;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        @NonNull
        public Map<Integer, String> a = new HashMap();
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public List<String> f55693b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<String> f55694c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f55695d;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f55696e;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f55696e = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.a.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f55693b.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.f55694c.add(optJSONArray2.optString(i3));
                }
            }
            this.f55695d = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            return this.f55696e;
        }
    }

    public p() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", this.a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("sdkPackInfo", null);
        this.a = string;
        try {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.a);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a((p) aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.a = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((p) aVar);
    }
}
