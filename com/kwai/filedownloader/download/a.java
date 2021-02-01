package com.kwai.filedownloader.download;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final long f10900a;

    /* renamed from: b  reason: collision with root package name */
    final long f10901b;
    final long c;
    final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j, long j2, long j3, long j4) {
        this.f10900a = j;
        this.f10901b = j2;
        this.c = j3;
        this.d = j4;
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f10900a), Long.valueOf(this.c), Long.valueOf(this.f10901b));
    }
}
