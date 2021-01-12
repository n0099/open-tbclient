package com.xiaomi.push.service;

import com.xiaomi.push.hg;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f14227a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(List list, boolean z) {
        this.f14227a = list;
        this.f918a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        boolean b3;
        b2 = ad.b("www.baidu.com:80");
        Iterator it = this.f14227a.iterator();
        while (true) {
            boolean z = b2;
            if (!it.hasNext()) {
                b2 = z;
                break;
            }
            String str = (String) it.next();
            if (!z) {
                b3 = ad.b(str);
                if (!b3) {
                    b2 = false;
                    if (!b2 && !this.f918a) {
                        break;
                    }
                }
            }
            b2 = true;
            if (!b2) {
            }
        }
        hg.a(b2 ? 1 : 2);
    }
}
