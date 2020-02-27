package kotlin.text;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements kotlin.jvm.a.m<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] $delimiters;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArr, boolean z) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.m
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        kotlin.jvm.internal.q.j(charSequence, "receiver$0");
        int a = l.a(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (a < 0) {
            return null;
        }
        return kotlin.j.k(Integer.valueOf(a), 1);
    }
}
