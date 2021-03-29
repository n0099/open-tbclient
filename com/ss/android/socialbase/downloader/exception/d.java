package com.ss.android.socialbase.downloader.exception;
/* loaded from: classes7.dex */
public class d extends BaseException {

    /* renamed from: a  reason: collision with root package name */
    public final long f38849a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38850b;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f38849a = j;
        this.f38850b = j2;
    }

    public long a() {
        return this.f38849a;
    }

    public long b() {
        return this.f38850b;
    }
}
