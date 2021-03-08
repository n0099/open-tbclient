package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f8481a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f794a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, String str2, String str3) {
        this.f8481a = pVar;
        this.f794a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f8481a.f787a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f794a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
