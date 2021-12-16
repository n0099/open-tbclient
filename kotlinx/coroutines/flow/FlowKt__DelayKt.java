package kotlinx.coroutines.flow;

import com.alipay.sdk.data.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0005\u001a0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0013\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMillis", "debounce", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/time/Duration;", a.O, "debounce-8GFy2Ro", "(Lkotlinx/coroutines/flow/Flow;D)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "fixedPeriodTicker", "(Lkotlinx/coroutines/CoroutineScope;JJ)Lkotlinx/coroutines/channels/ReceiveChannel;", "periodMillis", "sample", "period", "sample-8GFy2Ro", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, long j2) {
        if (j2 > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounce$2(flow, j2, null));
        }
        throw new IllegalArgumentException("Debounce timeout should be positive".toString());
    }

    @FlowPreview
    @ExperimentalTime
    /* renamed from: debounce-8GFy2Ro */
    public static final <T> Flow<T> m2105debounce8GFy2Ro(Flow<? extends T> flow, double d2) {
        return FlowKt.debounce(flow, DelayKt.m2082toDelayMillisLRDsOJo(d2));
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope coroutineScope, long j2, long j3) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        }
        if (j3 >= 0) {
            return ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j3, j2, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, j2, j3);
    }

    @FlowPreview
    public static final <T> Flow<T> sample(Flow<? extends T> flow, long j2) {
        if (j2 > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$sample$2(flow, j2, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @FlowPreview
    @ExperimentalTime
    /* renamed from: sample-8GFy2Ro */
    public static final <T> Flow<T> m2106sample8GFy2Ro(Flow<? extends T> flow, double d2) {
        return FlowKt.sample(flow, DelayKt.m2082toDelayMillisLRDsOJo(d2));
    }
}
