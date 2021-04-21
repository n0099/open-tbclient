package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f41283a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f41284b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41285c;

    public q(p pVar, String str, String str2, String str3) {
        this.f41283a = pVar;
        this.f825a = str;
        this.f41284b = str2;
        this.f41285c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f41283a.f818a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f825a, 4).edit();
        edit.putString(this.f41284b, this.f41285c);
        edit.commit();
    }
}
