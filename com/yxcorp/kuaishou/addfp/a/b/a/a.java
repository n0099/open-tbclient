package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public final class a implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f8596a;
    private e f;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private boolean g = false;

    public a(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f8596a = aVar;
        this.f = new e(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        b bVar = (b) iInterface;
        try {
            this.b = bVar.b();
            if (this.b == null) {
                this.b = "";
            }
        } catch (Throwable th) {
        }
        try {
            this.c = bVar.c();
            if (this.c == null) {
                this.c = "";
            }
        } catch (Throwable th2) {
        }
        try {
            this.d = bVar.d();
            if (this.d == null) {
                this.d = "";
            }
        } catch (Throwable th3) {
        }
        try {
            this.e = bVar.e();
            if (this.e == null) {
                this.e = "";
            }
        } catch (Throwable th4) {
        }
        try {
            this.g = bVar.a();
        } catch (Throwable th5) {
        }
        if (this.f != null) {
            this.f.a();
        }
        if (this.f8596a != null) {
            this.f8596a.a(this.g, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f.a(this);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean a() {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        return this.c;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return this.g;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f8596a != null) {
            this.f8596a.a(false, this);
        }
    }
}
