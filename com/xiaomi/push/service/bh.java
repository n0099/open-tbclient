package com.xiaomi.push.service;

import com.xiaomi.push.service.bg;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
class bh implements Runnable {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.f897a;
            for (bg.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Sync job exception :" + e.getMessage());
        }
        this.a.f898a = false;
    }
}
