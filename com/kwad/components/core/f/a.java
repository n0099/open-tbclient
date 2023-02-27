package com.kwad.components.core.f;

import com.ksad.json.annotation.KsJson;
import java.text.SimpleDateFormat;
import java.util.Date;
@KsJson
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public static SimpleDateFormat EB = new SimpleDateFormat("yyyy-MM-dd");
    public int ED;
    public long EE;

    public final boolean h(int i, int i2) {
        com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.EE <= 0) {
            ni();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = EB.format(new Date(this.EE));
        String format2 = EB.format(new Date(currentTimeMillis));
        com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.ED = 0;
            ni();
            return true;
        }
        long j = this.EE + (i * 60 * 60 * 1000);
        com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.ED);
        if (j >= currentTimeMillis || this.ED > i2) {
            return false;
        }
        ni();
        return true;
    }

    public final void ni() {
        this.EE = System.currentTimeMillis();
        this.ED++;
        com.kwad.sdk.core.e.b.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.EE + ", currentActiveCount " + this.ED);
    }
}
