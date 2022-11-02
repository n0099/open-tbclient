package com.kwad.sdk.core.network;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes8.dex */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public String Yp;
    public int Ys;
    public String errorMsg;
    public String host;
    public int httpCode;
    public String url;
    public int Yq = 0;
    public int Yr = 1;
    public double ratioCount = 1.0d;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return toJson().toString();
    }
}
