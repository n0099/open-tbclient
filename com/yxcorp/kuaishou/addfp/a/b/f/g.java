package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes5.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14659a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14660b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14659a = context;
        this.f14660b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d dVar;
        if (this.f14660b != null) {
            com.yxcorp.kuaishou.addfp.a.a.a aVar = this.f14660b;
            dVar = f.qeB;
            aVar.a(dVar.a(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d dVar;
        dVar = f.qeB;
        dVar.a(this.f14659a, this);
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
        String str = "";
        try {
            dVar = f.qeB;
            str = dVar.a(this.f14659a, "OUID");
            if (str != null) {
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return str;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        d dVar;
        dVar = f.qeB;
        return dVar.a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d dVar;
        dVar = f.qeB;
        dVar.a(this.f14659a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14660b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.f14660b.a(false, this);
        }
    }
}
