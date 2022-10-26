package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g extends b {

    /* loaded from: classes7.dex */
    public final class a extends com.kwad.sdk.core.response.kwai.a {
        public String VB = "";
        public String VC = "";
    }

    public g() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a aVar = (a) getValue();
        if (aVar == null) {
            aVar = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                aVar.parseJson(new JSONObject(b.bu(string)));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() == null || ((a) getValue()).toJson() == null) {
            editor.putString(getKey(), "");
            return;
        }
        editor.putString(getKey(), b.bt(((a) getValue()).toJson().toString()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }

    public final String getImei() {
        a aVar = (a) getValue();
        return (aVar == null || TextUtils.isEmpty(aVar.VB)) ? "" : aVar.VB;
    }

    public final String getOaid() {
        a aVar = (a) getValue();
        return (aVar == null || TextUtils.isEmpty(aVar.VC)) ? "" : aVar.VC;
    }
}
