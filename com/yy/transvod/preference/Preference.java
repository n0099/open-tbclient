package com.yy.transvod.preference;

import com.baidu.tieba.cgc;
import com.baidu.tieba.dgc;
import com.baidu.tieba.ggc;
import com.baidu.tieba.tfc;
import com.baidu.tieba.vcc;
import com.baidu.tieba.xfc;
import com.baidu.tieba.yfc;
import com.baidu.tieba.zfc;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static zfc a;
    public static dgc b;
    public static vcc c;
    public static cgc d;
    public static yfc e;
    public static xfc f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static xfc a() {
        return f;
    }

    public static zfc b() {
        return a;
    }

    public static vcc c() {
        return c;
    }

    public static cgc d() {
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
        return ggc.v.get();
    }

    public static void i(xfc xfcVar) {
        f = xfcVar;
    }

    public static void j(yfc yfcVar) {
        e = yfcVar;
        TLog.j(yfcVar);
    }

    public static void l(dgc dgcVar) {
        b = dgcVar;
        tfc.a(dgcVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        ggc.n().u(hashMap);
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
