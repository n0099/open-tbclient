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
    public Context f39015a;

    /* renamed from: b  reason: collision with root package name */
    public String f39016b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f39017c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39018d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f39019e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f39020f;

    /* renamed from: g  reason: collision with root package name */
    public d.q.a.a.a.b.c.a f39021g;

    public c(Context context, a aVar) {
        this.f39015a = context;
        this.f39020f = aVar;
        this.f39021g = new d.q.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            d dVar = (d) iInterface;
            String a2 = dVar.a();
            if (TextUtils.isEmpty(a2) || !a2.equals(this.f39016b)) {
                String a3 = dVar.a();
                this.f39016b = a3;
                if (TextUtils.isEmpty(a3)) {
                    if (this.f39020f != null) {
                        this.f39020f.a(false, null);
                        return;
                    }
                    return;
                }
                this.f39019e = true;
                if (this.f39020f != null) {
                    this.f39020f.a(true, this);
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
                String string = Settings.Global.getString(this.f39015a.getContentResolver(), "pps_oaid");
                Settings.Global.getString(this.f39015a.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    this.f39016b = string;
                    this.f39019e = true;
                    if (this.f39020f != null) {
                        this.f39020f.a(true, this);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        this.f39021g.d(this);
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
        return this.f39016b;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return this.f39019e;
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
        d.q.a.a.a.b.c.a aVar = this.f39021g;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar = this.f39020f;
        if (aVar != null) {
            aVar.a(false, this);
        }
    }
}
