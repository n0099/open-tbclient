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
                return a.dSS();
            case NEW_THREAD:
                return io.reactivex.f.a.dTz();
            case IO:
                return io.reactivex.f.a.dTx();
            case COMPUTATION:
                return io.reactivex.f.a.dTw();
            case TRAMPOLINE:
                return io.reactivex.f.a.dTy();
            case SINGLE:
                return io.reactivex.f.a.dTA();
            case EXECUTOR:
                return io.reactivex.f.a.a(ThreadHandler.DEFAULT.getExecutor());
            case HANDLER:
                return a.b(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return a.dSS();
        }
    }
}
