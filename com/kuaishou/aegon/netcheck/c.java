package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes4.dex */
final /* synthetic */ class c implements Runnable {
    private final String c;
    private final NetcheckTaskListenerWrapper pNR;
    private final EnumSet pNS;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.pNR = netcheckTaskListenerWrapper;
        this.pNS = enumSet;
        this.c = str;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNR.pNQ.a(this.pNS, this.c);
    }
}
