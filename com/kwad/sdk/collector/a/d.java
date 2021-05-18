package com.kwad.sdk.collector.a;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f31938a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f31939b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f31940c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f31941d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f31942e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f31943f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f31944g = 0;

    public d(Context context) {
        if (context != null) {
            d(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private int g(boolean z) {
        return z ? 1 : 2;
    }

    public void a(boolean z) {
        this.f31938a = g(z);
    }

    public void b(boolean z) {
        this.f31939b = g(z);
    }

    public void c(boolean z) {
        this.f31940c = g(z);
    }

    public void d(boolean z) {
        this.f31942e = g(z);
    }

    public void e(boolean z) {
        this.f31943f = g(z);
    }

    public void f(boolean z) {
        this.f31944g = g(z);
    }
}
