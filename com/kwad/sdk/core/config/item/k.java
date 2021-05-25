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
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.core.config.item.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f32036a;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public Map<Integer, String> f32037a = new HashMap();
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public List<String> f32038b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<String> f32039c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f32040d;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32040d = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f32037a.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f32038b.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.f32039c.add(optJSONArray2.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            return this.f32040d;
        }
    }

    public k() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", this.f32036a);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("sdkPackInfo", null);
        this.f32036a = string;
        try {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.f32036a);
            a aVar = new a();
            aVar.a(jSONObject);
            a((k) aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.f32036a = optJSONObject.toString();
        a aVar = new a();
        aVar.a(optJSONObject);
        a((k) aVar);
    }
}
