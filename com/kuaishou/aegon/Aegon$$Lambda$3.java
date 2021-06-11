package com.kuaishou.aegon;

import com.kuaishou.aegon.a.a;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$3 implements a.InterfaceC0353a {
    public static final Aegon$$Lambda$3 instance = new Aegon$$Lambda$3();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getEffectiveConfig():java.lang.String] */
    public static a.InterfaceC0353a lambdaFactory$() {
        return instance;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0353a
    public Object get() {
        return Aegon.nativeGetEffectiveConfig();
    }
}
