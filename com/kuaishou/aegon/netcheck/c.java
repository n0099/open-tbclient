package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final String c;
    private final NetcheckTaskListenerWrapper pSq;
    private final EnumSet pSr;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.pSq = netcheckTaskListenerWrapper;
        this.pSr = enumSet;
        this.c = str;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pSq.pSp.a(this.pSr, this.c);
    }
}
