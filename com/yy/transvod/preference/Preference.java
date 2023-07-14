package com.yy.transvod.preference;

import com.baidu.tieba.eyb;
import com.baidu.tieba.gvb;
import com.baidu.tieba.iyb;
import com.baidu.tieba.jyb;
import com.baidu.tieba.kyb;
import com.baidu.tieba.nyb;
import com.baidu.tieba.oyb;
import com.baidu.tieba.ryb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static kyb a;
    public static oyb b;
    public static gvb c;
    public static nyb d;
    public static jyb e;
    public static iyb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static iyb a() {
        return f;
    }

    public static kyb b() {
        return a;
    }

    public static gvb c() {
        return c;
    }

    public static nyb d() {
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
        return ryb.v.get();
    }

    public static void i(iyb iybVar) {
        f = iybVar;
    }

    public static void j(jyb jybVar) {
        e = jybVar;
        TLog.j(jybVar);
    }

    public static void l(oyb oybVar) {
        b = oybVar;
        eyb.a(oybVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        ryb.n().u(hashMap);
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
