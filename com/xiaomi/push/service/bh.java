package com.xiaomi.push.service;

import com.xiaomi.push.service.bg;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f14275a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.f14275a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f14275a.f970a;
            for (bg.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m79a("Sync job exception :" + e.getMessage());
        }
        this.f14275a.f971a = false;
    }
}
