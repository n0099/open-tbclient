package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.cg;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ch extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f40703a;

    public ch(cg cgVar) {
        this.f40703a = cgVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<cg.a> arrayList6;
        arrayList = this.f40703a.f172a;
        synchronized (arrayList) {
            arrayList2 = this.f40703a.f172a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.f40703a.f172a;
                if (arrayList3.size() > 1) {
                    cg cgVar = this.f40703a;
                    arrayList6 = this.f40703a.f172a;
                    cgVar.a(arrayList6);
                } else {
                    cg cgVar2 = this.f40703a;
                    arrayList4 = this.f40703a.f172a;
                    cgVar2.b((cg.a) arrayList4.get(0));
                }
                arrayList5 = this.f40703a.f172a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
