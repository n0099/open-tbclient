package com.yy.transvod.preference;

import com.baidu.tieba.blc;
import com.baidu.tieba.okc;
import com.baidu.tieba.qhc;
import com.baidu.tieba.skc;
import com.baidu.tieba.tkc;
import com.baidu.tieba.ukc;
import com.baidu.tieba.xkc;
import com.baidu.tieba.ykc;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class Preference {
    public static ukc a;
    public static ykc b;
    public static qhc c;
    public static xkc d;
    public static tkc e;
    public static skc f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static skc a() {
        return f;
    }

    public static ukc b() {
        return a;
    }

    public static qhc c() {
        return c;
    }

    public static xkc d() {
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
        return blc.v.get();
    }

    public static void i(skc skcVar) {
        f = skcVar;
    }

    public static void j(tkc tkcVar) {
        e = tkcVar;
        TLog.j(tkcVar);
    }

    public static void l(ykc ykcVar) {
        b = ykcVar;
        okc.a(ykcVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        blc.n().u(hashMap);
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
