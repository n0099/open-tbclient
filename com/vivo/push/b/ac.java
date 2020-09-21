package com.vivo.push.b;
/* loaded from: classes12.dex */
public final class ac extends com.vivo.push.y {
    private String a;

    public ac(String str) {
        super(2008);
        this.a = str;
    }

    public ac() {
        super(2008);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }
}
