package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class a implements d.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.a.a.a.a.a f41461a;

    /* renamed from: f  reason: collision with root package name */
    public d.r.a.a.a.b.a.a f41466f;

    /* renamed from: b  reason: collision with root package name */
    public String f41462b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41463c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41464d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41465e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f41467g = false;

    public a(Context context, d.r.a.a.a.a.a aVar) {
        this.f41461a = aVar;
        this.f41466f = new d.r.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            String b2 = bVar.b();
            this.f41462b = b2;
            if (b2 == null) {
                this.f41462b = "";
            }
        } catch (Throwable unused) {
        }
        try {
            String c2 = bVar.c();
            this.f41463c = c2;
            if (c2 == null) {
                this.f41463c = "";
            }
        } catch (Throwable unused2) {
        }
        try {
            String d2 = bVar.d();
            this.f41464d = d2;
            if (d2 == null) {
                this.f41464d = "";
            }
        } catch (Throwable unused3) {
        }
        try {
            String e2 = bVar.e();
            this.f41465e = e2;
            if (e2 == null) {
                this.f41465e = "";
            }
        } catch (Throwable unused4) {
        }
        try {
            this.f41467g = bVar.a();
        } catch (Throwable unused5) {
        }
        d.r.a.a.a.b.a.a aVar = this.f41466f;
        if (aVar != null) {
            aVar.b();
        }
        d.r.a.a.a.a.a aVar2 = this.f41461a;
        if (aVar2 != null) {
            aVar2.a(this.f41467g, this);
        }
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        this.f41466f.c(this);
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
        return this.f41463c;
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        return this.f41467g;
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
        d.r.a.a.a.b.a.a aVar = this.f41466f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.r.a.a.a.a.a aVar = this.f41461a;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
