package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends b<a> {

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a = "";
        public String b = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        String b;
        String str;
        if (a() == null || a().toJson() == null) {
            b = b();
            str = "";
        } else {
            b = b();
            str = a().toJson().toString();
        }
        editor.putString(b, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        a a2 = a();
        if (a2 == null) {
            a2 = new a();
        }
        String string = sharedPreferences.getString(b(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                a2.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.a.b(e);
            }
        }
        a((h) a2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(b());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((h) aVar);
    }

    public String d() {
        a a2 = a();
        return (a2 == null || TextUtils.isEmpty(a2.a)) ? "" : a2.a;
    }

    public String e() {
        a a2 = a();
        return (a2 == null || TextUtils.isEmpty(a2.b)) ? "" : a2.b;
    }
}
