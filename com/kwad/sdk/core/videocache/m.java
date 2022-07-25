package com.kwad.sdk.core.videocache;
/* loaded from: classes5.dex */
public final class m {
    public final long aeV;
    public final String aeW;
    public final String url;

    public m(String str, long j, String str2) {
        this.url = str;
        this.aeV = j;
        this.aeW = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aeV + ", mime='" + this.aeW + "'}";
    }
}
