package com.yy.transvod.preference;

import com.baidu.tieba.bgc;
import com.baidu.tieba.cgc;
import com.baidu.tieba.fgc;
import com.baidu.tieba.sfc;
import com.baidu.tieba.ucc;
import com.baidu.tieba.wfc;
import com.baidu.tieba.xfc;
import com.baidu.tieba.yfc;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static yfc a;
    public static cgc b;
    public static ucc c;
    public static bgc d;
    public static xfc e;
    public static wfc f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static wfc a() {
        return f;
    }

    public static yfc b() {
        return a;
    }

    public static ucc c() {
        return c;
    }

    public static bgc d() {
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
        return fgc.v.get();
    }

    public static void i(wfc wfcVar) {
        f = wfcVar;
    }

    public static void j(xfc xfcVar) {
        e = xfcVar;
        TLog.j(xfcVar);
    }

    public static void l(cgc cgcVar) {
        b = cgcVar;
        sfc.a(cgcVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        fgc.n().u(hashMap);
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
