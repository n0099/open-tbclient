package com.kwad.sdk.core.report;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public d(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.utils.r.putValue(jSONArray, ((m) it.next()).ut());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qO();
    }
}
