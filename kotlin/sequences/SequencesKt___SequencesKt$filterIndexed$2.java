package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements kotlin.jvm.a.b<x<? extends T>, T> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((x<? extends Object>) obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public final T invoke(x<? extends T> xVar) {
        p.j(xVar, AdvanceSetting.NETWORK_TYPE);
        return xVar.getValue();
    }
}
