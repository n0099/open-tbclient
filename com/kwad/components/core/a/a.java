package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.q;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public String IA;
    public String IB;
    public long IC;
    public long ID;
    public Timer IE;
    public boolean IF = false;
    public final long period;

    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0631a {
        public static final a IH = new a();
    }

    public a() {
        this.IC = -1L;
        try {
            this.IC = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.IC = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(d.Ay());
        com.kwad.sdk.core.c.d dVar = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.ml();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.eE();
            }
        };
        b.Ct();
        b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.IC;
        this.IC = elapsedRealtime;
        if (i == 1) {
            this.ID = 0L;
            this.IB = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.IA)) {
                this.IA = this.IB;
            }
        }
        this.ID++;
        q qVar = new q(10220L);
        qVar.arX = this.ID;
        if (j > 0) {
            qVar.awN = j;
        }
        qVar.awO = i;
        qVar.IA = this.IA;
        qVar.IB = this.IB;
        i.a2(qVar);
    }

    public static a mk() {
        return C0631a.IH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml() {
        this.IF = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.IE;
        if (timer != null) {
            timer.cancel();
        }
        ah(3);
    }

    public final void eE() {
        if (this.IF) {
            return;
        }
        this.IF = true;
        if (this.period <= 0) {
            return;
        }
        this.IE = new Timer();
        ah(1);
        try {
            this.IE.schedule(new TimerTask() { // from class: com.kwad.components.core.a.a.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    a.this.ah(2);
                }
            }, this.period, this.period);
        } catch (Throwable unused) {
        }
    }
}
