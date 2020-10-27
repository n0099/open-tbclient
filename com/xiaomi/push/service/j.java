package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
class j extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f5105a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f911a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f912a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, String str, List list, String str2) {
        super(i);
        this.f5105a = iVar;
        this.f911a = str;
        this.f912a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a2;
        XMPushService xMPushService;
        a2 = this.f5105a.a(this.f911a);
        ArrayList<il> a3 = bi.a(this.f912a, this.f911a, a2, 32768);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<il> it = a3.iterator();
        while (it.hasNext()) {
            il next = it.next();
            next.a("uploadWay", "longXMPushService");
            ii a4 = w.a(this.f911a, a2, next, hm.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f911a, this.b)) {
                if (a4.m418a() == null) {
                    hz hzVar = new hz();
                    hzVar.a("-1");
                    a4.a(hzVar);
                }
                a4.m418a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a5 = iw.a(a4);
            xMPushService = this.f5105a.f5104a;
            xMPushService.a(this.f911a, a5, true);
        }
    }
}
