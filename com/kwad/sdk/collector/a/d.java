package com.kwad.sdk.collector.a;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f31867a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f31868b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f31869c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f31870d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f31871e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f31872f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f31873g = 0;

    public d(Context context) {
        if (context != null) {
            d(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private int g(boolean z) {
        return z ? 1 : 2;
    }

    public void a(boolean z) {
        this.f31867a = g(z);
    }

    public void b(boolean z) {
        this.f31868b = g(z);
    }

    public void c(boolean z) {
        this.f31869c = g(z);
    }

    public void d(boolean z) {
        this.f31871e = g(z);
    }

    public void e(boolean z) {
        this.f31872f = g(z);
    }

    public void f(boolean z) {
        this.f31873g = g(z);
    }
}
