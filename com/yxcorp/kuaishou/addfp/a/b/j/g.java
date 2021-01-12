package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes4.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14378a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14379b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14378a = context;
        this.f14379b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        if (this.f14379b != null) {
            this.f14379b.a(d.eHi().c(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d.eHi().a(this.f14378a, this);
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
        return (d.eHi().c() && (a2 = d.eHi().a()) != null) ? a2 : "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return d.eHi().c();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d.eHi().a(this.f14378a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14379b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.f14379b.a(false, this);
        }
    }
}
