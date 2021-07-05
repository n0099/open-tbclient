package kotlin.collections;

import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequenceScope;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "bufferInitialCapacity", PerformanceJsonBean.KEY_GAP, "buffer", FreeSpaceBox.TYPE, "e", "$this$iterator", "bufferInitialCapacity", PerformanceJsonBean.KEY_GAP, "buffer", FreeSpaceBox.TYPE, "$this$iterator", "bufferInitialCapacity", PerformanceJsonBean.KEY_GAP, "buffer", "e", "$this$iterator", "bufferInitialCapacity", PerformanceJsonBean.KEY_GAP, "buffer", "$this$iterator", "bufferInitialCapacity", PerformanceJsonBean.KEY_GAP, "buffer"}, s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
/* loaded from: classes10.dex */
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Iterator $iterator;
    public final /* synthetic */ boolean $partialWindows;
    public final /* synthetic */ boolean $reuseBuffer;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    public int I$1;
    public int I$2;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public SequenceScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i2, int i3, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$size = i2;
        this.$step = i3;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, completion);
        slidingWindowKt$windowedIterator$1.p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bf -> B:31:0x00c1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0143 -> B:60:0x0146). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0175 -> B:73:0x0178). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        int i2;
        RingBuffer ringBuffer;
        SequenceScope sequenceScope2;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1;
        int i3;
        Iterator it;
        ArrayList arrayList;
        int i4;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$12;
        int i5;
        Iterator it2;
        RingBuffer ringBuffer2;
        int i6;
        int i7;
        SequenceScope sequenceScope3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = this.p$;
            int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.$size, 1024);
            i2 = this.$step - this.$size;
            if (i2 >= 0) {
                arrayList = new ArrayList(coerceAtMost);
                i4 = 0;
                slidingWindowKt$windowedIterator$12 = this;
                i5 = coerceAtMost;
                it2 = this.$iterator;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                    slidingWindowKt$windowedIterator$12.I$0 = i5;
                    slidingWindowKt$windowedIterator$12.I$1 = i2;
                    slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                    slidingWindowKt$windowedIterator$12.I$2 = i4;
                    slidingWindowKt$windowedIterator$12.label = 2;
                    if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    }
                }
                return Unit.INSTANCE;
            }
            ringBuffer = new RingBuffer(coerceAtMost);
            sequenceScope2 = sequenceScope;
            slidingWindowKt$windowedIterator$1 = this;
            i3 = coerceAtMost;
            it = this.$iterator;
            while (it.hasNext()) {
            }
            if (slidingWindowKt$windowedIterator$1.$partialWindows) {
            }
            return Unit.INSTANCE;
        } else if (i8 == 1) {
            it2 = (Iterator) this.L$3;
            arrayList = (ArrayList) this.L$1;
            i4 = this.I$1;
            i5 = this.I$0;
            SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            slidingWindowKt$windowedIterator$12 = this;
            if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                arrayList = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
            } else {
                arrayList.clear();
            }
            sequenceScope = sequenceScope4;
            i2 = i4;
            while (it2.hasNext()) {
                Object next = it2.next();
                if (i4 > 0) {
                    i4--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                        slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                        slidingWindowKt$windowedIterator$12.I$0 = i5;
                        slidingWindowKt$windowedIterator$12.I$1 = i2;
                        slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                        slidingWindowKt$windowedIterator$12.I$2 = i4;
                        slidingWindowKt$windowedIterator$12.L$2 = next;
                        slidingWindowKt$windowedIterator$12.L$3 = it2;
                        slidingWindowKt$windowedIterator$12.label = 1;
                        if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i4 = i2;
                        sequenceScope4 = sequenceScope;
                        if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                        }
                        sequenceScope = sequenceScope4;
                        i2 = i4;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                slidingWindowKt$windowedIterator$12.I$0 = i5;
                slidingWindowKt$windowedIterator$12.I$1 = i2;
                slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                slidingWindowKt$windowedIterator$12.I$2 = i4;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else {
            if (i8 == 2) {
                ArrayList arrayList2 = (ArrayList) this.L$1;
            } else if (i8 == 3) {
                it = (Iterator) this.L$3;
                ringBuffer = (RingBuffer) this.L$1;
                i2 = this.I$1;
                i3 = this.I$0;
                sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                while (it.hasNext()) {
                    Object next2 = it.next();
                    ringBuffer.add((RingBuffer) next2);
                    if (ringBuffer.isFull()) {
                        int size = ringBuffer.size();
                        int i9 = slidingWindowKt$windowedIterator$1.$size;
                        if (size >= i9) {
                            RandomAccess arrayList3 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer : new ArrayList(ringBuffer);
                            slidingWindowKt$windowedIterator$1.L$0 = sequenceScope2;
                            slidingWindowKt$windowedIterator$1.I$0 = i3;
                            slidingWindowKt$windowedIterator$1.I$1 = i2;
                            slidingWindowKt$windowedIterator$1.L$1 = ringBuffer;
                            slidingWindowKt$windowedIterator$1.L$2 = next2;
                            slidingWindowKt$windowedIterator$1.L$3 = it;
                            slidingWindowKt$windowedIterator$1.label = 3;
                            if (sequenceScope2.yield(arrayList3, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                            while (it.hasNext()) {
                            }
                        } else {
                            ringBuffer = ringBuffer.expanded(i9);
                        }
                    }
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                    ringBuffer2 = ringBuffer;
                    i6 = i2;
                    i7 = i3;
                    sequenceScope3 = sequenceScope2;
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    }
                }
                return Unit.INSTANCE;
            } else if (i8 == 4) {
                ringBuffer2 = (RingBuffer) this.L$1;
                i6 = this.I$1;
                i7 = this.I$0;
                sequenceScope3 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    RandomAccess arrayList4 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer2 : new ArrayList(ringBuffer2);
                    slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                    slidingWindowKt$windowedIterator$1.I$0 = i7;
                    slidingWindowKt$windowedIterator$1.I$1 = i6;
                    slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                    slidingWindowKt$windowedIterator$1.label = 4;
                    if (sequenceScope3.yield(arrayList4, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                        if (!ringBuffer2.isEmpty()) {
                            slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                            slidingWindowKt$windowedIterator$1.I$0 = i7;
                            slidingWindowKt$windowedIterator$1.I$1 = i6;
                            slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                            slidingWindowKt$windowedIterator$1.label = 5;
                            if (sequenceScope3.yield(ringBuffer2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
            } else if (i8 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                RingBuffer ringBuffer3 = (RingBuffer) this.L$1;
            }
            SequenceScope sequenceScope5 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }
}
