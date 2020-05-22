package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements kotlin.jvm.a.m<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.m
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        Pair a;
        kotlin.jvm.internal.q.m(charSequence, "receiver$0");
        a = u.a(charSequence, (Collection<String>) this.$delimitersList, i, this.$ignoreCase, false);
        if (a != null) {
            return kotlin.j.k(a.getFirst(), Integer.valueOf(((String) a.getSecond()).length()));
        }
        return null;
    }
}
