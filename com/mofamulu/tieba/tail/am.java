package com.mofamulu.tieba.tail;

import com.baidu.tieba.util.NetWorkCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    private final /* synthetic */ NetWorkCore a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NetWorkCore netWorkCore, String str) {
        this.a = netWorkCore;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            try {
                wait(100L);
            } catch (InterruptedException e) {
            }
        }
        com.mofamulu.tieba.ch.au.b(this.a.s(), this.b);
    }
}
