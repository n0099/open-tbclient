package org.acra;

import android.text.format.Time;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Time time = new Time();
        Time time2 = new Time();
        time.setToNow();
        long millis = time.toMillis(false);
        for (long j = 0; j < 3000; j = time2.toMillis(false) - millis) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                Log.d(a.a, "Interrupted while waiting for Toast to end.", e);
            }
            time2.setToNow();
        }
        boolean unused = m.j = true;
    }
}
