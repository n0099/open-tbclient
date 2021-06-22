package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class a implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.a.a f41963a;

    /* renamed from: f  reason: collision with root package name */
    public d.q.a.a.a.b.a.a f41968f;

    /* renamed from: b  reason: collision with root package name */
    public String f41964b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41965c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41966d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41967e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f41969g = false;

    public a(Context context, d.q.a.a.a.a.a aVar) {
        this.f41963a = aVar;
        this.f41968f = new d.q.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            String b2 = bVar.b();
            this.f41964b = b2;
            if (b2 == null) {
                this.f41964b = "";
            }
        } catch (Throwable unused) {
        }
        try {
            String c2 = bVar.c();
            this.f41965c = c2;
            if (c2 == null) {
                this.f41965c = "";
            }
        } catch (Throwable unused2) {
        }
        try {
            String d2 = bVar.d();
            this.f41966d = d2;
            if (d2 == null) {
                this.f41966d = "";
            }
        } catch (Throwable unused3) {
        }
        try {
            String e2 = bVar.e();
            this.f41967e = e2;
            if (e2 == null) {
                this.f41967e = "";
            }
        } catch (Throwable unused4) {
        }
        try {
            this.f41969g = bVar.a();
        } catch (Throwable unused5) {
        }
        d.q.a.a.a.b.a.a aVar = this.f41968f;
        if (aVar != null) {
            aVar.b();
        }
        d.q.a.a.a.a.a aVar2 = this.f41963a;
        if (aVar2 != null) {
            aVar2.a(this.f41969g, this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        this.f41968f.c(this);
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
        return this.f41965c;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f41969g;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.a.a aVar = this.f41968f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f41963a;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
