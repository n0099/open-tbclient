package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class c implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14344a;

    /* renamed from: b  reason: collision with root package name */
    private String f14345b = "";
    private String c = "";
    private String d = "";
    private boolean e = false;
    private com.yxcorp.kuaishou.addfp.a.a.a f;
    private a g;

    public c(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.f14344a = context;
        this.f = aVar;
        this.g = new a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        try {
            this.f14345b = ((d) iInterface).a();
            if (!TextUtils.isEmpty(this.f14345b)) {
                this.e = true;
                if (this.f != null) {
                    this.f.a(this.e, this);
                }
            } else if (this.f != null) {
                this.f.a(false, null);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        this.g.a(this);
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
        return this.f14345b;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return this.e;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        if (this.g != null) {
            this.g.a();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        if (this.f != null) {
            this.f.a(false, this);
        }
    }
}
