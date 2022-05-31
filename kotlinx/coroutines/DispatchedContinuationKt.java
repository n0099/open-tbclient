package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aB\u0010\n\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\b0\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\"\u001c\u0010\u0015\u001a\u00020\u00148\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\"\u001c\u0010\u0019\u001a\u00020\u00148\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u0012\u0004\b\u001a\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/DispatchedContinuation;", "", "contState", "", "mode", "", "doYield", "Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "executeUnconfined", "(Lkotlinx/coroutines/DispatchedContinuation;Ljava/lang/Object;IZLkotlin/Function0;)Z", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "(Lkotlinx/coroutines/DispatchedContinuation;)Z", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "UNDEFINED$annotations", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class DispatchedContinuationKt {
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    @JvmField
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static /* synthetic */ void REUSABLE_CLAIMED$annotations() {
    }

    public static /* synthetic */ void UNDEFINED$annotations() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.DispatchedContinuation.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation<? super T>):void, kotlinx.coroutines.DispatchedContinuation.takeState$kotlinx_coroutines_core():java.lang.Object] */
    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }

    public static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, Function0<Unit> function0) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th, null);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }

    public static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th, null);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }

    @InternalCoroutinesApi
    public static final <T> void resumeCancellableWith(Continuation<? super T> continuation, Object obj) {
        boolean z;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object state = CompletedExceptionallyKt.toState(obj);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    Result.Companion companion = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m688constructorimpl(ResultKt.createFailure(cancellationException)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext context = dispatchedContinuation.getContext();
                    Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    dispatchedContinuation.continuation.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CONST, CONST]}, finally: {[CONST, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
