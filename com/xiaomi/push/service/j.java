package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
class j extends XMPushService.i {
    final /* synthetic */ i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f915a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f916a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, String str, List list, String str2) {
        super(i);
        this.a = iVar;
        this.f915a = str;
        this.f916a = list;
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
        a = this.a.a(this.f915a);
        ArrayList<Cif> a2 = be.a(this.f916a, this.f915a, a, 32768);
        com.xiaomi.channel.commonutils.logger.b.m50a("TinyData LongConnUploader.upload pack notifications " + a2.toString() + "  ts:" + System.currentTimeMillis());
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<Cif> it = a2.iterator();
        while (it.hasNext()) {
            Cif next = it.next();
            next.a("uploadWay", "longXMPushService");
            ic a3 = w.a(this.f915a, a, next, hg.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f915a, this.b)) {
                if (a3.m404a() == null) {
                    ht htVar = new ht();
                    htVar.a("-1");
                    a3.a(htVar);
                }
                a3.m404a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a4 = iq.a(a3);
            xMPushService = this.a.a;
            xMPushService.a(this.f915a, a4, true);
        }
        Iterator it2 = this.f916a.iterator();
        while (it2.hasNext()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("TinyData LongConnUploader.upload uploaded by com.xiaomi.push.service.TinyDataUploader.  item" + ((hk) it2.next()).d() + "  ts:" + System.currentTimeMillis());
        }
    }
}
