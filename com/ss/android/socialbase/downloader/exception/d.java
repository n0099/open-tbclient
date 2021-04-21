package com.ss.android.socialbase.downloader.exception;
/* loaded from: classes6.dex */
public class d extends BaseException {

    /* renamed from: a  reason: collision with root package name */
    public final long f39233a;

    /* renamed from: b  reason: collision with root package name */
    public final long f39234b;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f39233a = j;
        this.f39234b = j2;
    }

    public long a() {
        return this.f39233a;
    }

    public long b() {
        return this.f39234b;
    }
}
