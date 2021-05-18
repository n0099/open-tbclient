package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f36631a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f36632b;

    public v(int i2) {
        super(i2);
        this.f36631a = null;
        this.f36632b = null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f36631a);
        aVar.a("error_msg", this.f36632b);
    }

    public final ArrayList<String> d() {
        return this.f36631a;
    }

    public final List<String> e() {
        return this.f36632b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36631a = aVar.b("content");
        this.f36632b = aVar.b("error_msg");
    }
}
