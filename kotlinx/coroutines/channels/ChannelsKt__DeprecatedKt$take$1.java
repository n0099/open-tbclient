package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$take$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel<E> $this_take;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$take$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$take$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0085 -> B:30:0x0087). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        boolean z;
        int i;
        ChannelIterator<E> it;
        ChannelsKt__DeprecatedKt$take$1<E> channelsKt__DeprecatedKt$take$1;
        ChannelsKt__DeprecatedKt$take$1<E> channelsKt__DeprecatedKt$take$12;
        ProducerScope producerScope2;
        ChannelIterator<E> channelIterator;
        int i2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    i2 = this.I$0;
                    channelIterator = (ChannelIterator) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    producerScope = (ProducerScope) this.L$0;
                    channelsKt__DeprecatedKt$take$1 = this;
                    int i4 = i2 - 1;
                    if (i4 != 0) {
                        return Unit.INSTANCE;
                    }
                    ChannelIterator<E> channelIterator2 = channelIterator;
                    i = i4;
                    it = channelIterator2;
                    channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
                    channelsKt__DeprecatedKt$take$1.L$1 = it;
                    channelsKt__DeprecatedKt$take$1.I$0 = i;
                    channelsKt__DeprecatedKt$take$1.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ChannelsKt__DeprecatedKt$take$1<E> channelsKt__DeprecatedKt$take$13 = channelsKt__DeprecatedKt$take$1;
                    producerScope2 = producerScope;
                    obj = hasNext;
                    channelsKt__DeprecatedKt$take$12 = channelsKt__DeprecatedKt$take$13;
                    int i5 = i;
                    channelIterator = it;
                    i2 = i5;
                    if (!((Boolean) obj).booleanValue()) {
                        E next = channelIterator.next();
                        channelsKt__DeprecatedKt$take$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$take$12.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$take$12.I$0 = i2;
                        channelsKt__DeprecatedKt$take$12.label = 2;
                        if (producerScope2.send(next, channelsKt__DeprecatedKt$take$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope = producerScope2;
                        channelsKt__DeprecatedKt$take$1 = channelsKt__DeprecatedKt$take$12;
                        int i42 = i2 - 1;
                        if (i42 != 0) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i2 = this.I$0;
                channelIterator = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelsKt__DeprecatedKt$take$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            int i6 = this.$n;
            if (i6 == 0) {
                return Unit.INSTANCE;
            }
            if (i6 >= 0) {
                z = true;
            } else {
                z = false;
            }
            i = this.$n;
            if (z) {
                it = this.$this_take.iterator();
                channelsKt__DeprecatedKt$take$1 = this;
                channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$take$1.L$1 = it;
                channelsKt__DeprecatedKt$take$1.I$0 = i;
                channelsKt__DeprecatedKt$take$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
        }
    }
}
