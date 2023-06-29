package kotlinx.coroutines.channels;

import com.fun.ad.sdk.FunAdSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.apache.http.HttpStatus;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {HttpStatus.SC_METHOD_FAILURE, HttpStatus.SC_UNPROCESSABLE_ENTITY}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", FunAdSdk.PLATFORM_MAX}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$maxWith$1(Continuation<? super ChannelsKt__DeprecatedKt$maxWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object maxWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        maxWith = ChannelsKt__DeprecatedKt.maxWith(null, null, this);
        return maxWith;
    }
}
