package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f39783a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f39784b;

    public v(int i) {
        super(i);
        this.f39783a = null;
        this.f39784b = null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f39783a);
        aVar.a("error_msg", this.f39784b);
    }

    public final ArrayList<String> d() {
        return this.f39783a;
    }

    public final List<String> e() {
        return this.f39784b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39783a = aVar.b("content");
        this.f39784b = aVar.b("error_msg");
    }
}
