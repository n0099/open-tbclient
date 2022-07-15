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
/* loaded from: classes5.dex */
public final class m extends b<a> {
    public String a;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        @NonNull
        public Map<Integer, String> a = new HashMap();
        @NonNull
        public List<String> b = new ArrayList();
        @NonNull
        public List<String> c = new ArrayList();
        public List<String> d = new ArrayList();
        public int e;
        public JSONObject f;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f = jSONObject;
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.b.add(optJSONArray.optString(i));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.c.add(optJSONArray2.optString(i2));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.d.add(optJSONArray3.optString(i3));
                }
            }
            this.e = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.f;
        }
    }

    public m() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", this.a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("sdkPackInfo", null);
        this.a = string;
        try {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.a);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a((m) aVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.a = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((m) aVar);
    }
}
