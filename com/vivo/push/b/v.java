package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f37386a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f37387b;

    public v(int i2) {
        super(i2);
        this.f37386a = null;
        this.f37387b = null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f37386a);
        aVar.a("error_msg", this.f37387b);
    }

    public final ArrayList<String> d() {
        return this.f37386a;
    }

    public final List<String> e() {
        return this.f37387b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f37386a = aVar.b("content");
        this.f37387b = aVar.b("error_msg");
    }
}
