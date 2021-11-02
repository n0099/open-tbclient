package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.sapi2.views.SmsLoginView;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000bR\u001a\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "", SmsLoginView.f.l, "", XAdRemoteEvent.COMPLETE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    public static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    public volatile Object _consensus;

    public AtomicOp() {
        Object obj;
        obj = AtomicKt.NO_DECISION;
        this._consensus = obj;
    }

    public abstract void complete(T t, Object obj);

    public final Object decide(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            obj4 = AtomicKt.NO_DECISION;
            if (!(obj != obj4)) {
                throw new AssertionError();
            }
        }
        Object obj5 = this._consensus;
        obj2 = AtomicKt.NO_DECISION;
        if (obj5 != obj2) {
            return obj5;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _consensus$FU;
        obj3 = AtomicKt.NO_DECISION;
        return atomicReferenceFieldUpdater.compareAndSet(this, obj3, obj) ? obj : this._consensus;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.internal.AtomicOp<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public AtomicOp<?> getAtomicOp() {
        return this;
    }

    public long getOpSequence() {
        return 0L;
    }

    public final boolean isDecided() {
        Object obj;
        Object obj2 = this._consensus;
        obj = AtomicKt.NO_DECISION;
        return obj2 != obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object obj) {
        Object obj2;
        Object obj3 = this._consensus;
        obj2 = AtomicKt.NO_DECISION;
        if (obj3 == obj2) {
            obj3 = decide(prepare(obj));
        }
        complete(obj, obj3);
        return obj3;
    }

    public abstract Object prepare(T t);
}
