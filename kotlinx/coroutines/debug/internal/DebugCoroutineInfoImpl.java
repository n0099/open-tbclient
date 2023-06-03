package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010$\u001a\u00020\u000eH\u0016J!\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\u000e2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0002\b)J%\u0010*\u001a\u00020&*\b\u0012\u0004\u0012\u00020\u00150+2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0082Pø\u0001\u0000¢\u0006\u0002\u0010,R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState", "()Ljava/lang/String;", "lastObservedStackTrace", "toString", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class DebugCoroutineInfoImpl {
    public final WeakReference<CoroutineContext> _context;
    public WeakReference<CoroutineStackFrame> _lastObservedFrame;
    public String _state = DebugCoroutineInfoImplKt.CREATED;
    public final StackTraceFrame creationStackBottom;
    @JvmField
    public Thread lastObservedThread;
    @JvmField
    public final long sequenceNumber;

    public DebugCoroutineInfoImpl(CoroutineContext coroutineContext, StackTraceFrame stackTraceFrame, long j) {
        this.creationStackBottom = stackTraceFrame;
        this.sequenceNumber = j;
        this._context = new WeakReference<>(coroutineContext);
    }

    private final List<StackTraceElement> creationStackTrace() {
        StackTraceFrame stackTraceFrame = this.creationStackBottom;
        if (stackTraceFrame == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new DebugCoroutineInfoImpl$creationStackTrace$1(this, stackTraceFrame, null)));
    }

    public final CoroutineContext getContext() {
        return this._context.get();
    }

    public final StackTraceFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return creationStackTrace();
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final String getState() {
        return this._state;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (lastObservedFrame$kotlinx_coroutines_core != null) {
            StackTraceElement stackTraceElement = lastObservedFrame$kotlinx_coroutines_core.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            lastObservedFrame$kotlinx_coroutines_core = lastObservedFrame$kotlinx_coroutines_core.getCallerFrame();
        }
        return arrayList;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + getState() + ",context=" + getContext() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004a -> B:26:0x0062). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005c -> B:25:0x005f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object yieldFrames(SequenceScope<? super StackTraceElement> sequenceScope, CoroutineStackFrame coroutineStackFrame, Continuation<? super Unit> continuation) {
        DebugCoroutineInfoImpl$yieldFrames$1 debugCoroutineInfoImpl$yieldFrames$1;
        int i;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl;
        if (continuation instanceof DebugCoroutineInfoImpl$yieldFrames$1) {
            debugCoroutineInfoImpl$yieldFrames$1 = (DebugCoroutineInfoImpl$yieldFrames$1) continuation;
            int i2 = debugCoroutineInfoImpl$yieldFrames$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                debugCoroutineInfoImpl$yieldFrames$1.label = i2 - Integer.MIN_VALUE;
                Object obj = debugCoroutineInfoImpl$yieldFrames$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = debugCoroutineInfoImpl$yieldFrames$1.label;
                if (i == 0) {
                    if (i == 1) {
                        CoroutineStackFrame coroutineStackFrame2 = (CoroutineStackFrame) debugCoroutineInfoImpl$yieldFrames$1.L$2;
                        SequenceScope<? super StackTraceElement> sequenceScope2 = (SequenceScope) debugCoroutineInfoImpl$yieldFrames$1.L$1;
                        debugCoroutineInfoImpl = (DebugCoroutineInfoImpl) debugCoroutineInfoImpl$yieldFrames$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        SequenceScope<? super StackTraceElement> sequenceScope3 = sequenceScope2;
                        coroutineStackFrame = coroutineStackFrame2;
                        sequenceScope = sequenceScope3;
                        coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                        if (coroutineStackFrame == null) {
                            return Unit.INSTANCE;
                        }
                        if (coroutineStackFrame == null) {
                            StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
                            if (stackTraceElement != null) {
                                debugCoroutineInfoImpl$yieldFrames$1.L$0 = debugCoroutineInfoImpl;
                                debugCoroutineInfoImpl$yieldFrames$1.L$1 = sequenceScope;
                                debugCoroutineInfoImpl$yieldFrames$1.L$2 = coroutineStackFrame;
                                debugCoroutineInfoImpl$yieldFrames$1.label = 1;
                                if (sequenceScope.yield(stackTraceElement, debugCoroutineInfoImpl$yieldFrames$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                CoroutineStackFrame coroutineStackFrame3 = coroutineStackFrame;
                                sequenceScope2 = sequenceScope;
                                coroutineStackFrame2 = coroutineStackFrame3;
                                SequenceScope<? super StackTraceElement> sequenceScope32 = sequenceScope2;
                                coroutineStackFrame = coroutineStackFrame2;
                                sequenceScope = sequenceScope32;
                            }
                            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                            if (coroutineStackFrame == null) {
                            }
                            if (coroutineStackFrame == null) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    debugCoroutineInfoImpl = this;
                    if (coroutineStackFrame == null) {
                    }
                }
            }
        }
        debugCoroutineInfoImpl$yieldFrames$1 = new DebugCoroutineInfoImpl$yieldFrames$1(this, continuation);
        Object obj2 = debugCoroutineInfoImpl$yieldFrames$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = debugCoroutineInfoImpl$yieldFrames$1.label;
        if (i == 0) {
        }
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame coroutineStackFrame) {
        WeakReference<CoroutineStackFrame> weakReference;
        if (coroutineStackFrame == null) {
            weakReference = null;
        } else {
            weakReference = new WeakReference<>(coroutineStackFrame);
        }
        this._lastObservedFrame = weakReference;
    }

    public final void updateState$kotlinx_coroutines_core(String str, Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame;
        if (Intrinsics.areEqual(this._state, str) && Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.SUSPENDED) && getLastObservedFrame$kotlinx_coroutines_core() != null) {
            return;
        }
        this._state = str;
        Thread thread = null;
        if (continuation instanceof CoroutineStackFrame) {
            coroutineStackFrame = (CoroutineStackFrame) continuation;
        } else {
            coroutineStackFrame = null;
        }
        setLastObservedFrame$kotlinx_coroutines_core(coroutineStackFrame);
        if (Intrinsics.areEqual(str, "RUNNING")) {
            thread = Thread.currentThread();
        }
        this.lastObservedThread = thread;
    }
}
