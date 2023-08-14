package com.yy.transvod.preference;

import com.baidu.tieba.ixb;
import com.baidu.tieba.kub;
import com.baidu.tieba.mxb;
import com.baidu.tieba.nxb;
import com.baidu.tieba.oxb;
import com.baidu.tieba.rxb;
import com.baidu.tieba.sxb;
import com.baidu.tieba.vxb;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class Preference {
    public static oxb a;
    public static sxb b;
    public static kub c;
    public static rxb d;
    public static nxb e;
    public static mxb f;
    public static boolean g;
    public static boolean h;
    public static AtomicInteger i = new AtomicInteger(0);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static mxb a() {
        return f;
    }

    public static oxb b() {
        return a;
    }

    public static kub c() {
        return c;
    }

    public static rxb d() {
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
        return vxb.v.get();
    }

    public static void i(mxb mxbVar) {
        f = mxbVar;
    }

    public static void j(nxb nxbVar) {
        e = nxbVar;
        TLog.j(nxbVar);
    }

    public static void l(sxb sxbVar) {
        b = sxbVar;
        ixb.a(sxbVar);
    }

    public static void k(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            TLog.d("[vod-java]", "setMediaConfig fail, configs is null");
        }
        vxb.n().u(hashMap);
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
