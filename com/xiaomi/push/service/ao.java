package com.xiaomi.push.service;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ao {
    public static int a(an anVar, com.xiaomi.xmpush.thrift.h hVar) {
        int i = 0;
        String a = a(hVar);
        switch (hVar) {
            case MISC_CONFIG:
                i = 1;
                break;
        }
        return anVar.a.getInt(a, i);
    }

    private static String a(com.xiaomi.xmpush.thrift.h hVar) {
        return "oc_version_" + hVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<com.xiaomi.xmpush.thrift.s> list, boolean z) {
        Pair pair;
        if (com.xiaomi.channel.commonutils.misc.c.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.xiaomi.xmpush.thrift.s sVar : list) {
            int a = sVar.a();
            com.xiaomi.xmpush.thrift.i a2 = com.xiaomi.xmpush.thrift.i.a(sVar.c());
            if (a2 != null) {
                if (z && sVar.c) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    switch (a2) {
                        case INT:
                            pair = new Pair(Integer.valueOf(a), Integer.valueOf(sVar.f()));
                            break;
                        case LONG:
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(sVar.h()));
                            break;
                        case STRING:
                            pair = new Pair(Integer.valueOf(a), sVar.j());
                            break;
                        case BOOLEAN:
                            pair = new Pair(Integer.valueOf(a), Boolean.valueOf(sVar.l()));
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

    public static void a(an anVar, com.xiaomi.xmpush.thrift.ag agVar) {
        anVar.b(a(agVar.a(), true));
    }

    public static void a(an anVar, com.xiaomi.xmpush.thrift.ah ahVar) {
        for (com.xiaomi.xmpush.thrift.q qVar : ahVar.a()) {
            if (qVar.a() > a(anVar, qVar.d())) {
                a(anVar, qVar.d(), qVar.a());
                anVar.a(a(qVar.b, false));
            }
        }
    }

    public static void a(an anVar, com.xiaomi.xmpush.thrift.h hVar, int i) {
        anVar.a.edit().putInt(a(hVar), i).commit();
    }
}
