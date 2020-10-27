package com.google.ar.core;

import android.content.Context;
/* loaded from: classes11.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4040a;
    private volatile boolean c;
    private final y oTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f4040a = context;
        this.oTh = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eoL().b(this.f4040a)) {
                this.oTh.a(p.COMPLETED);
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
