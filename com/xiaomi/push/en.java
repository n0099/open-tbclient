package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class en implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f303a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f304a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f303a = context;
        this.f304a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f303a, this.f304a, this.a, this.b);
    }
}
