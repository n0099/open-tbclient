package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f4788a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f795a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, String str2, String str3) {
        this.f4788a = pVar;
        this.f795a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f4788a.f788a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f795a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
