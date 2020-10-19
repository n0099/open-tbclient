package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class al {
    public static int a(ak akVar, hs hsVar) {
        int i = 0;
        String a2 = a(hsVar);
        switch (hsVar) {
            case MISC_CONFIG:
                i = 1;
                break;
        }
        return akVar.f847a.getInt(a2, i);
    }

    private static String a(hs hsVar) {
        return "oc_version_" + hsVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<hx> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.ad.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hx hxVar : list) {
            int a2 = hxVar.a();
            ht a3 = ht.a(hxVar.b());
            if (a3 != null) {
                if (z && hxVar.f483a) {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                } else {
                    switch (a3) {
                        case INT:
                            pair = new Pair(Integer.valueOf(a2), Integer.valueOf(hxVar.c()));
                            break;
                        case LONG:
                            pair = new Pair(Integer.valueOf(a2), Long.valueOf(hxVar.m363a()));
                            break;
                        case STRING:
                            pair = new Pair(Integer.valueOf(a2), hxVar.m364a());
                            break;
                        case BOOLEAN:
                            pair = new Pair(Integer.valueOf(a2), Boolean.valueOf(hxVar.g()));
                            break;
                        default:
                            pair = null;
                            break;
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }

    public static void a(ak akVar, hs hsVar, int i) {
        akVar.f847a.edit().putInt(a(hsVar), i).commit();
    }

    public static void a(ak akVar, ij ijVar) {
        akVar.b(a(ijVar.a(), true));
        akVar.b();
    }

    public static void a(ak akVar, ik ikVar) {
        for (hv hvVar : ikVar.a()) {
            if (hvVar.a() > a(akVar, hvVar.m359a())) {
                a(akVar, hvVar.m359a(), hvVar.a());
                akVar.a(a(hvVar.f475a, false));
            }
        }
        akVar.b();
    }
}
