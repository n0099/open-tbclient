package kotlinx.coroutines.channels;

import com.baidu.mobstat.Config;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {65}, m = Config.TRACE_VISIT_FIRST, n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
/* loaded from: classes10.dex */
public final class ChannelsKt__DeprecatedKt$first$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$first$1(Continuation<? super ChannelsKt__DeprecatedKt$first$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object first;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        first = ChannelsKt__DeprecatedKt.first(null, this);
        return first;
    }
}
