package d.a.g0.n;

import android.content.Context;
import android.content.Intent;
import d.a.g0.m.c;
import d.a.g0.n.a;
/* loaded from: classes2.dex */
public final class b implements d.a.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f40988a;

    @Override // d.a.g0.m.b
    public final String a() {
        return this.f40988a.a();
    }

    @Override // d.a.g0.m.b
    public final void a(Context context, c cVar) {
        a aVar = new a(context, cVar);
        this.f40988a = aVar;
        aVar.f40985c = new a.ServiceConnectionC0557a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f40983a.bindService(intent, aVar.f40985c, 1);
    }
}
