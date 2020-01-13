package tv.chushou.basis.rxjava.thread;

import io.reactivex.a.b.a;
import io.reactivex.v;
/* loaded from: classes4.dex */
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
                return a.dHX();
            case NEW_THREAD:
                return io.reactivex.f.a.dID();
            case IO:
                return io.reactivex.f.a.dIB();
            case COMPUTATION:
                return io.reactivex.f.a.dIA();
            case TRAMPOLINE:
                return io.reactivex.f.a.dIC();
            case SINGLE:
                return io.reactivex.f.a.dIE();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.a(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.dHX();
        }
    }
}
