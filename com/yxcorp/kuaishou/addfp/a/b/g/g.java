package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes5.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14663a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14664b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14663a = context;
        this.f14664b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d dVar;
        if (this.f14664b != null) {
            com.yxcorp.kuaishou.addfp.a.a.a aVar = this.f14664b;
            dVar = f.qeD;
            aVar.a(dVar.b(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d dVar;
        dVar = f.qeD;
        dVar.a(this.f14663a, this);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean a() {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        d dVar;
        d dVar2;
        dVar = f.qeD;
        if (dVar.b()) {
            dVar2 = f.qeD;
            String a2 = dVar2.a();
            return a2 == null ? "" : a2;
        }
        return "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        d dVar;
        dVar = f.qeD;
        return dVar.b();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d dVar;
        dVar = f.qeD;
        dVar.a(this.f14663a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14664b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.f14664b.a(false, this);
        }
    }
}
