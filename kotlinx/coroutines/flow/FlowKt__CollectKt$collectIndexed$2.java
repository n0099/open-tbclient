package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = MatroskaExtractor.ID_PIXEL_WIDTH)
/* loaded from: classes2.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements FlowCollector<T> {
    public final /* synthetic */ Function3<Integer, T, Continuation<? super Unit>, Object> $action;
    public int index;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collectIndexed$2(Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.$action = function3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.$action;
        int i = this.index;
        this.index = i + 1;
        if (i >= 0) {
            Object invoke = function3.invoke(Boxing.boxInt(i), t, continuation);
            if (invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return invoke;
            }
            return Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public Object emit$$forInline(T t, final Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collectIndexed$2.this.emit(null, this);
            }
        };
        InlineMarker.mark(5);
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.$action;
        int i = this.index;
        this.index = i + 1;
        if (i >= 0) {
            function3.invoke(Integer.valueOf(i), t, continuation);
            return Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
