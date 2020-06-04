package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.dd;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.be;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bf extends al.b {
    final /* synthetic */ be a;

    /* renamed from: a  reason: collision with other field name */
    boolean f886a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.a = beVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ej.a a = ej.a.a(Base64.decode(dd.a(com.xiaomi.push.t.m580a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ay>) null), 10));
            if (a != null) {
                this.a.f884a = a;
                this.f886a = true;
                this.a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m51a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo226c() {
        List list;
        List list2;
        be.a[] aVarArr;
        ej.a aVar;
        this.a.f883a = null;
        if (this.f886a) {
            synchronized (this.a) {
                list = this.a.f885a;
                list2 = this.a.f885a;
                aVarArr = (be.a[]) list.toArray(new be.a[list2.size()]);
            }
            for (be.a aVar2 : aVarArr) {
                aVar = this.a.f884a;
                aVar2.a(aVar);
            }
        }
    }
}
