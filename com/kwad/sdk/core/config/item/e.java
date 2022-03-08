package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends b<a> {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public String f54205b;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f54206b;

        /* renamed from: c  reason: collision with root package name */
        public String f54207c;

        public a() {
            this.a = "";
            this.f54206b = "";
            this.f54207c = "";
        }

        public a(String str, String str2, String str3) {
            this.a = str;
            this.f54206b = str2;
            this.f54207c = str3;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("iconUrl", this.a);
            this.f54206b = jSONObject.optString("nightIconUrl", this.f54206b);
            this.f54207c = jSONObject.optString("desc", this.f54207c);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "icon", this.a);
            t.a(jSONObject, "nightIconUrl", this.f54206b);
            t.a(jSONObject, "desc", this.f54207c);
            return jSONObject;
        }
    }

    public e(String str, String str2) {
        super(str, new a("", "", str2));
        this.a = str2;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        editor.putString(b(), this.f54205b);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(b(), null);
        this.f54205b = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f54205b);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a((e) aVar);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(b());
        if (optJSONObject == null) {
            return;
        }
        this.f54205b = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((e) aVar);
    }
}
