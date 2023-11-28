package com.xiaomi.push.service;

import com.xiaomi.push.service.bx;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class by implements Runnable {
    public final /* synthetic */ bx a;

    public by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.f956a;
            for (bx.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m190a("Sync job exception :" + e.getMessage());
        }
        this.a.f957a = false;
    }
}
