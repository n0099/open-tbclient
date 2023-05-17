package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.INet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class c extends com.kwad.sdk.core.network.b {
    @NonNull
    public final Map<String, String> ahK;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.ahK = hashMap;
        hashMap.put("did", str);
        this.ahK.put("sid", str2);
        this.ahK.put("fileExtend", str3);
        this.ahK.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getBodyMap() {
        return this.ahK;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.tH().F(INet.HostType.ULOG, "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
