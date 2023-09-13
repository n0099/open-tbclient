package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class bb {
    public static int a(ba baVar, hn hnVar) {
        return baVar.a(hnVar, bc.a[hnVar.ordinal()] != 1 ? 0 : 1);
    }

    public static List<Pair<Integer, Object>> a(List<hs> list, boolean z) {
        if (com.xiaomi.push.ad.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hs hsVar : list) {
            int a = hsVar.a();
            ho a2 = ho.a(hsVar.b());
            if (a2 != null) {
                if (z && hsVar.f514a) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    int i = bc.b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(hsVar.g())) : new Pair(Integer.valueOf(a), hsVar.m571a()) : new Pair(Integer.valueOf(a), Long.valueOf(hsVar.m570a())) : new Pair(Integer.valueOf(a), Integer.valueOf(hsVar.c())));
                }
            }
        }
        return arrayList;
    }

    public static void a(ba baVar, ie ieVar) {
        baVar.a(a(ieVar.a(), true));
        baVar.b();
    }

    public static void a(ba baVar, Cif cif) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (hq hqVar : cif.a()) {
            arrayList.add(new Pair<>(hqVar.m566a(), Integer.valueOf(hqVar.a())));
            List<Pair<Integer, Object>> a = a(hqVar.f506a, false);
            if (!com.xiaomi.push.ad.a(a)) {
                arrayList2.addAll(a);
            }
        }
        baVar.a(arrayList, arrayList2);
        baVar.b();
    }
}
