package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.b {
    public final Map<String, List<String>> auG = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> CP() {
        return this.auG;
    }

    @NonNull
    public final Set<String> CQ() {
        return this.auG.keySet();
    }

    public final boolean isEmpty() {
        return this.auG.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.auG;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            t.putValue(jSONObject, str, t.K(map.get(str)));
        }
        return jSONObject;
    }

    public static b dw(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        return bVar;
    }

    public final void a(b bVar) {
        this.auG.clear();
        if (bVar != null) {
            this.auG.putAll(bVar.CP());
        }
    }

    @NonNull
    public final List<String> dv(String str) {
        List<String> list = this.auG.get(str);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
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
                hashMap.put(next, t.h(jSONObject.optJSONArray(next)));
            }
        }
        this.auG.clear();
        this.auG.putAll(hashMap);
    }
}
