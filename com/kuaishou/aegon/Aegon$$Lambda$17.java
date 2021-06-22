package com.kuaishou.aegon;

import com.kuaishou.aegon.a.a;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$17 implements a.InterfaceC0356a {
    public static final Aegon$$Lambda$17 instance = new Aegon$$Lambda$17();

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getPublicIP():java.lang.String] */
    public static a.InterfaceC0356a lambdaFactory$() {
        return instance;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0356a
    public Object get() {
        String nativeGetPublicIP;
        nativeGetPublicIP = Aegon.nativeGetPublicIP();
        return nativeGetPublicIP;
    }
}
