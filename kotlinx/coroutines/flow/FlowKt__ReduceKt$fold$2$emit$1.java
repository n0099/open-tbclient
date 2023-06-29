package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = MatroskaExtractor.ID_PIXEL_WIDTH)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", f = "Reduce.kt", i = {}, l = {45}, m = "emit", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__ReduceKt$fold$2<T> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2<? super T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt$fold$2<? super T> flowKt__ReduceKt$fold$2, Continuation<? super FlowKt__ReduceKt$fold$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__ReduceKt$fold$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
