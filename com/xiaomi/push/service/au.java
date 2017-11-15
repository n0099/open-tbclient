package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.service.at;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class au extends h.b {
    boolean a = false;
    final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.b = atVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        try {
            a.C0163a b = a.C0163a.b(Base64.decode(HttpUtils.a(com.xiaomi.channel.commonutils.android.j.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.channel.commonutils.network.c>) null), 10));
            if (b != null) {
                this.b.c = b;
                this.a = true;
                this.b.i();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void c() {
        List list;
        List list2;
        at.a[] aVarArr;
        a.C0163a c0163a;
        this.b.d = null;
        if (this.a) {
            synchronized (this.b) {
                list = this.b.b;
                list2 = this.b.b;
                aVarArr = (at.a[]) list.toArray(new at.a[list2.size()]);
            }
            for (at.a aVar : aVarArr) {
                c0163a = this.b.c;
                aVar.a(c0163a);
            }
        }
    }
}
