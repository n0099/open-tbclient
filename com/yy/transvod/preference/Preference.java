package com.yy.transvod.preference;

import com.baidu.tieba.b1c;
import com.baidu.tieba.d4c;
import com.baidu.tieba.e4c;
import com.baidu.tieba.f4c;
import com.baidu.tieba.i4c;
import com.baidu.tieba.j4c;
import com.baidu.tieba.m4c;
import com.baidu.tieba.z3c;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static f4c a;
    public static j4c b;
    public static b1c c;
    public static i4c d;
    public static e4c e;
    public static d4c f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static d4c a() {
        return f;
    }

    public static f4c b() {
        return a;
    }

    public static b1c c() {
        return c;
    }

    public static i4c d() {
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
        return m4c.v.get();
    }

    public static void i(d4c d4cVar) {
        f = d4cVar;
    }

    public static void j(e4c e4cVar) {
        e = e4cVar;
        TLog.j(e4cVar);
    }

    public static void l(j4c j4cVar) {
        b = j4cVar;
        z3c.a(j4cVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        m4c.n().u(hashMap);
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
