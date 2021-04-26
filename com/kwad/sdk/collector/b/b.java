package com.kwad.sdk.collector.b;

import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.collector.UploadEntry;
import com.kwad.sdk.core.network.d;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class b extends d {
    public b(Collection<UploadEntry> collection) {
        a("collectData", a(collection));
        a("collectType", 1);
        b(CommandMessage.SDK_VERSION, "3.3.8.3");
        a("sdkVersionCode", 3030803);
    }

    private JSONArray a(Collection<UploadEntry> collection) {
        JSONArray jSONArray = new JSONArray();
        for (UploadEntry uploadEntry : collection) {
            jSONArray.put(uploadEntry.toJson());
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.h();
    }
}
