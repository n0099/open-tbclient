package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.misc.k;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.service.bh;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bi extends k.b {
    boolean a = false;
    final /* synthetic */ bh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.b = bhVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.k.b
    public void b() {
        try {
            a.C0598a b = a.C0598a.b(Base64.decode(HttpUtils.a(com.xiaomi.channel.commonutils.android.n.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.channel.commonutils.network.c>) null), 10));
            if (b != null) {
                this.b.c = b;
                this.a = true;
                this.b.i();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.k.b
    public void c() {
        List list;
        List list2;
        bh.a[] aVarArr;
        a.C0598a c0598a;
        this.b.d = null;
        if (this.a) {
            synchronized (this.b) {
                list = this.b.b;
                list2 = this.b.b;
                aVarArr = (bh.a[]) list.toArray(new bh.a[list2.size()]);
            }
            for (bh.a aVar : aVarArr) {
                c0598a = this.b.c;
                aVar.a(c0598a);
            }
        }
    }
}
