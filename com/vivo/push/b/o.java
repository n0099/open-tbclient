package com.vivo.push.b;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class o extends u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f36548a;

    public o() {
        super(8);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.f36548a);
    }

    public final ArrayList<String> d() {
        return this.f36548a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36548a = aVar.b("tags_list");
    }
}
