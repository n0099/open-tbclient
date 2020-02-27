package tv.chushou.basis.rxjava.thread;

import io.reactivex.a.b.a;
import io.reactivex.v;
/* loaded from: classes5.dex */
public enum EventThread {
    MAIN_THREAD,
    NEW_THREAD,
    IO,
    COMPUTATION,
    TRAMPOLINE,
    SINGLE,
    EXECUTOR,
    HANDLER;

    public static v getScheduler(EventThread eventThread) {
        switch (eventThread) {
            case MAIN_THREAD:
                return a.dJg();
            case NEW_THREAD:
                return io.reactivex.f.a.dJM();
            case IO:
                return io.reactivex.f.a.dJK();
            case COMPUTATION:
                return io.reactivex.f.a.dJJ();
            case TRAMPOLINE:
                return io.reactivex.f.a.dJL();
            case SINGLE:
                return io.reactivex.f.a.dJN();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.a(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.dJg();
        }
    }
}
