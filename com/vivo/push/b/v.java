package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f40342a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f40343b;

    public v(int i2) {
        super(i2);
        this.f40342a = null;
        this.f40343b = null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f40342a);
        aVar.a("error_msg", this.f40343b);
    }

    public final ArrayList<String> d() {
        return this.f40342a;
    }

    public final List<String> e() {
        return this.f40343b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40342a = aVar.b("content");
        this.f40343b = aVar.b("error_msg");
    }
}
