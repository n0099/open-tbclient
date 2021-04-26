package com.sdk.mobile.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ String f36562a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f36563b;

    public c(a aVar, String str) {
        this.f36563b = aVar;
        this.f36562a = str;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        this.f36563b.a(i2, i3, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        String str3;
        Context context;
        if (i2 == 0 && com.sdk.base.framework.a.a.c.a(this.f36562a).booleanValue()) {
            context = this.f36563b.f36556d;
            String a2 = com.sdk.base.framework.f.k.a.a(context, String.valueOf(t));
            if (a2 == null) {
                this.f36563b.a(1, "SDK解密异常", 302001, a2, str2);
                return;
            }
            str3 = a2;
        } else {
            str3 = t;
        }
        this.f36563b.a(i2, str, i3, str3, str2);
    }
}
