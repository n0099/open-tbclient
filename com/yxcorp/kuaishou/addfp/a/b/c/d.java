package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f41877a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f41878b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41879c;

    /* renamed from: d  reason: collision with root package name */
    public String f41880d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41881e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41882f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41883g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f41884h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f41878b = aVar;
        this.f41879c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f41884h = c2;
            if (c2) {
                String b2 = this.f41877a.b();
                this.f41880d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f41880d = "";
                }
                String h2 = this.f41877a.h();
                this.f41883g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f41883g = "";
                }
                String g2 = this.f41877a.g();
                this.f41882f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f41882f = "";
                }
                String e2 = this.f41877a.e();
                this.f41881e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f41881e = "";
                }
                if (!TextUtils.isEmpty(this.f41880d)) {
                    this.f41878b.a(true, this);
                }
                aVar = this.f41878b;
            } else {
                aVar = this.f41878b;
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
        this.f41877a = new d.q.a.a.a.b.d.a(this.f41879c, this);
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
        return this.f41880d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f41877a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f41877a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f41878b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
