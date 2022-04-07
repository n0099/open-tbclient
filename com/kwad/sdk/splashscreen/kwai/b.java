package com.kwad.sdk.splashscreen.kwai;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd");
    public long a;
    public int b;

    public b() {
        this.a = -1L;
        this.b = -1;
    }

    public b(long j, int i) {
        this.a = -1L;
        this.b = -1;
        this.a = j;
        this.b = i;
    }

    public boolean a() {
        int aO = com.kwad.sdk.core.config.b.aO();
        int i = this.b;
        return i > 0 && i >= aO;
    }

    public boolean a(long j) {
        if (this.a > 0 && j > 0) {
            try {
                return c.format(new Date(this.a)).equals(c.format(new Date(j)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.b(e);
            }
        }
        return false;
    }
}
