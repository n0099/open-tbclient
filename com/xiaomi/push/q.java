package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f14493a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f873a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14494b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, String str2, String str3) {
        this.f14493a = pVar;
        this.f873a = str;
        this.f14494b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f14493a.f866a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f873a, 4).edit();
        edit.putString(this.f14494b, this.c);
        edit.commit();
    }
}
