package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40309a;

    public ac(String str) {
        super(2008);
        this.f40309a = str;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f40309a);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40309a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }

    public ac() {
        super(2008);
    }
}
