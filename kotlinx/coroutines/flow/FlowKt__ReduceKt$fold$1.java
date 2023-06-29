package kotlinx.coroutines.flow;

import com.baidu.pass.ecommerce.StatKey;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = MatroskaExtractor.ID_PIXEL_WIDTH)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = StatKey.EDITADDR_PASTE_ADDRESS_STAGE_FOLD, n = {"accumulator"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ReduceKt$fold$1(Continuation<? super FlowKt__ReduceKt$fold$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__ReduceKt.fold(null, null, null, this);
    }
}
