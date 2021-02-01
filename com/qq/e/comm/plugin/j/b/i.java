package com.qq.e.comm.plugin.j.b;
/* loaded from: classes15.dex */
class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final long f12173a;

    /* renamed from: b  reason: collision with root package name */
    private volatile long f12174b;
    private com.qq.e.comm.plugin.j.f c;

    public i(long j, long j2) {
        this.f12173a = j;
        this.f12174b = j2;
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public long a() {
        return this.f12174b;
    }

    @Override // com.qq.e.comm.plugin.j.b.c
    public void a(long j) {
        this.f12174b = j;
        if (this.c != null) {
            this.c.a(a(), b());
        }
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public void a(com.qq.e.comm.plugin.j.f fVar) {
        this.c = fVar;
    }

    public long b() {
        return this.f12173a;
    }
}
