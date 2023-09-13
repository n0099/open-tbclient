package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class p implements Runnable {
    public final /* synthetic */ o a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f826a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public p(o oVar, String str, String str2, String str3) {
        this.a = oVar;
        this.f826a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.f823a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f826a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
