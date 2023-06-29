package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0087\b¢\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return receiveChannel.receiveOrNull(continuation);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(receiveChannel);
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0079), top: B:40:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0079), top: B:40:0x0066 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please submit an issue!!! */
    @ObsoleteCoroutinesApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        int i;
        ReceiveChannel<E> receiveChannel;
        Throwable th;
        ReceiveChannel<E> receiveChannel2;
        ChannelIterator<E> it;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            int i2 = channelsKt__Channels_commonKt$consumeEach$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$consumeEach$3.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEach$3.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator<E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                        receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                        Function1<? super E, Unit> function12 = (Function1) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                            ReceiveChannel<E> receiveChannel3 = receiveChannel;
                            function1 = function12;
                            ChannelIterator<E> channelIterator2 = channelIterator;
                            Object obj2 = coroutine_suspended;
                            ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$33 = channelsKt__Channels_commonKt$consumeEach$32;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke((Object) channelIterator2.next());
                                    receiveChannel2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$consumeEach$3 = channelsKt__Channels_commonKt$consumeEach$33;
                                    coroutine_suspended = obj2;
                                    it = channelIterator2;
                                    try {
                                        channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                                        channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                                        channelsKt__Channels_commonKt$consumeEach$3.L$2 = it;
                                        channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        channelIterator2 = it;
                                        Object obj22 = coroutine_suspended;
                                        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$332 = channelsKt__Channels_commonKt$consumeEach$32;
                                        if (!((Boolean) obj).booleanValue()) {
                                            Unit unit = Unit.INSTANCE;
                                            InlineMarker.finallyStart(1);
                                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                                            InlineMarker.finallyEnd(1);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        receiveChannel = receiveChannel2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                receiveChannel = receiveChannel3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
                    try {
                        receiveChannel2 = openSubscription;
                        it = openSubscription.iterator();
                        channelsKt__Channels_commonKt$consumeEach$3.L$0 = function1;
                        channelsKt__Channels_commonKt$consumeEach$3.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$3.L$2 = it;
                        channelsKt__Channels_commonKt$consumeEach$3.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$3);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel = openSubscription;
                        th = th5;
                    }
                }
                InlineMarker.finallyStart(1);
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$consumeEach$3.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$3.label;
        if (i == 0) {
        }
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0065, B:21:0x004a, B:28:0x006e), top: B:39:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0065, B:21:0x004a, B:28:0x006e), top: B:39:0x0031 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> it;
        Function1<? super E, Unit> function12;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
            channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
            int i2 = channelsKt__Channels_commonKt$consumeEach$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$consumeEach$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEach$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                        Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                function13.invoke((Object) channelIterator2.next());
                                function12 = function13;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$consumeEach$1.L$0 = function12;
                                channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
                                channelsKt__Channels_commonKt$consumeEach$1.L$2 = it;
                                channelsKt__Channels_commonKt$consumeEach$1.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function13 = function12;
                                obj = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                throw th3;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        channelsKt__Channels_commonKt$consumeEach$1.L$0 = function12;
                        channelsKt__Channels_commonKt$consumeEach$1.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$1.L$2 = it;
                        channelsKt__Channels_commonKt$consumeEach$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$consumeEach$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$1.label;
        if (i == 0) {
        }
    }

    @ObsoleteCoroutinesApi
    public static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator<E> it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    function1.invoke(it.next());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: E, ? super E */
    public static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        try {
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    function1.invoke((E) it.next());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<? extends E>, kotlinx.coroutines.selects.SelectClause1<E> */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> SelectClause1<E> onReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
        return (SelectClause1<? extends E>) receiveChannel.getOnReceiveOrNull();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:26:0x0068, B:28:0x0070, B:29:0x0079), top: B:44:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:26:0x0068, B:28:0x0070, B:29:0x0079), top: B:44:0x0035 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        List list;
        ChannelIterator<? extends E> it;
        List list2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toList$1) {
            channelsKt__Channels_commonKt$toList$1 = (ChannelsKt__Channels_commonKt$toList$1) continuation;
            int i2 = channelsKt__Channels_commonKt$toList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toList$1.label = i2 - Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$toList$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$toList$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$toList$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$2;
                        List list3 = (List) channelsKt__Channels_commonKt$toList$1.L$1;
                        list = (List) channelsKt__Channels_commonKt$toList$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            List list4 = list3;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            if (!((Boolean) obj).booleanValue()) {
                                list4.add(channelIterator2.next());
                                receiveChannel2 = receiveChannel3;
                                list2 = list4;
                                it = channelIterator2;
                                try {
                                    channelsKt__Channels_commonKt$toList$1.L$0 = list;
                                    channelsKt__Channels_commonKt$toList$1.L$1 = list2;
                                    channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
                                    channelsKt__Channels_commonKt$toList$1.L$3 = it;
                                    channelsKt__Channels_commonKt$toList$1.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel3 = receiveChannel2;
                                    obj = hasNext;
                                    list4 = list2;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel3, null);
                                        return CollectionsKt__CollectionsJVMKt.build(list);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                                        throw th3;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            receiveChannel2 = receiveChannel3;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
                        list = createListBuilder;
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        list2 = createListBuilder;
                        channelsKt__Channels_commonKt$toList$1.L$0 = list;
                        channelsKt__Channels_commonKt$toList$1.L$1 = list2;
                        channelsKt__Channels_commonKt$toList$1.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$toList$1.L$3 = it;
                        channelsKt__Channels_commonKt$toList$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$toList$1 = new ChannelsKt__Channels_commonKt$toList$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$toList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toList$1.label;
        if (i == 0) {
        }
    }
}
