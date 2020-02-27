package kotlin.text;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class Regex$findAll$1 extends Lambda implements kotlin.jvm.a.a<i> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final i invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
