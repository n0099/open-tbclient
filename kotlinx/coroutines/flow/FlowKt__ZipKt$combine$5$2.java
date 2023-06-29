package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 6, 0}, xi = MatroskaExtractor.ID_PIXEL_WIDTH)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", f = "Zip.kt", i = {}, l = {238, 238}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combine$5$2<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super T[], ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$2(Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$5$2> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.$transform, continuation);
        flowKt__ZipKt$combine$5$2.L$0 = flowCollector;
        flowKt__ZipKt$combine$5$2.L$1 = tArr;
        return flowKt__ZipKt$combine$5$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<T[], kotlin.coroutines.Continuation<? super R>, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            Function2<T[], Continuation<? super R>, Object> function2 = this.$transform;
            this.L$0 = flowCollector2;
            this.label = 1;
            obj = function2.invoke((Object[]) this.L$1, this);
            flowCollector = flowCollector2;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<T[], kotlin.coroutines.Continuation<? super R>, java.lang.Object> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: kotlinx.coroutines.flow.FlowCollector */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend$$forInline(Object obj) {
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        InlineMarker.mark(0);
        ((FlowCollector) this.L$0).emit(invoke, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
