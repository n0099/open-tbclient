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
    public Context f41374a;

    /* renamed from: b  reason: collision with root package name */
    public String f41375b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41376c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41377d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f41378e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f41379f;

    /* renamed from: g  reason: collision with root package name */
    public d.q.a.a.a.b.c.a f41380g;

    public c(Context context, a aVar) {
        this.f41374a = context;
        this.f41379f = aVar;
        this.f41380g = new d.q.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            String a2 = ((d) iInterface).a();
            this.f41375b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (this.f41379f != null) {
                    this.f41379f.a(false, null);
                    return;
                }
                return;
            }
            this.f41378e = true;
            if (this.f41379f != null) {
                this.f41379f.a(true, this);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(a aVar) {
        this.f41380g.d(this);
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
        return this.f41375b;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f41378e;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.c.a aVar = this.f41380g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f41379f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
