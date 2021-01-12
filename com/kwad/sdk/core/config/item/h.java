package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h extends a<List<com.kwad.sdk.core.response.model.b>> {
    public h() {
        super("posContentInfoList", new ArrayList());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        List<com.kwad.sdk.core.response.model.b> b2 = b();
        if (w.a(b2)) {
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
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                        bVar.a(optJSONObject);
                        arrayList.add(bVar);
                    }
                    if (arrayList.size() > 0) {
                        a((h) arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        a((h) c());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("posContentInfoList")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                    bVar.a(optJSONObject);
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                a((h) arrayList);
                return;
            }
        }
        a((h) c());
    }
}
