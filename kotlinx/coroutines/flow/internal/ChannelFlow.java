package kotlinx.coroutines.flow.internal;

import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H¤@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H$¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010\u001aR\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R;\u0010&\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!8@@\u0000X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010'R\u0016\u0010*\u001a\u00020\u00178B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineStart;", IntentConfig.START, "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastImpl", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "create", "(Lkotlin/coroutines/CoroutineContext;I)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "toString", IMTrack.DbBuilder.ACTION_UPDATE, "I", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "collectToFun", "Lkotlin/coroutines/CoroutineContext;", "getProduceCapacity", "()I", "produceCapacity", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class ChannelFlow<T> implements Flow<T> {
    @JvmField
    public final int capacity;
    @JvmField
    public final CoroutineContext context;

    public ChannelFlow(CoroutineContext coroutineContext, int i2) {
        this.context = coroutineContext;
        this.capacity = i2;
    }

    public static /* synthetic */ Object collect$suspendImpl(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(channelFlow, flowCollector, null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private final int getProduceCapacity() {
        int i2 = this.capacity;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    public static /* synthetic */ ChannelFlow update$default(ChannelFlow channelFlow, CoroutineContext coroutineContext, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            }
            if ((i3 & 2) != 0) {
                i2 = -3;
            }
            return channelFlow.update(coroutineContext, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
    }

    public String additionalToStringProps() {
        return "";
    }

    public BroadcastChannel<T> broadcastImpl(CoroutineScope coroutineScope, CoroutineStart coroutineStart) {
        return BroadcastKt.broadcast$default(coroutineScope, this.context, getProduceCapacity(), coroutineStart, null, getCollectToFun$kotlinx_coroutines_core(), 8, null);
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    public abstract Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public abstract ChannelFlow<T> create(CoroutineContext coroutineContext, int i2);

    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce$default(coroutineScope, this.context, getProduceCapacity(), CoroutineStart.ATOMIC, null, getCollectToFun$kotlinx_coroutines_core(), 8, null);
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + additionalToStringProps() + "context=" + this.context + ", capacity=" + this.capacity + ']';
    }

    public final ChannelFlow<T> update(CoroutineContext coroutineContext, int i2) {
        CoroutineContext plus = coroutineContext.plus(this.context);
        int i3 = this.capacity;
        if (i3 != -3) {
            if (i2 != -3) {
                if (i3 != -2) {
                    if (i2 != -2) {
                        if (i3 == -1 || i2 == -1) {
                            i2 = -1;
                        } else {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                if (!(this.capacity >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                if (!(i2 >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            i2 += this.capacity;
                            if (i2 < 0) {
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
            }
            i2 = i3;
        }
        return (Intrinsics.areEqual(plus, this.context) && i2 == this.capacity) ? this : create(plus, i2);
    }
}
