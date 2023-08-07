package com.yy.transvod.preference;

import com.baidu.tieba.hxb;
import com.baidu.tieba.jub;
import com.baidu.tieba.lxb;
import com.baidu.tieba.mxb;
import com.baidu.tieba.nxb;
import com.baidu.tieba.qxb;
import com.baidu.tieba.rxb;
import com.baidu.tieba.uxb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static nxb a;
    public static rxb b;
    public static jub c;
    public static qxb d;
    public static mxb e;
    public static lxb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static lxb a() {
        return f;
    }

    public static nxb b() {
        return a;
    }

    public static jub c() {
        return c;
    }

    public static qxb d() {
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
        return uxb.v.get();
    }

    public static void i(lxb lxbVar) {
        f = lxbVar;
    }

    public static void j(mxb mxbVar) {
        e = mxbVar;
        TLog.j(mxbVar);
    }

    public static void l(rxb rxbVar) {
        b = rxbVar;
        hxb.a(rxbVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        uxb.n().u(hashMap);
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
