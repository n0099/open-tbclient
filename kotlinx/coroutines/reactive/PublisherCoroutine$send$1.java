package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {98}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class PublisherCoroutine$send$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.reactive.PublisherCoroutine<? super T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine$send$1(PublisherCoroutine<? super T> publisherCoroutine, Continuation<? super PublisherCoroutine$send$1> continuation) {
        super(continuation);
        this.this$0 = publisherCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, this);
    }
}
