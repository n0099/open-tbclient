package kotlin.sequences;

import java.util.Iterator;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
import kotlin.l;
@kotlin.coroutines.jvm.internal.c(c = "kotlin/sequences/SequencesKt__SequencesKt$ifEmpty$1", dQB = {67, 69}, f = "Sequences.kt", m = "invokeSuspend")
@kotlin.h
/* loaded from: classes7.dex */
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements m<d<? super T>, kotlin.coroutines.a<? super l>, Object> {
    final /* synthetic */ kotlin.jvm.a.a $defaultValue;
    final /* synthetic */ c $this_ifEmpty;
    Object L$0;
    int label;
    private d p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(c cVar, kotlin.jvm.a.a aVar, kotlin.coroutines.a aVar2) {
        super(2, aVar2);
        this.$this_ifEmpty = cVar;
        this.$defaultValue = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.a<l> create(Object obj, kotlin.coroutines.a<?> aVar) {
        q.m(aVar, "completion");
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, aVar);
        d dVar = (d) obj;
        sequencesKt__SequencesKt$ifEmpty$1.p$ = (d) obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.a.m
    public final Object invoke(Object obj, kotlin.coroutines.a<? super l> aVar) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(obj, aVar)).invokeSuspend(l.nPb);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=5] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object dQA = kotlin.coroutines.intrinsics.a.dQA();
        switch (this.label) {
            case 0:
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                d dVar = this.p$;
                Iterator it = this.$this_ifEmpty.iterator();
                if (it.hasNext()) {
                    this.L$0 = it;
                    this.label = 1;
                    if (dVar.a(it, (kotlin.coroutines.a<? super l>) this) == dQA) {
                        return dQA;
                    }
                } else {
                    this.L$0 = it;
                    this.label = 2;
                    if (dVar.a((c) this.$defaultValue.invoke(), (kotlin.coroutines.a<? super l>) this) == dQA) {
                        return dQA;
                    }
                }
                break;
            case 1:
                Iterator it2 = (Iterator) this.L$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                break;
            case 2:
                Iterator it3 = (Iterator) this.L$0;
                if (obj instanceof Result.Failure) {
                    throw ((Result.Failure) obj).exception;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return l.nPb;
    }
}
