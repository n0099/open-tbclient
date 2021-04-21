package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41493a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.a.a.a.a.a f41494b;

    public g(Context context, d.r.a.a.a.a.a aVar) {
        this.f41493a = context;
        this.f41494b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.r.a.a.a.a.a aVar = this.f41494b;
        if (aVar != null) {
            aVar.a(d.r.a.a.a.b.k.a.f().h(), this);
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        d.r.a.a.a.b.k.a.f().d(this.f41493a, this);
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
        String a2;
        return (d.r.a.a.a.b.k.a.f().h() && (a2 = d.r.a.a.a.b.k.a.f().a()) != null) ? a2 : "";
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        return d.r.a.a.a.b.k.a.f().h();
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.k.a.f().c(this.f41493a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f41494b != null) {
            d.r.a.a.c.b.b.e("failed here");
            this.f41494b.a(false, this);
        }
    }
}
