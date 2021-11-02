package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u0003B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010!\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010#\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/Closed;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/channels/Send;", "value", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "completeResumeSend", "()V", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "closeCause", "Ljava/lang/Throwable;", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "offerResult", "getPollResult", "pollResult", "getReceiveException", "()Ljava/lang/Throwable;", "receiveException", "getSendException", "sendException", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    @JvmField
    public final Throwable closeCause;

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(E e2) {
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Closed<E> getOfferResult() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlinx.coroutines.channels.Send
    public Closed<E> getPollResult() {
        return this;
    }

    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed@" + DebugStringsKt.getHexAddress(this) + '[' + this.closeCause + ']';
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol tryResumeReceive(E e2, LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
        if (prepareOp != null) {
            prepareOp.finishPrepare();
        }
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
        if (prepareOp != null) {
            prepareOp.finishPrepare();
        }
        return symbol;
    }
}
