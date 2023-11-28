package com.kwad.framework.filedownloader.download;
/* loaded from: classes10.dex */
public final class a {
    public final long afA;
    public final long afB;
    public final long afz;
    public final long contentLength;

    public a(long j, long j2, long j3, long j4) {
        this.afz = j;
        this.afA = j2;
        this.afB = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("range[%d, %d) current offset[%d]", Long.valueOf(this.afz), Long.valueOf(this.afB), Long.valueOf(this.afA));
    }
}
