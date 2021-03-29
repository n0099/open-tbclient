package d.b.f0.n;

import android.content.Context;
import android.content.Intent;
import d.b.f0.m.c;
import d.b.f0.n.a;
/* loaded from: classes2.dex */
public final class b implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f43042a;

    @Override // d.b.f0.m.b
    public final String a() {
        return this.f43042a.a();
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, c cVar) {
        a aVar = new a(context, cVar);
        this.f43042a = aVar;
        aVar.f43039c = new a.ServiceConnectionC0587a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f43037a.bindService(intent, aVar.f43039c, 1);
    }
}
