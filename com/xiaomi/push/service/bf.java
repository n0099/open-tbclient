package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.dd;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.be;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bf extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f5076a;

    /* renamed from: a  reason: collision with other field name */
    boolean f885a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f5076a = beVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ej.a a2 = ej.a.a(Base64.decode(dd.a(com.xiaomi.push.t.m583a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ay>) null), 10));
            if (a2 != null) {
                this.f5076a.f883a = a2;
                this.f885a = true;
                this.f5076a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo229c() {
        List list;
        List list2;
        be.a[] aVarArr;
        ej.a aVar;
        this.f5076a.f882a = null;
        if (this.f885a) {
            synchronized (this.f5076a) {
                list = this.f5076a.f884a;
                list2 = this.f5076a.f884a;
                aVarArr = (be.a[]) list.toArray(new be.a[list2.size()]);
            }
            for (be.a aVar2 : aVarArr) {
                aVar = this.f5076a.f883a;
                aVar2.a(aVar);
            }
        }
    }
}
