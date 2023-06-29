package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a6\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a#\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017\u001a+\u0010\u0018\u001a\u00020\u0019*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001b\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u001c"}, d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getNO_VALUE$annotations", "()V", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedFlowKt {
    @JvmField
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    public static /* synthetic */ void getNO_VALUE$annotations() {
    }

    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int i, int i2, BufferOverflow bufferOverflow) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (i <= 0 && i2 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z3 = false;
                }
                if (z3) {
                    int i3 = i2 + i;
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(i, i3, bufferOverflow);
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", bufferOverflow).toString());
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("extraBufferCapacity cannot be negative, but was ", Integer.valueOf(i2)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("replay cannot be negative, but was ", Integer.valueOf(i)).toString());
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int i, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i, i2, bufferOverflow);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.flow.SharedFlowImpl.cancelEmitter(kotlinx.coroutines.flow.SharedFlowImpl$Emitter):void, kotlinx.coroutines.flow.SharedFlowImpl.cleanupTailLocked():void, kotlinx.coroutines.flow.SharedFlowImpl.getLastReplayedLocked():T, kotlinx.coroutines.flow.SharedFlowImpl.getPeekedValueLockedAt(long):java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl.getReplayCache():java.util.List<T>, kotlinx.coroutines.flow.SharedFlowImpl.growBuffer(java.lang.Object[], int, int):java.lang.Object[], kotlinx.coroutines.flow.SharedFlowImpl.updateCollectorIndexLocked$kotlinx_coroutines_core(long):kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    public static final /* synthetic */ Object access$getBufferAt(Object[] objArr, long j) {
        return getBufferAt(objArr, j);
    }

    public static final Object getBufferAt(Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.flow.SharedFlowImpl.cancelEmitter(kotlinx.coroutines.flow.SharedFlowImpl$Emitter):void, kotlinx.coroutines.flow.SharedFlowImpl.cleanupTailLocked():void, kotlinx.coroutines.flow.SharedFlowImpl.dropOldestLocked():void, kotlinx.coroutines.flow.SharedFlowImpl.enqueueLocked(java.lang.Object):void, kotlinx.coroutines.flow.SharedFlowImpl.growBuffer(java.lang.Object[], int, int):java.lang.Object[], kotlinx.coroutines.flow.SharedFlowImpl.updateBufferLocked(long, long, long, long):void, kotlinx.coroutines.flow.SharedFlowImpl.updateCollectorIndexLocked$kotlinx_coroutines_core(long):kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    public static final /* synthetic */ void access$setBufferAt(Object[] objArr, long j, Object obj) {
        setBufferAt(objArr, j, obj);
    }

    public static final void setBufferAt(Object[] objArr, long j, Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }

    public static final <T> Flow<T> fuseSharedFlow(SharedFlow<? extends T> sharedFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, bufferOverflow);
    }
}
