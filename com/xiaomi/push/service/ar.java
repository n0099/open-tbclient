package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ar {
    public static int a(aq aqVar, hl hlVar) {
        return aqVar.f895a.getInt(a(hlVar), as.f40955a[hlVar.ordinal()] != 1 ? 0 : 1);
    }

    public static String a(hl hlVar) {
        return "oc_version_" + hlVar.a();
    }

    public static List<Pair<Integer, Object>> a(List<hq> list, boolean z) {
        if (com.xiaomi.push.ad.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hq hqVar : list) {
            int a2 = hqVar.a();
            hm a3 = hm.a(hqVar.b());
            if (a3 != null) {
                if (z && hqVar.f512a) {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                } else {
                    int i = as.f40956b[a3.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(hqVar.g())) : new Pair(Integer.valueOf(a2), hqVar.m374a()) : new Pair(Integer.valueOf(a2), Long.valueOf(hqVar.m373a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(hqVar.c())));
                }
            }
        }
        return arrayList;
    }

    public static void a(aq aqVar, hl hlVar, int i) {
        aqVar.f895a.edit().putInt(a(hlVar), i).commit();
    }

    public static void a(aq aqVar, ic icVar) {
        aqVar.b(a(icVar.a(), true));
        aqVar.b();
    }

    public static void a(aq aqVar, id idVar) {
        for (ho hoVar : idVar.a()) {
            if (hoVar.a() > a(aqVar, hoVar.m369a())) {
                a(aqVar, hoVar.m369a(), hoVar.a());
                aqVar.a(a(hoVar.f504a, false));
            }
        }
        aqVar.b();
    }
}
