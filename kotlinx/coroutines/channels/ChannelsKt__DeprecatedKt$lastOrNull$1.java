package kotlinx.coroutines.channels;

import com.baidu.searchbox.player.ubc.FloatingStatPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", FloatingStatPlugin.VALUE_LAST}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$lastOrNull$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$lastOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$lastOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object lastOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lastOrNull = ChannelsKt__DeprecatedKt.lastOrNull(null, this);
        return lastOrNull;
    }
}
