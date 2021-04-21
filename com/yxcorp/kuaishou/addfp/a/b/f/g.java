package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41487a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.a.a.a.a.a f41488b;

    public g(Context context, d.r.a.a.a.a.a aVar) {
        this.f41487a = context;
        this.f41488b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.r.a.a.a.b.g.a aVar;
        d.r.a.a.a.a.a aVar2 = this.f41488b;
        if (aVar2 != null) {
            aVar = d.r.a.a.a.b.g.c.f68469a;
            aVar2.a(aVar.f(), this);
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        d.r.a.a.a.b.g.a aVar2;
        aVar2 = d.r.a.a.a.b.g.c.f68469a;
        aVar2.d(this.f41487a, this);
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
        d.r.a.a.a.b.g.a aVar;
        try {
            aVar = d.r.a.a.a.b.g.c.f68469a;
            String a2 = aVar.a(this.f41487a, "OUID");
            return a2 != null ? a2 : a2;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "";
        }
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        d.r.a.a.a.b.g.a aVar;
        aVar = d.r.a.a.a.b.g.c.f68469a;
        return aVar.f();
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.g.a aVar;
        aVar = d.r.a.a.a.b.g.c.f68469a;
        aVar.c(this.f41487a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f41488b != null) {
            d.r.a.a.c.b.b.e("failed here");
            this.f41488b.a(false, this);
        }
    }
}
