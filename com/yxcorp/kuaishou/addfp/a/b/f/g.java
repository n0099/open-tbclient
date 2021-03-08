package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public final class g implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f8609a;
    private com.yxcorp.kuaishou.addfp.a.a.a b;

    public g(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f8609a = context;
        this.b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d dVar;
        if (this.b != null) {
            com.yxcorp.kuaishou.addfp.a.a.a aVar = this.b;
            dVar = f.qmP;
            aVar.a(dVar.a(), this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        d dVar;
        dVar = f.qmP;
        dVar.a(this.f8609a, this);
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
            dVar = f.qmP;
            str = dVar.a(this.f8609a, "OUID");
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
        dVar = f.qmP;
        return dVar.a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        d dVar;
        dVar = f.qmP;
        dVar.a(this.f8609a);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.b != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("failed here");
            this.b.a(false, this);
        }
    }
}
