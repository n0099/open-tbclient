package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class w extends x {

    /* renamed from: a  reason: collision with root package name */
    public long f40344a;

    /* renamed from: b  reason: collision with root package name */
    public int f40345b;

    public w() {
        super(20);
        this.f40344a = -1L;
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f40344a);
        aVar.a("undo_msg_type_v1", this.f40345b);
    }

    public final long d() {
        return this.f40344a;
    }

    public final String e() {
        long j = this.f40344a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40344a = aVar.b("undo_msg_v1", this.f40344a);
        this.f40345b = aVar.b("undo_msg_type_v1", 0);
    }
}
