package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
class bj extends XMPushService.h {
    final /* synthetic */ ArrayList b;
    final /* synthetic */ bi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bi biVar, int i, ArrayList arrayList) {
        super(i);
        this.c = biVar;
        this.b = arrayList;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        String a;
        String packageName = this.c.a.getPackageName();
        a = this.c.a(packageName);
        ArrayList<com.xiaomi.xmpush.thrift.ae> a2 = av.a(this.b, packageName, a);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in XMPushService.");
            return;
        }
        Iterator<com.xiaomi.xmpush.thrift.ae> it = a2.iterator();
        while (it.hasNext()) {
            com.xiaomi.xmpush.thrift.ae next = it.next();
            next.a("uploadWay", "longXMPushService");
            this.c.a.a(packageName, com.xiaomi.xmpush.thrift.aq.a(aa.a(packageName, a, next, com.xiaomi.xmpush.thrift.a.Notification)), true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "Send tiny data.";
    }
}
