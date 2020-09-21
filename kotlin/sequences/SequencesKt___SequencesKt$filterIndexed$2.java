package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.ac;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes5.dex */
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements kotlin.jvm.a.b<ac<? extends T>, T> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((ac<? extends Object>) obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public final T invoke(ac<? extends T> acVar) {
        q.m(acVar, AdvanceSetting.NETWORK_TYPE);
        return acVar.getValue();
    }
}
