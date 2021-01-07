package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f14494a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f874a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14495b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, String str2, String str3) {
        this.f14494a = pVar;
        this.f874a = str;
        this.f14495b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f14494a.f867a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f874a, 4).edit();
        edit.putString(this.f14495b, this.c);
        edit.commit();
    }
}
