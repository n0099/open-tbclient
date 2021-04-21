package com.kuaishou.aegon;

import com.kuaishou.aegon.a.a;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$12 implements a.InterfaceC0370a {
    public static final Aegon$$Lambda$12 instance = new Aegon$$Lambda$12();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getVersionString():java.lang.String] */
    public static a.InterfaceC0370a lambdaFactory$() {
        return instance;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0370a
    public Object get() {
        return Aegon.nativeGetVersionString();
    }
}
