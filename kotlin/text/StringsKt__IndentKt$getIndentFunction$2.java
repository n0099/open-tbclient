package kotlin.text;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes20.dex */
final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements kotlin.jvm.a.b<String, String> {
    final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.$indent = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(String str) {
        kotlin.jvm.internal.q.m(str, "line");
        return this.$indent + str;
    }
}
