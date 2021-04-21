package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.a.a.a.b.d.a f41478a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.a.a.a.a.a f41479b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41480c;

    /* renamed from: d  reason: collision with root package name */
    public String f41481d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41482e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41483f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41484g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f41485h = false;

    public d(Context context, d.r.a.a.a.a.a aVar) {
        this.f41479b = aVar;
        this.f41480c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.r.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f41485h = c2;
            if (c2) {
                String b2 = this.f41478a.b();
                this.f41481d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f41481d = "";
                }
                String h2 = this.f41478a.h();
                this.f41484g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f41484g = "";
                }
                String g2 = this.f41478a.g();
                this.f41483f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f41483f = "";
                }
                String e2 = this.f41478a.e();
                this.f41482e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f41482e = "";
                }
                if (!TextUtils.isEmpty(this.f41481d)) {
                    this.f41479b.a(true, this);
                }
                aVar = this.f41479b;
            } else {
                aVar = this.f41479b;
            }
            aVar.a(false, null);
        } catch (Throwable th) {
            try {
                d.r.a.a.c.b.b.c(th);
            } finally {
                d();
            }
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        this.f41478a = new d.r.a.a.a.b.d.a(this.f41480c, this);
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
        return this.f41481d;
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        d.r.a.a.a.b.d.a aVar = this.f41478a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.d.a aVar = this.f41478a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.r.a.a.a.a.a aVar = this.f41479b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
