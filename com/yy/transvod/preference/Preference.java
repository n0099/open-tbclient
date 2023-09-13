package com.yy.transvod.preference;

import com.baidu.tieba.c7c;
import com.baidu.tieba.e4c;
import com.baidu.tieba.g7c;
import com.baidu.tieba.h7c;
import com.baidu.tieba.i7c;
import com.baidu.tieba.l7c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.p7c;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static i7c a;
    public static m7c b;
    public static e4c c;
    public static l7c d;
    public static h7c e;
    public static g7c f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static g7c a() {
        return f;
    }

    public static i7c b() {
        return a;
    }

    public static e4c c() {
        return c;
    }

    public static l7c d() {
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
        return p7c.v.get();
    }

    public static void i(g7c g7cVar) {
        f = g7cVar;
    }

    public static void j(h7c h7cVar) {
        e = h7cVar;
        TLog.j(h7cVar);
    }

    public static void l(m7c m7cVar) {
        b = m7cVar;
        c7c.a(m7cVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        p7c.n().u(hashMap);
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
