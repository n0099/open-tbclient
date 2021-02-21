package com.google.ar.core;

import android.content.Context;
/* loaded from: classes15.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7862a;
    private volatile boolean c;
    private final y pSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f7862a = context;
        this.pSe = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eBa().b(this.f7862a)) {
                this.pSe.a(p.COMPLETED);
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
