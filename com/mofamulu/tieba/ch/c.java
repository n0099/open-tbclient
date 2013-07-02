package com.mofamulu.tieba.ch;
/* loaded from: classes.dex */
class c extends Thread {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    wait(201);
                } catch (Exception e) {
                }
            }
        }
    }
}
