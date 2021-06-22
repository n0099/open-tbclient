package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class g implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41995a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f41996b;

    public g(Context context, d.q.a.a.a.a.a aVar) {
        this.f41995a = context;
        this.f41996b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar = this.f41996b;
        if (aVar != null) {
            aVar.a(d.q.a.a.a.b.k.a.f().h(), this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        d.q.a.a.a.b.k.a.f().d(this.f41995a, this);
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
        String a2;
        return (d.q.a.a.a.b.k.a.f().h() && (a2 = d.q.a.a.a.b.k.a.f().a()) != null) ? a2 : "";
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return d.q.a.a.a.b.k.a.f().h();
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.k.a.f().c(this.f41995a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f41996b != null) {
            d.q.a.a.c.b.b.e("failed here");
            this.f41996b.a(false, this);
        }
    }
}
