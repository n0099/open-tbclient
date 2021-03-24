package com.kwai.filedownloader.download;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final long f36942a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36943b;

    /* renamed from: c  reason: collision with root package name */
    public final long f36944c;

    /* renamed from: d  reason: collision with root package name */
    public final long f36945d;

    public a(long j, long j2, long j3, long j4) {
        this.f36942a = j;
        this.f36943b = j2;
        this.f36944c = j3;
        this.f36945d = j4;
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f36942a), Long.valueOf(this.f36944c), Long.valueOf(this.f36943b));
    }
}
