package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.SafeCollector;
@FlowPreview
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractFlow<T> implements Flow<T>, CancellableFlow<T> {
    public abstract Object collectSafely(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        if (continuation instanceof AbstractFlow$collect$1) {
            abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
            int i2 = abstractFlow$collect$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                abstractFlow$collect$1.label = i2 - Integer.MIN_VALUE;
                Object obj = abstractFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = abstractFlow$collect$1.label;
                if (i == 0) {
                    if (i == 1) {
                        safeCollector = (SafeCollector) abstractFlow$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            safeCollector.releaseIntercepted();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<? super T> safeCollector2 = new SafeCollector<>(flowCollector, abstractFlow$collect$1.getContext());
                    try {
                        abstractFlow$collect$1.L$0 = safeCollector2;
                        abstractFlow$collect$1.label = 1;
                        if (collectSafely(safeCollector2, abstractFlow$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector = safeCollector2;
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
        i = abstractFlow$collect$1.label;
        if (i == 0) {
        }
        safeCollector.releaseIntercepted();
        return Unit.INSTANCE;
    }
}
