package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class a implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.a.a f38181a;

    /* renamed from: f  reason: collision with root package name */
    public d.q.a.a.a.b.a.a f38186f;

    /* renamed from: b  reason: collision with root package name */
    public String f38182b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f38183c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f38184d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f38185e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f38187g = false;

    public a(Context context, d.q.a.a.a.a.a aVar) {
        this.f38181a = aVar;
        this.f38186f = new d.q.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            String b2 = bVar.b();
            this.f38182b = b2;
            if (b2 == null) {
                this.f38182b = "";
            }
        } catch (Throwable unused) {
        }
        try {
            String c2 = bVar.c();
            this.f38183c = c2;
            if (c2 == null) {
                this.f38183c = "";
            }
        } catch (Throwable unused2) {
        }
        try {
            String d2 = bVar.d();
            this.f38184d = d2;
            if (d2 == null) {
                this.f38184d = "";
            }
        } catch (Throwable unused3) {
        }
        try {
            String e2 = bVar.e();
            this.f38185e = e2;
            if (e2 == null) {
                this.f38185e = "";
            }
        } catch (Throwable unused4) {
        }
        try {
            this.f38187g = bVar.a();
        } catch (Throwable unused5) {
        }
        d.q.a.a.a.b.a.a aVar = this.f38186f;
        if (aVar != null) {
            aVar.b();
        }
        d.q.a.a.a.a.a aVar2 = this.f38181a;
        if (aVar2 != null) {
            aVar2.a(this.f38187g, this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        this.f38186f.c(this);
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
        return this.f38183c;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f38187g;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.a.a aVar = this.f38186f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f38181a;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
