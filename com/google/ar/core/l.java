package com.google.ar.core;

import android.content.Context;
/* loaded from: classes17.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4045a;
    private volatile boolean c;
    private final y ptn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f4045a = context;
        this.ptn = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eyc().b(this.f4045a)) {
                this.ptn.a(p.COMPLETED);
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
