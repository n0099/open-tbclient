package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i extends b<a> {

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a = TiebaStatic.MAX_COST_VALUE;
        public int b = 90000;
    }

    public i(String str) {
        super(str, new a());
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
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(b(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        if (jSONObject != null) {
            a2.parseJson(jSONObject);
        }
        a((i) a2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
            a((i) c());
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        a((i) aVar);
    }
}
