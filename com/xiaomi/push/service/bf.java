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
    final /* synthetic */ be f5078a;

    /* renamed from: a  reason: collision with other field name */
    boolean f888a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f5078a = beVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ej.a a2 = ej.a.a(Base64.decode(dd.a(com.xiaomi.push.t.m584a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ay>) null), 10));
            if (a2 != null) {
                this.f5078a.f886a = a2;
                this.f888a = true;
                this.f5078a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m55a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo230c() {
        List list;
        List list2;
        be.a[] aVarArr;
        ej.a aVar;
        this.f5078a.f885a = null;
        if (this.f888a) {
            synchronized (this.f5078a) {
                list = this.f5078a.f887a;
                list2 = this.f5078a.f887a;
                aVarArr = (be.a[]) list.toArray(new be.a[list2.size()]);
            }
            for (be.a aVar2 : aVarArr) {
                aVar = this.f5078a.f886a;
                aVar2.a(aVar);
            }
        }
    }
}
