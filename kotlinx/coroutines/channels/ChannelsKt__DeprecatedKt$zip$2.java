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
/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
/* loaded from: classes10.dex */
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel<R> $other;
    public final /* synthetic */ ReceiveChannel<E> $this_zip;
    public final /* synthetic */ Function2<E, R, V> $transform;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends R> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super R, ? extends V> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:26:0x00b1, B:28:0x00b9, B:40:0x0109, B:13:0x004a), top: B:54:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9 A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #2 {all -> 0x0106, blocks: (B:32:0x00d9, B:35:0x00e9), top: B:52:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109 A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:26:0x00b1, B:28:0x00b9, B:40:0x0109, B:13:0x004a), top: B:54:0x004a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:22:0x0093). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        Function2 function2;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$2;
        ChannelIterator channelIterator;
        ChannelIterator it;
        ReceiveChannel receiveChannel2;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        Function2 function22;
        ReceiveChannel receiveChannel3;
        Object obj2;
        ChannelIterator channelIterator3;
        Object obj3;
        ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$22;
        ProducerScope producerScope3;
        ChannelIterator channelIterator4;
        Function2 function23;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            it = (ChannelIterator) this.L$4;
                            receiveChannel = (ReceiveChannel) this.L$3;
                            function2 = (Function2) this.L$2;
                            channelIterator = (ChannelIterator) this.L$1;
                            producerScope = (ProducerScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            channelsKt__DeprecatedKt$zip$2 = this;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        Object obj4 = this.L$5;
                        channelIterator3 = (ChannelIterator) this.L$4;
                        receiveChannel2 = (ReceiveChannel) this.L$3;
                        Function2 function24 = (Function2) this.L$2;
                        ChannelIterator channelIterator5 = (ChannelIterator) this.L$1;
                        ProducerScope producerScope4 = (ProducerScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            producerScope2 = producerScope4;
                            channelIterator2 = channelIterator5;
                            function22 = function24;
                            receiveChannel3 = receiveChannel2;
                            obj2 = obj4;
                            obj3 = coroutine_suspended;
                            channelsKt__DeprecatedKt$zip$22 = this;
                            try {
                                if (((Boolean) obj).booleanValue()) {
                                    Object invoke = function22.invoke(obj2, channelIterator2.next());
                                    channelsKt__DeprecatedKt$zip$22.L$0 = producerScope2;
                                    channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator2;
                                    channelsKt__DeprecatedKt$zip$22.L$2 = function22;
                                    channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel3;
                                    channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                                    channelsKt__DeprecatedKt$zip$22.L$5 = null;
                                    channelsKt__DeprecatedKt$zip$22.label = 3;
                                    if (producerScope2.send(invoke, channelsKt__DeprecatedKt$zip$22) == obj3) {
                                        return obj3;
                                    }
                                }
                                channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                                coroutine_suspended = obj3;
                                it = channelIterator3;
                                receiveChannel = receiveChannel3;
                                function2 = function22;
                                channelIterator = channelIterator2;
                                producerScope = producerScope2;
                            } catch (Throwable th) {
                                th = th;
                                receiveChannel = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            receiveChannel = receiveChannel2;
                            throw th;
                        }
                    }
                } else {
                    ChannelIterator channelIterator6 = (ChannelIterator) this.L$4;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) this.L$3;
                    Function2 function25 = (Function2) this.L$2;
                    ChannelIterator channelIterator7 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope3 = producerScope5;
                    channelIterator4 = channelIterator7;
                    function23 = function25;
                    receiveChannel2 = receiveChannel4;
                    channelIterator3 = channelIterator6;
                    obj3 = coroutine_suspended;
                    channelsKt__DeprecatedKt$zip$22 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator3.next();
                        channelsKt__DeprecatedKt$zip$22.L$0 = producerScope3;
                        channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator4;
                        channelsKt__DeprecatedKt$zip$22.L$2 = function23;
                        channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                        channelsKt__DeprecatedKt$zip$22.L$5 = next;
                        channelsKt__DeprecatedKt$zip$22.label = 2;
                        Object hasNext = channelIterator4.hasNext(channelsKt__DeprecatedKt$zip$22);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        ReceiveChannel receiveChannel5 = receiveChannel2;
                        obj2 = next;
                        obj = hasNext;
                        producerScope2 = producerScope3;
                        channelIterator2 = channelIterator4;
                        function22 = function23;
                        receiveChannel3 = receiveChannel5;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                        coroutine_suspended = obj3;
                        it = channelIterator3;
                        receiveChannel = receiveChannel3;
                        function2 = function22;
                        channelIterator = channelIterator2;
                        producerScope = producerScope2;
                    } else {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                ChannelIterator it2 = this.$other.iterator();
                receiveChannel = this.$this_zip;
                function2 = this.$transform;
                producerScope = producerScope6;
                channelsKt__DeprecatedKt$zip$2 = this;
                channelIterator = it2;
                it = receiveChannel.iterator();
            }
            channelsKt__DeprecatedKt$zip$2.L$0 = producerScope;
            channelsKt__DeprecatedKt$zip$2.L$1 = channelIterator;
            channelsKt__DeprecatedKt$zip$2.L$2 = function2;
            channelsKt__DeprecatedKt$zip$2.L$3 = receiveChannel;
            channelsKt__DeprecatedKt$zip$2.L$4 = it;
            channelsKt__DeprecatedKt$zip$2.L$5 = null;
            channelsKt__DeprecatedKt$zip$2.label = 1;
            Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$zip$2);
            if (hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj5 = coroutine_suspended;
            channelsKt__DeprecatedKt$zip$22 = channelsKt__DeprecatedKt$zip$2;
            obj = hasNext2;
            producerScope3 = producerScope;
            channelIterator4 = channelIterator;
            function23 = function2;
            receiveChannel2 = receiveChannel;
            channelIterator3 = it;
            obj3 = obj5;
            if (!((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
