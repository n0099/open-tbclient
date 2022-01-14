package com.ss.android.socialbase.downloader.exception;
/* loaded from: classes3.dex */
public class d extends BaseException {
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f59998b;

    public d(long j2, long j3) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j3), String.valueOf(j2)));
        this.a = j2;
        this.f59998b = j3;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.f59998b;
    }
}
