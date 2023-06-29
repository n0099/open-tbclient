package kotlinx.coroutines.flow;

import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0}, l = {JfifUtil.MARKER_SOI}, m = "invokeSafely$FlowKt__EmittersKt", n = {"cause"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__EmittersKt$invokeSafely$1(Continuation<? super FlowKt__EmittersKt$invokeSafely$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeSafely$FlowKt__EmittersKt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(null, null, null, this);
        return invokeSafely$FlowKt__EmittersKt;
    }
}
