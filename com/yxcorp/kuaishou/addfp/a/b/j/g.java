package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f8619a;
    private com.yxcorp.kuaishou.addfp.a.a.a b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f8619a = context;
        this.b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        if (this.b != null) {
            this.b.a(d.eJo().c(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d.eJo().a(this.f8619a, this);
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
        return (d.eJo().c() && (a2 = d.eJo().a()) != null) ? a2 : "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return d.eJo().c();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d.eJo().a(this.f8619a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.b.a(false, this);
        }
    }
}
