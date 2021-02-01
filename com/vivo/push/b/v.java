package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f13594a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f13595b;

    public v(int i) {
        super(i);
        this.f13594a = null;
        this.f13595b = null;
    }

    public final ArrayList<String> d() {
        return this.f13594a;
    }

    public final List<String> e() {
        return this.f13595b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f13594a);
        aVar.a("error_msg", this.f13595b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13594a = aVar.b("content");
        this.f13595b = aVar.b("error_msg");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
