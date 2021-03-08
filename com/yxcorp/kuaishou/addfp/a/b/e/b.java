package com.yxcorp.kuaishou.addfp.a.b.e;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class b implements com.yxcorp.kuaishou.addfp.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private String f8607a = "";
    private Context b;

    public b(Context context) {
        this.b = context;
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
        String b = a.iX(this.b).b();
        return TextUtils.isEmpty(b) ? "" : b;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return a.iX(this.b).a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
    }
}
