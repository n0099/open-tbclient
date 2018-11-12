package kotlin.text;

import kotlin.jvm.internal.Lambda;
import kotlin.text.i;
/* loaded from: classes2.dex */
final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements kotlin.jvm.a.b<Integer, e> {
    final /* synthetic */ i.a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatcherMatchResult$groups$1$iterator$1(i.a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final e invoke(int i) {
        return this.this$0.yF(i);
    }
}
