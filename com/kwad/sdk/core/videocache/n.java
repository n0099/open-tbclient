package com.kwad.sdk.core.videocache;
/* loaded from: classes10.dex */
public final class n {
    public final long aBu;
    public final String aBv;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.aBu = j;
        this.aBv = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aBu + ", mime='" + this.aBv + "'}";
    }
}
