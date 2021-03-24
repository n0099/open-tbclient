package kotlin.coroutines.experimental.migration;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0005*\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\t*\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001ae\u0010\u0018\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0015*\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aS\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001a\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0015*\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001aH\u0000¢\u0006\u0004\b\u0018\u0010\u001b\u001aA\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001c\"\u0004\b\u0000\u0010\u0015*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001cH\u0000¢\u0006\u0004\b\u0018\u0010\u001d¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/coroutines/Continuation;", "toContinuation", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "Lkotlin/coroutines/ContinuationInterceptor;", "toContinuationInterceptor", "(Lkotlin/coroutines/experimental/ContinuationInterceptor;)Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "toCoroutineContext", "(Lkotlin/coroutines/experimental/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "toExperimentalContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "toExperimentalContinuationInterceptor", "(Lkotlin/coroutines/ContinuationInterceptor;)Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toExperimentalCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/experimental/CoroutineContext;", "T1", "T2", "R", "Lkotlin/Function3;", "", "toExperimentalSuspendFunction", "(Lkotlin/Function3;)Lkotlin/Function3;", "Lkotlin/Function2;", "(Lkotlin/Function2;)Lkotlin/Function2;", "Lkotlin/Function1;", "(Lkotlin/Function1;)Lkotlin/Function1;", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class CoroutinesMigrationKt {
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<T> toContinuation(kotlin.coroutines.experimental.Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        ExperimentalContinuationMigration experimentalContinuationMigration = (ExperimentalContinuationMigration) (!(continuation instanceof ExperimentalContinuationMigration) ? null : continuation);
        return (experimentalContinuationMigration == null || (continuation2 = experimentalContinuationMigration.getContinuation()) == null) ? new ContinuationMigration(continuation) : continuation2;
    }

    @SinceKotlin(version = "1.3")
    public static final ContinuationInterceptor toContinuationInterceptor(kotlin.coroutines.experimental.ContinuationInterceptor continuationInterceptor) {
        ContinuationInterceptor interceptor;
        ExperimentalContinuationInterceptorMigration experimentalContinuationInterceptorMigration = (ExperimentalContinuationInterceptorMigration) (!(continuationInterceptor instanceof ExperimentalContinuationInterceptorMigration) ? null : continuationInterceptor);
        return (experimentalContinuationInterceptorMigration == null || (interceptor = experimentalContinuationInterceptorMigration.getInterceptor()) == null) ? new ContinuationInterceptorMigration(continuationInterceptor) : interceptor;
    }

    @SinceKotlin(version = "1.3")
    public static final CoroutineContext toCoroutineContext(kotlin.coroutines.experimental.CoroutineContext coroutineContext) {
        CoroutineContext coroutineContext2;
        kotlin.coroutines.experimental.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.experimental.ContinuationInterceptor) coroutineContext.get(kotlin.coroutines.experimental.ContinuationInterceptor.Key);
        ExperimentalContextMigration experimentalContextMigration = (ExperimentalContextMigration) coroutineContext.get(ExperimentalContextMigration.Key);
        kotlin.coroutines.experimental.CoroutineContext minusKey = coroutineContext.minusKey(kotlin.coroutines.experimental.ContinuationInterceptor.Key).minusKey(ExperimentalContextMigration.Key);
        if (experimentalContextMigration == null || (coroutineContext2 = experimentalContextMigration.getContext()) == null) {
            coroutineContext2 = EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE) {
            coroutineContext2 = coroutineContext2.plus(new ContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext2 : coroutineContext2.plus(toContinuationInterceptor(continuationInterceptor));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> kotlin.coroutines.experimental.Continuation<T> toExperimentalContinuation(Continuation<? super T> continuation) {
        kotlin.coroutines.experimental.Continuation<T> continuation2;
        ContinuationMigration continuationMigration = (ContinuationMigration) (!(continuation instanceof ContinuationMigration) ? null : continuation);
        return (continuationMigration == null || (continuation2 = continuationMigration.getContinuation()) == null) ? new ExperimentalContinuationMigration(continuation) : continuation2;
    }

    @SinceKotlin(version = "1.3")
    public static final kotlin.coroutines.experimental.ContinuationInterceptor toExperimentalContinuationInterceptor(ContinuationInterceptor continuationInterceptor) {
        kotlin.coroutines.experimental.ContinuationInterceptor interceptor;
        ContinuationInterceptorMigration continuationInterceptorMigration = (ContinuationInterceptorMigration) (!(continuationInterceptor instanceof ContinuationInterceptorMigration) ? null : continuationInterceptor);
        return (continuationInterceptorMigration == null || (interceptor = continuationInterceptorMigration.getInterceptor()) == null) ? new ExperimentalContinuationInterceptorMigration(continuationInterceptor) : interceptor;
    }

    @SinceKotlin(version = "1.3")
    public static final kotlin.coroutines.experimental.CoroutineContext toExperimentalCoroutineContext(CoroutineContext coroutineContext) {
        kotlin.coroutines.experimental.CoroutineContext coroutineContext2;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        ContextMigration contextMigration = (ContextMigration) coroutineContext.get(ContextMigration.Key);
        CoroutineContext minusKey = coroutineContext.minusKey(ContinuationInterceptor.Key).minusKey(ContextMigration.Key);
        if (contextMigration == null || (coroutineContext2 = contextMigration.getContext()) == null) {
            coroutineContext2 = kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != EmptyCoroutineContext.INSTANCE) {
            coroutineContext2 = coroutineContext2.plus(new ExperimentalContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext2 : coroutineContext2.plus(toExperimentalContinuationInterceptor(continuationInterceptor));
    }

    public static final <R> Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        return new ExperimentalSuspendFunction0Migration(function1);
    }

    public static final <T1, R> Function2<T1, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function2<? super T1, ? super Continuation<? super R>, ? extends Object> function2) {
        return new ExperimentalSuspendFunction1Migration(function2);
    }

    public static final <T1, T2, R> Function3<T1, T2, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new ExperimentalSuspendFunction2Migration(function3);
    }
}
