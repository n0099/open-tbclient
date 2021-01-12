package com.vivo.push.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class ac extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.v vVar = (com.vivo.push.b.v) yVar;
        ArrayList<String> d = vVar.d();
        List<String> e = vVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h = vVar.h();
        String g = vVar.g();
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
                com.vivo.push.p.a().a(arrayList);
            }
            com.vivo.push.p.a().a(vVar.g(), arrayList3.size() > 0 ? 10000 : h);
            com.vivo.push.w.b(new ad(this, h, arrayList, arrayList3, g));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.p.a().b((String) arrayList2.get(0));
            }
            com.vivo.push.p.a().a(vVar.g(), h);
            com.vivo.push.w.b(new ae(this, h, arrayList2, arrayList4, g));
        }
    }
}
