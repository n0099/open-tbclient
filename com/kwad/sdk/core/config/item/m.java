package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m extends b<List<com.kwad.sdk.core.response.model.b>> {
    public m() {
        super("posContentInfoList", new ArrayList());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        List<com.kwad.sdk.core.response.model.b> a = a();
        if (ae.a(a)) {
            JSONArray jSONArray = new JSONArray();
            for (com.kwad.sdk.core.response.model.b bVar : a) {
                jSONArray.put(bVar.toJson());
            }
            editor.putString("posContentInfoList", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("posContentInfoList", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                        bVar.parseJson(optJSONObject);
                        arrayList.add(bVar);
                    }
                    if (arrayList.size() > 0) {
                        a((m) arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        a((m) c());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("posContentInfoList")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                    bVar.parseJson(optJSONObject);
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                a((m) arrayList);
                return;
            }
        }
        a((m) c());
    }
}
