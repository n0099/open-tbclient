package com.yy.transvod.preference;

import com.baidu.tieba.b4c;
import com.baidu.tieba.c4c;
import com.baidu.tieba.d4c;
import com.baidu.tieba.g4c;
import com.baidu.tieba.h4c;
import com.baidu.tieba.k4c;
import com.baidu.tieba.x3c;
import com.baidu.tieba.z0c;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static d4c a;
    public static h4c b;
    public static z0c c;
    public static g4c d;
    public static c4c e;
    public static b4c f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static b4c a() {
        return f;
    }

    public static d4c b() {
        return a;
    }

    public static z0c c() {
        return c;
    }

    public static g4c d() {
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
        return k4c.v.get();
    }

    public static void i(b4c b4cVar) {
        f = b4cVar;
    }

    public static void j(c4c c4cVar) {
        e = c4cVar;
        TLog.j(c4cVar);
    }

    public static void l(h4c h4cVar) {
        b = h4cVar;
        x3c.a(h4cVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        k4c.n().u(hashMap);
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
