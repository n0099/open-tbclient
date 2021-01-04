package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes5.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14677a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14678b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14677a = context;
        this.f14678b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        if (this.f14678b != null) {
            this.f14678b.a(d.eKu().c(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d.eKu().a(this.f14677a, this);
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
        String a2;
        return (d.eKu().c() && (a2 = d.eKu().a()) != null) ? a2 : "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return d.eKu().c();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d.eKu().a(this.f14677a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14678b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.f14678b.a(false, this);
        }
    }
}
