package com.vivo.push.b;

import java.util.ArrayList;
/* loaded from: classes14.dex */
public final class o extends u {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f8020a;

    public o() {
        super(8);
    }

    public final ArrayList<String> d() {
        return this.f8020a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.f8020a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f8020a = aVar.b("tags_list");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnListTagCommand";
    }
}
