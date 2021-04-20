package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f41383a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f41384b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41385c;

    /* renamed from: d  reason: collision with root package name */
    public String f41386d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41387e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41388f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41389g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f41390h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f41384b = aVar;
        this.f41385c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f41390h = c2;
            if (c2) {
                String b2 = this.f41383a.b();
                this.f41386d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f41386d = "";
                }
                String h2 = this.f41383a.h();
                this.f41389g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f41389g = "";
                }
                String g2 = this.f41383a.g();
                this.f41388f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f41388f = "";
                }
                String e2 = this.f41383a.e();
                this.f41387e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f41387e = "";
                }
                if (!TextUtils.isEmpty(this.f41386d)) {
                    this.f41384b.a(true, this);
                }
                aVar = this.f41384b;
            } else {
                aVar = this.f41384b;
            }
            aVar.a(false, null);
        } catch (Throwable th) {
            try {
                d.q.a.a.c.b.b.c(th);
            } finally {
                d();
            }
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        this.f41383a = new d.q.a.a.a.b.d.a(this.f41385c, this);
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
        return this.f41386d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f41383a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f41383a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f41384b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
