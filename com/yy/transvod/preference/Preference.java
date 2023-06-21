package com.yy.transvod.preference;

import com.baidu.tieba.alb;
import com.baidu.tieba.dlb;
import com.baidu.tieba.qkb;
import com.baidu.tieba.shb;
import com.baidu.tieba.ukb;
import com.baidu.tieba.vkb;
import com.baidu.tieba.wkb;
import com.baidu.tieba.zkb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static wkb a;
    public static alb b;
    public static shb c;
    public static zkb d;
    public static vkb e;
    public static ukb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static ukb a() {
        return f;
    }

    public static wkb b() {
        return a;
    }

    public static shb c() {
        return c;
    }

    public static zkb d() {
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
        return dlb.v.get();
    }

    public static void i(ukb ukbVar) {
        f = ukbVar;
    }

    public static void j(vkb vkbVar) {
        e = vkbVar;
        TLog.j(vkbVar);
    }

    public static void l(alb albVar) {
        b = albVar;
        qkb.a(albVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        dlb.n().u(hashMap);
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
