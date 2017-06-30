package com.xiaomi.smack;

import com.xiaomi.network.HostManager;
/* loaded from: classes2.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HostManager.getInstance().getFallbacksByHost(this.a, true);
    }
}
