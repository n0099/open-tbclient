package com.kwad.sdk.collector.kwai;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f55522b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f55523c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f55524d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f55525e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f55526f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f55527g = 0;

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
        this.f55522b = g(z);
    }

    public void c(boolean z) {
        this.f55523c = g(z);
    }

    public void d(boolean z) {
        this.f55525e = g(z);
    }

    public void e(boolean z) {
        this.f55526f = g(z);
    }

    public void f(boolean z) {
        this.f55527g = g(z);
    }
}
