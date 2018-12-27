package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements kotlin.jvm.a.b<x<? extends T>, Boolean> {
    final /* synthetic */ kotlin.jvm.a.c $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$filterIndexed$1(kotlin.jvm.a.c cVar) {
        super(1);
        this.$predicate = cVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((x) obj));
    }

    public final boolean invoke(x<? extends T> xVar) {
        p.j(xVar, AdvanceSetting.NETWORK_TYPE);
        return ((Boolean) this.$predicate.invoke(Integer.valueOf(xVar.getIndex()), xVar.getValue())).booleanValue();
    }
}
