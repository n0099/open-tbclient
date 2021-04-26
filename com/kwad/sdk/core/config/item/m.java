package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m extends a<List<String>> {
    public m(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        if (u.a(b())) {
            editor.putString(a(), o.a(b()).toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        List a2 = o.a(sharedPreferences.getString(a(), ""));
        if (u.a(a2)) {
            a((m) a2);
        } else {
            a((m) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(a())) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (optString != null && !optString.isEmpty()) {
                    arrayList.add(optString);
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
