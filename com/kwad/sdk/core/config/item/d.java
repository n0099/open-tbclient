package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.config.item.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final String f32856a;

    /* renamed from: b  reason: collision with root package name */
    public String f32857b;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f32858a;

        /* renamed from: b  reason: collision with root package name */
        public String f32859b;

        /* renamed from: c  reason: collision with root package name */
        public String f32860c;

        public a() {
            this.f32858a = "";
            this.f32859b = "";
            this.f32860c = "";
        }

        public a(String str, String str2, String str3) {
            this.f32858a = str;
            this.f32859b = str2;
            this.f32860c = str3;
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32858a = jSONObject.optString("iconUrl", this.f32858a);
            this.f32859b = jSONObject.optString("nightIconUrl", this.f32859b);
            this.f32860c = jSONObject.optString("desc", this.f32860c);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "icon", this.f32858a);
            o.a(jSONObject, "nightIconUrl", this.f32859b);
            o.a(jSONObject, "desc", this.f32860c);
            return jSONObject;
        }
    }

    public d(String str, String str2) {
        super(str, new a("", "", str2));
        this.f32856a = str2;
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences.Editor editor) {
        editor.putString(a(), this.f32857b);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(a(), null);
        this.f32857b = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f32857b);
            a aVar = new a();
            aVar.a(jSONObject);
            a((d) aVar);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(a());
        if (optJSONObject == null) {
            return;
        }
        this.f32857b = optJSONObject.toString();
        a aVar = new a();
        aVar.a(optJSONObject);
        a((d) aVar);
    }
}
