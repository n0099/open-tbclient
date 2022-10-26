package com.kwad.sdk.collector.kwai;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends d {
    public b(Collection collection) {
        putBody("collectData", a(collection));
        putBody("collectType", 1);
        putBody(CommandMessage.SDK_VERSION, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    public static JSONArray a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            JSONObject rv = ((e) it.next()).rv();
            if (rv != null) {
                jSONArray.put(rv);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qT();
    }
}
