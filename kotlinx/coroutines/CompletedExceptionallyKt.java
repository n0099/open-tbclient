package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\b\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a0\u0010\b\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "state", "Lkotlin/coroutines/Continuation;", "uCont", "Lkotlin/Result;", "recoverResult", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "caller", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class CompletedExceptionallyKt {
    public static final Object recoverResult(Object obj, Continuation continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.Companion;
            Throwable th = ((CompletedExceptionally) obj).cause;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
            }
            return Result.m698constructorimpl(ResultKt.createFailure(th));
        }
        Result.Companion companion2 = Result.Companion;
        return Result.m698constructorimpl(obj);
    }

    public static final Object toState(Object obj, CancellableContinuation cancellableContinuation) {
        Throwable m701exceptionOrNullimpl = Result.m701exceptionOrNullimpl(obj);
        if (m701exceptionOrNullimpl != null) {
            if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                m701exceptionOrNullimpl = StackTraceRecoveryKt.access$recoverFromStackFrame(m701exceptionOrNullimpl, (CoroutineStackFrame) cancellableContinuation);
            }
            return new CompletedExceptionally(m701exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static final Object toState(Object obj) {
        Throwable m701exceptionOrNullimpl = Result.m701exceptionOrNullimpl(obj);
        if (m701exceptionOrNullimpl != null) {
            return new CompletedExceptionally(m701exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }
}
