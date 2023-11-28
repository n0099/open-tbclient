package com.kwad.components.core.k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;
@KsJson
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public static SimpleDateFormat Mj = new SimpleDateFormat("yyyy-MM-dd");
    public int Mk;
    public long Ml;

    public final void oy() {
        this.Ml = System.currentTimeMillis();
        this.Mk++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Ml + ", currentActiveCount " + this.Mk);
    }

    public final boolean l(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.Ml > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = Mj.format(new Date(this.Ml));
            String format2 = Mj.format(new Date(currentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.Mk = 0;
                oy();
                return true;
            }
            long j = this.Ml + (i * 60 * 60 * 1000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.Mk);
            if (j >= currentTimeMillis || this.Mk > i2) {
                return false;
            }
            oy();
            return true;
        }
        oy();
        return true;
    }
}
