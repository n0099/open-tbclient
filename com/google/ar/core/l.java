package com.google.ar.core;

import android.content.Context;
/* loaded from: classes3.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8159a;
    private volatile boolean c;
    private final y pKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f8159a = context;
        this.pKr = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eBO().b(this.f8159a)) {
                this.pKr.a(p.COMPLETED);
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
