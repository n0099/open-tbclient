package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.internal.SafeCollector;
@FlowPreview
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class AbstractFlow<T> implements Flow<T> {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        int i2;
        SafeCollector safeCollector;
        if (continuation instanceof AbstractFlow$collect$1) {
            abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
            int i3 = abstractFlow$collect$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                abstractFlow$collect$1.label = i3 - Integer.MIN_VALUE;
                Object obj = abstractFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = abstractFlow$collect$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<? super T> safeCollector2 = new SafeCollector<>(flowCollector, abstractFlow$collect$1.getContext());
                    try {
                        abstractFlow$collect$1.L$0 = this;
                        abstractFlow$collect$1.L$1 = flowCollector;
                        abstractFlow$collect$1.L$2 = safeCollector2;
                        abstractFlow$collect$1.label = 1;
                        if (collectSafely(safeCollector2, abstractFlow$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th) {
                        th = th;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    safeCollector = (SafeCollector) abstractFlow$collect$1.L$2;
                    FlowCollector flowCollector2 = (FlowCollector) abstractFlow$collect$1.L$1;
                    AbstractFlow abstractFlow = (AbstractFlow) abstractFlow$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                return Unit.INSTANCE;
            }
        }
        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
        Object obj2 = abstractFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = abstractFlow$collect$1.label;
        if (i2 != 0) {
        }
        safeCollector.releaseIntercepted();
        return Unit.INSTANCE;
    }

    public abstract Object collectSafely(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
