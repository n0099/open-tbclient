package com.kwad.sdk.collector.kwai;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f57708b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f57709c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f57710d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f57711e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f57712f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f57713g = 0;

    public d(Context context) {
        if (context != null) {
            d(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private int g(boolean z) {
        return z ? 1 : 2;
    }

    public void a(boolean z) {
        this.a = g(z);
    }

    public void b(boolean z) {
        this.f57708b = g(z);
    }

    public void c(boolean z) {
        this.f57709c = g(z);
    }

    public void d(boolean z) {
        this.f57711e = g(z);
    }

    public void e(boolean z) {
        this.f57712f = g(z);
    }

    public void f(boolean z) {
        this.f57713g = g(z);
    }
}
