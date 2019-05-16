package com.xiaomi.metoknlp.devicediscover;

import java.net.InetAddress;
/* loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ m a;
    private String b;

    public e(m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            InetAddress.getByName(this.b).isReachable(500);
        } catch (Exception e) {
        }
    }
}
