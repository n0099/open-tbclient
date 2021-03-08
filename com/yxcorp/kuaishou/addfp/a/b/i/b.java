package com.yxcorp.kuaishou.addfp.a.b.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class b implements com.yxcorp.kuaishou.addfp.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f8617a;

    public b(Context context) {
        this.f8617a = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean a() {
        return true;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        String a2 = a.a(this.f8617a);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return a.a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
    }
}
