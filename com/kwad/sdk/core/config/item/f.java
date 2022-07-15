package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends b<a> {

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a = "";
        public String b = "";
    }

    public f() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        String a2;
        String str;
        if (b() == null || b().toJson() == null) {
            a2 = a();
            str = "";
        } else {
            a2 = a();
            str = b().toJson().toString();
        }
        editor.putString(a2, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a b = b();
        if (b == null) {
            b = new a();
        }
        String string = sharedPreferences.getString(a(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                b.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
        a((f) b);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(a());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((f) aVar);
    }

    public final String d() {
        a b = b();
        return (b == null || TextUtils.isEmpty(b.a)) ? "" : b.a;
    }

    public final String e() {
        a b = b();
        return (b == null || TextUtils.isEmpty(b.b)) ? "" : b.b;
    }
}
