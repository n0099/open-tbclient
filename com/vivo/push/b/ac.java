package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f4633a;

    public ac(String str) {
        super(2008);
        this.f4633a = str;
    }

    public ac() {
        super(2008);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f4633a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f4633a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }
}
