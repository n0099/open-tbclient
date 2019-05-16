package com.vivo.push.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class ab extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) vVar;
        ArrayList<String> d = tVar.d();
        List<String> e = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h = tVar.h();
        String g = tVar.g();
        if (d != null) {
            for (String str : d) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e != null) {
            for (String str2 : e) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                com.vivo.push.m.a().a(arrayList);
            }
            com.vivo.push.m.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h);
            b.post(new ac(this, h, arrayList, arrayList3, g));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.m.a().a((String) arrayList2.get(0));
            }
            com.vivo.push.m.a().a(tVar.g(), h);
            b.post(new ad(this, h, arrayList2, arrayList4, g));
        }
    }
}
