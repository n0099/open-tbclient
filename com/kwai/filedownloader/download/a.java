package com.kwai.filedownloader.download;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final long f10898a;

    /* renamed from: b  reason: collision with root package name */
    final long f10899b;
    final long c;
    final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j, long j2, long j3, long j4) {
        this.f10898a = j;
        this.f10899b = j2;
        this.c = j3;
        this.d = j4;
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f10898a), Long.valueOf(this.c), Long.valueOf(this.f10899b));
    }
}
