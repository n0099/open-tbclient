package com.yy.transvod.preference;

import com.baidu.tieba.a3c;
import com.baidu.tieba.b3c;
import com.baidu.tieba.e3c;
import com.baidu.tieba.r2c;
import com.baidu.tieba.tzb;
import com.baidu.tieba.v2c;
import com.baidu.tieba.w2c;
import com.baidu.tieba.x2c;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static x2c a;
    public static b3c b;
    public static tzb c;
    public static a3c d;
    public static w2c e;
    public static v2c f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static v2c a() {
        return f;
    }

    public static x2c b() {
        return a;
    }

    public static tzb c() {
        return c;
    }

    public static a3c d() {
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
        return e3c.v.get();
    }

    public static void i(v2c v2cVar) {
        f = v2cVar;
    }

    public static void j(w2c w2cVar) {
        e = w2cVar;
        TLog.j(w2cVar);
    }

    public static void l(b3c b3cVar) {
        b = b3cVar;
        r2c.a(b3cVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        e3c.n().u(hashMap);
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
