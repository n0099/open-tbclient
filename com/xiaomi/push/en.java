package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class en implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f304a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f305a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f304a = context;
        this.f305a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f304a, this.f305a, this.a, this.b);
    }
}
