package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"T", "Lorg/reactivestreams/Publisher;", "Lkotlin/Function1;", "", "action", "collect", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeEach", "", "request", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "(Lorg/reactivestreams/Publisher;I)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:12:0x0042, B:25:0x0087, B:27:0x008f, B:21:0x006c, B:28:0x0099), top: B:41:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:12:0x0042, B:25:0x0087, B:27:0x008f, B:21:0x006c, B:28:0x0099), top: B:41:0x0042 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:25:0x0087). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelKt$collect$1 channelKt$collect$1;
        int i2;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Function1<? super T, Unit> function12;
        Publisher<T> publisher2;
        ChannelIterator channelIterator;
        Object obj;
        ChannelKt$collect$1 channelKt$collect$12;
        ReceiveChannel receiveChannel3;
        Object hasNext;
        if (continuation instanceof ChannelKt$collect$1) {
            channelKt$collect$1 = (ChannelKt$collect$1) continuation;
            int i3 = channelKt$collect$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                channelKt$collect$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = channelKt$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelKt$collect$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    ReceiveChannel openSubscription$default = openSubscription$default(publisher, 0, 1, null);
                    try {
                        ChannelIterator it = openSubscription$default.iterator();
                        receiveChannel2 = openSubscription$default;
                        th = null;
                        function12 = function1;
                        receiveChannel = receiveChannel2;
                        publisher2 = publisher;
                        channelIterator = it;
                        obj = coroutine_suspended;
                        channelKt$collect$12 = channelKt$collect$1;
                        receiveChannel3 = receiveChannel;
                        channelKt$collect$12.L$0 = publisher2;
                        channelKt$collect$12.L$1 = function12;
                        channelKt$collect$12.L$2 = receiveChannel2;
                        channelKt$collect$12.L$3 = receiveChannel;
                        channelKt$collect$12.L$4 = th;
                        channelKt$collect$12.L$5 = receiveChannel3;
                        channelKt$collect$12.L$6 = channelIterator;
                        channelKt$collect$12.label = 1;
                        hasNext = channelIterator.hasNext(channelKt$collect$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        receiveChannel = openSubscription$default;
                        throw th;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelKt$collect$1.L$6;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelKt$collect$1.L$5;
                    Throwable th3 = (Throwable) channelKt$collect$1.L$4;
                    receiveChannel = (ReceiveChannel) channelKt$collect$1.L$3;
                    ReceiveChannel receiveChannel5 = (ReceiveChannel) channelKt$collect$1.L$2;
                    Function1<? super T, Unit> function13 = (Function1) channelKt$collect$1.L$1;
                    Publisher<T> publisher3 = (Publisher) channelKt$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelKt$collect$1 channelKt$collect$13 = channelKt$collect$1;
                        receiveChannel3 = receiveChannel4;
                        publisher2 = publisher3;
                        ReceiveChannel receiveChannel6 = receiveChannel5;
                        th = th3;
                        obj = coroutine_suspended;
                        channelKt$collect$12 = channelKt$collect$13;
                        if (!((Boolean) obj2).booleanValue()) {
                            function13.invoke((Object) channelIterator.next());
                            function12 = function13;
                            receiveChannel2 = receiveChannel6;
                            channelKt$collect$12.L$0 = publisher2;
                            channelKt$collect$12.L$1 = function12;
                            channelKt$collect$12.L$2 = receiveChannel2;
                            channelKt$collect$12.L$3 = receiveChannel;
                            channelKt$collect$12.L$4 = th;
                            channelKt$collect$12.L$5 = receiveChannel3;
                            channelKt$collect$12.L$6 = channelIterator;
                            channelKt$collect$12.label = 1;
                            hasNext = channelIterator.hasNext(channelKt$collect$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            ReceiveChannel receiveChannel7 = receiveChannel2;
                            function13 = function12;
                            obj2 = hasNext;
                            receiveChannel6 = receiveChannel7;
                            if (!((Boolean) obj2).booleanValue()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            throw th;
                        } finally {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            InlineMarker.finallyEnd(1);
                        }
                    }
                }
            }
        }
        channelKt$collect$1 = new ChannelKt$collect$1(continuation);
        Object obj22 = channelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelKt$collect$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final Object collect$$forInline(Publisher publisher, Function1 function1, Continuation continuation) {
        ReceiveChannel openSubscription$default = openSubscription$default(publisher, 0, 1, null);
        try {
            ChannelIterator it = openSubscription$default.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(openSubscription$default, null);
                    InlineMarker.finallyEnd(1);
                    return unit;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:12:0x0042, B:25:0x0087, B:27:0x008f, B:21:0x006c, B:28:0x0099), top: B:41:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:12:0x0042, B:25:0x0087, B:27:0x008f, B:21:0x006c, B:28:0x0099), top: B:41:0x0042 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:25:0x0087). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use collect instead", replaceWith = @ReplaceWith(expression = "this.collect(action)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object consumeEach(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelKt$consumeEach$1 channelKt$consumeEach$1;
        int i2;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Function1<? super T, Unit> function12;
        Publisher<T> publisher2;
        ChannelIterator channelIterator;
        Object obj;
        ChannelKt$consumeEach$1 channelKt$consumeEach$12;
        ReceiveChannel receiveChannel3;
        Object hasNext;
        if (continuation instanceof ChannelKt$consumeEach$1) {
            channelKt$consumeEach$1 = (ChannelKt$consumeEach$1) continuation;
            int i3 = channelKt$consumeEach$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                channelKt$consumeEach$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = channelKt$consumeEach$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelKt$consumeEach$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    ReceiveChannel openSubscription$default = openSubscription$default(publisher, 0, 1, null);
                    try {
                        ChannelIterator it = openSubscription$default.iterator();
                        receiveChannel2 = openSubscription$default;
                        th = null;
                        function12 = function1;
                        receiveChannel = receiveChannel2;
                        publisher2 = publisher;
                        channelIterator = it;
                        obj = coroutine_suspended;
                        channelKt$consumeEach$12 = channelKt$consumeEach$1;
                        receiveChannel3 = receiveChannel;
                        channelKt$consumeEach$12.L$0 = publisher2;
                        channelKt$consumeEach$12.L$1 = function12;
                        channelKt$consumeEach$12.L$2 = receiveChannel2;
                        channelKt$consumeEach$12.L$3 = receiveChannel;
                        channelKt$consumeEach$12.L$4 = th;
                        channelKt$consumeEach$12.L$5 = receiveChannel3;
                        channelKt$consumeEach$12.L$6 = channelIterator;
                        channelKt$consumeEach$12.label = 1;
                        hasNext = channelIterator.hasNext(channelKt$consumeEach$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        receiveChannel = openSubscription$default;
                        throw th;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelKt$consumeEach$1.L$6;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelKt$consumeEach$1.L$5;
                    Throwable th3 = (Throwable) channelKt$consumeEach$1.L$4;
                    receiveChannel = (ReceiveChannel) channelKt$consumeEach$1.L$3;
                    ReceiveChannel receiveChannel5 = (ReceiveChannel) channelKt$consumeEach$1.L$2;
                    Function1<? super T, Unit> function13 = (Function1) channelKt$consumeEach$1.L$1;
                    Publisher<T> publisher3 = (Publisher) channelKt$consumeEach$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelKt$consumeEach$1 channelKt$consumeEach$13 = channelKt$consumeEach$1;
                        receiveChannel3 = receiveChannel4;
                        publisher2 = publisher3;
                        ReceiveChannel receiveChannel6 = receiveChannel5;
                        th = th3;
                        obj = coroutine_suspended;
                        channelKt$consumeEach$12 = channelKt$consumeEach$13;
                        if (!((Boolean) obj2).booleanValue()) {
                            function13.invoke((Object) channelIterator.next());
                            function12 = function13;
                            receiveChannel2 = receiveChannel6;
                            channelKt$consumeEach$12.L$0 = publisher2;
                            channelKt$consumeEach$12.L$1 = function12;
                            channelKt$consumeEach$12.L$2 = receiveChannel2;
                            channelKt$consumeEach$12.L$3 = receiveChannel;
                            channelKt$consumeEach$12.L$4 = th;
                            channelKt$consumeEach$12.L$5 = receiveChannel3;
                            channelKt$consumeEach$12.L$6 = channelIterator;
                            channelKt$consumeEach$12.label = 1;
                            hasNext = channelIterator.hasNext(channelKt$consumeEach$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            ReceiveChannel receiveChannel7 = receiveChannel2;
                            function13 = function12;
                            obj2 = hasNext;
                            receiveChannel6 = receiveChannel7;
                            if (!((Boolean) obj2).booleanValue()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            throw th;
                        } finally {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            InlineMarker.finallyEnd(1);
                        }
                    }
                }
            }
        }
        channelKt$consumeEach$1 = new ChannelKt$consumeEach$1(continuation);
        Object obj22 = channelKt$consumeEach$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelKt$consumeEach$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use collect instead", replaceWith = @ReplaceWith(expression = "this.collect(action)", imports = {}))
    public static final Object consumeEach$$forInline(Publisher publisher, Function1 function1, Continuation continuation) {
        ReceiveChannel openSubscription$default = openSubscription$default(publisher, 0, 1, null);
        try {
            ChannelIterator it = openSubscription$default.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(openSubscription$default, null);
                    InlineMarker.finallyEnd(1);
                    return unit;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Transforming publisher to channel is deprecated, use asFlow() instead")
    public static final <T> ReceiveChannel<T> openSubscription(Publisher<T> publisher, int i2) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i2);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel openSubscription$default(Publisher publisher, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 1;
        }
        return openSubscription(publisher, i2);
    }
}
