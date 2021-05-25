package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public final class dx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37506a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f305a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f306a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37507b;

    public dx(Context context, String str, int i2, String str2) {
        this.f305a = context;
        this.f306a = str;
        this.f37506a = i2;
        this.f37507b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dw.c(this.f305a, this.f306a, this.f37506a, this.f37507b);
    }
}
