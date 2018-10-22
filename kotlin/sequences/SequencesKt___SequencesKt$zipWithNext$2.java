package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$zipWithNext$2 extends CoroutineImpl implements kotlin.jvm.a.c<kotlin.coroutines.experimental.f<? super R>, kotlin.coroutines.experimental.b<? super kotlin.e>, Object> {
    final /* synthetic */ kotlin.jvm.a.c $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    private kotlin.coroutines.experimental.f p$;
    final /* synthetic */ c receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(c cVar, kotlin.jvm.a.c cVar2, kotlin.coroutines.experimental.b bVar) {
        super(2, bVar);
        this.receiver$0 = cVar;
        this.$transform = cVar2;
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ kotlin.coroutines.experimental.b create(Object obj, kotlin.coroutines.experimental.b bVar) {
        return create((kotlin.coroutines.experimental.f) obj, (kotlin.coroutines.experimental.b<? super kotlin.e>) bVar);
    }

    public final kotlin.coroutines.experimental.b<kotlin.e> create(kotlin.coroutines.experimental.f<? super R> fVar, kotlin.coroutines.experimental.b<? super kotlin.e> bVar) {
        p.i(fVar, "$receiver");
        p.i(bVar, "continuation");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.receiver$0, this.$transform, bVar);
        sequencesKt___SequencesKt$zipWithNext$2.p$ = fVar;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final Object invoke(kotlin.coroutines.experimental.f<? super R> fVar, kotlin.coroutines.experimental.b<? super kotlin.e> bVar) {
        p.i(fVar, "$receiver");
        p.i(bVar, "continuation");
        return ((SequencesKt___SequencesKt$zipWithNext$2) create((kotlin.coroutines.experimental.f) fVar, bVar)).doResume(kotlin.e.ioR, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1615=4] */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        kotlin.coroutines.experimental.f fVar;
        Iterator it;
        Object obj2;
        Object cai = kotlin.coroutines.experimental.a.a.cai();
        switch (this.label) {
            case 0:
                if (th == null) {
                    fVar = this.p$;
                    it = this.receiver$0.iterator();
                    if (it.hasNext()) {
                        obj2 = it.next();
                        break;
                    } else {
                        return kotlin.e.ioR;
                    }
                } else {
                    throw th;
                }
            case 1:
                Object obj3 = this.L$3;
                Object obj4 = this.L$2;
                Iterator it2 = (Iterator) this.L$1;
                kotlin.coroutines.experimental.f fVar2 = (kotlin.coroutines.experimental.f) this.L$0;
                if (th == null) {
                    fVar = fVar2;
                    it = it2;
                    obj2 = obj3;
                    break;
                } else {
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Object invoke = this.$transform.invoke(obj2, next);
            this.L$0 = fVar;
            this.L$1 = it;
            this.L$2 = obj2;
            this.L$3 = next;
            this.label = 1;
            if (fVar.a(invoke, this) == cai) {
                return cai;
            }
            obj2 = next;
        }
        return kotlin.e.ioR;
    }
}
