package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InsertScreenConfigItem extends b<InsertScreenConfig> {

    /* loaded from: classes3.dex */
    public static class InsertScreenConfig extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8956767980880231273L;
        public int firstPosition = 1;
        public int interval = 3;
        public int threshold = 2;
        public int preRequestCount = 2;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        String b2;
        String str;
        if (a() == null || a().toJson() == null) {
            b2 = b();
            str = "";
        } else {
            b2 = b();
            str = a().toJson().toString();
        }
        editor.putString(b2, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        InsertScreenConfig a = a();
        if (a == null) {
            a = new InsertScreenConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(b(), ""));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (jSONObject != null) {
            a.parseJson(jSONObject);
        }
        a((InsertScreenConfigItem) a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
            a((InsertScreenConfigItem) c());
            return;
        }
        InsertScreenConfig insertScreenConfig = new InsertScreenConfig();
        insertScreenConfig.parseJson(optJSONObject);
        a((InsertScreenConfigItem) insertScreenConfig);
    }
}
