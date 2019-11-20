package com.xiaomi.push.service;

import com.xiaomi.push.ha;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ad implements Runnable {
    final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(List list, boolean z) {
        this.a = list;
        this.f843a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        b = ac.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            boolean z = b;
            if (!it.hasNext()) {
                b = z;
                break;
            }
            String str = (String) it.next();
            if (!z) {
                b2 = ac.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.f843a) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        ha.a(b ? 1 : 2);
    }
}
