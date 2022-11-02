package kotlinx.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0082\b¢\u0006\u0004\b\u0007\u0010\b\u001a@\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aT\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000e\u001a@\u0010\u000f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001aT\u0010\u000f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a[\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\r\u001a\u00028\u00012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a[\u0010\u0014\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\r\u001a\u00028\u00012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001aF\u0010\u001a\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00032\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018H\u0082\b¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/Function1;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", "startDirect", "(Lkotlin/coroutines/Continuation;Lkotlin/Function1;)V", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "startUndispatchedOrReturn", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "undispatchedResult", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Lkotlin/Function1;Lkotlin/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            if (function1 != null) {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m698constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m698constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
            if (completedExceptionally == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
            if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
                Continuation<? super T> continuation = scopeCoroutine.uCont;
                if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) {
                    throw th2;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(th2, (CoroutineStackFrame) continuation);
            }
            return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
        }
        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (function1 != null) {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m698constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m698constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T> void startDirect(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            Object invoke = function1.invoke(probeCoroutineCreated);
            if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                probeCoroutineCreated.resumeWith(Result.m698constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        boolean z = false;
        try {
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
            if (completedExceptionally == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
            if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
                Throwable th2 = completedExceptionally2.cause;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == scopeCoroutine) ? true : true) {
                    Throwable th3 = completedExceptionally2.cause;
                    Continuation<? super T> continuation = scopeCoroutine.uCont;
                    if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) {
                        throw th3;
                    }
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(th3, (CoroutineStackFrame) continuation);
                } else if (completedExceptionally instanceof CompletedExceptionally) {
                    Throwable th4 = ((CompletedExceptionally) completedExceptionally).cause;
                    Continuation<? super T> continuation2 = scopeCoroutine.uCont;
                    if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation2 instanceof CoroutineStackFrame)) {
                        throw th4;
                    }
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(th4, (CoroutineStackFrame) continuation2);
                } else {
                    return completedExceptionally;
                }
            }
            return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
        }
        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final <T> Object undispatchedResult(ScopeCoroutine<? super T> scopeCoroutine, Function1<? super Throwable, Boolean> function1, Function0<? extends Object> function0) {
        Object completedExceptionally;
        try {
            completedExceptionally = function0.invoke();
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
        if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
            if (function1.invoke(completedExceptionally2.cause).booleanValue()) {
                Throwable th2 = completedExceptionally2.cause;
                Continuation<? super T> continuation = scopeCoroutine.uCont;
                if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) {
                    throw th2;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(th2, (CoroutineStackFrame) continuation);
            } else if (completedExceptionally instanceof CompletedExceptionally) {
                Throwable th3 = ((CompletedExceptionally) completedExceptionally).cause;
                Continuation<? super T> continuation2 = scopeCoroutine.uCont;
                if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation2 instanceof CoroutineStackFrame)) {
                    throw th3;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(th3, (CoroutineStackFrame) continuation2);
            } else {
                return completedExceptionally;
            }
        }
        return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
    }
}
