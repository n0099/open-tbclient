package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes10.dex */
final class SequencesKt___SequencesKt$zip$1 extends Lambda implements m<T, R, Pair<? extends T, ? extends R>> {
    public static final SequencesKt___SequencesKt$zip$1 INSTANCE = new SequencesKt___SequencesKt$zip$1();

    SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.a.m
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SequencesKt___SequencesKt$zip$1) obj, obj2);
    }

    @Override // kotlin.jvm.a.m
    public final Pair<T, R> invoke(T t, R r) {
        return kotlin.j.k(t, r);
    }
}
