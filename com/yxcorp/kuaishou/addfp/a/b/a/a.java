package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes7.dex */
public final class a implements d.q.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public d.q.a.a.a.a.a f39007a;

    /* renamed from: f  reason: collision with root package name */
    public d.q.a.a.a.b.a.a f39012f;

    /* renamed from: b  reason: collision with root package name */
    public String f39008b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f39009c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39010d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39011e = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f39013g = false;

    public a(Context context, d.q.a.a.a.a.a aVar) {
        this.f39007a = aVar;
        this.f39012f = new d.q.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            String b2 = bVar.b();
            this.f39008b = b2;
            if (b2 == null) {
                this.f39008b = "";
            }
        } catch (Throwable unused) {
        }
        try {
            String c2 = bVar.c();
            this.f39009c = c2;
            if (c2 == null) {
                this.f39009c = "";
            }
        } catch (Throwable unused2) {
        }
        try {
            String d2 = bVar.d();
            this.f39010d = d2;
            if (d2 == null) {
                this.f39010d = "";
            }
        } catch (Throwable unused3) {
        }
        try {
            String e2 = bVar.e();
            this.f39011e = e2;
            if (e2 == null) {
                this.f39011e = "";
            }
        } catch (Throwable unused4) {
        }
        try {
            this.f39013g = bVar.a();
        } catch (Throwable unused5) {
        }
        d.q.a.a.a.b.a.a aVar = this.f39012f;
        if (aVar != null) {
            aVar.b();
        }
        d.q.a.a.a.a.a aVar2 = this.f39007a;
        if (aVar2 != null) {
            aVar2.a(this.f39013g, this);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        this.f39012f.c(this);
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
        return this.f39009c;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f39013g;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.a.a aVar = this.f39012f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.q.a.a.a.a.a aVar = this.f39007a;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
