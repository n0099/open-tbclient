package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lorg/reactivestreams/Publisher;)Lkotlinx/coroutines/flow/Flow;", "asPublisher", "(Lkotlinx/coroutines/flow/Flow;)Lorg/reactivestreams/Publisher;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "injectCoroutineContext", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;)Lorg/reactivestreams/Publisher;", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "contextInjectors", "[Lkotlinx/coroutines/reactive/ContextInjector;", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ReactiveFlowKt {
    public static final ContextInjector[] contextInjectors;

    static {
        Object[] array = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator())).toArray(new ContextInjector[0]);
        if (array != null) {
            contextInjectors = (ContextInjector[]) array;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final <T> Flow<T> asFlow(Publisher<T> publisher) {
        return new PublisherAsFlow(publisher, null, 0, 6, null);
    }

    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow) {
        return new FlowAsPublisher(flow);
    }

    public static final <T> Publisher<T> injectCoroutineContext(Publisher<T> publisher, CoroutineContext coroutineContext) {
        for (ContextInjector contextInjector : contextInjectors) {
            publisher = contextInjector.injectCoroutineContext(publisher, coroutineContext);
        }
        return publisher;
    }
}
