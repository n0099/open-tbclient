package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dy implements Runnable {
    final /* synthetic */ dx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dx dxVar) {
        this.a = dxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
