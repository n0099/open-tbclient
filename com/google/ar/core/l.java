package com.google.ar.core;

import android.content.Context;
/* loaded from: classes11.dex */
final class l extends Thread {
    private final Context a;
    private volatile boolean c;
    private final y nCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.a = context;
        this.nCC = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.dXc().b(this.a)) {
                this.nCC.a(p.COMPLETED);
                return;
            }
            try {
                sleep(200L);
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.c = true;
    }
}
