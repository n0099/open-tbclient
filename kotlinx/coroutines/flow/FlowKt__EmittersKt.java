package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001as\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012D\u0010\u000b\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f23\u0010\u000b\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001an\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f2D\u0010\u000b\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013\u001aW\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f2-\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0012\u001au\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u00028\u00000\u000f2D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001au\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u00028\u00000\u000f2D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\nH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "action", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeSafely", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "onCompletion", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onStart", "R", "value", "transform", "unsafeTransform", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__EmittersKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object invokeSafely$FlowKt__EmittersKt(FlowCollector flowCollector, Function3 function3, Throwable th, Continuation continuation) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        int i;
        try {
            if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
                flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
                int i2 = flowKt__EmittersKt$invokeSafely$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__EmittersKt$invokeSafely$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = flowKt__EmittersKt$invokeSafely$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__EmittersKt$invokeSafely$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            th = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$2;
                            Function3 function32 = (Function3) flowKt__EmittersKt$invokeSafely$1.L$1;
                            FlowCollector flowCollector2 = (FlowCollector) flowKt__EmittersKt$invokeSafely$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowKt__EmittersKt$invokeSafely$1.L$0 = flowCollector;
                        flowKt__EmittersKt$invokeSafely$1.L$1 = function3;
                        flowKt__EmittersKt$invokeSafely$1.L$2 = th;
                        flowKt__EmittersKt$invokeSafely$1.label = 1;
                        if (function3.invoke(flowCollector, th, flowKt__EmittersKt$invokeSafely$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i == 0) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            if (th != null) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th2, th);
            }
            throw th2;
        }
        flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
        Object obj2 = flowKt__EmittersKt$invokeSafely$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__EmittersKt$invokeSafely$1.label;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.flow.FlowKt.onCompletion(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2):kotlinx.coroutines.flow.Flow] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with a version w/o FlowCollector receiver")
    public static final /* synthetic */ Flow onCompletion(Flow flow, Function2 function2) {
        return FlowKt.onCompletion(flow, new FlowKt__EmittersKt$onCompletion$2(function2, null));
    }

    public static final Flow onStart(Flow flow, Function2 function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(flow, function2);
    }

    public static final Flow transform(Flow flow, Function3 function3) {
        return FlowKt.flow(new FlowKt__EmittersKt$transform$1(flow, function3, null));
    }

    public static final Flow unsafeTransform(Flow flow, Function3 function3) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(flow, function3);
    }

    public static final Flow onCompletion(Flow flow, Function3 function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(flow, function3);
    }
}
