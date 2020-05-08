package kotlin.coroutines;

import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
/* loaded from: classes7.dex */
final class CombinedContext$writeReplace$1 extends Lambda implements m<l, c.b, l> {
    final /* synthetic */ c[] $elements;
    final /* synthetic */ Ref.IntRef $index;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(c[] cVarArr, Ref.IntRef intRef) {
        super(2);
        this.$elements = cVarArr;
        this.$index = intRef;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.m
    public /* bridge */ /* synthetic */ l invoke(l lVar, c.b bVar) {
        invoke2(lVar, bVar);
        return l.mXc;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(l lVar, c.b bVar) {
        q.j(lVar, "<anonymous parameter 0>");
        q.j(bVar, "element");
        c[] cVarArr = this.$elements;
        Ref.IntRef intRef = this.$index;
        int i = intRef.element;
        intRef.element = i + 1;
        cVarArr[i] = bVar;
    }
}
