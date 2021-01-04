package com.kwai.video.ksvodplayerkit.HttpDns;

import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public enum ResolverType {
    LOCAL("local"),
    HTTP(HttpHost.DEFAULT_SCHEME_NAME),
    LOCAL_AND_HTTP("local|http");
    
    public final String mValue;

    ResolverType(String str) {
        this.mValue = str;
    }
}
