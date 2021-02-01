package com.ss.android.socialbase.downloader.e;
/* loaded from: classes6.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final long f13145a;

    /* renamed from: b  reason: collision with root package name */
    private final long f13146b;

    public e(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f13145a = j;
        this.f13146b = j2;
    }

    public long c() {
        return this.f13145a;
    }

    public long d() {
        return this.f13146b;
    }
}
