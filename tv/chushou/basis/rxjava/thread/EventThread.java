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
                return a.dKy();
            case NEW_THREAD:
                return io.reactivex.f.a.dLf();
            case IO:
                return io.reactivex.f.a.dLd();
            case COMPUTATION:
                return io.reactivex.f.a.dLc();
            case TRAMPOLINE:
                return io.reactivex.f.a.dLe();
            case SINGLE:
                return io.reactivex.f.a.dLg();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.a(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.dKy();
        }
    }
}
