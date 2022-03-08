package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\b\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"", "T", "Lorg/reactivestreams/Publisher;", "", "batchSize", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lorg/reactivestreams/Publisher;I)Lkotlinx/coroutines/flow/Flow;", "(Lorg/reactivestreams/Publisher;)Lkotlinx/coroutines/flow/Flow;", "asFlowDeprecated", "asPublisher", "(Lkotlinx/coroutines/flow/Flow;)Lorg/reactivestreams/Publisher;", "asPublisherDeprecated", "kotlinx-coroutines-reactive"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/reactive/FlowKt")
/* loaded from: classes9.dex */
public final /* synthetic */ class FlowKt__MigrationKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced in favor of ReactiveFlow extension, please import kotlinx.coroutines.reactive.* instead of kotlinx.coroutines.reactive.FlowKt")
    @JvmName(name = "asFlow")
    public static final <T> Flow<T> asFlow(Publisher<T> publisher) {
        return ReactiveFlowKt.asFlow(publisher);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced in favor of ReactiveFlow extension, please import kotlinx.coroutines.reactive.* instead of kotlinx.coroutines.reactive.FlowKt")
    @JvmName(name = "asPublisher")
    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow) {
        return ReactiveFlowKt.asPublisher(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "batchSize parameter is deprecated, use .buffer() instead to control the backpressure", replaceWith = @ReplaceWith(expression = "asFlow().buffer(batchSize)", imports = {"kotlinx.coroutines.flow.*"}))
    @FlowPreview
    public static final <T> Flow<T> asFlow(Publisher<T> publisher, int i2) {
        return kotlinx.coroutines.flow.FlowKt.buffer(ReactiveFlowKt.asFlow(publisher), i2);
    }
}
