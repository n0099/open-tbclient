package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cc extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f13910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.f13910a = cbVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
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
        arrayList = this.f13910a.f228a;
        synchronized (arrayList) {
            arrayList2 = this.f13910a.f228a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.f13910a.f228a;
                if (arrayList3.size() > 1) {
                    cb cbVar = this.f13910a;
                    arrayList6 = this.f13910a.f228a;
                    cbVar.a(arrayList6);
                } else {
                    cb cbVar2 = this.f13910a;
                    arrayList4 = this.f13910a.f228a;
                    cbVar2.b((cb.a) arrayList4.get(0));
                }
                arrayList5 = this.f13910a.f228a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
