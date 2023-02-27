package com.kwad.components.core.i.kwai;

import android.os.SystemClock;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public final class a {
    public long HA;
    public boolean HB;
    public String Hx;
    public long Hy;
    public long Hz;

    public final void at(String str) {
        this.Hx = str;
    }

    public final void n(long j) {
        this.Hy = j;
        this.Hz = SystemClock.uptimeMillis();
    }

    public final void oe() {
        if (this.HB) {
            return;
        }
        this.HB = true;
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.i.kwai.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.HA = SystemClock.uptimeMillis();
                a.this.of();
            }
        });
    }

    public final void of() {
        b bVar = new b();
        bVar.Hx = this.Hx;
        long j = this.Hy;
        bVar.HE = j != 0 ? this.Hz - j : 0L;
        long j2 = this.Hz;
        bVar.HF = j2 != 0 ? this.HA - j2 : 0L;
        long j3 = this.Hy;
        bVar.HD = j3 != 0 ? this.HA - j3 : 0L;
        com.kwad.components.core.j.a.og().a(bVar);
        com.kwad.sdk.core.e.b.d("PageMonitor", bVar.toString());
    }
}
