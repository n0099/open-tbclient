package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;
import d.q.a.a.a.a.a;
import d.q.a.a.a.b.b;
/* loaded from: classes7.dex */
public final class c implements b, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f38260a;

    /* renamed from: b  reason: collision with root package name */
    public String f38261b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f38262c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f38263d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f38264e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f38265f;

    /* renamed from: g  reason: collision with root package name */
    public d.q.a.a.a.b.c.a f38266g;

    public c(Context context, a aVar) {
        this.f38260a = context;
        this.f38265f = aVar;
        this.f38266g = new d.q.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            d dVar = (d) iInterface;
            String a2 = dVar.a();
            if (TextUtils.isEmpty(a2) || !a2.equals(this.f38261b)) {
                String a3 = dVar.a();
                this.f38261b = a3;
                if (TextUtils.isEmpty(a3)) {
                    if (this.f38265f != null) {
                        this.f38265f.a(false, null);
                        return;
                    }
                    return;
                }
                this.f38264e = true;
                if (this.f38265f != null) {
                    this.f38265f.a(true, this);
                }
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.f38260a.getContentResolver(), "pps_oaid");
                Settings.Global.getString(this.f38260a.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    this.f38261b = string;
                    this.f38264e = true;
                    if (this.f38265f != null) {
                        this.f38265f.a(true, this);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        this.f38266g.d(this);
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
        return this.f38261b;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f38264e;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.c.a aVar = this.f38266g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f38265f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
