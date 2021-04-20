package com.sdk.mobile.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ String f38882a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f38883b;

    public c(a aVar, String str) {
        this.f38883b = aVar;
        this.f38882a = str;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.f38883b.a(i, i2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        String str3;
        Context context;
        if (i == 0 && com.sdk.base.framework.a.a.c.a(this.f38882a).booleanValue()) {
            context = this.f38883b.f38876d;
            String a2 = com.sdk.base.framework.f.k.a.a(context, String.valueOf(t));
            if (a2 == null) {
                this.f38883b.a(1, "SDK解密异常", 302001, a2, str2);
                return;
            }
            str3 = a2;
        } else {
            str3 = t;
        }
        this.f38883b.a(i, str, i2, str3, str2);
    }
}
