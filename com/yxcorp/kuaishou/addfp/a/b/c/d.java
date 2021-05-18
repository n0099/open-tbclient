package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f38269a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f38270b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38271c;

    /* renamed from: d  reason: collision with root package name */
    public String f38272d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f38273e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f38274f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f38275g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f38276h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f38270b = aVar;
        this.f38271c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f38276h = c2;
            if (c2) {
                String b2 = this.f38269a.b();
                this.f38272d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f38272d = "";
                }
                String h2 = this.f38269a.h();
                this.f38275g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f38275g = "";
                }
                String g2 = this.f38269a.g();
                this.f38274f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f38274f = "";
                }
                String e2 = this.f38269a.e();
                this.f38273e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f38273e = "";
                }
                if (!TextUtils.isEmpty(this.f38272d)) {
                    this.f38270b.a(true, this);
                }
                aVar = this.f38270b;
            } else {
                aVar = this.f38270b;
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
        this.f38269a = new d.q.a.a.a.b.d.a(this.f38271c, this);
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
        return this.f38272d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f38269a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f38269a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f38270b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
