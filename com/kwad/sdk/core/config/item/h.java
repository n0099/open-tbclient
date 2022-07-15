package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h extends b<a> {

    @KsJson
    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a = TiebaStatic.MAX_COST_VALUE;
        public int b = 90000;
    }

    public h(String str) {
        super(str, new a());
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
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(a(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        if (jSONObject != null) {
            b.parseJson(jSONObject);
        }
        a((h) b);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((h) c());
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((h) aVar);
    }
}
