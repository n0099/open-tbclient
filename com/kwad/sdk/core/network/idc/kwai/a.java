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
/* loaded from: classes9.dex */
public final class a implements b {
    public final Map<String, List<String>> Zg = new ConcurrentHashMap();

    public static a cb(String str) {
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        return aVar;
    }

    @NonNull
    private Map<String, List<String>> tK() {
        return this.Zg;
    }

    public final void b(a aVar) {
        this.Zg.clear();
        if (aVar != null) {
            this.Zg.putAll(aVar.tK());
        }
    }

    @NonNull
    public final List<String> ca(String str) {
        List<String> list = this.Zg.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.Zg.isEmpty();
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
                hashMap.put(next, r.f(jSONObject.optJSONArray(next)));
            }
        }
        this.Zg.clear();
        this.Zg.putAll(hashMap);
    }

    @NonNull
    public final Set<String> tL() {
        return this.Zg.keySet();
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.Zg;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            r.putValue(jSONObject, str, r.B(map.get(str)));
        }
        return jSONObject;
    }
}
