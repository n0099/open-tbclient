package com.mofamulu.tieba.sms;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b a;
    private final /* synthetic */ e b;
    private final /* synthetic */ f c;
    private final /* synthetic */ LinkedList d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, e eVar, f fVar, LinkedList linkedList, String str) {
        this.a = bVar;
        this.b = eVar;
        this.c = fVar;
        this.d = linkedList;
        this.e = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b, this.c, this.d, this.e);
    }
}
