package kotlinx.coroutines.channels;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "", "exception", "", "handleJobException", "(Ljava/lang/Throwable;)Z", "cause", "", "onCancelling", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", GrowthConstant.UBC_VALUE_TYPE_DEFAULT, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    public ActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, channel, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.util.concurrent.CancellationException */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public void onCancelling(Throwable th) {
        Channel<E> channel = get_channel();
        if (th != null) {
            r1 = th instanceof CancellationException ? th : null;
            if (r1 == null) {
                r1 = ExceptionsKt.CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", th);
            }
        }
        channel.cancel(r1);
    }
}
