package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements kotlin.jvm.a.b<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ kotlin.jvm.a.b $transform;
    final /* synthetic */ CharSequence receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, kotlin.jvm.a.b bVar, int i) {
        super(1);
        this.receiver$0 = charSequence;
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
        return this.$transform.invoke(this.receiver$0.subSequence(i, kotlin.b.d.cW(this.$size + i, this.receiver$0.length())));
    }
}
