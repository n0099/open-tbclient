package kotlin.text;

import kotlin.jvm.internal.Lambda;
import kotlin.text.j;
@kotlin.h
/* loaded from: classes7.dex */
final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements kotlin.jvm.a.b<Integer, f> {
    final /* synthetic */ j.a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatcherMatchResult$groups$1$iterator$1(j.a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ f invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final f invoke(int i) {
        return this.this$0.JV(i);
    }
}
