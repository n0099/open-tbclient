package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements kotlin.jvm.a.b<c<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Iterator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.a.b
    public final Iterator<T> invoke(c<? extends T> cVar) {
        q.m(cVar, AdvanceSetting.NETWORK_TYPE);
        return cVar.iterator();
    }
}
