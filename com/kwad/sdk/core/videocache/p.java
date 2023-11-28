package com.kwad.sdk.core.videocache;
/* loaded from: classes10.dex */
public abstract class p implements m {
    public volatile String aBv;
    public volatile int length = Integer.MIN_VALUE;
    public String url;

    public abstract String Fp();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aBv + "'}";
    }
}
