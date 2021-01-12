package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes4.dex */
final /* synthetic */ class c implements Runnable {
    private final String c;
    private final NetcheckTaskListenerWrapper pNQ;
    private final EnumSet pNR;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.pNQ = netcheckTaskListenerWrapper;
        this.pNR = enumSet;
        this.c = str;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNQ.pNP.a(this.pNR, this.c);
    }
}
