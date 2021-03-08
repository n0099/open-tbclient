package kotlin.text;

import kotlin.jvm.internal.Lambda;
@kotlin.e
/* loaded from: classes14.dex */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements kotlin.jvm.a.b<kotlin.b.h, String> {
    final /* synthetic */ CharSequence receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.receiver$0 = charSequence;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(kotlin.b.h hVar) {
        kotlin.jvm.internal.p.p(hVar, "it");
        return l.a(this.receiver$0, hVar);
    }
}
