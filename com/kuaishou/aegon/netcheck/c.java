package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes3.dex */
final /* synthetic */ class c implements Runnable {
    private final String c;
    private final NetcheckTaskListenerWrapper pYv;
    private final EnumSet pYw;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.pYv = netcheckTaskListenerWrapper;
        this.pYw = enumSet;
        this.c = str;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYv.pYu.a(this.pYw, this.c);
    }
}
