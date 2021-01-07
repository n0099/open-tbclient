package com.qq.e.comm.plugin.j.b;
/* loaded from: classes4.dex */
class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final long f12471a;

    /* renamed from: b  reason: collision with root package name */
    private volatile long f12472b;
    private com.qq.e.comm.plugin.j.f c;

    public i(long j, long j2) {
        this.f12471a = j;
        this.f12472b = j2;
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public long a() {
        return this.f12472b;
    }

    @Override // com.qq.e.comm.plugin.j.b.c
    public void a(long j) {
        this.f12472b = j;
        if (this.c != null) {
            this.c.a(a(), b());
        }
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public void a(com.qq.e.comm.plugin.j.f fVar) {
        this.c = fVar;
    }

    public long b() {
        return this.f12471a;
    }
}
