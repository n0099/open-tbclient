package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i extends a<List<com.kwad.sdk.core.response.model.b>> {
    public i() {
        super("posContentInfoList", new ArrayList());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        List<com.kwad.sdk.core.response.model.b> b2 = b();
        if (u.a(b2)) {
            JSONArray jSONArray = new JSONArray();
            for (com.kwad.sdk.core.response.model.b bVar : b2) {
                jSONArray.put(bVar.toJson());
            }
            editor.putString("posContentInfoList", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("posContentInfoList", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                        bVar.a(optJSONObject);
                        arrayList.add(bVar);
                    }
                    if (arrayList.size() > 0) {
                        a((i) arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        a((i) c());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("posContentInfoList")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                    bVar.a(optJSONObject);
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                a((i) arrayList);
                return;
            }
        }
        a((i) c());
    }
}
