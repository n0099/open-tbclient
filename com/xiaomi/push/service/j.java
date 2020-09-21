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
/* loaded from: classes9.dex */
class j extends XMPushService.i {
    final /* synthetic */ i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f913a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f914a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, String str, List list, String str2) {
        super(i);
        this.a = iVar;
        this.f913a = str;
        this.f914a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a;
        XMPushService xMPushService;
        a = this.a.a(this.f913a);
        ArrayList<il> a2 = bi.a(this.f914a, this.f913a, a, 32768);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<il> it = a2.iterator();
        while (it.hasNext()) {
            il next = it.next();
            next.a("uploadWay", "longXMPushService");
            ii a3 = w.a(this.f913a, a, next, hm.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f913a, this.b)) {
                if (a3.m418a() == null) {
                    hz hzVar = new hz();
                    hzVar.a("-1");
                    a3.a(hzVar);
                }
                a3.m418a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a4 = iw.a(a3);
            xMPushService = this.a.a;
            xMPushService.a(this.f913a, a4, true);
        }
    }
}
