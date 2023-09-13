package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hh;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
/* loaded from: classes10.dex */
public final class ch implements Runnable {
    public final /* synthetic */ ig a;

    public ch(ig igVar) {
        this.a = igVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        byte[] a = ir.a(ah.a(this.a.c(), this.a.b(), this.a, hh.Notification));
        context = cg.a;
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m181a("UNDatas UploadNotificationDatas failed because not xmsf");
            return;
        }
        context2 = cg.a;
        ((XMPushService) context2).a(this.a.c(), a, true);
    }
}
