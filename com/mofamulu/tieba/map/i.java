package com.mofamulu.tieba.map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ FreeLocationService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FreeLocationService freeLocationService) {
        this.a = freeLocationService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.o();
            this.a.a((String) null);
        } catch (Throwable th) {
            this.a.a(th.getMessage());
        }
    }
}
