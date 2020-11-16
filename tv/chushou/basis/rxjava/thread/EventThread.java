package tv.chushou.basis.rxjava.thread;

import io.reactivex.a.b.a;
import io.reactivex.v;
/* loaded from: classes6.dex */
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
                return a.eAC();
            case NEW_THREAD:
                return io.reactivex.f.a.eBj();
            case IO:
                return io.reactivex.f.a.eBh();
            case COMPUTATION:
                return io.reactivex.f.a.eBg();
            case TRAMPOLINE:
                return io.reactivex.f.a.eBi();
            case SINGLE:
                return io.reactivex.f.a.eBk();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.c(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.eAC();
        }
    }
}
