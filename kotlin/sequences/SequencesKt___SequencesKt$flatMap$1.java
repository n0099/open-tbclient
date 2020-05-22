package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
final class SequencesKt___SequencesKt$flatMap$1 extends Lambda implements kotlin.jvm.a.b<c<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    SequencesKt___SequencesKt$flatMap$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Iterator<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.a.b
    public final Iterator<R> invoke(c<? extends R> cVar) {
        q.m(cVar, AdvanceSetting.NETWORK_TYPE);
        return cVar.iterator();
    }
}
