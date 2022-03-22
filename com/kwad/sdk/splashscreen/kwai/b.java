package com.kwad.sdk.splashscreen.kwai;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {

    /* renamed from: c  reason: collision with root package name */
    public static SimpleDateFormat f41339c = new SimpleDateFormat("yyyy-MM-dd");
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f41340b;

    public b() {
        this.a = -1L;
        this.f41340b = -1;
    }

    public b(long j, int i) {
        this.a = -1L;
        this.f41340b = -1;
        this.a = j;
        this.f41340b = i;
    }

    public boolean a() {
        int aO = com.kwad.sdk.core.config.b.aO();
        int i = this.f41340b;
        return i > 0 && i >= aO;
    }

    public boolean a(long j) {
        if (this.a > 0 && j > 0) {
            try {
                return f41339c.format(new Date(this.a)).equals(f41339c.format(new Date(j)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
        return false;
    }
}
