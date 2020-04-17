package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
@kotlin.coroutines.jvm.internal.c(c = "kotlin/collections/SlidingWindowKt$windowedIterator$1", dDQ = {33, 39, 46, 52, 55}, f = "SlidingWindow.kt", m = "invokeSuspend")
@kotlin.h
/* loaded from: classes7.dex */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements kotlin.jvm.a.m<kotlin.sequences.d<? super List<? extends T>>, kotlin.coroutines.a<? super kotlin.l>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private kotlin.sequences.d p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, kotlin.coroutines.a aVar) {
        super(2, aVar);
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.a<kotlin.l> create(Object obj, kotlin.coroutines.a<?> aVar) {
        kotlin.jvm.internal.q.j(aVar, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, aVar);
        kotlin.sequences.d dVar = (kotlin.sequences.d) obj;
        slidingWindowKt$windowedIterator$1.p$ = (kotlin.sequences.d) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.a.m
    public final Object invoke(Object obj, kotlin.coroutines.a<? super kotlin.l> aVar) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, aVar)).invokeSuspend(kotlin.l.mWZ);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [24=11] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0193  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0043 -> B:13:0x0031). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x013d -> B:51:0x00e0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x018a -> B:72:0x0147). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ak akVar;
        kotlin.sequences.d dVar;
        int i;
        Iterator it;
        ak akVar2;
        kotlin.sequences.d dVar2;
        int i2;
        Iterator it2;
        ArrayList arrayList;
        kotlin.sequences.d dVar3;
        int i3;
        int i4;
        kotlin.sequences.d dVar4;
        int i5;
        kotlin.sequences.d dVar5;
        Iterator it3;
        kotlin.sequences.d dVar6;
        int i6;
        int i7;
        Object dDP = kotlin.coroutines.intrinsics.a.dDP();
        switch (this.label) {
            case 0:
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                dVar3 = this.p$;
                i3 = this.$step - this.$size;
                if (i3 >= 0) {
                    arrayList = new ArrayList(this.$size);
                    it2 = this.$iterator;
                    i7 = 0;
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (i7 > 0) {
                            int i8 = i7 - 1;
                            dVar6 = dVar3;
                            i6 = i3;
                            i3 = i8;
                        } else {
                            arrayList.add(next);
                            if (arrayList.size() == this.$size) {
                                this.L$0 = dVar3;
                                this.I$0 = i3;
                                this.L$1 = arrayList;
                                this.I$1 = i7;
                                this.L$2 = next;
                                this.L$3 = it2;
                                this.label = 1;
                                if (dVar3.a((kotlin.sequences.d) arrayList, (kotlin.coroutines.a<? super kotlin.l>) this) == dDP) {
                                    return dDP;
                                }
                                if (this.$reuseBuffer) {
                                    arrayList = new ArrayList(this.$size);
                                } else {
                                    arrayList.clear();
                                }
                                dVar6 = dVar3;
                                i6 = i3;
                            } else {
                                int i9 = i7;
                                dVar6 = dVar3;
                                i6 = i3;
                                i3 = i9;
                            }
                        }
                        int i10 = i3;
                        i3 = i6;
                        dVar3 = dVar6;
                        i7 = i10;
                        if (it2.hasNext()) {
                            if ((arrayList.isEmpty() ? false : true) && (this.$partialWindows || arrayList.size() == this.$size)) {
                                this.I$0 = i3;
                                this.L$0 = arrayList;
                                this.I$1 = i7;
                                this.label = 2;
                                if (dVar3.a((kotlin.sequences.d) arrayList, (kotlin.coroutines.a<? super kotlin.l>) this) == dDP) {
                                    return dDP;
                                }
                            }
                            return kotlin.l.mWZ;
                        }
                    }
                } else {
                    akVar2 = new ak(this.$size);
                    i5 = i3;
                    dVar5 = dVar3;
                    it3 = this.$iterator;
                    if (!it3.hasNext()) {
                        Object next2 = it3.next();
                        akVar2.add((ak) next2);
                        if (akVar2.isFull()) {
                            List arrayList2 = this.$reuseBuffer ? akVar2 : new ArrayList(akVar2);
                            this.L$0 = dVar5;
                            this.I$0 = i5;
                            this.L$1 = akVar2;
                            this.L$2 = next2;
                            this.L$3 = it3;
                            this.label = 3;
                            if (dVar5.a((kotlin.sequences.d) arrayList2, (kotlin.coroutines.a<? super kotlin.l>) this) == dDP) {
                                return dDP;
                            }
                            it = it3;
                            i2 = i5;
                            dVar2 = dVar5;
                            akVar2.Jf(this.$step);
                            i5 = i2;
                            dVar5 = dVar2;
                            it3 = it;
                            if (!it3.hasNext()) {
                            }
                        } else {
                            it = it3;
                            i2 = i5;
                            dVar2 = dVar5;
                            i5 = i2;
                            dVar5 = dVar2;
                            it3 = it;
                            if (!it3.hasNext()) {
                                if (this.$partialWindows) {
                                    i4 = i5;
                                    dVar4 = dVar5;
                                    if (akVar2.size() <= this.$step) {
                                        List arrayList3 = this.$reuseBuffer ? akVar2 : new ArrayList(akVar2);
                                        this.L$0 = dVar4;
                                        this.I$0 = i4;
                                        this.L$1 = akVar2;
                                        this.label = 4;
                                        if (dVar4.a((kotlin.sequences.d) arrayList3, (kotlin.coroutines.a<? super kotlin.l>) this) == dDP) {
                                            return dDP;
                                        }
                                        akVar = akVar2;
                                        dVar = dVar4;
                                        i = i4;
                                        akVar.Jf(this.$step);
                                        i4 = i;
                                        dVar4 = dVar;
                                        akVar2 = akVar;
                                        if (akVar2.size() <= this.$step) {
                                            if (akVar2.isEmpty() ? false : true) {
                                                this.I$0 = i4;
                                                this.L$0 = akVar2;
                                                this.label = 5;
                                                if (dVar4.a((kotlin.sequences.d) akVar2, (kotlin.coroutines.a<? super kotlin.l>) this) == dDP) {
                                                    return dDP;
                                                }
                                            }
                                        }
                                    }
                                }
                                return kotlin.l.mWZ;
                            }
                        }
                    }
                }
                break;
            case 1:
                it2 = (Iterator) this.L$3;
                Object obj2 = this.L$2;
                int i11 = this.I$1;
                arrayList = (ArrayList) this.L$1;
                int i12 = this.I$0;
                kotlin.sequences.d dVar7 = (kotlin.sequences.d) this.L$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                dVar3 = dVar7;
                i3 = i12;
                if (this.$reuseBuffer) {
                }
                dVar6 = dVar3;
                i6 = i3;
                int i102 = i3;
                i3 = i6;
                dVar3 = dVar6;
                i7 = i102;
                if (it2.hasNext()) {
                }
                break;
            case 2:
                int i13 = this.I$1;
                ArrayList arrayList4 = (ArrayList) this.L$0;
                int i14 = this.I$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                return kotlin.l.mWZ;
            case 3:
                it = (Iterator) this.L$3;
                Object obj3 = this.L$2;
                akVar2 = (ak) this.L$1;
                int i15 = this.I$0;
                kotlin.sequences.d dVar8 = (kotlin.sequences.d) this.L$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                dVar2 = dVar8;
                i2 = i15;
                akVar2.Jf(this.$step);
                i5 = i2;
                dVar5 = dVar2;
                it3 = it;
                if (!it3.hasNext()) {
                }
                break;
            case 4:
                akVar = (ak) this.L$1;
                int i16 = this.I$0;
                kotlin.sequences.d dVar9 = (kotlin.sequences.d) this.L$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                dVar = dVar9;
                i = i16;
                akVar.Jf(this.$step);
                i4 = i;
                dVar4 = dVar;
                akVar2 = akVar;
                if (akVar2.size() <= this.$step) {
                }
                break;
            case 5:
                ak akVar3 = (ak) this.L$0;
                int i17 = this.I$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                return kotlin.l.mWZ;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
