package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
class n extends XMPushService.i {
    final /* synthetic */ String b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ m e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, int i, String str, List list, String str2) {
        super(i);
        this.e = mVar;
        this.b = str;
        this.c = list;
        this.d = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a;
        XMPushService xMPushService;
        a = this.e.a(this.b);
        ArrayList<com.xiaomi.xmpush.thrift.ai> a2 = bj.a(this.c, this.b, a, 32768);
        com.xiaomi.channel.commonutils.logger.b.a("TinyData LongConnUploader.upload pack notifications " + a2.toString() + "  ts:" + System.currentTimeMillis());
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<com.xiaomi.xmpush.thrift.ai> it = a2.iterator();
        while (it.hasNext()) {
            com.xiaomi.xmpush.thrift.ai next = it.next();
            next.a("uploadWay", "longXMPushService");
            com.xiaomi.xmpush.thrift.af a3 = af.a(this.b, a, next, com.xiaomi.xmpush.thrift.a.Notification);
            if (!TextUtils.isEmpty(this.d) && !TextUtils.equals(this.b, this.d)) {
                if (a3.m() == null) {
                    com.xiaomi.xmpush.thrift.u uVar = new com.xiaomi.xmpush.thrift.u();
                    uVar.a(LivenessStat.TYPE_STRING_DEFAULT);
                    a3.a(uVar);
                }
                a3.m().b("ext_traffic_source_pkg", this.d);
            }
            byte[] a4 = com.xiaomi.xmpush.thrift.at.a(a3);
            xMPushService = this.e.a;
            xMPushService.a(this.b, a4, true);
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData LongConnUploader.upload uploaded by com.xiaomi.push.service.TinyDataUploader.  item" + ((com.xiaomi.xmpush.thrift.f) it2.next()).m() + "  ts:" + System.currentTimeMillis());
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "Send tiny data.";
    }
}
