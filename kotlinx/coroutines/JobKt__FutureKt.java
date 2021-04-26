package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00062\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "Ljava/util/concurrent/Future;", "future", "", "cancelFutureOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/util/concurrent/Future;)V", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/DisposableHandle;", "cancelFutureOnCompletion", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/Future;)Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes7.dex */
public final /* synthetic */ class JobKt__FutureKt {
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }

    @InternalCoroutinesApi
    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return job.invokeOnCompletion(new CancelFutureOnCompletion(job, future));
    }
}
