package kotlin.sequences;

import java.util.Iterator;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@kotlin.coroutines.jvm.internal.c(c = "kotlin/sequences/SequencesKt___SequencesKt$zipWithNext$2", dJf = {1693}, f = "_Sequences.kt", m = "invokeSuspend")
/* loaded from: classes5.dex */
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements m<d<? super R>, kotlin.coroutines.a<? super kotlin.k>, Object> {
    final /* synthetic */ c $this_zipWithNext;
    final /* synthetic */ m $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private d p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(c cVar, m mVar, kotlin.coroutines.a aVar) {
        super(2, aVar);
        this.$this_zipWithNext = cVar;
        this.$transform = mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.a<kotlin.k> create(Object obj, kotlin.coroutines.a<?> aVar) {
        q.j(aVar, "completion");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, aVar);
        d dVar = (d) obj;
        sequencesKt___SequencesKt$zipWithNext$2.p$ = (d) obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.a.m
    public final Object invoke(Object obj, kotlin.coroutines.a<? super kotlin.k> aVar) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(obj, aVar)).invokeSuspend(kotlin.k.nAT);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1687=4] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        d dVar;
        Iterator it;
        Object obj2;
        Object dJe = kotlin.coroutines.intrinsics.a.dJe();
        switch (this.label) {
            case 0:
                if (!(obj instanceof Result.Failure)) {
                    dVar = this.p$;
                    it = this.$this_zipWithNext.iterator();
                    if (it.hasNext()) {
                        obj2 = it.next();
                        break;
                    } else {
                        return kotlin.k.nAT;
                    }
                } else {
                    throw ((Result.Failure) obj).exception;
                }
            case 1:
                Object obj3 = this.L$3;
                Object obj4 = this.L$2;
                Iterator it2 = (Iterator) this.L$1;
                d dVar2 = (d) this.L$0;
                if (!(obj instanceof Result.Failure)) {
                    dVar = dVar2;
                    it = it2;
                    obj2 = obj3;
                    break;
                } else {
                    throw ((Result.Failure) obj).exception;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Object invoke = this.$transform.invoke(obj2, next);
            this.L$0 = dVar;
            this.L$1 = it;
            this.L$2 = obj2;
            this.L$3 = next;
            this.label = 1;
            if (dVar.a((d) invoke, (kotlin.coroutines.a<? super kotlin.k>) this) == dJe) {
                return dJe;
            }
            obj2 = next;
        }
        return kotlin.k.nAT;
    }
}
