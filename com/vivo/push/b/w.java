package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class w extends x {

    /* renamed from: a  reason: collision with root package name */
    public long f39401a;

    /* renamed from: b  reason: collision with root package name */
    public int f39402b;

    public w() {
        super(20);
        this.f39401a = -1L;
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f39401a);
        aVar.a("undo_msg_type_v1", this.f39402b);
    }

    public final long d() {
        return this.f39401a;
    }

    public final String e() {
        long j = this.f39401a;
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
        this.f39401a = aVar.b("undo_msg_v1", this.f39401a);
        this.f39402b = aVar.b("undo_msg_type_v1", 0);
    }
}
