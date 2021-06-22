package com.xiaomi.push.service;

import com.xiaomi.push.gz;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f41827a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f884a;

    public ah(List list, boolean z) {
        this.f41827a = list;
        this.f884a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        boolean b3;
        b2 = ag.b("www.baidu.com:80");
        Iterator it = this.f41827a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!b2) {
                b3 = ag.b(str);
                if (!b3) {
                    b2 = false;
                    if (!b2 && !this.f884a) {
                        break;
                    }
                }
            }
            b2 = true;
            if (!b2) {
            }
        }
        gz.a(b2 ? 1 : 2);
    }
}
