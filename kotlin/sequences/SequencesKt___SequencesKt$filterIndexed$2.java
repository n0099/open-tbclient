package kotlin.sequences;

import kotlin.collections.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements kotlin.jvm.a.b<x<? extends T>, T> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((x<? extends Object>) obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public final T invoke(x<? extends T> xVar) {
        p.p(xVar, "it");
        return xVar.getValue();
    }
}
