package com.kwad.sdk.core.network.a;

import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class a {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public String f;
    public String g;

    @NonNull
    public String toString() {
        return "NetworkMonitorInfo{requestTotalTime=" + this.a + ", mRequestCreateTime" + this.b + ", requestResponseTime=" + this.c + ", requestParseDataTime=" + this.d + ", requestCallbackTime=" + this.e + ", requestFailReason='" + this.f + "', requestUrl='" + this.g + "'}";
    }
}
