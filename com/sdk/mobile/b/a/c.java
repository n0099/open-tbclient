package com.sdk.mobile.b.a;

import android.content.Context;
/* loaded from: classes7.dex */
public final class c implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ String f35736a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f35737b;

    public c(a aVar, String str) {
        this.f35737b = aVar;
        this.f35736a = str;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        this.f35737b.a(i2, i3, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        String str3;
        Context context;
        if (i2 == 0 && com.sdk.base.framework.a.a.c.a(this.f35736a).booleanValue()) {
            context = this.f35737b.f35730d;
            String a2 = com.sdk.base.framework.f.k.a.a(context, String.valueOf(t));
            if (a2 == null) {
                this.f35737b.a(1, "SDK解密异常", 302001, a2, str2);
                return;
            }
            str3 = a2;
        } else {
            str3 = t;
        }
        this.f35737b.a(i2, str, i3, str3, str2);
    }
}
