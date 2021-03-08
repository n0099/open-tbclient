package com.google.ar.core;

import android.content.Context;
/* loaded from: classes14.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5264a;
    private volatile boolean c;
    private final y pST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f5264a = context;
        this.pST = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eBg().b(this.f5264a)) {
                this.pST.a(p.COMPLETED);
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
