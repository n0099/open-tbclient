package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class FlowKt__MigrationKt$combine$$inlined$combine$1 implements Flow<R> {
    public final /* synthetic */ Flow[] $flows$inlined;
    public final /* synthetic */ Function4 $transform$inlined$1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$1$lambda$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$combine$$inlined$combine$1$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass2 extends Lambda implements Function0<Object[]> {
        public AnonymousClass2() {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final Object[] invoke() {
            return new Object[FlowKt__MigrationKt$combine$$inlined$combine$1.this.$flows$inlined.length];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$1$lambda$2"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$combine$$inlined$combine$1$3", f = "Zip.kt", i = {0, 0}, l = {323}, m = "invokeSuspend", n = {"$receiver", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$combine$$inlined$combine$1$3  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public FlowCollector p$;
        public Object[] p$0;
        public final /* synthetic */ FlowKt__MigrationKt$combine$$inlined$combine$1 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Continuation continuation, FlowKt__MigrationKt$combine$$inlined$combine$1 flowKt__MigrationKt$combine$$inlined$combine$1) {
            super(3, continuation);
            this.this$0 = flowKt__MigrationKt$combine$$inlined$combine$1;
        }

        public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
            anonymousClass3.p$ = flowCollector;
            anonymousClass3.p$0 = objArr;
            return anonymousClass3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create((FlowCollector) obj, objArr, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    Object[] objArr = (Object[]) this.L$1;
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = this.p$;
                Object[] objArr2 = this.p$0;
                Object invoke = this.this$0.$transform$inlined$1.invoke(objArr2[0], objArr2[1], objArr2[2], this);
                this.L$0 = flowCollector2;
                this.L$1 = objArr2;
                this.label = 1;
                if (flowCollector2.emit(invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = this.p$;
            Object[] objArr = this.p$0;
            Object invoke = this.this$0.$transform$inlined$1.invoke(objArr[0], objArr[1], objArr[2], this);
            InlineMarker.mark(0);
            flowCollector.emit(invoke, this);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
    }

    public FlowKt__MigrationKt$combine$$inlined$combine$1(Flow[] flowArr, Function4 function4) {
        this.$flows$inlined = flowArr;
        this.$transform$inlined$1 = function4;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object combineInternal = CombineKt.combineInternal(flowCollector, this.$flows$inlined, new AnonymousClass2(), new AnonymousClass3(null, this), continuation);
        if (combineInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__MigrationKt$combine$$inlined$combine$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__MigrationKt$combine$$inlined$combine$1.this.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        Flow[] flowArr = this.$flows$inlined;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(null, this);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, anonymousClass2, anonymousClass3, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
