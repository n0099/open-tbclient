package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class d implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private e f14647a;

    /* renamed from: b  reason: collision with root package name */
    private com.yxcorp.kuaishou.addfp.a.a.a f14648b;
    private Context c;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private boolean h = false;

    public d(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14648b = aVar;
        this.c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            this.h = c();
            if (this.h) {
                this.d = this.f14647a.a();
                if (TextUtils.isEmpty(this.d)) {
                    this.d = "";
                }
                this.g = this.f14647a.e();
                if (TextUtils.isEmpty(this.g)) {
                    this.g = "";
                }
                this.f = this.f14647a.d();
                if (TextUtils.isEmpty(this.f)) {
                    this.f = "";
                }
                this.e = this.f14647a.b();
                if (TextUtils.isEmpty(this.e)) {
                    this.e = "";
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.f14648b.a(false, null);
                } else {
                    this.f14648b.a(true, this);
                }
            } else {
                this.f14648b.a(false, null);
            }
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            } finally {
                d();
            }
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14647a = new e(this.c, this);
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
        return this.d;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        if (this.f14647a != null) {
            return this.f14647a.c();
        }
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        if (this.f14647a != null) {
            this.f14647a.f();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f14648b != null) {
            this.f14648b.a(false, this);
        }
    }
}
