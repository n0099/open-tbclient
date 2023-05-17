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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.TimeSourceKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/SendChannel;", "", "channel", "fixedDelayTicker", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "ticker", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            $EnumSwitchMapping$0[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008f -> B:14:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        long j3;
        long j4;
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
                                sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                                j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                                j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                                ResultKt.throwOnFailure(obj);
                                sendChannel = sendChannel2;
                                j2 = j4;
                                j = j3;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                            j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                            j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                            ResultKt.throwOnFailure(obj);
                            tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                            tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedDelayTicker$1.label = 3;
                            if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel = sendChannel2;
                            j2 = j4;
                            j = j3;
                        }
                    } else {
                        sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        j2 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                        j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long j5 = j;
                sendChannel2 = sendChannel;
                j4 = j2;
                j3 = j5;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                j2 = j4;
                j = j3;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
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
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0172 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0173  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0142 -> B:49:0x0145). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0173 -> B:50:0x0146). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i;
        long nanoTime;
        SendChannel<? super Unit> sendChannel2;
        long j3;
        long j4;
        Long boxLong;
        long delayToNanos;
        long j5;
        long j6;
        long j7;
        SendChannel<? super Unit> sendChannel3;
        long j8;
        TimeSource timeSource;
        long nanoTime2;
        long j9;
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$12;
        long j10;
        long coerceAtLeast;
        long delayNanosToMillis;
        Long boxLong2;
        SendChannel<? super Unit> sendChannel4;
        Unit unit;
        long j11 = j2;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i2 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                int i3 = 2;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    long j12 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                                    long j13 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                                    j8 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                long j14 = tickerChannelsKt$fixedPeriodTicker$1.J$6;
                                long j15 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                                long j16 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                                j8 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                                j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                                sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            long j17 = j6;
                            j4 = j5;
                            delayToNanos = j8;
                            j11 = j17;
                            sendChannel4 = sendChannel3;
                            i3 = 2;
                            j7 = j3 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = i3;
                            if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel3 = sendChannel4;
                            long j18 = j11;
                            j8 = delayToNanos;
                            j5 = j4;
                            j6 = j18;
                            timeSource = TimeSourceKt.getTimeSource();
                            if (timeSource == null && (boxLong2 = Boxing.boxLong(timeSource.nanoTime())) != null) {
                                nanoTime2 = boxLong2.longValue();
                            } else {
                                nanoTime2 = System.nanoTime();
                            }
                            j9 = nanoTime2;
                            tickerChannelsKt$fixedPeriodTicker$12 = tickerChannelsKt$fixedPeriodTicker$1;
                            j10 = j7;
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j7 - j9, 0L);
                            if (coerceAtLeast != 0 && j8 != 0) {
                                long j19 = j8 - ((j9 - j10) % j8);
                                long j20 = j9 + j19;
                                long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j19);
                                tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                                tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                                tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$12.J$2 = j20;
                                tickerChannelsKt$fixedPeriodTicker$12.J$3 = j8;
                                tickerChannelsKt$fixedPeriodTicker$12.J$4 = j9;
                                tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                                tickerChannelsKt$fixedPeriodTicker$12.J$6 = j19;
                                tickerChannelsKt$fixedPeriodTicker$12.label = 3;
                                if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$12;
                                j3 = j20;
                                long j172 = j6;
                                j4 = j5;
                                delayToNanos = j8;
                                j11 = j172;
                                sendChannel4 = sendChannel3;
                                i3 = 2;
                                j7 = j3 + delayToNanos;
                                unit = Unit.INSTANCE;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                                tickerChannelsKt$fixedPeriodTicker$1.label = i3;
                                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                }
                            } else {
                                delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                                tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                                tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                                long j21 = j6;
                                tickerChannelsKt$fixedPeriodTicker$12.J$2 = j10;
                                tickerChannelsKt$fixedPeriodTicker$12.J$3 = j8;
                                tickerChannelsKt$fixedPeriodTicker$12.J$4 = j9;
                                tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                                tickerChannelsKt$fixedPeriodTicker$12.label = 4;
                                if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$12) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$12;
                                j3 = j10;
                                j6 = j21;
                                long j1722 = j6;
                                j4 = j5;
                                delayToNanos = j8;
                                j11 = j1722;
                                sendChannel4 = sendChannel3;
                                i3 = 2;
                                j7 = j3 + delayToNanos;
                                unit = Unit.INSTANCE;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                                tickerChannelsKt$fixedPeriodTicker$1.label = i3;
                                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                }
                            }
                        } else {
                            j8 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                            j7 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                            sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                            j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                            j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                            ResultKt.throwOnFailure(obj);
                            timeSource = TimeSourceKt.getTimeSource();
                            if (timeSource == null) {
                            }
                            nanoTime2 = System.nanoTime();
                            j9 = nanoTime2;
                            tickerChannelsKt$fixedPeriodTicker$12 = tickerChannelsKt$fixedPeriodTicker$1;
                            j10 = j7;
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j7 - j9, 0L);
                            if (coerceAtLeast != 0) {
                            }
                            delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                            tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                            tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                            tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                            long j212 = j6;
                            tickerChannelsKt$fixedPeriodTicker$12.J$2 = j10;
                            tickerChannelsKt$fixedPeriodTicker$12.J$3 = j8;
                            tickerChannelsKt$fixedPeriodTicker$12.J$4 = j9;
                            tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                            tickerChannelsKt$fixedPeriodTicker$12.label = 4;
                            if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$12) != coroutine_suspended) {
                            }
                        }
                    } else {
                        long j22 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        long j23 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j11 = j23;
                        j3 = j22;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                    if (timeSource2 != null && (boxLong = Boxing.boxLong(timeSource2.nanoTime())) != null) {
                        nanoTime = boxLong.longValue();
                    } else {
                        nanoTime = System.nanoTime();
                    }
                    long delayToNanos2 = nanoTime + EventLoop_commonKt.delayToNanos(j2);
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = delayToNanos2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j11, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = delayToNanos2;
                    j4 = j;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j4);
                sendChannel4 = sendChannel2;
                j7 = j3 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
                tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = i3;
                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        int i32 = 2;
        if (i == 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j4);
        sendChannel4 = sendChannel2;
        j7 = j3 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j11;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j7;
        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = i32;
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
