package com.kwai.filedownloader.download;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final long f11198a;

    /* renamed from: b  reason: collision with root package name */
    final long f11199b;
    final long c;
    final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j, long j2, long j3, long j4) {
        this.f11198a = j;
        this.f11199b = j2;
        this.c = j3;
        this.d = j4;
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f11198a), Long.valueOf(this.c), Long.valueOf(this.f11199b));
    }
}
