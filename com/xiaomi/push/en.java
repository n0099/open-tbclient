package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4887a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f296a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f297a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f296a = context;
        this.f297a = str;
        this.f4887a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f296a, this.f297a, this.f4887a, this.b);
    }
}
