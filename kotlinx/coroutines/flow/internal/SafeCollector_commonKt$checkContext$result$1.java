package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
    public final /* synthetic */ SafeCollector $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public final int invoke(int i2, CoroutineContext.Element element) {
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key != Job.Key) {
            if (element != element2) {
                return Integer.MIN_VALUE;
            }
            return i2 + 1;
        }
        Job job = (Job) element2;
        if (element != null) {
            Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
            if (transitiveCoroutineParent == job) {
                return job == null ? i2 : i2 + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Job");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
        return Integer.valueOf(invoke(num.intValue(), element));
    }
}
