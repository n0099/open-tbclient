package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f8611a;
    private com.yxcorp.kuaishou.addfp.a.a.a b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f8611a = context;
        this.b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d dVar;
        if (this.b != null) {
            com.yxcorp.kuaishou.addfp.a.a.a aVar = this.b;
            dVar = f.qmR;
            aVar.a(dVar.b(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d dVar;
        dVar = f.qmR;
        dVar.a(this.f8611a, this);
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
        dVar = f.qmR;
        if (dVar.b()) {
            dVar2 = f.qmR;
            String a2 = dVar2.a();
            return a2 == null ? "" : a2;
        }
        return "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        d dVar;
        dVar = f.qmR;
        return dVar.b();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d dVar;
        dVar = f.qmR;
        dVar.a(this.f8611a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.b.a(false, this);
        }
    }
}
