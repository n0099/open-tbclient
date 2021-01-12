package com.xiaomi.push;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13992a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f377a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f378a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13993b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(Context context, String str, int i, String str2) {
        this.f377a = context;
        this.f378a = str;
        this.f13992a = i;
        this.f13993b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        em.c(this.f377a, this.f378a, this.f13992a, this.f13993b);
    }
}
