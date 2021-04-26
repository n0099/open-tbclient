package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes7.dex */
public final class dx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f38332a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f305a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f306a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38333b;

    public dx(Context context, String str, int i2, String str2) {
        this.f305a = context;
        this.f306a = str;
        this.f38332a = i2;
        this.f38333b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dw.c(this.f305a, this.f306a, this.f38332a, this.f38333b);
    }
}
