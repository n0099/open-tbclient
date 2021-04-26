package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f39036a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f39037b;

    public g(Context context, d.q.a.a.a.a.a aVar) {
        this.f39036a = context;
        this.f39037b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.b.h.a aVar;
        d.q.a.a.a.a.a aVar2 = this.f39037b;
        if (aVar2 != null) {
            aVar = d.q.a.a.a.b.h.c.f66855a;
            aVar2.a(aVar.f(), this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        d.q.a.a.a.b.h.a aVar2;
        aVar2 = d.q.a.a.a.b.h.c.f66855a;
        aVar2.d(this.f39036a, this);
    }

    @Override // d.q.a.a.a.b.b
    public final boolean a() {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    @Override // d.q.a.a.a.b.b
    public final String b() {
        d.q.a.a.a.b.h.a aVar;
        d.q.a.a.a.b.h.a aVar2;
        aVar = d.q.a.a.a.b.h.c.f66855a;
        if (aVar.f()) {
            aVar2 = d.q.a.a.a.b.h.c.f66855a;
            String a2 = aVar2.a();
            return a2 == null ? "" : a2;
        }
        return "";
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.h.a aVar;
        aVar = d.q.a.a.a.b.h.c.f66855a;
        return aVar.f();
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.h.a aVar;
        aVar = d.q.a.a.a.b.h.c.f66855a;
        aVar.c(this.f39036a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f39037b != null) {
            d.q.a.a.c.b.b.e("failed here");
            this.f39037b.a(false, this);
        }
    }
}
