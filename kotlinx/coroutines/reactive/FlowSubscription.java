package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B%\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00158\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "cancel", "()V", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowProcessing", "onStart", "", "n", "request", "(J)V", "Lkotlinx/coroutines/CancellableContinuation;", "resumeSafely", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lorg/reactivestreams/Subscriber;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    @JvmField
    public final Flow<T> flow;
    public volatile Object producer;
    public volatile long requested;
    @JvmField
    public final Subscriber<? super T> subscriber;
    public static final AtomicLongFieldUpdater requested$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested");
    public static final AtomicReferenceFieldUpdater producer$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer");

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber) {
        super(Dispatchers.getUnconfined(), false);
        this.flow = flow;
        this.subscriber = subscriber;
        this.requested = 0L;
        this.producer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeSafely(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume$default = CancellableContinuation.DefaultImpls.tryResume$default(cancellableContinuation, Unit.INSTANCE, null, 2, null);
        if (tryResume$default != null) {
            cancellableContinuation.completeResume(tryResume$default);
        }
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        cancel((CancellationException) null);
    }

    public final /* synthetic */ Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowSubscription$consumeFlow$$inlined$collect$1(this), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x002d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x004e */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052 A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:27:0x004e, B:29:0x0052, B:30:0x0058), top: B:41:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #2 {all -> 0x005e, blocks: (B:27:0x004e, B:29:0x0052, B:30:0x0058), top: B:41:0x004e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x005f -> B:40:0x0066). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object flowProcessing(Continuation<? super Unit> continuation) {
        FlowSubscription$flowProcessing$1 flowSubscription$flowProcessing$1;
        int i;
        FlowSubscription<T> flowSubscription;
        if (continuation instanceof FlowSubscription$flowProcessing$1) {
            flowSubscription$flowProcessing$1 = (FlowSubscription$flowProcessing$1) continuation;
            int i2 = flowSubscription$flowProcessing$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowSubscription$flowProcessing$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowSubscription$flowProcessing$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowSubscription$flowProcessing$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        flowSubscription$flowProcessing$1.L$0 = this;
                        flowSubscription$flowProcessing$1.label = 1;
                        if (consumeFlow(flowSubscription$flowProcessing$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowSubscription = this;
                    } catch (Throwable th) {
                        th = th;
                        flowSubscription = this;
                        if (!(th instanceof CancellationException)) {
                            flowSubscription.subscriber.onComplete();
                            flowSubscription = flowSubscription;
                        } else {
                            flowSubscription.subscriber.onError(th);
                            flowSubscription = flowSubscription;
                        }
                        return Unit.INSTANCE;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowSubscription = (FlowSubscription) flowSubscription$flowProcessing$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        flowSubscription = flowSubscription;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            if (!(th instanceof CancellationException)) {
                            }
                        } catch (Throwable th3) {
                            CoroutineContext coroutineContext = flowSubscription.getCoroutineContext();
                            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th3);
                            flowSubscription = coroutineContext;
                        }
                        return Unit.INSTANCE;
                    }
                }
                flowSubscription.subscriber.onComplete();
                return Unit.INSTANCE;
            }
        }
        flowSubscription$flowProcessing$1 = new FlowSubscription$flowProcessing$1(this, continuation);
        Object obj2 = flowSubscription$flowProcessing$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowSubscription$flowProcessing$1.label;
        if (i != 0) {
        }
        flowSubscription.subscriber.onComplete();
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onStart() {
        CancellableKt.startCoroutineCancellable(new FlowSubscription$onStart$1(this), this);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        long j2;
        long j3;
        if (j <= 0) {
            return;
        }
        start();
        do {
            j2 = this.requested;
            j3 = j2 + j;
            if (j3 <= 0) {
                j3 = Long.MAX_VALUE;
            }
        } while (!requested$FU.compareAndSet(this, j2, j3));
        CancellableContinuation<? super Unit> cancellableContinuation = (CancellableContinuation) producer$FU.getAndSet(this, null);
        if (cancellableContinuation != null) {
            resumeSafely(cancellableContinuation);
        }
    }
}
