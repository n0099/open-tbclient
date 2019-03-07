package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements kotlin.jvm.a.b<T, T> {
    final /* synthetic */ kotlin.jvm.a.a $nextFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$1(kotlin.jvm.a.a aVar) {
        super(1);
        this.$nextFunction = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.a.b
    public final T invoke(T t) {
        p.k(t, AdvanceSetting.NETWORK_TYPE);
        return this.$nextFunction.invoke();
    }
}
