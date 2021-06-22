package com.kuaishou.aegon;

import com.kuaishou.aegon.a.a;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$6 implements a.InterfaceC0356a {
    public static final Aegon$$Lambda$6 instance = new Aegon$$Lambda$6();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getHttpCacheUsedBytes():long] */
    public static a.InterfaceC0356a lambdaFactory$() {
        return instance;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0356a
    public Object get() {
        return Long.valueOf(Aegon.nativeGetHttpCacheUsedBytes());
    }
}
