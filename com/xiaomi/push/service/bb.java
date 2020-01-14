package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.cy;
import com.xiaomi.push.ed;
import com.xiaomi.push.service.ba;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bb extends al.b {
    final /* synthetic */ ba a;

    /* renamed from: a  reason: collision with other field name */
    boolean f892a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        try {
            ed.a a = ed.a.a(Base64.decode(cy.a(com.xiaomi.push.t.m556a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.ar>) null), 10));
            if (a != null) {
                this.a.f890a = a;
                this.f892a = true;
                this.a.e();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo215c() {
        List list;
        List list2;
        ba.a[] aVarArr;
        ed.a aVar;
        this.a.f889a = null;
        if (this.f892a) {
            synchronized (this.a) {
                list = this.a.f891a;
                list2 = this.a.f891a;
                aVarArr = (ba.a[]) list.toArray(new ba.a[list2.size()]);
            }
            for (ba.a aVar2 : aVarArr) {
                aVar = this.a.f890a;
                aVar2.a(aVar);
            }
        }
    }
}
