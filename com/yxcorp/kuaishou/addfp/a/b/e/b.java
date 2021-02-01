package com.yxcorp.kuaishou.addfp.a.b.e;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class b implements com.yxcorp.kuaishou.addfp.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private String f14358a = "";

    /* renamed from: b  reason: collision with root package name */
    private Context f14359b;

    public b(Context context) {
        this.f14359b = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        if (aVar != null) {
            try {
                aVar.a(c(), this);
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean a() {
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        String b2 = a.jd(this.f14359b).b();
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return a.jd(this.f14359b).a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
    }
}
