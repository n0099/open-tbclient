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
    public Context f41084a;

    /* renamed from: b  reason: collision with root package name */
    public String f41085b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41086c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41087d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f41088e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f41089f;

    /* renamed from: g  reason: collision with root package name */
    public d.q.a.a.a.b.c.a f41090g;

    public c(Context context, a aVar) {
        this.f41084a = context;
        this.f41089f = aVar;
        this.f41090g = new d.q.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            String a2 = ((d) iInterface).a();
            this.f41085b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (this.f41089f != null) {
                    this.f41089f.a(false, null);
                    return;
                }
                return;
            }
            this.f41088e = true;
            if (this.f41089f != null) {
                this.f41089f.a(true, this);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(a aVar) {
        this.f41090g.d(this);
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
        return this.f41085b;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f41088e;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.c.a aVar = this.f41090g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f41089f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
