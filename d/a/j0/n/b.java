package d.a.j0.n;

import android.content.Context;
import android.content.Intent;
import d.a.j0.m.c;
import d.a.j0.n.a;
/* loaded from: classes2.dex */
public final class b implements d.a.j0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f40494a;

    @Override // d.a.j0.m.b
    public final String a() {
        return this.f40494a.a();
    }

    @Override // d.a.j0.m.b
    public final void a(Context context, c cVar) {
        a aVar = new a(context, cVar);
        this.f40494a = aVar;
        aVar.f40491c = new a.ServiceConnectionC0557a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f40489a.bindService(intent, aVar.f40491c, 1);
    }
}
