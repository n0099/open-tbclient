package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import d.q.a.a.a.a.a;
import d.q.a.a.a.b.b;
/* loaded from: classes7.dex */
public final class c implements b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41085a;

    /* renamed from: b  reason: collision with root package name */
    public String f41086b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41087c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41088d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f41089e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f41090f;

    /* renamed from: g  reason: collision with root package name */
    public d.q.a.a.a.b.c.a f41091g;

    public c(Context context, a aVar) {
        this.f41085a = context;
        this.f41090f = aVar;
        this.f41091g = new d.q.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            String a2 = ((d) iInterface).a();
            this.f41086b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (this.f41090f != null) {
                    this.f41090f.a(false, null);
                    return;
                }
                return;
            }
            this.f41089e = true;
            if (this.f41090f != null) {
                this.f41090f.a(true, this);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(a aVar) {
        this.f41091g.d(this);
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
        return this.f41086b;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f41089e;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.c.a aVar = this.f41091g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f41090f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
