package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aa\u0010\u0010\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00028\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aJ\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0012\u001a\u00020\u00002'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aM\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0016\u001a\u00020\u00152'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0087@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aL\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0012\u001a\u00020\u00002'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0014\u001aO\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0016\u001a\u00020\u00152'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0087@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"", "time", "Lkotlinx/coroutines/Job;", "coroutine", "Lkotlinx/coroutines/TimeoutCancellationException;", "TimeoutCancellationException", "(JLkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "U", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/TimeoutCoroutine;", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "setupTimeout", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "timeMillis", "withTimeout", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "withTimeout-lwyi7ZQ", "(DLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "withTimeoutOrNull-lwyi7ZQ", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class TimeoutKt {
    public static final TimeoutCancellationException TimeoutCancellationException(long j, Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j + " ms", job);
    }

    public static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, function2);
    }

    public static final <T> Object withTimeout(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j > 0) {
            Object obj = setupTimeout(new TimeoutCoroutine(j, continuation), function2);
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return obj;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @ExperimentalTime
    /* renamed from: withTimeout-lwyi7ZQ  reason: not valid java name */
    public static final <T> Object m2085withTimeoutlwyi7ZQ(double d, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m2078toDelayMillisLRDsOJo(d), function2, continuation);
    }

    @ExperimentalTime
    /* renamed from: withTimeoutOrNull-lwyi7ZQ  reason: not valid java name */
    public static final <T> Object m2086withTimeoutOrNulllwyi7ZQ(double d, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m2078toDelayMillisLRDsOJo(d), function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.TimeoutCoroutine, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrNull(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuation;
            int i2 = timeoutKt$withTimeoutOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = timeoutKt$withTimeoutOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = timeoutKt$withTimeoutOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) timeoutKt$withTimeoutOrNull$1.L$1;
                        Function2 function22 = (Function2) timeoutKt$withTimeoutOrNull$1.L$0;
                        long j2 = timeoutKt$withTimeoutOrNull$1.J$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        } catch (TimeoutCancellationException e) {
                            e = e;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (j <= 0) {
                        return null;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    try {
                        timeoutKt$withTimeoutOrNull$1.J$0 = j;
                        timeoutKt$withTimeoutOrNull$1.L$0 = function2;
                        timeoutKt$withTimeoutOrNull$1.L$1 = objectRef2;
                        timeoutKt$withTimeoutOrNull$1.label = 1;
                        ?? r2 = (T) new TimeoutCoroutine(j, timeoutKt$withTimeoutOrNull$1);
                        objectRef2.element = r2;
                        Object obj2 = setupTimeout(r2, function2);
                        if (obj2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(timeoutKt$withTimeoutOrNull$1);
                        }
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj2;
                    } catch (TimeoutCancellationException e2) {
                        e = e2;
                        objectRef = objectRef2;
                    }
                }
                if (e.coroutine != ((TimeoutCoroutine) objectRef.element)) {
                    return null;
                }
                throw e;
            }
        }
        timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
        Object obj3 = timeoutKt$withTimeoutOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = timeoutKt$withTimeoutOrNull$1.label;
        if (i == 0) {
        }
        if (e.coroutine != ((TimeoutCoroutine) objectRef.element)) {
        }
    }
}
