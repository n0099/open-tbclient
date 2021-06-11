package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectClause1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed", "nonClosed", "remainingNulls"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes8.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function0 $arrayFactory;
    public final /* synthetic */ Flow[] $flows;
    public final /* synthetic */ FlowCollector $this_combineInternal;
    public final /* synthetic */ Function3 $transform;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    public CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0168  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0154 -> B:43:0x0164). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel[] receiveChannelArr;
        Object[] objArr;
        Boolean[] boolArr;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        CoroutineScope coroutineScope;
        int i2;
        Object obj2;
        ReceiveChannel asFairChannel;
        SelectBuilderImpl selectBuilderImpl;
        CombineKt$combineInternal$2 combineKt$combineInternal$22;
        CoroutineScope coroutineScope2;
        int i3;
        ReceiveChannel[] receiveChannelArr2;
        Object[] objArr2;
        Boolean[] boolArr2;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        Object result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        int i5 = 1;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            int length = this.$flows.length;
            ReceiveChannel[] receiveChannelArr3 = new ReceiveChannel[length];
            for (int i6 = 0; i6 < length; i6++) {
                asFairChannel = CombineKt.asFairChannel(coroutineScope3, this.$flows[Boxing.boxInt(i6).intValue()]);
                receiveChannelArr3[i6] = asFairChannel;
            }
            Object[] objArr3 = new Object[length];
            Boolean[] boolArr3 = new Boolean[length];
            for (int i7 = 0; i7 < length; i7++) {
                Boxing.boxInt(i7).intValue();
                boolArr3[i7] = Boxing.boxBoolean(false);
            }
            Ref.IntRef intRef5 = new Ref.IntRef();
            intRef5.element = length;
            Ref.IntRef intRef6 = new Ref.IntRef();
            intRef6.element = length;
            receiveChannelArr = receiveChannelArr3;
            objArr = objArr3;
            boolArr = boolArr3;
            intRef = intRef5;
            intRef2 = intRef6;
            combineKt$combineInternal$2 = this;
            coroutineScope = coroutineScope3;
            i2 = length;
            obj2 = coroutine_suspended;
            if (intRef.element != 0) {
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CombineKt$combineInternal$2 combineKt$combineInternal$23 = (CombineKt$combineInternal$2) this.L$6;
            int i8 = this.I$0;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            intRef2 = (Ref.IntRef) this.L$5;
            intRef = (Ref.IntRef) this.L$4;
            boolArr = (Boolean[]) this.L$3;
            objArr = (Object[]) this.L$2;
            receiveChannelArr = (ReceiveChannel[]) this.L$1;
            obj2 = coroutine_suspended;
            combineKt$combineInternal$2 = this;
            i2 = i8;
            coroutineScope = coroutineScope4;
            i5 = 1;
            if (intRef.element != 0) {
                combineKt$combineInternal$2.L$0 = coroutineScope;
                combineKt$combineInternal$2.I$0 = i2;
                combineKt$combineInternal$2.L$1 = receiveChannelArr;
                combineKt$combineInternal$2.L$2 = objArr;
                combineKt$combineInternal$2.L$3 = boolArr;
                combineKt$combineInternal$2.L$4 = intRef;
                combineKt$combineInternal$2.L$5 = intRef2;
                combineKt$combineInternal$2.L$6 = combineKt$combineInternal$2;
                combineKt$combineInternal$2.label = i5;
                SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(combineKt$combineInternal$2);
                int i9 = 0;
                while (i9 < i2) {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        selectBuilderImpl = selectBuilderImpl2;
                        combineKt$combineInternal$22 = combineKt$combineInternal$2;
                        coroutineScope2 = coroutineScope;
                        i3 = i2;
                        receiveChannelArr2 = receiveChannelArr;
                        objArr2 = objArr;
                        boolArr2 = boolArr;
                        intRef3 = intRef;
                    }
                    boolean booleanValue = boolArr[i9].booleanValue();
                    ReceiveChannel receiveChannel = receiveChannelArr[i9];
                    selectBuilderImpl = selectBuilderImpl2;
                    combineKt$combineInternal$22 = combineKt$combineInternal$2;
                    coroutineScope2 = coroutineScope;
                    i3 = i2;
                    receiveChannelArr2 = receiveChannelArr;
                    objArr2 = objArr;
                    boolArr2 = boolArr;
                    intRef3 = intRef;
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        intRef4 = intRef2;
                        selectBuilderImpl.handleBuilderException(th);
                        result = selectBuilderImpl.getResult();
                        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        }
                        if (result == obj2) {
                        }
                    }
                    CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(i9, null, combineKt$combineInternal$2, i2, boolArr, receiveChannelArr, objArr, intRef2, intRef);
                    if (booleanValue) {
                        intRef4 = intRef2;
                    } else {
                        SelectClause1 onReceiveOrNull = receiveChannel.getOnReceiveOrNull();
                        intRef4 = intRef2;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            selectBuilderImpl.handleBuilderException(th);
                            result = selectBuilderImpl.getResult();
                            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            }
                            if (result == obj2) {
                            }
                        }
                        selectBuilderImpl.invoke(onReceiveOrNull, new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1, null, i9, combineKt$combineInternal$22, i3, boolArr2, receiveChannelArr2, objArr2, intRef2, intRef3));
                    }
                    i9++;
                    selectBuilderImpl2 = selectBuilderImpl;
                    intRef2 = intRef4;
                    combineKt$combineInternal$2 = combineKt$combineInternal$22;
                    coroutineScope = coroutineScope2;
                    i2 = i3;
                    receiveChannelArr = receiveChannelArr2;
                    objArr = objArr2;
                    boolArr = boolArr2;
                    intRef = intRef3;
                }
                selectBuilderImpl = selectBuilderImpl2;
                combineKt$combineInternal$22 = combineKt$combineInternal$2;
                coroutineScope2 = coroutineScope;
                i3 = i2;
                receiveChannelArr2 = receiveChannelArr;
                objArr2 = objArr;
                boolArr2 = boolArr;
                intRef3 = intRef;
                intRef4 = intRef2;
                result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(combineKt$combineInternal$22);
                }
                if (result == obj2) {
                    return obj2;
                }
                intRef2 = intRef4;
                combineKt$combineInternal$2 = combineKt$combineInternal$22;
                coroutineScope = coroutineScope2;
                i2 = i3;
                receiveChannelArr = receiveChannelArr2;
                objArr = objArr2;
                boolArr = boolArr2;
                intRef = intRef3;
                i5 = 1;
                if (intRef.element != 0) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
