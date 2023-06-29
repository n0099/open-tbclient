package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00028\u0000H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", ExifInterface.LONGITUDE_EAST, "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ChannelIterator<E> {
    Object hasNext(Continuation<? super Boolean> continuation);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    /* synthetic */ Object next(Continuation continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object next(ChannelIterator channelIterator, Continuation continuation) {
            ChannelIterator$next0$1 channelIterator$next0$1;
            Object obj;
            int i;
            if (continuation instanceof ChannelIterator$next0$1) {
                channelIterator$next0$1 = (ChannelIterator$next0$1) continuation;
                int i2 = channelIterator$next0$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelIterator$next0$1.label = i2 - Integer.MIN_VALUE;
                    obj = channelIterator$next0$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelIterator$next0$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            channelIterator = (ChannelIterator) channelIterator$next0$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        channelIterator$next0$1.L$0 = channelIterator;
                        channelIterator$next0$1.label = 1;
                        obj = channelIterator.hasNext(channelIterator$next0$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return channelIterator.next();
                    }
                    throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
                }
            }
            channelIterator$next0$1 = new ChannelIterator$next0$1(continuation);
            obj = channelIterator$next0$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = channelIterator$next0$1.label;
            if (i == 0) {
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        }
    }
}
