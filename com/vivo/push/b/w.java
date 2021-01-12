package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class w extends x {

    /* renamed from: a  reason: collision with root package name */
    private long f13594a;

    /* renamed from: b  reason: collision with root package name */
    private int f13595b;

    public w() {
        super(20);
        this.f13594a = -1L;
    }

    public final long d() {
        return this.f13594a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f13594a);
        aVar.a("undo_msg_type_v1", this.f13595b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13594a = aVar.b("undo_msg_v1", this.f13594a);
        this.f13595b = aVar.b("undo_msg_type_v1", 0);
    }

    public final String e() {
        if (this.f13594a != -1) {
            return String.valueOf(this.f13594a);
        }
        return null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnUndoMsgCommand";
    }
}
