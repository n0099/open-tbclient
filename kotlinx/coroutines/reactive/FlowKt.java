package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/reactive/FlowKt__MigrationKt"}, d2 = {}, k = 4, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced in favor of ReactiveFlow extension, please import kotlinx.coroutines.reactive.* instead of kotlinx.coroutines.reactive.FlowKt")
    public static final Flow asFlow(Publisher publisher) {
        return FlowKt__MigrationKt.asFlow(publisher);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced in favor of ReactiveFlow extension, please import kotlinx.coroutines.reactive.* instead of kotlinx.coroutines.reactive.FlowKt")
    public static final Publisher asPublisher(Flow flow) {
        return FlowKt__MigrationKt.asPublisher(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "batchSize parameter is deprecated, use .buffer() instead to control the backpressure", replaceWith = @ReplaceWith(expression = "asFlow().buffer(batchSize)", imports = {"kotlinx.coroutines.flow.*"}))
    public static final Flow asFlow(Publisher publisher, int i) {
        return FlowKt__MigrationKt.asFlow(publisher, i);
    }
}
