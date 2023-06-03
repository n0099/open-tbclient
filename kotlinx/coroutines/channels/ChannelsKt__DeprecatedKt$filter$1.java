package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {Constants.METHOD_IM_FETCH_BUSINESS_SESSION_MSG, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes10.dex */
public final class ChannelsKt__DeprecatedKt$filter$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    public final /* synthetic */ ReceiveChannel<E> $this_filter;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a4 -> B:14:0x0057). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<E> it;
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$1;
        ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$12;
        ProducerScope producerScope2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        it = (ChannelIterator) this.L$1;
                        producerScope = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    Object obj3 = this.L$2;
                    channelIterator = (ChannelIterator) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    E e = obj3;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filter$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__DeprecatedKt$filter$1.L$0 = producerScope3;
                        channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$filter$1.L$2 = null;
                        channelsKt__DeprecatedKt$filter$1.label = 3;
                        if (producerScope3.send(e, channelsKt__DeprecatedKt$filter$1) == obj2) {
                            return obj2;
                        }
                    }
                    channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
                    coroutine_suspended = obj2;
                    it = channelIterator;
                    producerScope = producerScope3;
                    channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
                    channelsKt__DeprecatedKt$filter$12.L$1 = it;
                    channelsKt__DeprecatedKt$filter$12.L$2 = null;
                    channelsKt__DeprecatedKt$filter$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filter$1 = channelsKt__DeprecatedKt$filter$12;
                    obj = hasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    obj2 = obj4;
                    if (!((Boolean) obj).booleanValue()) {
                        E next = channelIterator.next();
                        Function2<E, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$filter$1.$predicate;
                        channelsKt__DeprecatedKt$filter$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$filter$1.L$2 = next;
                        channelsKt__DeprecatedKt$filter$1.label = 2;
                        Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$filter$1);
                        if (invoke == obj2) {
                            return obj2;
                        }
                        ProducerScope producerScope4 = producerScope2;
                        e = next;
                        obj = invoke;
                        producerScope3 = producerScope4;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
                        coroutine_suspended = obj2;
                        it = channelIterator;
                        producerScope = producerScope3;
                        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
                        channelsKt__DeprecatedKt$filter$12.L$1 = it;
                        channelsKt__DeprecatedKt$filter$12.L$2 = null;
                        channelsKt__DeprecatedKt$filter$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                producerScope2 = (ProducerScope) this.L$0;
                channelIterator = (ChannelIterator) this.L$1;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$filter$1 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            it = this.$this_filter.iterator();
            producerScope = (ProducerScope) this.L$0;
        }
        channelsKt__DeprecatedKt$filter$12 = this;
        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filter$12.L$1 = it;
        channelsKt__DeprecatedKt$filter$12.L$2 = null;
        channelsKt__DeprecatedKt$filter$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
        if (hasNext == coroutine_suspended) {
        }
    }
}
