package com.xiaomi.push.service;

import com.xiaomi.push.service.bc;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
class bd implements Runnable {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.f892a;
            for (bc.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m30a("Sync job exception :" + e.getMessage());
        }
        this.a.f893a = false;
    }
}
