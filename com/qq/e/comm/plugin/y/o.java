package com.qq.e.comm.plugin.y;
/* loaded from: classes3.dex */
class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private int f12711a;

    /* renamed from: b  reason: collision with root package name */
    private long f12712b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i, String str) {
        this.f12711a = i;
        this.c = str;
        this.f12712b = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, long j) {
        this.f12711a = -1;
        this.f12712b = j;
        this.c = str;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public int a() {
        return this.f12711a;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public String b() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public long c() {
        return this.f12712b;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(getClass().getSimpleName()).append("{");
        append.append("id=").append(this.f12711a);
        append.append(", time=").append(this.f12712b);
        append.append(", content='").append(this.c).append('\'');
        append.append('}');
        return append.toString();
    }
}
