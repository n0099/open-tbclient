package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u00002\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@"}, d2 = {"sendSuspend", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {113}, m = "sendSuspend", n = {"this", "element"}, s = {"L$0", "L$1"})
/* loaded from: classes9.dex */
public final class PublisherCoroutine$sendSuspend$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PublisherCoroutine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$sendSuspend$1(PublisherCoroutine publisherCoroutine, Continuation continuation) {
        super(continuation);
        this.this$0 = publisherCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendSuspend(null, this);
    }
}
