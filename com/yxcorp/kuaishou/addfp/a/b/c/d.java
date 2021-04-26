package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f39024a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f39025b;

    /* renamed from: c  reason: collision with root package name */
    public Context f39026c;

    /* renamed from: d  reason: collision with root package name */
    public String f39027d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39028e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39029f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f39030g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f39031h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f39025b = aVar;
        this.f39026c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f39031h = c2;
            if (c2) {
                String b2 = this.f39024a.b();
                this.f39027d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f39027d = "";
                }
                String h2 = this.f39024a.h();
                this.f39030g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f39030g = "";
                }
                String g2 = this.f39024a.g();
                this.f39029f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f39029f = "";
                }
                String e2 = this.f39024a.e();
                this.f39028e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f39028e = "";
                }
                if (!TextUtils.isEmpty(this.f39027d)) {
                    this.f39025b.a(true, this);
                }
                aVar = this.f39025b;
            } else {
                aVar = this.f39025b;
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
        this.f39024a = new d.q.a.a.a.b.d.a(this.f39026c, this);
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
        return this.f39027d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f39024a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f39024a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f39025b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
