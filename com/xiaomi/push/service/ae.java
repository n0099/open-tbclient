package com.xiaomi.push.service;

import com.xiaomi.push.hg;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4816a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(List list, boolean z) {
        this.f4816a = list;
        this.f840a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        b = ad.b("www.baidu.com:80");
        Iterator it = this.f4816a.iterator();
        while (true) {
            boolean z = b;
            if (!it.hasNext()) {
                b = z;
                break;
            }
            String str = (String) it.next();
            if (!z) {
                b2 = ad.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.f840a) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        hg.a(b ? 1 : 2);
    }
}
