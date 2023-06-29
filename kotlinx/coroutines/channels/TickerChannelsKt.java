package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TickerChannelsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedDelayTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label = i2 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                                sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                sendChannel = sendChannel2;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                            sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                            tickerChannelsKt$fixedDelayTicker$1.label = 3;
                            if (DelayKt.delay(j, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel = sendChannel2;
                        }
                    } else {
                        j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (DelayKt.delay(j, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i == 0) {
        }
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
    }

    @ObsoleteCoroutinesApi
    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j2 < 0) {
                z2 = false;
            }
            if (z2) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j, j2, null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0108 -> B:18:0x0050). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x011f -> B:18:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i;
        Long boxLong;
        long longValue;
        SendChannel<? super Unit> sendChannel2;
        long j3;
        long j4;
        long delayToNanos;
        long j5;
        long j6;
        SendChannel<? super Unit> sendChannel3;
        AbstractTimeSource timeSource;
        Long boxLong2;
        long longValue2;
        long coerceAtLeast;
        long delayNanosToMillis;
        SendChannel<? super Unit> sendChannel4;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i2 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            long j7 = j6;
                            j3 = j5;
                            delayToNanos = j7;
                            sendChannel4 = sendChannel3;
                            long j8 = j3 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j8;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel3 = sendChannel4;
                            j6 = delayToNanos;
                            j5 = j8;
                            timeSource = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource != null) {
                                boxLong2 = null;
                            } else {
                                boxLong2 = Boxing.boxLong(timeSource.nanoTime());
                            }
                            if (boxLong2 != null) {
                                longValue2 = System.nanoTime();
                            } else {
                                longValue2 = boxLong2.longValue();
                            }
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j5 - longValue2, 0L);
                            if (coerceAtLeast != 0 && j6 != 0) {
                                long j9 = j6 - ((longValue2 - j5) % j6);
                                j5 = longValue2 + j9;
                                long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j9);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                                if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                                if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            long j72 = j6;
                            j3 = j5;
                            delayToNanos = j72;
                            sendChannel4 = sendChannel3;
                            long j82 = j3 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j82;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                        } else {
                            j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                            j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                            sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            timeSource = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource != null) {
                            }
                            if (boxLong2 != null) {
                            }
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j5 - longValue2, 0L);
                            if (coerceAtLeast != 0) {
                            }
                            delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                            if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                            long j722 = j6;
                            j3 = j5;
                            delayToNanos = j722;
                            sendChannel4 = sendChannel3;
                            long j822 = j3 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j822;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                        }
                    } else {
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 == null) {
                        boxLong = null;
                    } else {
                        boxLong = Boxing.boxLong(timeSource2.nanoTime());
                    }
                    if (boxLong == null) {
                        longValue = System.nanoTime();
                    } else {
                        longValue = boxLong.longValue();
                    }
                    long delayToNanos2 = longValue + EventLoop_commonKt.delayToNanos(j2);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = delayToNanos2;
                    j4 = j;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j4);
                sendChannel4 = sendChannel2;
                long j8222 = j3 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j8222;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i == 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j4);
        sendChannel4 = sendChannel2;
        long j82222 = j3 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j82222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }
}
