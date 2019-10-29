package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class j extends s {
    private String a;
    private String b;
    private String c;

    public j(int i) {
        super(i);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.a);
        aVar.a("client_id", this.b);
        aVar.a("client_token", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a(Constants.APP_ID);
        this.b = aVar.a("client_id");
        this.c = aVar.a("client_token");
    }

    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }
}
