package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f38001a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38003c;

    public q(p pVar, String str, String str2, String str3) {
        this.f38001a = pVar;
        this.f825a = str;
        this.f38002b = str2;
        this.f38003c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f38001a.f818a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f825a, 4).edit();
        edit.putString(this.f38002b, this.f38003c);
        edit.commit();
    }
}
