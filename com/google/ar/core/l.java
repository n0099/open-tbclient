package com.google.ar.core;

import android.content.Context;
/* loaded from: classes11.dex */
final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4042a;
    private volatile boolean c;
    private final y obQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, y yVar) {
        this.f4042a = context;
        this.obQ = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.c) {
            if (o.eeL().b(this.f4042a)) {
                this.obQ.a(p.COMPLETED);
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
