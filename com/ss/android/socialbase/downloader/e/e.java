package com.ss.android.socialbase.downloader.e;
/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final long f13143a;

    /* renamed from: b  reason: collision with root package name */
    private final long f13144b;

    public e(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f13143a = j;
        this.f13144b = j2;
    }

    public long c() {
        return this.f13143a;
    }

    public long d() {
        return this.f13144b;
    }
}
