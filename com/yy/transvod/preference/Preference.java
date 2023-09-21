package com.yy.transvod.preference;

import com.baidu.tieba.a9c;
import com.baidu.tieba.d9c;
import com.baidu.tieba.e9c;
import com.baidu.tieba.h9c;
import com.baidu.tieba.u8c;
import com.baidu.tieba.w5c;
import com.baidu.tieba.y8c;
import com.baidu.tieba.z8c;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static a9c a;
    public static e9c b;
    public static w5c c;
    public static d9c d;
    public static z8c e;
    public static y8c f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static y8c a() {
        return f;
    }

    public static a9c b() {
        return a;
    }

    public static w5c c() {
        return c;
    }

    public static d9c d() {
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
        return h9c.v.get();
    }

    public static void i(y8c y8cVar) {
        f = y8cVar;
    }

    public static void j(z8c z8cVar) {
        e = z8cVar;
        TLog.j(z8cVar);
    }

    public static void l(e9c e9cVar) {
        b = e9cVar;
        u8c.a(e9cVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        h9c.n().u(hashMap);
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
