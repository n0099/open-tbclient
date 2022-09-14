package kotlinx.coroutines.internal;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a;\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\tH\u0002¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\t2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a3\u0010\u0016\u001a\u00020\u00152\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\u00132\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0005H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a.\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030 H\u0080\b¢\u0006\u0004\b\u001e\u0010!\u001a\"\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\"\u0010\u001f\u001a!\u0010#\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b#\u0010\u001f\u001a3\u0010%\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\u00130$\"\b\b\u0000\u0010\u0006*\u00020\u0005*\u00028\u0000H\u0002¢\u0006\u0004\b%\u0010&\u001a#\u0010)\u001a\u00020(*\u00060\u0002j\u0002`\n2\n\u0010'\u001a\u00060\u0002j\u0002`\nH\u0002¢\u0006\u0004\b)\u0010*\u001a%\u0010-\u001a\u00020,*\f\u0012\b\u0012\u00060\u0002j\u0002`\n0\u00132\u0006\u0010+\u001a\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010.\u001a\u001b\u0010/\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020(*\u00060\u0002j\u0002`\nH\u0000¢\u0006\u0004\b1\u00102\u001a\u001d\u00103\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\u00028\u0000H\u0002¢\u0006\u0004\b3\u0010\u001f\"\u0016\u00104\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u001e\u00107\u001a\n 6*\u0004\u0018\u00010\u00000\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00105\"\u0016\u00108\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00105\"\u001e\u00109\u001a\n 6*\u0004\u0018\u00010\u00000\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00105*\f\b\u0000\u0010:\"\u00020\u000e2\u00020\u000e*\f\b\u0000\u0010;\"\u00020\u00022\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"", "message", "Ljava/lang/StackTraceElement;", "artificialFrame", "(Ljava/lang/String;)Ljava/lang/StackTraceElement;", "", "E", "cause", TiebaStatic.LogFields.RESULT, "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "createFinalException", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "continuation", "createStackTrace", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;", "", "recoveredStacktrace", "", "mergeRecoveredTraces", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "exception", "", "recoverAndThrow", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "Lkotlin/Pair;", "causeAndStacktrace", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "e", "", "elementWiseEquals", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "methodName", "", "frameIndex", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "isArtificial", "(Ljava/lang/StackTraceElement;)Z", "sanitizeStackTrace", "baseContinuationImplClass", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "baseContinuationImplClassName", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class StackTraceRecoveryKt {
    public static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    public static final String baseContinuationImplClassName;
    public static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    public static final String stackTraceRecoveryClassName;

    static {
        Object m699constructorimpl;
        Object m699constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            m699constructorimpl = Result.m699constructorimpl(Class.forName(baseContinuationImplClass).getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m699constructorimpl = Result.m699constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m702exceptionOrNullimpl(m699constructorimpl) != null) {
            m699constructorimpl = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String) m699constructorimpl;
        try {
            Result.Companion companion3 = Result.Companion;
            m699constructorimpl2 = Result.m699constructorimpl(Class.forName(stackTraceRecoveryClass).getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m699constructorimpl2 = Result.m699constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m702exceptionOrNullimpl(m699constructorimpl2) != null) {
            m699constructorimpl2 = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String) m699constructorimpl2;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.CancellableContinuationImpl.getResult():java.lang.Object, kotlinx.coroutines.CompletedExceptionallyKt.recoverResult(java.lang.Object, kotlin.coroutines.Continuation<? super T>):java.lang.Object, kotlinx.coroutines.CompletedExceptionallyKt.toState(java.lang.Object, kotlinx.coroutines.CancellableContinuation<?>):java.lang.Object, kotlinx.coroutines.DispatchedTask.run():void, kotlinx.coroutines.JobSupport.awaitInternal$kotlinx_coroutines_core(kotlin.coroutines.Continuation<java.lang.Object>):java.lang.Object, kotlinx.coroutines.intrinsics.UndispatchedKt.startUndispatchedOrReturn(kotlinx.coroutines.internal.ScopeCoroutine<? super T>, R, kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>):java.lang.Object, kotlinx.coroutines.intrinsics.UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(kotlinx.coroutines.internal.ScopeCoroutine<? super T>, R, kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>):java.lang.Object, kotlinx.coroutines.intrinsics.UndispatchedKt.undispatchedResult(kotlinx.coroutines.internal.ScopeCoroutine<? super T>, kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean>, kotlin.jvm.functions.Function0<? extends java.lang.Object>):java.lang.Object, kotlinx.coroutines.selects.SelectBuilderImpl.resumeSelectWithException(java.lang.Throwable):void, kotlinx.coroutines.selects.SelectBuilderImpl.resumeWith(java.lang.Object):void] */
    public static final /* synthetic */ Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return recoverFromStackFrame(th, coroutineStackFrame);
    }

    @InternalCoroutinesApi
    public static final StackTraceElement artificialFrame(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (isArtificial(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return TuplesKt.to(cause, stackTrace);
            }
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        return TuplesKt.to(e, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E createFinalException(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i = 0;
        if (frameIndex == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + frameIndex];
        for (int i2 = 0; i2 < frameIndex; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[frameIndex + i] = stackTraceElement;
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            if (coroutineStackFrame == null || (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final void initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    public static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2--;
        }
    }

    public static final Object recoverAndThrow(Throwable th, Continuation<?> continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (continuation instanceof CoroutineStackFrame) {
                throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
            }
            throw th;
        }
        throw th;
    }

    public static final Object recoverAndThrow$$forInline(Throwable th, Continuation continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            InlineMarker.mark(0);
            if (continuation instanceof CoroutineStackFrame) {
                throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
            }
            throw th;
        }
        throw th;
    }

    public static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(th);
        if (tryCopyException == null || (!Intrinsics.areEqual(tryCopyException.getMessage(), th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e;
        }
        if (th != e) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th, tryCopyException, createStackTrace);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        Throwable tryCopyException;
        return (DebugKt.getRECOVER_STACK_TRACES() && (tryCopyException = ExceptionsConstuctorKt.tryCopyException(e)) != null) ? (E) sanitizeStackTrace(tryCopyException) : e;
    }

    public static final <E extends Throwable> E sanitizeStackTrace(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName);
        int i = frameIndex + 1;
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName);
        int i2 = (length - frameIndex) - (frameIndex2 == -1 ? 0 : length - frameIndex2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E unwrap(E e) {
        return !DebugKt.getRECOVER_STACK_TRACES() ? e : (E) unwrapImpl(e);
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (isArtificial(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e, Continuation<?> continuation) {
        return (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? (E) recoverFromStackFrame(e, (CoroutineStackFrame) continuation) : e;
    }
}
