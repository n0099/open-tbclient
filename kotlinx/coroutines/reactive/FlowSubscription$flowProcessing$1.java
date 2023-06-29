package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {0}, l = {209}, m = "flowProcessing", n = {"this"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowSubscription<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, Continuation<? super FlowSubscription$flowProcessing$1> continuation) {
        super(continuation);
        this.this$0 = flowSubscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object flowProcessing;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        flowProcessing = this.this$0.flowProcessing(this);
        return flowProcessing;
    }
}
