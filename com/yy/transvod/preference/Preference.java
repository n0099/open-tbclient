package com.yy.transvod.preference;

import com.baidu.tieba.bjb;
import com.baidu.tieba.cjb;
import com.baidu.tieba.djb;
import com.baidu.tieba.gjb;
import com.baidu.tieba.hjb;
import com.baidu.tieba.kjb;
import com.baidu.tieba.xib;
import com.baidu.tieba.zfb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static djb a;
    public static hjb b;
    public static zfb c;
    public static gjb d;
    public static cjb e;
    public static bjb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static bjb a() {
        return f;
    }

    public static djb b() {
        return a;
    }

    public static zfb c() {
        return c;
    }

    public static gjb d() {
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
        return kjb.v.get();
    }

    public static void i(bjb bjbVar) {
        f = bjbVar;
    }

    public static void j(cjb cjbVar) {
        e = cjbVar;
        TLog.j(cjbVar);
    }

    public static void l(hjb hjbVar) {
        b = hjbVar;
        xib.a(hjbVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        kjb.n().u(hashMap);
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
