package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.am;
import com.xiaomi.push.cy;
import com.xiaomi.push.dv;
import com.xiaomi.push.service.bv;
import java.util.List;
/* loaded from: classes10.dex */
public class bw extends am.b {
    public final /* synthetic */ bv a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f957a = false;

    public bw(bv bvVar) {
        this.a = bvVar;
    }

    @Override // com.xiaomi.push.am.b
    public void b() {
        try {
            dv.a a = dv.a.a(Base64.decode(cy.a(com.xiaomi.push.s.m722a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.bh>) null), 10));
            if (a != null) {
                this.a.f955a = a;
                this.f957a = true;
                this.a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo359c() {
        List list;
        List list2;
        bv.a[] aVarArr;
        dv.a aVar;
        this.a.f954a = null;
        if (this.f957a) {
            synchronized (this.a) {
                list = this.a.f956a;
                list2 = this.a.f956a;
                aVarArr = (bv.a[]) list.toArray(new bv.a[list2.size()]);
            }
            for (bv.a aVar2 : aVarArr) {
                aVar = this.a.f955a;
                aVar2.a(aVar);
            }
        }
    }
}
