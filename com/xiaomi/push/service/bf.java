package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.dd;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.be;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bf extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f14272a;

    /* renamed from: a  reason: collision with other field name */
    boolean f966a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f14272a = beVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ej.a a2 = ej.a.a(Base64.decode(dd.a(com.xiaomi.push.t.m608a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ay>) null), 10));
            if (a2 != null) {
                this.f14272a.f964a = a2;
                this.f966a = true;
                this.f14272a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m79a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo254c() {
        List list;
        List list2;
        be.a[] aVarArr;
        ej.a aVar;
        this.f14272a.f963a = null;
        if (this.f966a) {
            synchronized (this.f14272a) {
                list = this.f14272a.f965a;
                list2 = this.f14272a.f965a;
                aVarArr = (be.a[]) list.toArray(new be.a[list2.size()]);
            }
            for (be.a aVar2 : aVarArr) {
                aVar = this.f14272a.f964a;
                aVar2.a(aVar);
            }
        }
    }
}
