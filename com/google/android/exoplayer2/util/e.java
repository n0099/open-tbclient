package com.google.android.exoplayer2.util;
/* loaded from: classes5.dex */
public final class e {
    private boolean isOpen;

    public synchronized boolean hN() {
        boolean z = true;
        synchronized (this) {
            if (this.isOpen) {
                z = false;
            } else {
                this.isOpen = true;
                notifyAll();
            }
        }
        return z;
    }

    public synchronized boolean Mn() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }
}
