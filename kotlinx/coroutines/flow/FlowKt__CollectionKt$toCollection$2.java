package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
/* JADX WARN: Incorrect field signature: TC; */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\u0003*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "C", "", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__CollectionKt$toCollection$2<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Collection $destination;

    /* JADX WARN: Incorrect types in method signature: (TC;)V */
    public FlowKt__CollectionKt$toCollection$2(Collection collection) {
        this.$destination = collection;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$destination.add(t);
        return Unit.INSTANCE;
    }
}
