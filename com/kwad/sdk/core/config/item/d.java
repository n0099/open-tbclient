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
    public final String f32101a;

    /* renamed from: b  reason: collision with root package name */
    public String f32102b;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f32103a;

        /* renamed from: b  reason: collision with root package name */
        public String f32104b;

        /* renamed from: c  reason: collision with root package name */
        public String f32105c;

        public a() {
            this.f32103a = "";
            this.f32104b = "";
            this.f32105c = "";
        }

        public a(String str, String str2, String str3) {
            this.f32103a = str;
            this.f32104b = str2;
            this.f32105c = str3;
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32103a = jSONObject.optString("iconUrl", this.f32103a);
            this.f32104b = jSONObject.optString("nightIconUrl", this.f32104b);
            this.f32105c = jSONObject.optString("desc", this.f32105c);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "icon", this.f32103a);
            o.a(jSONObject, "nightIconUrl", this.f32104b);
            o.a(jSONObject, "desc", this.f32105c);
            return jSONObject;
        }
    }

    public d(String str, String str2) {
        super(str, new a("", "", str2));
        this.f32101a = str2;
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences.Editor editor) {
        editor.putString(a(), this.f32102b);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(a(), null);
        this.f32102b = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f32102b);
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
        this.f32102b = optJSONObject.toString();
        a aVar = new a();
        aVar.a(optJSONObject);
        a((d) aVar);
    }
}
