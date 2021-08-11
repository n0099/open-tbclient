package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "T", "invoke", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowSubscription$onStart$1 extends FunctionReference implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
    public FlowSubscription$onStart$1(FlowSubscription flowSubscription) {
        super(1, flowSubscription);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "flowProcessing";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FlowSubscription.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "flowProcessing(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        Object flowProcessing = ((FlowSubscription) this.receiver).flowProcessing(continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return flowProcessing;
    }
}
