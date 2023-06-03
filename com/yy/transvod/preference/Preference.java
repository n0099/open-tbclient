package com.yy.transvod.preference;

import com.baidu.tieba.bjb;
import com.baidu.tieba.cjb;
import com.baidu.tieba.fjb;
import com.baidu.tieba.sib;
import com.baidu.tieba.ufb;
import com.baidu.tieba.wib;
import com.baidu.tieba.xib;
import com.baidu.tieba.yib;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static yib a;
    public static cjb b;
    public static ufb c;
    public static bjb d;
    public static xib e;
    public static wib f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static wib a() {
        return f;
    }

    public static yib b() {
        return a;
    }

    public static ufb c() {
        return c;
    }

    public static bjb d() {
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
        return fjb.v.get();
    }

    public static void i(wib wibVar) {
        f = wibVar;
    }

    public static void j(xib xibVar) {
        e = xibVar;
        TLog.j(xibVar);
    }

    public static void l(cjb cjbVar) {
        b = cjbVar;
        sib.a(cjbVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        fjb.n().u(hashMap);
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
