package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@KsJson
/* loaded from: classes8.dex */
public class HttpDnsInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = -6943205584670122267L;
    public List<IpInfo> recommendList = new ArrayList();
    public List<IpInfo> backUpList = new ArrayList();
    public List<IpInfo> otherList = new ArrayList();

    @KsJson
    /* loaded from: classes8.dex */
    public static class IpInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -6943205584670122266L;
        public String ip = "";
        public int weight;

        @Override // com.kwad.sdk.core.response.kwai.a
        public String toString() {
            try {
                return toJson().toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        try {
            return toJson().toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
