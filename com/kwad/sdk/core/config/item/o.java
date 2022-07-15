package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class o extends b<List<String>> {
    public o(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        if (ad.a(b())) {
            editor.putString(a(), r.a(b()).toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        List a = r.a(sharedPreferences.getString(a(), ""));
        if (ad.a(a)) {
            a((o) a);
        } else {
            a((o) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(a())) != null && optJSONArray.length() > 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (optString != null && !optString.isEmpty()) {
                    copyOnWriteArrayList.add(optString);
                }
            }
            if (copyOnWriteArrayList.size() > 0) {
                a((o) copyOnWriteArrayList);
                return;
            }
        }
        a((o) c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final List<String> b() {
        List<String> list = (List) super.b();
        return list == null ? new ArrayList() : list;
    }
}
