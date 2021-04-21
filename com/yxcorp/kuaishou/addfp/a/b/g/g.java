package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41490a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.a.a.a.a.a f41491b;

    public g(Context context, d.r.a.a.a.a.a aVar) {
        this.f41490a = context;
        this.f41491b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.r.a.a.a.b.h.a aVar;
        d.r.a.a.a.a.a aVar2 = this.f41491b;
        if (aVar2 != null) {
            aVar = d.r.a.a.a.b.h.c.f68476a;
            aVar2.a(aVar.f(), this);
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        d.r.a.a.a.b.h.a aVar2;
        aVar2 = d.r.a.a.a.b.h.c.f68476a;
        aVar2.d(this.f41490a, this);
    }

    @Override // d.r.a.a.a.b.b
    public final boolean a() {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    @Override // d.r.a.a.a.b.b
    public final String b() {
        d.r.a.a.a.b.h.a aVar;
        d.r.a.a.a.b.h.a aVar2;
        aVar = d.r.a.a.a.b.h.c.f68476a;
        if (aVar.f()) {
            aVar2 = d.r.a.a.a.b.h.c.f68476a;
            String a2 = aVar2.a();
            return a2 == null ? "" : a2;
        }
        return "";
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        d.r.a.a.a.b.h.a aVar;
        aVar = d.r.a.a.a.b.h.c.f68476a;
        return aVar.f();
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.h.a aVar;
        aVar = d.r.a.a.a.b.h.c.f68476a;
        aVar.c(this.f41490a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f41491b != null) {
            d.r.a.a.c.b.b.e("failed here");
            this.f41491b.a(false, this);
        }
    }
}
