package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f40898a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40899b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40900c;

    public q(p pVar, String str, String str2, String str3) {
        this.f40898a = pVar;
        this.f825a = str;
        this.f40899b = str2;
        this.f40900c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f40898a.f818a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f825a, 4).edit();
        edit.putString(this.f40899b, this.f40900c);
        edit.commit();
    }
}
