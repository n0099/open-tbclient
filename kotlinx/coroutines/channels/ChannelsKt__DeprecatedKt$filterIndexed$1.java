package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.adevent.AdEventType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {AdEventType.VIDEO_LOADING, AdEventType.VIDEO_PRELOADED, AdEventType.VIDEO_PRELOADED}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
/* loaded from: classes10.dex */
public final class ChannelsKt__DeprecatedKt$filterIndexed$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    public final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bc -> B:15:0x0062). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        ChannelIterator<E> it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        Object obj2;
        ChannelsKt__DeprecatedKt$filterIndexed$1<E> channelsKt__DeprecatedKt$filterIndexed$1;
        ChannelsKt__DeprecatedKt$filterIndexed$1<E> channelsKt__DeprecatedKt$filterIndexed$12;
        ChannelIterator<E> channelIterator;
        int i2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        i = this.I$0;
                        it = (ChannelIterator) this.L$1;
                        producerScope = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    int i4 = this.I$0;
                    Object obj3 = this.L$2;
                    producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    int i5 = i4;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filterIndexed$1 = this;
                    ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$1;
                    E e = obj3;
                    it = channelIterator2;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                        channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                        channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i5;
                        channelsKt__DeprecatedKt$filterIndexed$1.label = 3;
                        if (producerScope2.send(e, channelsKt__DeprecatedKt$filterIndexed$1) == obj2) {
                            return obj2;
                        }
                    }
                    channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
                    coroutine_suspended = obj2;
                    producerScope = producerScope2;
                    i = i5;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
                    channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
                    channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                    obj = hasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    i2 = i;
                    obj2 = obj4;
                    if (!((Boolean) obj).booleanValue()) {
                        E next = channelIterator.next();
                        Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = channelsKt__DeprecatedKt$filterIndexed$1.$predicate;
                        i5 = i2 + 1;
                        Integer boxInt = Boxing.boxInt(i2);
                        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$filterIndexed$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$filterIndexed$1.L$2 = next;
                        channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i5;
                        channelsKt__DeprecatedKt$filterIndexed$1.label = 2;
                        Object invoke = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$filterIndexed$1);
                        if (invoke == obj2) {
                            return obj2;
                        }
                        channelIterator2 = channelIterator;
                        e = next;
                        obj = invoke;
                        it = channelIterator2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
                        coroutine_suspended = obj2;
                        producerScope = producerScope2;
                        i = i5;
                        channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
                        channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
                        channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
                        channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
                        channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                int i6 = this.I$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = (ProducerScope) this.L$0;
                channelIterator = (ChannelIterator) this.L$1;
                i2 = i6;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$filterIndexed$1 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i = 0;
            it = this.$this_filterIndexed.iterator();
            producerScope = (ProducerScope) this.L$0;
        }
        channelsKt__DeprecatedKt$filterIndexed$12 = this;
        channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
        channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
        channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
        channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
        if (hasNext == coroutine_suspended) {
        }
    }
}
