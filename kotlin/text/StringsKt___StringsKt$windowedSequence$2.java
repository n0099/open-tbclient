package kotlin.text;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements kotlin.jvm.a.b<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ kotlin.jvm.a.b $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, kotlin.jvm.a.b bVar, int i) {
        super(1);
        this.$this_windowedSequence = charSequence;
        this.$transform = bVar;
        this.$size = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
    public final R invoke(int i) {
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i, kotlin.b.l.ez(this.$size + i, this.$this_windowedSequence.length())));
    }
}
