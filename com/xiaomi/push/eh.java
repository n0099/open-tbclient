package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class eh implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f315a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f316a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(Context context, String str, int i, String str2) {
        this.f315a = context;
        this.f316a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        eg.c(this.f315a, this.f316a, this.a, this.b);
    }
}
