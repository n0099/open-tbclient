package com.qq.e.comm.plugin.y;
/* loaded from: classes4.dex */
class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private int f13011a;

    /* renamed from: b  reason: collision with root package name */
    private long f13012b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i, String str) {
        this.f13011a = i;
        this.c = str;
        this.f13012b = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, long j) {
        this.f13011a = -1;
        this.f13012b = j;
        this.c = str;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public int a() {
        return this.f13011a;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public String b() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.y.n
    public long c() {
        return this.f13012b;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(getClass().getSimpleName()).append("{");
        append.append("id=").append(this.f13011a);
        append.append(", time=").append(this.f13012b);
        append.append(", content='").append(this.c).append('\'');
        append.append('}');
        return append.toString();
    }
}
