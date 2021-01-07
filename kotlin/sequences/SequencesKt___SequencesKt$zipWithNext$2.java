package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.h;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
final class SequencesKt___SequencesKt$zipWithNext$2 extends CoroutineImpl implements kotlin.jvm.a.c<kotlin.coroutines.experimental.f<? super R>, kotlin.coroutines.experimental.b<? super h>, Object> {
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
        return create((kotlin.coroutines.experimental.f) obj, (kotlin.coroutines.experimental.b<? super h>) bVar);
    }

    public final kotlin.coroutines.experimental.b<h> create(kotlin.coroutines.experimental.f<? super R> fVar, kotlin.coroutines.experimental.b<? super h> bVar) {
        p.o(fVar, "$receiver");
        p.o(bVar, "continuation");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.receiver$0, this.$transform, bVar);
        sequencesKt___SequencesKt$zipWithNext$2.p$ = fVar;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final Object invoke(kotlin.coroutines.experimental.f<? super R> fVar, kotlin.coroutines.experimental.b<? super h> bVar) {
        p.o(fVar, "$receiver");
        p.o(bVar, "continuation");
        return ((SequencesKt___SequencesKt$zipWithNext$2) create((kotlin.coroutines.experimental.f) fVar, bVar)).doResume(h.qnl, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005f -> B:13:0x002b). Please submit an issue!!! */
    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doResume(Object obj, Throwable th) {
        Object obj2;
        Iterator it;
        kotlin.coroutines.experimental.f fVar;
        Object obj3;
        Iterator it2;
        Object eMI = kotlin.coroutines.experimental.a.a.eMI();
        switch (this.label) {
            case 0:
                if (th == null) {
                    kotlin.coroutines.experimental.f fVar2 = this.p$;
                    it2 = this.receiver$0.iterator();
                    if (it2.hasNext()) {
                        obj3 = it2.next();
                        fVar = fVar2;
                        break;
                    } else {
                        return h.qnl;
                    }
                } else {
                    throw th;
                }
            case 1:
                obj2 = this.L$3;
                Object obj4 = this.L$2;
                Iterator it3 = (Iterator) this.L$1;
                kotlin.coroutines.experimental.f fVar3 = (kotlin.coroutines.experimental.f) this.L$0;
                if (th == null) {
                    it = it3;
                    fVar = fVar3;
                    obj3 = obj2;
                    it2 = it;
                    break;
                } else {
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it2.hasNext()) {
            obj2 = it2.next();
            Object invoke = this.$transform.invoke(obj3, obj2);
            this.L$0 = fVar;
            this.L$1 = it2;
            this.L$2 = obj3;
            this.L$3 = obj2;
            this.label = 1;
            if (fVar.a(invoke, this) == eMI) {
                return eMI;
            }
            it = it2;
            obj3 = obj2;
            it2 = it;
            if (!it2.hasNext()) {
                return h.qnl;
            }
        }
    }
}
