package kotlinx.coroutines;

import com.yy.gslbsdk.db.DelayTB;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {DelayTB.DELAY, "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCancellation(Continuation<?> continuation) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        int i;
        if (continuation instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuation;
            int i2 = delayKt$awaitCancellation$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i2 - Integer.MIN_VALUE;
                Object obj = delayKt$awaitCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = delayKt$awaitCancellation$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    delayKt$awaitCancellation$1.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(delayKt$awaitCancellation$1), 1);
                    cancellableContinuationImpl.initCancellability();
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(delayKt$awaitCancellation$1);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuation);
        Object obj2 = delayKt$awaitCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = delayKt$awaitCancellation$1.label;
        if (i == 0) {
        }
        throw new KotlinNothingValueException();
    }

    public static final Object delay(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getContext()).mo2347scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: delay-VtjQ1oo  reason: not valid java name */
    public static final Object m2284delayVtjQ1oo(long j, Continuation<? super Unit> continuation) {
        Object delay = delay(m2285toDelayMillisLRDsOJo(j), continuation);
        if (delay == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return delay;
        }
        return Unit.INSTANCE;
    }

    public static final Delay getDelay(CoroutineContext coroutineContext) {
        Delay delay;
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        if (element instanceof Delay) {
            delay = (Delay) element;
        } else {
            delay = null;
        }
        if (delay == null) {
            return DefaultExecutorKt.getDefaultDelay();
        }
        return delay;
    }

    /* renamed from: toDelayMillis-LRDsOJo  reason: not valid java name */
    public static final long m2285toDelayMillisLRDsOJo(long j) {
        if (Duration.m2147compareToLRDsOJo(j, Duration.Companion.m2250getZEROUwyO8pc()) > 0) {
            return RangesKt___RangesKt.coerceAtLeast(Duration.m2166getInWholeMillisecondsimpl(j), 1L);
        }
        return 0L;
    }
}
