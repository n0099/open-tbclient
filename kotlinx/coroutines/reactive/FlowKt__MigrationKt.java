package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import org.reactivestreams.Publisher;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\b\u0000\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/reactivestreams/Publisher;", "batchSize", "", "asFlowDeprecated", "asPublisherDeprecated", "asPublisher", "kotlinx-coroutines-reactive"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/reactive/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__MigrationKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "batchSize parameter is deprecated, use .buffer() instead to control the backpressure", replaceWith = @ReplaceWith(expression = "asFlow().buffer(batchSize)", imports = {"kotlinx.coroutines.flow.*"}))
    @FlowPreview
    public static final /* synthetic */ Flow asFlow(Publisher publisher, int i) {
        Flow buffer$default;
        buffer$default = FlowKt__ContextKt.buffer$default(ReactiveFlowKt.asFlow(publisher), i, null, 2, null);
        return buffer$default;
    }
}
