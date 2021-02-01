package com.qq.e.comm.plugin.r.a;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
class b {
    private static int a(com.qq.e.comm.plugin.r.b.c cVar) {
        GDTLogger.d("BiddingUtils " + cVar.a() + " Priority config, isEnableRtPriority: " + cVar.j() + "  getRtPriority: " + cVar.l() + "  isContractAd: " + cVar.m() + "  getContractPriority(): " + cVar.n() + "  getPriority: " + cVar.d());
        int d = cVar.d();
        return cVar.j() ? cVar.l() > 0 ? cVar.l() : (cVar.n() <= 0 || !cVar.m()) ? d : cVar.n() : d;
    }

    public static List<com.qq.e.comm.plugin.r.b.c> a(List<com.qq.e.comm.plugin.r.b.c> list) {
        return a(list, false);
    }

    private static List<com.qq.e.comm.plugin.r.b.c> a(List<com.qq.e.comm.plugin.r.b.c> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            com.qq.e.comm.plugin.r.b.c[] cVarArr = (com.qq.e.comm.plugin.r.b.c[]) list.toArray(new com.qq.e.comm.plugin.r.b.c[list.size()]);
            int length = cVarArr.length;
            for (int i = 0; i < length - 1; i++) {
                int i2 = i;
                for (int i3 = i + 1; i3 < length; i3++) {
                    if (a(cVarArr[i3], cVarArr[i2], z)) {
                        i2 = i3;
                    }
                }
                if (i != i2) {
                    com.qq.e.comm.plugin.r.b.c cVar = cVarArr[i];
                    cVarArr[i] = cVarArr[i2];
                    cVarArr[i2] = cVar;
                }
            }
            Collections.addAll(arrayList, cVarArr);
        }
        return arrayList;
    }

    private static boolean a(com.qq.e.comm.plugin.r.b.c cVar, com.qq.e.comm.plugin.r.b.c cVar2, boolean z) {
        int d;
        int d2;
        long c;
        long c2;
        if (cVar != null && cVar2 != null) {
            if (z) {
                d = a(cVar);
                d2 = a(cVar2);
                c = b(cVar);
                c2 = b(cVar2);
            } else {
                d = cVar.d();
                d2 = cVar2.d();
                c = cVar.c();
                c2 = cVar2.c();
            }
            if (d < d2) {
                return true;
            }
            if (d == d2) {
                return c > c2;
            }
        }
        return false;
    }

    private static long b(com.qq.e.comm.plugin.r.b.c cVar) {
        GDTLogger.d("BiddingUtils " + cVar.a() + "  ECPM config, isEnableRtBid: " + cVar.k() + "  getECPM: " + cVar.i() + "  getECPM() * 1000: " + (cVar.i() * 1000) + "  getBid: " + cVar.c());
        return (!cVar.k() || cVar.i() <= 0) ? cVar.c() : cVar.i() * 1000;
    }

    public static List<com.qq.e.comm.plugin.r.b.c> b(List<com.qq.e.comm.plugin.r.b.c> list) {
        List<com.qq.e.comm.plugin.r.b.c> a2 = a(list, true);
        Iterator<com.qq.e.comm.plugin.r.b.c> it = a2.iterator();
        while (it.hasNext()) {
            if (!it.next().r()) {
                it.remove();
            }
        }
        return a2;
    }
}
