package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowSubscription$consumeFlow$$inlined$collect$1 implements FlowCollector {
    public final /* synthetic */ FlowSubscription this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\u0007"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1", f = "ReactiveFlow.kt", i = {0, 0, 0, 0}, l = {Cea708Decoder.COMMAND_DLW}, m = "emit", n = {"this", "value", "continuation", "value"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowSubscription$consumeFlow$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowSubscription$consumeFlow$$inlined$collect$1(FlowSubscription flowSubscription) {
        this.this$0 = flowSubscription;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        FlowSubscription$consumeFlow$$inlined$collect$1 flowSubscription$consumeFlow$$inlined$collect$1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i == 0) {
                    if (i == 1) {
                        AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$4;
                        obj = anonymousClass1.L$3;
                        Continuation continuation2 = (Continuation) anonymousClass1.L$2;
                        Object obj3 = anonymousClass1.L$1;
                        flowSubscription$consumeFlow$$inlined$collect$1 = (FlowSubscription$consumeFlow$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    JobKt.ensureActive(this.this$0.getCoroutineContext());
                    if (this.this$0.requested <= 0) {
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = anonymousClass1;
                        anonymousClass1.L$3 = obj;
                        anonymousClass1.L$4 = anonymousClass1;
                        anonymousClass1.label = 1;
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(anonymousClass1), 1);
                        this.this$0.producer = cancellableContinuationImpl;
                        if (this.this$0.requested != 0) {
                            this.this$0.resumeSafely(cancellableContinuationImpl);
                        }
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    flowSubscription$consumeFlow$$inlined$collect$1 = this;
                }
                FlowSubscription.requested$FU.decrementAndGet(flowSubscription$consumeFlow$$inlined$collect$1.this$0);
                flowSubscription$consumeFlow$$inlined$collect$1.this$0.subscriber.onNext(obj);
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i == 0) {
        }
        FlowSubscription.requested$FU.decrementAndGet(flowSubscription$consumeFlow$$inlined$collect$1.this$0);
        flowSubscription$consumeFlow$$inlined$collect$1.this$0.subscriber.onNext(obj);
        return Unit.INSTANCE;
    }
}
