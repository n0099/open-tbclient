package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dt implements Runnable {
    final /* synthetic */ ds a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar) {
        this.a = dsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
