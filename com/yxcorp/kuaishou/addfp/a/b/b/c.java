package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import d.r.a.a.a.a.a;
import d.r.a.a.a.b.b;
/* loaded from: classes7.dex */
public final class c implements b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f41469a;

    /* renamed from: b  reason: collision with root package name */
    public String f41470b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41471c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41472d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f41473e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f41474f;

    /* renamed from: g  reason: collision with root package name */
    public d.r.a.a.a.b.c.a f41475g;

    public c(Context context, a aVar) {
        this.f41469a = context;
        this.f41474f = aVar;
        this.f41475g = new d.r.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            String a2 = ((d) iInterface).a();
            this.f41470b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (this.f41474f != null) {
                    this.f41474f.a(false, null);
                    return;
                }
                return;
            }
            this.f41473e = true;
            if (this.f41474f != null) {
                this.f41474f.a(true, this);
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(a aVar) {
        this.f41475g.d(this);
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
        return this.f41470b;
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        return this.f41473e;
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.c.a aVar = this.f41475g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f41474f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
