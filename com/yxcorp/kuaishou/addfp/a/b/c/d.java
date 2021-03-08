package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class d implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private e f8601a;
    private com.yxcorp.kuaishou.addfp.a.a.a b;
    private Context c;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private boolean h = false;

    public d(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.b = aVar;
        this.c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            this.h = c();
            if (this.h) {
                this.d = this.f8601a.a();
                if (TextUtils.isEmpty(this.d)) {
                    this.d = "";
                }
                this.g = this.f8601a.e();
                if (TextUtils.isEmpty(this.g)) {
                    this.g = "";
                }
                this.f = this.f8601a.d();
                if (TextUtils.isEmpty(this.f)) {
                    this.f = "";
                }
                this.e = this.f8601a.b();
                if (TextUtils.isEmpty(this.e)) {
                    this.e = "";
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.b.a(false, null);
                } else {
                    this.b.a(true, this);
                }
            } else {
                this.b.a(false, null);
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
        this.f8601a = new e(this.c, this);
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
        if (this.f8601a != null) {
            return this.f8601a.c();
        }
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        if (this.f8601a != null) {
            this.f8601a.f();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.b != null) {
            this.b.a(false, this);
        }
    }
}
