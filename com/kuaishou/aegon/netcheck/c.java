package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final String c;
    private final NetcheckTaskListenerWrapper pQI;
    private final EnumSet pQJ;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.pQI = netcheckTaskListenerWrapper;
        this.pQJ = enumSet;
        this.c = str;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pQI.pQH.a(this.pQJ, this.c);
    }
}
