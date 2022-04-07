package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r extends b<List<String>> {
    public r(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        if (ae.a(a())) {
            editor.putString(b(), t.a(a()).toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        List a = t.a(sharedPreferences.getString(b(), ""));
        if (ae.a(a)) {
            a((r) a);
        } else {
            a((r) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(b())) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (optString != null && !optString.isEmpty()) {
                    arrayList.add(optString);
                }
            }
            if (arrayList.size() > 0) {
                a((r) arrayList);
                return;
            }
        }
        a((r) c());
    }
}
