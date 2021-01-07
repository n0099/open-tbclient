package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f14292a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f378a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f379a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14293b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f378a = context;
        this.f379a = str;
        this.f14292a = i;
        this.f14293b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f378a, this.f379a, this.f14292a, this.f14293b);
    }
}
