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
/* loaded from: classes18.dex */
class j extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f4877a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f914a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f915a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, String str, List list, String str2) {
        super(i);
        this.f4877a = iVar;
        this.f914a = str;
        this.f915a = list;
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
        a2 = this.f4877a.a(this.f914a);
        ArrayList<il> a3 = bi.a(this.f915a, this.f914a, a2, 32768);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<il> it = a3.iterator();
        while (it.hasNext()) {
            il next = it.next();
            next.a("uploadWay", "longXMPushService");
            ii a4 = w.a(this.f914a, a2, next, hm.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f914a, this.b)) {
                if (a4.m411a() == null) {
                    hz hzVar = new hz();
                    hzVar.a("-1");
                    a4.a(hzVar);
                }
                a4.m411a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a5 = iw.a(a4);
            xMPushService = this.f4877a.f4876a;
            xMPushService.a(this.f914a, a5, true);
        }
    }
}
