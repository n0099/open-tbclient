package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hh;
import com.xiaomi.push.hu;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class s extends XMPushService.j {
    public final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f1003a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f1004a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i, String str, List list, String str2) {
        super(i);
        this.a = rVar;
        this.f1003a = str;
        this.f1004a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo672a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo389a() {
        String a;
        XMPushService xMPushService;
        a = this.a.a(this.f1003a);
        ArrayList<ig> a2 = bz.a(this.f1004a, this.f1003a, a, 32768);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<ig> it = a2.iterator();
        while (it.hasNext()) {
            ig next = it.next();
            next.a("uploadWay", "longXMPushService");
            id a3 = ah.a(this.f1003a, a, next, hh.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f1003a, this.b)) {
                if (a3.m541a() == null) {
                    hu huVar = new hu();
                    huVar.a("-1");
                    a3.a(huVar);
                }
                a3.m541a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a4 = ir.a(a3);
            xMPushService = this.a.a;
            xMPushService.a(this.f1003a, a4, true);
        }
    }
}
