package com.xiaomi.push.service;

import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class af implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        b = ae.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            boolean z = b;
            if (!it.hasNext()) {
                b = z;
                break;
            }
            String str = (String) it.next();
            if (!z) {
                b2 = ae.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.b) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        com.xiaomi.stats.h.a(b ? 1 : 2);
    }
}
