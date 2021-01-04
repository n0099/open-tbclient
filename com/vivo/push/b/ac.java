package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13867a;

    public ac(String str) {
        super(2008);
        this.f13867a = str;
    }

    public ac() {
        super(2008);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f13867a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13867a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }
}
