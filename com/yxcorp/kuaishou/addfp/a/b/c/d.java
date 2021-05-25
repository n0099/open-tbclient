package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class d implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.b.d.a f38198a;

    /* renamed from: b  reason: collision with root package name */
    public d.q.a.a.a.a.a f38199b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38200c;

    /* renamed from: d  reason: collision with root package name */
    public String f38201d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f38202e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f38203f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f38204g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f38205h = false;

    public d(Context context, d.q.a.a.a.a.a aVar) {
        this.f38199b = aVar;
        this.f38200c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.q.a.a.a.a.a aVar;
        try {
            boolean c2 = c();
            this.f38205h = c2;
            if (c2) {
                String b2 = this.f38198a.b();
                this.f38201d = b2;
                if (TextUtils.isEmpty(b2)) {
                    this.f38201d = "";
                }
                String h2 = this.f38198a.h();
                this.f38204g = h2;
                if (TextUtils.isEmpty(h2)) {
                    this.f38204g = "";
                }
                String g2 = this.f38198a.g();
                this.f38203f = g2;
                if (TextUtils.isEmpty(g2)) {
                    this.f38203f = "";
                }
                String e2 = this.f38198a.e();
                this.f38202e = e2;
                if (TextUtils.isEmpty(e2)) {
                    this.f38202e = "";
                }
                if (!TextUtils.isEmpty(this.f38201d)) {
                    this.f38199b.a(true, this);
                }
                aVar = this.f38199b;
            } else {
                aVar = this.f38199b;
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
        this.f38198a = new d.q.a.a.a.b.d.a(this.f38200c, this);
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
        return this.f38201d;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        d.q.a.a.a.b.d.a aVar = this.f38198a;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.d.a aVar = this.f38198a;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f38199b;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
