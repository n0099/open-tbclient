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
                return a.dKM();
            case NEW_THREAD:
                return io.reactivex.f.a.dLt();
            case IO:
                return io.reactivex.f.a.dLr();
            case COMPUTATION:
                return io.reactivex.f.a.dLq();
            case TRAMPOLINE:
                return io.reactivex.f.a.dLs();
            case SINGLE:
                return io.reactivex.f.a.dLu();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.a(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.dKM();
        }
    }
}
