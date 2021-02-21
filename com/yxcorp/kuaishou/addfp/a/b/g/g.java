package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14366a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14367b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14366a = context;
        this.f14367b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d dVar;
        if (this.f14367b != null) {
            com.yxcorp.kuaishou.addfp.a.a.a aVar = this.f14367b;
            dVar = f.qmp;
            aVar.a(dVar.b(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d dVar;
        dVar = f.qmp;
        dVar.a(this.f14366a, this);
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
        dVar = f.qmp;
        if (dVar.b()) {
            dVar2 = f.qmp;
            String a2 = dVar2.a();
            return a2 == null ? "" : a2;
        }
        return "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        d dVar;
        dVar = f.qmp;
        return dVar.b();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d dVar;
        dVar = f.qmp;
        dVar.a(this.f14366a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14367b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.f14367b.a(false, this);
        }
    }
}
