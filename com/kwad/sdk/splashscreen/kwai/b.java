package com.kwad.sdk.splashscreen.kwai;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {

    /* renamed from: c  reason: collision with root package name */
    public static SimpleDateFormat f60170c = new SimpleDateFormat("yyyy-MM-dd");
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f60171b;

    public b() {
        this.a = -1L;
        this.f60171b = -1;
    }

    public b(long j2, int i2) {
        this.a = -1L;
        this.f60171b = -1;
        this.a = j2;
        this.f60171b = i2;
    }

    public boolean a() {
        int aO = com.kwad.sdk.core.config.b.aO();
        int i2 = this.f60171b;
        return i2 > 0 && i2 >= aO;
    }

    public boolean a(long j2) {
        if (this.a > 0 && j2 > 0) {
            try {
                return f60170c.format(new Date(this.a)).equals(f60170c.format(new Date(j2)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
        return false;
    }
}
