package com.xiaomi.push.service;

import com.xiaomi.push.service.bk;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bk f38937a;

    public bl(bk bkVar) {
        this.f38937a = bkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f38937a.f934a;
            for (bk.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Sync job exception :" + e2.getMessage());
        }
        this.f38937a.f935a = false;
    }
}
