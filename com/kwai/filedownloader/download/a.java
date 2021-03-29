package com.kwai.filedownloader.download;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final long f36943a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36944b;

    /* renamed from: c  reason: collision with root package name */
    public final long f36945c;

    /* renamed from: d  reason: collision with root package name */
    public final long f36946d;

    public a(long j, long j2, long j3, long j4) {
        this.f36943a = j;
        this.f36944b = j2;
        this.f36945c = j3;
        this.f36946d = j4;
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f36943a), Long.valueOf(this.f36945c), Long.valueOf(this.f36944b));
    }
}
