package kotlin.coroutines.experimental.migration;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationInterceptorMigration;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "continuation", "interceptContinuation", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/coroutines/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "getInterceptor", "()Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "key", "<init>", "(Lkotlin/coroutines/ContinuationInterceptor;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ExperimentalContinuationInterceptorMigration implements ContinuationInterceptor {
    public final kotlin.coroutines.ContinuationInterceptor interceptor;

    public ExperimentalContinuationInterceptorMigration(kotlin.coroutines.ContinuationInterceptor continuationInterceptor) {
        this.interceptor = continuationInterceptor;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) ContinuationInterceptor.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, key);
    }

    public final kotlin.coroutines.ContinuationInterceptor getInterceptor() {
        return this.interceptor;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return ContinuationInterceptor.Key;
    }

    @Override // kotlin.coroutines.experimental.ContinuationInterceptor
    public <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return CoroutinesMigrationKt.toExperimentalContinuation(this.interceptor.interceptContinuation(CoroutinesMigrationKt.toContinuation(continuation)));
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return ContinuationInterceptor.DefaultImpls.plus(this, coroutineContext);
    }
}
