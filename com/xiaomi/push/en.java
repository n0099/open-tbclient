package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4659a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f299a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f300a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f299a = context;
        this.f300a = str;
        this.f4659a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f299a, this.f300a, this.f4659a, this.b);
    }
}
