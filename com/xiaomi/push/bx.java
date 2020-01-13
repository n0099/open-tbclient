package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.bw;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bx extends ai.a {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 100957;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<bw.a> arrayList6;
        arrayList = this.a.f164a;
        synchronized (arrayList) {
            arrayList2 = this.a.f164a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f164a;
                if (arrayList3.size() > 1) {
                    bw bwVar = this.a;
                    arrayList6 = this.a.f164a;
                    bwVar.a(arrayList6);
                } else {
                    bw bwVar2 = this.a;
                    arrayList4 = this.a.f164a;
                    bwVar2.b((bw.a) arrayList4.get(0));
                }
                arrayList5 = this.a.f164a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
