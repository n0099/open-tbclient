package com.mofamulu.tieba.tail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ LovedBarListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LovedBarListActivity lovedBarListActivity) {
        this.a = lovedBarListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.m();
    }
}
