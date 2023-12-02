package com.yy.transvod.preference;

import com.baidu.tieba.alc;
import com.baidu.tieba.nkc;
import com.baidu.tieba.phc;
import com.baidu.tieba.rkc;
import com.baidu.tieba.skc;
import com.baidu.tieba.tkc;
import com.baidu.tieba.wkc;
import com.baidu.tieba.xkc;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class Preference {
    public static tkc a;
    public static xkc b;
    public static phc c;
    public static wkc d;
    public static skc e;
    public static rkc f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static rkc a() {
        return f;
    }

    public static tkc b() {
        return a;
    }

    public static phc c() {
        return c;
    }

    public static wkc d() {
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
        return alc.v.get();
    }

    public static void i(rkc rkcVar) {
        f = rkcVar;
    }

    public static void j(skc skcVar) {
        e = skcVar;
        TLog.j(skcVar);
    }

    public static void l(xkc xkcVar) {
        b = xkcVar;
        nkc.a(xkcVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        alc.n().u(hashMap);
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
