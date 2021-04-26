package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class k extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f38972a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f957a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38973b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, int i2, String str, List list, String str2) {
        super(i2);
        this.f38972a = jVar;
        this.f957a = str;
        this.f958a = list;
        this.f38973b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a2;
        XMPushService xMPushService;
        a2 = this.f38972a.a(this.f957a);
        ArrayList<ie> a3 = bm.a(this.f958a, this.f957a, a2, 32768);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<ie> it = a3.iterator();
        while (it.hasNext()) {
            ie next = it.next();
            next.a("uploadWay", "longXMPushService");
            ib a4 = y.a(this.f957a, a2, next, hf.Notification);
            if (!TextUtils.isEmpty(this.f38973b) && !TextUtils.equals(this.f957a, this.f38973b)) {
                if (a4.m438a() == null) {
                    hs hsVar = new hs();
                    hsVar.a("-1");
                    a4.a(hsVar);
                }
                a4.m438a().b("ext_traffic_source_pkg", this.f38973b);
            }
            byte[] a5 = ip.a(a4);
            xMPushService = this.f38972a.f38971a;
            xMPushService.a(this.f957a, a5, true);
        }
    }
}
