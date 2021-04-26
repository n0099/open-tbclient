package com.ss.android.socialbase.downloader.exception;
/* loaded from: classes6.dex */
public class d extends BaseException {

    /* renamed from: a  reason: collision with root package name */
    public final long f36823a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36824b;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f36823a = j;
        this.f36824b = j2;
    }

    public long a() {
        return this.f36823a;
    }

    public long b() {
        return this.f36824b;
    }
}
