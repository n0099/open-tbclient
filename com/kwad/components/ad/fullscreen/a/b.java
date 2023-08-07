package com.kwad.components.ad.fullscreen.a;

import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat em = new SimpleDateFormat("yyyy-MM-dd");
    public long en;
    public int eo;

    public b() {
        this.en = -1L;
        this.eo = -1;
    }

    public b(long j, int i) {
        this.en = -1L;
        this.eo = -1;
        this.en = j;
        this.eo = 1;
    }

    public final boolean e(long j) {
        if (this.en > 0 && j > 0) {
            try {
                return em.format(new Date(this.en)).equals(em.format(new Date(j)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public final boolean w(int i) {
        int i2 = this.eo;
        return i2 > 0 && i2 >= i;
    }
}
