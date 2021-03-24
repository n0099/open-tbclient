package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class a implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.a.a f41076a;

    /* renamed from: f  reason: collision with root package name */
    public d.q.a.a.a.b.a.a f41081f;

    /* renamed from: b  reason: collision with root package name */
    public String f41077b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41078c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41079d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41080e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f41082g = false;

    public a(Context context, d.q.a.a.a.a.a aVar) {
        this.f41076a = aVar;
        this.f41081f = new d.q.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            String b2 = bVar.b();
            this.f41077b = b2;
            if (b2 == null) {
                this.f41077b = "";
            }
        } catch (Throwable unused) {
        }
        try {
            String c2 = bVar.c();
            this.f41078c = c2;
            if (c2 == null) {
                this.f41078c = "";
            }
        } catch (Throwable unused2) {
        }
        try {
            String d2 = bVar.d();
            this.f41079d = d2;
            if (d2 == null) {
                this.f41079d = "";
            }
        } catch (Throwable unused3) {
        }
        try {
            String e2 = bVar.e();
            this.f41080e = e2;
            if (e2 == null) {
                this.f41080e = "";
            }
        } catch (Throwable unused4) {
        }
        try {
            this.f41082g = bVar.a();
        } catch (Throwable unused5) {
        }
        d.q.a.a.a.b.a.a aVar = this.f41081f;
        if (aVar != null) {
            aVar.b();
        }
        d.q.a.a.a.a.a aVar2 = this.f41076a;
        if (aVar2 != null) {
            aVar2.a(this.f41082g, this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        this.f41081f.c(this);
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
        return this.f41078c;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f41082g;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.a.a aVar = this.f41081f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f41076a;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
