package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\u0012-\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R@\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000b8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/flow/SafeFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SafeFlow implements Flow {
    public final Function2 block;

    public SafeFlow(Function2 function2) {
        this.block = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        SafeFlow$collect$1 safeFlow$collect$1;
        int i;
        SafeCollector safeCollector;
        if (continuation instanceof SafeFlow$collect$1) {
            safeFlow$collect$1 = (SafeFlow$collect$1) continuation;
            int i2 = safeFlow$collect$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                safeFlow$collect$1.label = i2 - Integer.MIN_VALUE;
                Object obj = safeFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = safeFlow$collect$1.label;
                if (i == 0) {
                    if (i == 1) {
                        safeCollector = (SafeCollector) safeFlow$collect$1.L$2;
                        FlowCollector flowCollector2 = (FlowCollector) safeFlow$collect$1.L$1;
                        SafeFlow safeFlow = (SafeFlow) safeFlow$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th) {
                            th = th;
                            safeCollector.releaseIntercepted();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector, safeFlow$collect$1.getContext());
                    try {
                        Function2 function2 = this.block;
                        safeFlow$collect$1.L$0 = this;
                        safeFlow$collect$1.L$1 = flowCollector;
                        safeFlow$collect$1.L$2 = safeCollector2;
                        safeFlow$collect$1.label = 1;
                        if (function2.invoke(safeCollector2, safeFlow$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                return Unit.INSTANCE;
            }
        }
        safeFlow$collect$1 = new SafeFlow$collect$1(this, continuation);
        Object obj2 = safeFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = safeFlow$collect$1.label;
        if (i == 0) {
        }
        safeCollector.releaseIntercepted();
        return Unit.INSTANCE;
    }
}
