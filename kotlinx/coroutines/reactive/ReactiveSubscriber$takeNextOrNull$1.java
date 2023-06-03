package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.ReactiveSubscriber", f = "ReactiveFlow.kt", i = {}, l = {129}, m = "takeNextOrNull", n = {}, s = {})
/* loaded from: classes10.dex */
public final class ReactiveSubscriber$takeNextOrNull$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ReactiveSubscriber<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactiveSubscriber$takeNextOrNull$1(ReactiveSubscriber<T> reactiveSubscriber, Continuation<? super ReactiveSubscriber$takeNextOrNull$1> continuation) {
        super(continuation);
        this.this$0 = reactiveSubscriber;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.takeNextOrNull(this);
    }
}
