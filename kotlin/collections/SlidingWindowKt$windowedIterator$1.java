package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
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
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequenceScope;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", PerformanceJsonBean.KEY_GAP, "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes9.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Iterator<T> $iterator;
    public final /* synthetic */ boolean $partialWindows;
    public final /* synthetic */ boolean $reuseBuffer;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator<? extends T> it, boolean z, boolean z2, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0153  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a5 -> B:29:0x00a8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x011c -> B:58:0x011f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x014a -> B:71:0x014d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        RingBuffer ringBuffer;
        Iterator<T> it;
        SequenceScope sequenceScope;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$1;
        int i2;
        SequenceScope sequenceScope2;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$12;
        ArrayList arrayList;
        Iterator<T> it2;
        RingBuffer ringBuffer2;
        SequenceScope sequenceScope3;
        RandomAccess arrayList2;
        RandomAccess arrayList3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ringBuffer2 = (RingBuffer) this.L$1;
                            sequenceScope3 = (SequenceScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            slidingWindowKt$windowedIterator$1 = this;
                            ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                            if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                                if (slidingWindowKt$windowedIterator$1.$reuseBuffer) {
                                    arrayList3 = ringBuffer2;
                                } else {
                                    arrayList3 = new ArrayList(ringBuffer2);
                                }
                                slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                                slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                                slidingWindowKt$windowedIterator$1.L$2 = null;
                                slidingWindowKt$windowedIterator$1.label = 4;
                                if (sequenceScope3.yield(arrayList3, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                                if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                                    if (!ringBuffer2.isEmpty()) {
                                        slidingWindowKt$windowedIterator$1.L$0 = null;
                                        slidingWindowKt$windowedIterator$1.L$1 = null;
                                        slidingWindowKt$windowedIterator$1.L$2 = null;
                                        slidingWindowKt$windowedIterator$1.label = 5;
                                        if (sequenceScope3.yield(ringBuffer2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    } else {
                        it = (Iterator) this.L$2;
                        ringBuffer = (RingBuffer) this.L$1;
                        sequenceScope = (SequenceScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        slidingWindowKt$windowedIterator$1 = this;
                        ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                        while (it.hasNext()) {
                            ringBuffer.add((RingBuffer) it.next());
                            if (ringBuffer.isFull()) {
                                int size = ringBuffer.size();
                                int i4 = slidingWindowKt$windowedIterator$1.$size;
                                if (size < i4) {
                                    ringBuffer = ringBuffer.expanded(i4);
                                } else {
                                    if (slidingWindowKt$windowedIterator$1.$reuseBuffer) {
                                        arrayList2 = ringBuffer;
                                    } else {
                                        arrayList2 = new ArrayList(ringBuffer);
                                    }
                                    slidingWindowKt$windowedIterator$1.L$0 = sequenceScope;
                                    slidingWindowKt$windowedIterator$1.L$1 = ringBuffer;
                                    slidingWindowKt$windowedIterator$1.L$2 = it;
                                    slidingWindowKt$windowedIterator$1.label = 3;
                                    if (sequenceScope.yield(arrayList2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                                    while (it.hasNext()) {
                                    }
                                }
                            }
                        }
                        if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                            ringBuffer2 = ringBuffer;
                            sequenceScope3 = sequenceScope;
                            if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            int i5 = this.I$0;
            it2 = (Iterator) this.L$2;
            arrayList = (ArrayList) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            slidingWindowKt$windowedIterator$12 = this;
            i = i5;
            if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                arrayList.clear();
            } else {
                arrayList = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
            }
            i2 = i;
            while (it2.hasNext()) {
                T next = it2.next();
                if (i2 > 0) {
                    i2--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                        slidingWindowKt$windowedIterator$12.L$0 = sequenceScope2;
                        slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                        slidingWindowKt$windowedIterator$12.L$2 = it2;
                        slidingWindowKt$windowedIterator$12.I$0 = i;
                        slidingWindowKt$windowedIterator$12.label = 1;
                        if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                        }
                        i2 = i;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.$size, 1024);
        i = this.$step - this.$size;
        if (i >= 0) {
            ArrayList arrayList4 = new ArrayList(coerceAtMost);
            i2 = 0;
            sequenceScope2 = sequenceScope4;
            slidingWindowKt$windowedIterator$12 = this;
            arrayList = arrayList4;
            it2 = this.$iterator;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        ringBuffer = new RingBuffer(coerceAtMost);
        it = this.$iterator;
        sequenceScope = sequenceScope4;
        slidingWindowKt$windowedIterator$1 = this;
        while (it.hasNext()) {
        }
        if (slidingWindowKt$windowedIterator$1.$partialWindows) {
        }
        return Unit.INSTANCE;
    }
}
