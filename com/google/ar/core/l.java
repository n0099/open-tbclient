package com.google.ar.core;

import android.content.Context;
/* loaded from: classes11.dex */
final class l extends Thread {
    private final Context a;
    private volatile boolean c;
    private final y nCk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.a = context;
        this.nCk = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.dWT().b(this.a)) {
                this.nCk.a(p.COMPLETED);
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
