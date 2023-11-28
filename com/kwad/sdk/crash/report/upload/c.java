package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class c extends com.kwad.sdk.core.network.b {
    @NonNull
    public final Map<String, String> aGj;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aGj = hashMap;
        hashMap.put("did", str);
        this.aGj.put("sid", str2);
        this.aGj.put("fileExtend", str3);
        this.aGj.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aGj;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.CJ().U("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
