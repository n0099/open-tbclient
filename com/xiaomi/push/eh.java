package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class eh implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f312a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f313a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(Context context, String str, int i, String str2) {
        this.f312a = context;
        this.f313a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        eg.c(this.f312a, this.f313a, this.a, this.b);
    }
}
