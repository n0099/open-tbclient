package com.kwad.sdk.core.network.idc.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a implements b {
    public final Map<String, List<String>> a = new ConcurrentHashMap();

    public static a b(String str) {
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        return aVar;
    }

    @NonNull
    private Map<String, List<String>> c() {
        return this.a;
    }

    @NonNull
    public final List<String> a(String str) {
        List<String> list = this.a.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final void a(a aVar) {
        this.a.clear();
        if (aVar != null) {
            this.a.putAll(aVar.c());
        }
    }

    public final boolean a() {
        return this.a.isEmpty();
    }

    @NonNull
    public final Set<String> b() {
        return this.a.keySet();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, r.a(jSONObject.optJSONArray(next)));
            }
        }
        this.a.clear();
        this.a.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.a;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            r.a(jSONObject, str, r.b(map.get(str)));
        }
        return jSONObject;
    }
}
