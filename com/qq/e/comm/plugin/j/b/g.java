package com.qq.e.comm.plugin.j.b;
/* loaded from: classes4.dex */
class g implements d, com.qq.e.comm.plugin.j.f {

    /* renamed from: a  reason: collision with root package name */
    private final long f12469a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12470b;
    private final c[] c;
    private com.qq.e.comm.plugin.j.f d;

    public g(long j, long[] jArr, long[] jArr2) {
        this.f12469a = j;
        this.f12470b = jArr.length;
        this.c = new c[this.f12470b];
        for (int i = 0; i < this.f12470b; i++) {
            this.c[i] = new i(jArr[i], jArr2[i]);
            this.c[i].a(this);
        }
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public long a() {
        long j = 0;
        for (c cVar : this.c) {
            j += cVar.a();
        }
        return j;
    }

    public c a(int i) {
        if (i < 0 || i >= this.f12470b) {
            return null;
        }
        return this.c[i];
    }

    @Override // com.qq.e.comm.plugin.j.f
    public void a(long j, long j2) {
        if (this.d != null) {
            this.d.a(a(), b());
        }
    }

    @Override // com.qq.e.comm.plugin.j.b.d
    public void a(com.qq.e.comm.plugin.j.f fVar) {
        this.d = fVar;
    }

    public long b() {
        return this.f12469a;
    }
}
