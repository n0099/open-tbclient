package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f39033a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f39034b;

    public g(Context context, d.q.a.a.a.a.a aVar) {
        this.f39033a = context;
        this.f39034b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.b.g.a aVar;
        d.q.a.a.a.a.a aVar2 = this.f39034b;
        if (aVar2 != null) {
            aVar = d.q.a.a.a.b.g.c.f66848a;
            aVar2.a(aVar.f(), this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        d.q.a.a.a.b.g.a aVar2;
        aVar2 = d.q.a.a.a.b.g.c.f66848a;
        aVar2.d(this.f39033a, this);
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
        d.q.a.a.a.b.g.a aVar;
        try {
            aVar = d.q.a.a.a.b.g.c.f66848a;
            String a2 = aVar.a(this.f39033a, "OUID");
            return a2 != null ? a2 : a2;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.g.a aVar;
        aVar = d.q.a.a.a.b.g.c.f66848a;
        return aVar.f();
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.g.a aVar;
        aVar = d.q.a.a.a.b.g.c.f66848a;
        aVar.c(this.f39033a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f39034b != null) {
            d.q.a.a.c.b.b.e("failed here");
            this.f39034b.a(false, this);
        }
    }
}
