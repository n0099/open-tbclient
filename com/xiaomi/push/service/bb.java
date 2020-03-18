package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.cy;
import com.xiaomi.push.ed;
import com.xiaomi.push.service.ba;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bb extends al.b {
    final /* synthetic */ ba a;

    /* renamed from: a  reason: collision with other field name */
    boolean f888a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ed.a a = ed.a.a(Base64.decode(cy.a(com.xiaomi.push.t.m559a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ar>) null), 10));
            if (a != null) {
                this.a.f886a = a;
                this.f888a = true;
                this.a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m45a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo218c() {
        List list;
        List list2;
        ba.a[] aVarArr;
        ed.a aVar;
        this.a.f885a = null;
        if (this.f888a) {
            synchronized (this.a) {
                list = this.a.f887a;
                list2 = this.a.f887a;
                aVarArr = (ba.a[]) list.toArray(new ba.a[list2.size()]);
            }
            for (ba.a aVar2 : aVarArr) {
                aVar = this.a.f886a;
                aVar2.a(aVar);
            }
        }
    }
}
