package kotlin.collections;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes9.dex */
final class AbstractCollection$toString$1 extends Lambda implements kotlin.jvm.a.b<E, CharSequence> {
    final /* synthetic */ a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractCollection$toString$1(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
        return invoke((AbstractCollection$toString$1) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.b
    public final CharSequence invoke(E e) {
        return e == this.this$0 ? "(this Collection)" : String.valueOf(e);
    }
}
