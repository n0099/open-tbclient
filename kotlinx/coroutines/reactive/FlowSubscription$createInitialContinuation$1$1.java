package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public /* synthetic */ class FlowSubscription$createInitialContinuation$1$1 extends FunctionReferenceImpl implements Function1<Unit>, SuspendFunction {
    public FlowSubscription$createInitialContinuation$1$1(Object obj) {
        super(1, obj, FlowSubscription.class, "flowProcessing", "flowProcessing(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object flowProcessing;
        flowProcessing = ((FlowSubscription) this.receiver).flowProcessing(continuation);
        return flowProcessing;
    }
}
