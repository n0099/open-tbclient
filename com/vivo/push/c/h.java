package com.vivo.push.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class h extends ab {
    public h(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.v vVar = (com.vivo.push.b.v) yVar;
        ArrayList<String> d2 = vVar.d();
        List<String> e2 = vVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h2 = vVar.h();
        String g2 = vVar.g();
        if (d2 != null) {
            for (String str : d2) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e2 != null) {
            for (String str2 : e2) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                com.vivo.push.p.a().b(arrayList);
            }
            com.vivo.push.p.a().a(vVar.g(), arrayList3.size() > 0 ? 10000 : h2);
            com.vivo.push.w.b(new i(this, h2, arrayList, arrayList3, g2));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.p.a().c(arrayList2);
            }
            com.vivo.push.p.a().a(vVar.g(), h2);
            com.vivo.push.w.b(new j(this, h2, arrayList2, arrayList4, g2));
        }
    }
}
