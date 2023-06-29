package com.yy.transvod.preference;

import com.baidu.tieba.hpb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.lpb;
import com.baidu.tieba.mpb;
import com.baidu.tieba.npb;
import com.baidu.tieba.qpb;
import com.baidu.tieba.rpb;
import com.baidu.tieba.upb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static npb a;
    public static rpb b;
    public static jmb c;
    public static qpb d;
    public static mpb e;
    public static lpb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static lpb a() {
        return f;
    }

    public static npb b() {
        return a;
    }

    public static jmb c() {
        return c;
    }

    public static qpb d() {
        return d;
    }

    public static int e() {
        return i.getAndAdd(1);
    }

    public static boolean f() {
        return g;
    }

    public static boolean g() {
        return h;
    }

    public static boolean h() {
        return upb.v.get();
    }

    public static void i(lpb lpbVar) {
        f = lpbVar;
    }

    public static void j(mpb mpbVar) {
        e = mpbVar;
        TLog.j(mpbVar);
    }

    public static void l(rpb rpbVar) {
        b = rpbVar;
        hpb.a(rpbVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        upb.n().u(hashMap);
        StringBuilder sb = new StringBuilder("mediaConfig:");
        for (String str : hashMap.keySet()) {
            sb.append(" ");
            sb.append(str);
            sb.append("-");
            sb.append(hashMap.get(str));
        }
        TLog.d("[vod-java]", sb.toString());
        nativeSetMediaConfig(hashMap);
    }
}
