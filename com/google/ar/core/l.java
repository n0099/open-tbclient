package com.google.ar.core;

import android.content.Context;
/* loaded from: classes5.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7860a;
    private volatile boolean c;
    private final y pHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f7860a = context;
        this.pHz = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eyA().b(this.f7860a)) {
                this.pHz.a(p.COMPLETED);
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
