package com.yxcorp.kuaishou.addfp.a.b.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.android.b.b;
import com.yxcorp.kuaishou.addfp.android.b.c;
/* loaded from: classes4.dex */
public final class a implements com.yxcorp.kuaishou.addfp.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private String f14366a = "";

    /* renamed from: b  reason: collision with root package name */
    private Context f14367b;

    public a(Context context) {
        this.f14367b = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                aVar.a(false, new c());
            }
            if (aVar != null) {
                aVar.a(c(), this);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public final void a(String str) {
        this.f14366a = str;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean a() {
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        String b2 = com.yxcorp.kuaishou.addfp.a.b.h.a.b.jb(this.f14367b).b();
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        return com.yxcorp.kuaishou.addfp.a.b.h.a.b.jb(this.f14367b).a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
    }
}
