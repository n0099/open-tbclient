package com.mofamulu.tieba.ch;
/* loaded from: classes.dex */
class b extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            synchronized (this) {
                new c(this).start();
            }
        }
    }
}
