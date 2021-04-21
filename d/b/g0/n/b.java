package d.b.g0.n;

import android.content.Context;
import android.content.Intent;
import d.b.g0.m.c;
import d.b.g0.n.a;
/* loaded from: classes2.dex */
public final class b implements d.b.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public a f43731a;

    @Override // d.b.g0.m.b
    public final String a() {
        return this.f43731a.a();
    }

    @Override // d.b.g0.m.b
    public final void a(Context context, c cVar) {
        a aVar = new a(context, cVar);
        this.f43731a = aVar;
        aVar.f43728c = new a.ServiceConnectionC0618a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        aVar.f43726a.bindService(intent, aVar.f43728c, 1);
    }
}
