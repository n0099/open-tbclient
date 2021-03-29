package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f41094a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f41095b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41096c;

    /* renamed from: d  reason: collision with root package name */
    public String f41097d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41098e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41099f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41100g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f41101h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f41095b = aVar;
        this.f41096c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f41101h = c2;
            if (c2) {
                String b2 = this.f41094a.b();
                this.f41097d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f41097d = "";
                }
                String h2 = this.f41094a.h();
                this.f41100g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f41100g = "";
                }
                String g2 = this.f41094a.g();
                this.f41099f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f41099f = "";
                }
                String e2 = this.f41094a.e();
                this.f41098e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f41098e = "";
                }
                if (!TextUtils.isEmpty(this.f41097d)) {
                    this.f41095b.a(true, this);
                }
                aVar = this.f41095b;
            } else {
                aVar = this.f41095b;
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
        this.f41094a = new d.q.a.a.a.b.d.a(this.f41096c, this);
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
        return this.f41097d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f41094a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f41094a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f41095b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
