package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class en implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f298a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f299a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f298a = context;
        this.f299a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f298a, this.f299a, this.a, this.b);
    }
}
