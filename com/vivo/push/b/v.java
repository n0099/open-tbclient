package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class v extends u {
    private ArrayList<String> a;
    private ArrayList<String> b;

    public v(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("error_msg", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.b("content");
        this.b = aVar.b("error_msg");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
