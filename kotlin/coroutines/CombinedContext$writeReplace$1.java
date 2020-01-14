package kotlin.coroutines;

import kotlin.coroutines.c;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.q;
import kotlin.k;
/* loaded from: classes5.dex */
final class CombinedContext$writeReplace$1 extends Lambda implements m<k, c.b, k> {
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
    public /* bridge */ /* synthetic */ k invoke(k kVar, c.b bVar) {
        invoke2(kVar, bVar);
        return k.nAY;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(k kVar, c.b bVar) {
        q.j(kVar, "<anonymous parameter 0>");
        q.j(bVar, "element");
        c[] cVarArr = this.$elements;
        Ref.IntRef intRef = this.$index;
        int i = intRef.element;
        intRef.element = i + 1;
        cVarArr[i] = bVar;
    }
}
