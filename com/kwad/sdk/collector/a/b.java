package com.kwad.sdk.collector.a;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {
    public b(Collection<e> collection) {
        a("collectData", a(collection));
        a("collectType", 1);
        b(CommandMessage.SDK_VERSION, "3.3.17.4");
        a("sdkVersionCode", 3031704);
    }

    private JSONArray a(Collection<e> collection) {
        JSONArray jSONArray = new JSONArray();
        for (e eVar : collection) {
            JSONObject a = eVar.a();
            if (a != null) {
                jSONArray.put(a);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.m();
    }
}
