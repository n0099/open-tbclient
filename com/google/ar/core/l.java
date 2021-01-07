package com.google.ar.core;

import android.content.Context;
/* loaded from: classes6.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8160a;
    private volatile boolean c;
    private final y pLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f8160a = context;
        this.pLZ = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eCs().b(this.f8160a)) {
                this.pLZ.a(p.COMPLETED);
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
