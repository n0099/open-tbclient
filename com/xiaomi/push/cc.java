package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class cc extends ai.a {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.a = cbVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo163a() {
        return 100957;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<cb.a> arrayList6;
        arrayList = this.a.f148a;
        synchronized (arrayList) {
            arrayList2 = this.a.f148a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f148a;
                if (arrayList3.size() > 1) {
                    cb cbVar = this.a;
                    arrayList6 = this.a.f148a;
                    cbVar.a(arrayList6);
                } else {
                    cb cbVar2 = this.a;
                    arrayList4 = this.a.f148a;
                    cbVar2.b((cb.a) arrayList4.get(0));
                }
                arrayList5 = this.a.f148a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
