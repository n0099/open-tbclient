package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.ac;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements kotlin.jvm.a.b<ac<? extends T>, Boolean> {
    final /* synthetic */ m $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$filterIndexed$1(m mVar) {
        super(1);
        this.$predicate = mVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((ac) obj));
    }

    public final boolean invoke(ac<? extends T> acVar) {
        q.n(acVar, AdvanceSetting.NETWORK_TYPE);
        return ((Boolean) this.$predicate.invoke(Integer.valueOf(acVar.getIndex()), acVar.getValue())).booleanValue();
    }
}
