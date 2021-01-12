package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k extends a<List<String>> {
    public k(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        if (w.a(b())) {
            editor.putString(a(), o.a(b()).toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        List a2 = o.a(sharedPreferences.getString(a(), ""));
        if (w.a(a2)) {
            a((k) a2);
        } else {
            a((k) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(a())) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (optString != null && !optString.isEmpty()) {
                    arrayList.add(optString);
                }
            }
            if (arrayList.size() > 0) {
                a((k) arrayList);
                return;
            }
        }
        a((k) c());
    }
}
