package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hr;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ah {
    public static int a(ag agVar, hm hmVar) {
        int i = 0;
        String a = a(hmVar);
        switch (hmVar) {
            case MISC_CONFIG:
                i = 1;
                break;
        }
        return agVar.f851a.getInt(a, i);
    }

    private static String a(hm hmVar) {
        return "oc_version_" + hmVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<hr> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.ad.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hr hrVar : list) {
            int a = hrVar.a();
            hn a2 = hn.a(hrVar.b());
            if (a2 != null) {
                if (z && hrVar.f500a) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    switch (a2) {
                        case INT:
                            pair = new Pair(Integer.valueOf(a), Integer.valueOf(hrVar.c()));
                            break;
                        case LONG:
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(hrVar.m337a()));
                            break;
                        case STRING:
                            pair = new Pair(Integer.valueOf(a), hrVar.m338a());
                            break;
                        case BOOLEAN:
                            pair = new Pair(Integer.valueOf(a), Boolean.valueOf(hrVar.g()));
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

    public static void a(ag agVar, hm hmVar, int i) {
        agVar.f851a.edit().putInt(a(hmVar), i).commit();
    }

    public static void a(ag agVar, id idVar) {
        agVar.b(a(idVar.a(), true));
        agVar.b();
    }

    public static void a(ag agVar, ie ieVar) {
        for (hp hpVar : ieVar.a()) {
            if (hpVar.a() > a(agVar, hpVar.m333a())) {
                a(agVar, hpVar.m333a(), hpVar.a());
                agVar.a(a(hpVar.f492a, false));
            }
        }
        agVar.b();
    }
}
