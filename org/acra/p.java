package org.acra;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Thread {
    final /* synthetic */ q a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ m e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, q qVar, boolean z, String str, boolean z2) {
        this.e = mVar;
        this.a = qVar;
        this.b = z;
        this.c = str;
        this.d = z2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        Log.d(a.a, "Waiting for Toast + worker...");
        while (true) {
            z = m.j;
            if (!z || (this.a != null && this.a.isAlive())) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    Log.e(a.a, "Error : ", e);
                }
            }
        }
        if (this.b) {
            Log.d(a.a, "About to create DIALOG from #handleException");
            this.e.a(this.c);
        }
        Log.d(a.a, "Wait for Toast + worker ended. Kill Application ? " + this.d);
        if (this.d) {
            this.e.f();
        }
    }
}
