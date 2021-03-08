package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
@kotlin.e
/* loaded from: classes14.dex */
final class SlidingWindowKt$windowedIterator$1 extends CoroutineImpl implements kotlin.jvm.a.c<kotlin.coroutines.experimental.f<? super List<? extends T>>, kotlin.coroutines.experimental.b<? super kotlin.h>, Object> {
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
    private kotlin.coroutines.experimental.f p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, kotlin.coroutines.experimental.b bVar) {
        super(2, bVar);
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ kotlin.coroutines.experimental.b create(Object obj, kotlin.coroutines.experimental.b bVar) {
        return create((kotlin.coroutines.experimental.f) obj, (kotlin.coroutines.experimental.b<? super kotlin.h>) bVar);
    }

    public final kotlin.coroutines.experimental.b<kotlin.h> create(kotlin.coroutines.experimental.f<? super List<? extends T>> fVar, kotlin.coroutines.experimental.b<? super kotlin.h> bVar) {
        kotlin.jvm.internal.p.p(fVar, "$receiver");
        kotlin.jvm.internal.p.p(bVar, "continuation");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, bVar);
        slidingWindowKt$windowedIterator$1.p$ = fVar;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final Object invoke(kotlin.coroutines.experimental.f<? super List<? extends T>> fVar, kotlin.coroutines.experimental.b<? super kotlin.h> bVar) {
        kotlin.jvm.internal.p.p(fVar, "$receiver");
        kotlin.jvm.internal.p.p(bVar, "continuation");
        return ((SlidingWindowKt$windowedIterator$1) create((kotlin.coroutines.experimental.f) fVar, bVar)).doResume(kotlin.h.qtQ, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [37=10] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0167  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003a -> B:11:0x002b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x011a -> B:47:0x00c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x015f -> B:67:0x0124). Please submit an issue!!! */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doResume(Object obj, Throwable th) {
        af afVar;
        int i;
        kotlin.coroutines.experimental.f fVar;
        Iterator it;
        af afVar2;
        kotlin.coroutines.experimental.f fVar2;
        int i2;
        Iterator it2;
        ArrayList arrayList;
        int i3;
        kotlin.coroutines.experimental.f fVar3;
        int i4;
        Iterator it3;
        int i5;
        kotlin.coroutines.experimental.f fVar4;
        int i6;
        int i7;
        int i8;
        Object eKY = kotlin.coroutines.experimental.a.a.eKY();
        switch (this.label) {
            case 0:
                if (th != null) {
                    throw th;
                }
                fVar3 = this.p$;
                i7 = this.$step - this.$size;
                if (i7 >= 0) {
                    arrayList = new ArrayList(this.$size);
                    it2 = this.$iterator;
                    i8 = 0;
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (i8 > 0) {
                            i6 = i8 - 1;
                        } else {
                            arrayList.add(next);
                            if (arrayList.size() == this.$size) {
                                this.L$0 = fVar3;
                                this.I$0 = i7;
                                this.L$1 = arrayList;
                                this.I$1 = i8;
                                this.L$2 = next;
                                this.L$3 = it2;
                                this.label = 1;
                                if (fVar3.a(arrayList, this) == eKY) {
                                    return eKY;
                                }
                                i3 = i7;
                                if (this.$reuseBuffer) {
                                    arrayList = new ArrayList(this.$size);
                                } else {
                                    arrayList.clear();
                                }
                                i6 = i3;
                                i7 = i3;
                            } else {
                                i6 = i8;
                            }
                        }
                        i8 = i6;
                        if (it2.hasNext()) {
                            if ((arrayList.isEmpty() ? false : true) && (this.$partialWindows || arrayList.size() == this.$size)) {
                                this.I$0 = i7;
                                this.L$0 = arrayList;
                                this.I$1 = i8;
                                this.label = 2;
                                if (fVar3.a(arrayList, this) == eKY) {
                                    return eKY;
                                }
                            }
                            return kotlin.h.qtQ;
                        }
                    }
                } else {
                    afVar2 = new af(this.$size);
                    it3 = this.$iterator;
                    i5 = i7;
                    fVar4 = fVar3;
                    if (!it3.hasNext()) {
                        Object next2 = it3.next();
                        afVar2.add((af) next2);
                        if (afVar2.isFull()) {
                            List arrayList2 = this.$reuseBuffer ? afVar2 : new ArrayList(afVar2);
                            this.L$0 = fVar4;
                            this.I$0 = i5;
                            this.L$1 = afVar2;
                            this.L$2 = next2;
                            this.L$3 = it3;
                            this.label = 3;
                            if (fVar4.a(arrayList2, this) == eKY) {
                                return eKY;
                            }
                            it = it3;
                            i2 = i5;
                            fVar2 = fVar4;
                            afVar2.St(this.$step);
                            it3 = it;
                            i5 = i2;
                            fVar4 = fVar2;
                            if (!it3.hasNext()) {
                            }
                        } else {
                            it = it3;
                            i2 = i5;
                            fVar2 = fVar4;
                            it3 = it;
                            i5 = i2;
                            fVar4 = fVar2;
                            if (!it3.hasNext()) {
                                if (this.$partialWindows) {
                                    i4 = i5;
                                    fVar = fVar4;
                                    if (afVar2.size() <= this.$step) {
                                        List arrayList3 = this.$reuseBuffer ? afVar2 : new ArrayList(afVar2);
                                        this.L$0 = fVar;
                                        this.I$0 = i4;
                                        this.L$1 = afVar2;
                                        this.label = 4;
                                        if (fVar.a(arrayList3, this) == eKY) {
                                            return eKY;
                                        }
                                        afVar = afVar2;
                                        i = i4;
                                        afVar.St(this.$step);
                                        afVar2 = afVar;
                                        i4 = i;
                                        if (afVar2.size() <= this.$step) {
                                            if (afVar2.isEmpty() ? false : true) {
                                                this.I$0 = i4;
                                                this.L$0 = afVar2;
                                                this.label = 5;
                                                if (fVar.a(afVar2, this) == eKY) {
                                                    return eKY;
                                                }
                                            }
                                        }
                                    }
                                }
                                return kotlin.h.qtQ;
                            }
                        }
                    }
                }
                break;
            case 1:
                it2 = (Iterator) this.L$3;
                Object obj2 = this.L$2;
                int i9 = this.I$1;
                arrayList = (ArrayList) this.L$1;
                i3 = this.I$0;
                kotlin.coroutines.experimental.f fVar5 = (kotlin.coroutines.experimental.f) this.L$0;
                if (th != null) {
                    throw th;
                }
                fVar3 = fVar5;
                if (this.$reuseBuffer) {
                }
                i6 = i3;
                i7 = i3;
                i8 = i6;
                if (it2.hasNext()) {
                }
                break;
            case 2:
                int i10 = this.I$1;
                ArrayList arrayList4 = (ArrayList) this.L$0;
                int i11 = this.I$0;
                if (th != null) {
                    throw th;
                }
                return kotlin.h.qtQ;
            case 3:
                it = (Iterator) this.L$3;
                Object obj3 = this.L$2;
                afVar2 = (af) this.L$1;
                int i12 = this.I$0;
                fVar2 = (kotlin.coroutines.experimental.f) this.L$0;
                if (th != null) {
                    throw th;
                }
                i2 = i12;
                afVar2.St(this.$step);
                it3 = it;
                i5 = i2;
                fVar4 = fVar2;
                if (!it3.hasNext()) {
                }
                break;
            case 4:
                afVar = (af) this.L$1;
                i = this.I$0;
                kotlin.coroutines.experimental.f fVar6 = (kotlin.coroutines.experimental.f) this.L$0;
                if (th != null) {
                    throw th;
                }
                fVar = fVar6;
                afVar.St(this.$step);
                afVar2 = afVar;
                i4 = i;
                if (afVar2.size() <= this.$step) {
                }
                break;
            case 5:
                af afVar3 = (af) this.L$0;
                int i13 = this.I$0;
                if (th != null) {
                    throw th;
                }
                return kotlin.h.qtQ;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
