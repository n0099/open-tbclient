package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {
    public final /* synthetic */ CharSequence $input;
    public final /* synthetic */ int $startIndex;
    public final /* synthetic */ Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i2) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final MatchResult invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
