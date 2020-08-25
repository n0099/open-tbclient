package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class q implements Runnable {
    final /* synthetic */ p a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f796a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str, String str2, String str3) {
        this.a = pVar;
        this.f796a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.f789a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f796a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
