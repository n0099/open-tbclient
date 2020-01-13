package tv.chushou.basis.rxjava;

import tv.chushou.basis.rxjava.thread.ThreadEnforcer;
/* loaded from: classes4.dex */
public class RxBus {
    private static volatile Bus sBus;

    public static Bus get() {
        if (sBus == null) {
            synchronized (RxBus.class) {
                if (sBus == null) {
                    sBus = new Bus(ThreadEnforcer.ANY);
                }
            }
        }
        return sBus;
    }
}
