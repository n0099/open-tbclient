package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u001d2\b\u0012\u0004\u0012\u00020\n0\u001eB-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001c\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "flow", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "", "cancel", "()V", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "createInitialContinuation", "()Lkotlin/coroutines/Continuation;", "flowProcessing", "", "n", "request", "(J)V", "", "cancellationRequested", "Z", "Lkotlinx/coroutines/flow/Flow;", "Lorg/reactivestreams/Subscriber;", "kotlinx-coroutines-reactive", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    public volatile boolean cancellationRequested;
    @JvmField
    public final Flow<T> flow;
    public volatile /* synthetic */ Object producer;
    public volatile /* synthetic */ long requested;
    @JvmField
    public final Subscriber<? super T> subscriber;
    public static final /* synthetic */ AtomicLongFieldUpdater requested$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested");
    public static final /* synthetic */ AtomicReferenceFieldUpdater producer$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer");

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.requested = 0L;
        this.producer = createInitialContinuation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowSubscription$consumeFlow$2(this), continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext coroutineContext = getCoroutineContext();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(3:9|10|11)(2:39|40))(4:41|42|43|(1:45)(1:46))|12|13|14|15))|50|6|(0)(0)|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0.getCoroutineContext(), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flowProcessing(Continuation<? super Unit> continuation) {
        FlowSubscription$flowProcessing$1 flowSubscription$flowProcessing$1;
        int i;
        FlowSubscription<T> flowSubscription;
        Throwable unwrapImpl;
        if (continuation instanceof FlowSubscription$flowProcessing$1) {
            flowSubscription$flowProcessing$1 = (FlowSubscription$flowProcessing$1) continuation;
            int i2 = flowSubscription$flowProcessing$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowSubscription$flowProcessing$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowSubscription$flowProcessing$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowSubscription$flowProcessing$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowSubscription = (FlowSubscription) flowSubscription$flowProcessing$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th) {
                            th = th;
                            if (DebugKt.getRECOVER_STACK_TRACES()) {
                            }
                            if (flowSubscription.cancellationRequested) {
                            }
                            try {
                                flowSubscription.subscriber.onError(th);
                            } catch (Throwable th2) {
                                ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
                                CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription.getCoroutineContext(), th);
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        flowSubscription$flowProcessing$1.L$0 = this;
                        flowSubscription$flowProcessing$1.label = 1;
                        if (consumeFlow(flowSubscription$flowProcessing$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowSubscription = this;
                    } catch (Throwable th3) {
                        th = th3;
                        flowSubscription = this;
                        if (DebugKt.getRECOVER_STACK_TRACES()) {
                            unwrapImpl = th;
                        } else {
                            unwrapImpl = StackTraceRecoveryKt.unwrapImpl(th);
                        }
                        if (flowSubscription.cancellationRequested || flowSubscription.isActive() || unwrapImpl != flowSubscription.getCancellationException()) {
                            flowSubscription.subscriber.onError(th);
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
        if (i == 0) {
        }
        flowSubscription.subscriber.onComplete();
        return Unit.INSTANCE;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        long j2;
        long j3;
        boolean z;
        Continuation continuation;
        if (j <= 0) {
            return;
        }
        do {
            j2 = this.requested;
            j3 = j2 + j;
            if (j3 <= 0) {
                j3 = Long.MAX_VALUE;
            }
        } while (!requested$FU.compareAndSet(this, j2, j3));
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i <= 0) {
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Assertion failed");
            }
            do {
                continuation = (Continuation) producer$FU.getAndSet(this, null);
            } while (continuation == null);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m844constructorimpl(Unit.INSTANCE));
        }
    }
}
