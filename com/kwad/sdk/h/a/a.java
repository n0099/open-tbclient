package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes5.dex */
public class a {
    public String a;
    public long b;
    public long c;
    public long d;
    public boolean e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j = this.b;
        bVar.c = j != 0 ? this.c - j : 0L;
        long j2 = this.c;
        bVar.d = j2 != 0 ? this.d - j2 : 0L;
        long j3 = this.b;
        bVar.b = j3 != 0 ? this.d - j3 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j) {
        this.b = j;
        this.c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.e) {
            return;
        }
        this.e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
