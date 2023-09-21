package com.xiaomi.push;

import com.xiaomi.push.aj;
import com.xiaomi.push.ci;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class cj extends aj.a {
    public final /* synthetic */ ci a;

    public cj(ci ciVar) {
        this.a = ciVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo303a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<ci.a> arrayList6;
        arrayList = this.a.f167a;
        synchronized (arrayList) {
            arrayList2 = this.a.f167a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f167a;
                if (arrayList3.size() > 1) {
                    ci ciVar = this.a;
                    arrayList6 = this.a.f167a;
                    ciVar.a(arrayList6);
                } else {
                    ci ciVar2 = this.a;
                    arrayList4 = this.a.f167a;
                    ciVar2.b((ci.a) arrayList4.get(0));
                }
                arrayList5 = this.a.f167a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
