package com.kwai.video.ksvodplayerkit.HttpDns;
/* loaded from: classes7.dex */
public enum ResolverType {
    LOCAL("local"),
    HTTP("http"),
    LOCAL_AND_HTTP("local|http");
    
    public final String mValue;

    ResolverType(String str) {
        this.mValue = str;
    }
}
