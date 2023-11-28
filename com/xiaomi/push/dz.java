package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes10.dex */
public final class dz implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f298a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f299a;
    public final /* synthetic */ String b;

    public dz(Context context, String str, int i, String str2) {
        this.f298a = context;
        this.f299a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dy.c(this.f298a, this.f299a, this.a, this.b);
    }
}
