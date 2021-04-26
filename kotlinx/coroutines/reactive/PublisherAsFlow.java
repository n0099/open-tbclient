package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ!\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "injectContext", "collectImpl", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSlowPath", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "", "capacity", "create", "(Lkotlin/coroutines/CoroutineContext;I)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lorg/reactivestreams/Publisher;", "publisher", "Lorg/reactivestreams/Publisher;", "", "getRequestSize", "()J", "requestSize$annotations", "()V", "requestSize", "<init>", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class PublisherAsFlow<T> extends ChannelFlow<T> {
    public final Publisher<T> publisher;

    public /* synthetic */ PublisherAsFlow(Publisher publisher, CoroutineContext coroutineContext, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(publisher, (i3 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 4) != 0 ? -2 : i2);
    }

    private final long getRequestSize() {
        int i2 = this.capacity;
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 == 0) {
                    return 1L;
                }
                if (i2 != Integer.MAX_VALUE) {
                    long j = i2;
                    if (j >= 1) {
                        return j;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            return Long.MAX_VALUE;
        }
        return Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
    }

    public static /* synthetic */ void requestSize$annotations() {
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        CoroutineContext context = continuation.getContext();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) this.context.get(ContinuationInterceptor.Key);
        if (continuationInterceptor != null && !Intrinsics.areEqual(continuationInterceptor, (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
            Object collectSlowPath = collectSlowPath(flowCollector, continuation);
            return collectSlowPath == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectSlowPath : Unit.INSTANCE;
        }
        Object collectImpl = collectImpl(context.plus(this.context), flowCollector, continuation);
        return collectImpl == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0028 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: kotlinx.coroutines.reactive.ReactiveSubscriber */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:13:0x0042, B:31:0x00b9, B:33:0x00c4, B:23:0x0087, B:28:0x00a4, B:18:0x0062), top: B:40:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:13:0x0042, B:31:0x00b9, B:33:0x00c4, B:23:0x0087, B:28:0x00a4, B:18:0x0062), top: B:40:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.reactive.ReactiveSubscriber] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b6 -> B:14:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object collectImpl(CoroutineContext coroutineContext, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$1;
        ReactiveSubscriber reactiveSubscriber;
        CoroutineContext coroutineContext2;
        ReactiveSubscriber reactiveSubscriber2;
        PublisherAsFlow<T> publisherAsFlow;
        long j;
        FlowCollector<? super T> flowCollector2;
        PublisherAsFlow<T> publisherAsFlow2;
        CoroutineContext coroutineContext3;
        FlowCollector flowCollector3;
        long j2;
        ReactiveSubscriber reactiveSubscriber3;
        Object takeNextOrNull;
        try {
            if (continuation instanceof PublisherAsFlow$collectImpl$1) {
                publisherAsFlow$collectImpl$1 = (PublisherAsFlow$collectImpl$1) continuation;
                int i2 = publisherAsFlow$collectImpl$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    publisherAsFlow$collectImpl$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = publisherAsFlow$collectImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
                    if (reactiveSubscriber != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReactiveSubscriber reactiveSubscriber4 = new ReactiveSubscriber(this.capacity, getRequestSize());
                        coroutineContext2 = coroutineContext;
                        ReactiveFlowKt.injectCoroutineContext(this.publisher, coroutineContext2).subscribe(reactiveSubscriber4);
                        reactiveSubscriber2 = reactiveSubscriber4;
                        publisherAsFlow = this;
                        j = 0;
                        flowCollector2 = flowCollector;
                        publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                        publisherAsFlow$collectImpl$1.L$1 = coroutineContext2;
                        publisherAsFlow$collectImpl$1.L$2 = flowCollector2;
                        publisherAsFlow$collectImpl$1.L$3 = reactiveSubscriber2;
                        publisherAsFlow$collectImpl$1.J$0 = j;
                        publisherAsFlow$collectImpl$1.label = 1;
                        takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                        if (takeNextOrNull == coroutine_suspended) {
                        }
                    } else if (reactiveSubscriber == 1) {
                        j2 = publisherAsFlow$collectImpl$1.J$0;
                        ReactiveSubscriber reactiveSubscriber5 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$3;
                        FlowCollector flowCollector4 = (FlowCollector) publisherAsFlow$collectImpl$1.L$2;
                        coroutineContext3 = (CoroutineContext) publisherAsFlow$collectImpl$1.L$1;
                        publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        reactiveSubscriber3 = reactiveSubscriber5;
                        flowCollector3 = flowCollector4;
                        if (obj == null) {
                        }
                    } else if (reactiveSubscriber != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = publisherAsFlow$collectImpl$1.L$4;
                        j2 = publisherAsFlow$collectImpl$1.J$0;
                        ReactiveSubscriber reactiveSubscriber6 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$3;
                        FlowCollector<? super T> flowCollector5 = (FlowCollector) publisherAsFlow$collectImpl$1.L$2;
                        coroutineContext3 = (CoroutineContext) publisherAsFlow$collectImpl$1.L$1;
                        publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        reactiveSubscriber = reactiveSubscriber6;
                        FlowCollector<? super T> flowCollector6 = flowCollector5;
                        flowCollector2 = flowCollector6;
                        long j3 = j2 + 1;
                        if (j3 == publisherAsFlow2.getRequestSize()) {
                            reactiveSubscriber.makeRequest();
                            j3 = 0;
                        }
                        long j4 = j3;
                        coroutineContext2 = coroutineContext3;
                        j = j4;
                        publisherAsFlow = publisherAsFlow2;
                        reactiveSubscriber2 = reactiveSubscriber;
                        publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                        publisherAsFlow$collectImpl$1.L$1 = coroutineContext2;
                        publisherAsFlow$collectImpl$1.L$2 = flowCollector2;
                        publisherAsFlow$collectImpl$1.L$3 = reactiveSubscriber2;
                        publisherAsFlow$collectImpl$1.J$0 = j;
                        publisherAsFlow$collectImpl$1.label = 1;
                        takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                        if (takeNextOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        long j5 = j;
                        flowCollector3 = flowCollector2;
                        coroutineContext3 = coroutineContext2;
                        obj = takeNextOrNull;
                        publisherAsFlow2 = publisherAsFlow;
                        j2 = j5;
                        reactiveSubscriber3 = reactiveSubscriber2;
                        if (obj == null) {
                            publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow2;
                            publisherAsFlow$collectImpl$1.L$1 = coroutineContext3;
                            publisherAsFlow$collectImpl$1.L$2 = flowCollector3;
                            publisherAsFlow$collectImpl$1.L$3 = reactiveSubscriber3;
                            publisherAsFlow$collectImpl$1.J$0 = j2;
                            publisherAsFlow$collectImpl$1.L$4 = obj;
                            publisherAsFlow$collectImpl$1.label = 2;
                            Object emit = flowCollector3.emit(obj, publisherAsFlow$collectImpl$1);
                            reactiveSubscriber = reactiveSubscriber3;
                            flowCollector6 = flowCollector3;
                            if (emit == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowCollector2 = flowCollector6;
                            long j32 = j2 + 1;
                            if (j32 == publisherAsFlow2.getRequestSize()) {
                            }
                            long j42 = j32;
                            coroutineContext2 = coroutineContext3;
                            j = j42;
                            publisherAsFlow = publisherAsFlow2;
                            reactiveSubscriber2 = reactiveSubscriber;
                            publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                            publisherAsFlow$collectImpl$1.L$1 = coroutineContext2;
                            publisherAsFlow$collectImpl$1.L$2 = flowCollector2;
                            publisherAsFlow$collectImpl$1.L$3 = reactiveSubscriber2;
                            publisherAsFlow$collectImpl$1.J$0 = j;
                            publisherAsFlow$collectImpl$1.label = 1;
                            takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                            if (takeNextOrNull == coroutine_suspended) {
                            }
                        } else {
                            reactiveSubscriber3.cancel();
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            if (reactiveSubscriber != 0) {
            }
        } catch (Throwable th) {
            reactiveSubscriber.cancel();
            throw th;
        }
        publisherAsFlow$collectImpl$1 = new PublisherAsFlow$collectImpl$1(this, continuation);
        Object obj3 = publisherAsFlow$collectImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
    }

    public final /* synthetic */ Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(this, flowCollector, null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        return collectImpl == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> create(CoroutineContext coroutineContext, int i2) {
        return new PublisherAsFlow(this.publisher, coroutineContext, i2);
    }

    public PublisherAsFlow(Publisher<T> publisher, CoroutineContext coroutineContext, int i2) {
        super(coroutineContext, i2);
        this.publisher = publisher;
    }
}
