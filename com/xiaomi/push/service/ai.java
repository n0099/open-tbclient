package com.xiaomi.push.service;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ai {
    public static int a(ah ahVar, com.xiaomi.xmpush.thrift.f fVar) {
        int i = 0;
        String a = a(fVar);
        switch (fVar) {
            case MISC_CONFIG:
                i = 1;
                break;
        }
        return ahVar.a.getInt(a, i);
    }

    private static String a(com.xiaomi.xmpush.thrift.f fVar) {
        return "oc_version_" + fVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<com.xiaomi.xmpush.thrift.p> list, boolean z) {
        Pair pair;
        if (com.xiaomi.channel.commonutils.misc.b.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.xiaomi.xmpush.thrift.p pVar : list) {
            int a = pVar.a();
            com.xiaomi.xmpush.thrift.g a2 = com.xiaomi.xmpush.thrift.g.a(pVar.c());
            if (a2 != null) {
                if (z && pVar.c) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    switch (a2) {
                        case INT:
                            pair = new Pair(Integer.valueOf(a), Integer.valueOf(pVar.f()));
                            break;
                        case LONG:
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(pVar.h()));
                            break;
                        case STRING:
                            pair = new Pair(Integer.valueOf(a), pVar.j());
                            break;
                        case BOOLEAN:
                            pair = new Pair(Integer.valueOf(a), Boolean.valueOf(pVar.l()));
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

    public static void a(ah ahVar, com.xiaomi.xmpush.thrift.ac acVar) {
        ahVar.b(a(acVar.a(), true));
    }

    public static void a(ah ahVar, com.xiaomi.xmpush.thrift.ad adVar) {
        for (com.xiaomi.xmpush.thrift.n nVar : adVar.a()) {
            if (nVar.a() > a(ahVar, nVar.d())) {
                a(ahVar, nVar.d(), nVar.a());
                ahVar.a(a(nVar.b, false));
            }
        }
    }

    public static void a(ah ahVar, com.xiaomi.xmpush.thrift.f fVar, int i) {
        ahVar.a.edit().putInt(a(fVar), i).commit();
    }
}
