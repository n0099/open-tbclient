package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005bcdefB\u0007¢\u0006\u0004\b`\u0010aJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u000e\u0012\u0002\b\u00030\fj\u0006\u0012\u0002\b\u0003`\r2\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\u000e\u0012\u0002\b\u00030\fj\u0006\u0012\u0002\b\u0003`\r2\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010#\u001a\u00020\u001b2\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001b0 j\u0002`!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b)\u0010*J#\u0010-\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0014¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101JX\u00106\u001a\u00020\u001b\"\u0004\b\u0001\u001022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+2\u0006\u0010\u000b\u001a\u00028\u00002(\u00105\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000104\u0012\u0006\u0012\u0004\u0018\u00010\u001603H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001b\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u00108J\u001d\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u0001092\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b:\u0010;J\u001b\u0010=\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\b<\u00108J\u001b\u0010>\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b>\u00108J\u0017\u0010?\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0014¢\u0006\u0004\b?\u0010@J\u0011\u0010A\u001a\u0004\u0018\u00010\u0014H\u0004¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ#\u0010F\u001a\u00020\u001b*\u0006\u0012\u0002\b\u0003042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020C8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\bH\u0010ER\u001c\u0010L\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010N\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u0016\u0010O\u001a\u00020\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010PR\u0013\u0010R\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0016\u0010S\u001a\u00020\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010PR\u0016\u0010T\u001a\u00020\u00058D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bT\u0010PR%\u0010X\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020U8F@\u0006¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001c\u0010Z\u001a\u00020Y8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020C8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendFair$kotlinx_coroutines_core", "sendFair", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFull", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "<init>", "()V", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    public static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    public final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
    public volatile Object onCloseHandler = null;

    public String getBufferDebugString() {
        return "";
    }

    public abstract boolean isBufferAlwaysFull();

    public abstract boolean isBufferFull();

    public void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00028\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "", "completeResumeSend", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "element", "Ljava/lang/Object;", "", "getPollResult", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class SendBuffered<E> extends Send {
        @JvmField
        public final E element;

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed<?> closed) {
        }

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return symbol;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", ExifInterface.LONGITUDE_EAST, "kotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", SmsLoginView.f.l, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, new SendBuffered(e));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (!(lockFreeLinkedListNode instanceof Closed)) {
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return AbstractChannelKt.OFFER_FAILED;
                }
                return null;
            }
            return lockFreeLinkedListNode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendConflatedDesc;", ExifInterface.LONGITUDE_EAST, "kotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class SendConflatedDesc<E> extends SendBufferedDesc<E> {
        public SendConflatedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, e);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            if (!(lockFreeLinkedListNode instanceof SendBuffered)) {
                lockFreeLinkedListNode = null;
            }
            SendBuffered sendBuffered = (SendBuffered) lockFreeLinkedListNode;
            if (sendBuffered != null) {
                sendBuffered.remove();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BZ\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00020\"\u0012(\u0010\u0019\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R;\u0010\u0019\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00158\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00020\"8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/channels/Send;", "", "completeResumeSend", "()V", "dispose", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "pollResult", "Ljava/lang/Object;", "getPollResult", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {
        @JvmField
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        @JvmField
        public final AbstractSendChannel<E> channel;
        public final Object pollResult;
        @JvmField
        public final SelectInstance<R> select;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super E>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(Object obj, AbstractSendChannel<E> abstractSendChannel, SelectInstance<? super R> selectInstance, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.pollResult = obj;
            this.channel = abstractSendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
            ContinuationKt.startCoroutine(this.block, this.channel, this.select.getCompletion());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            remove();
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.pollResult;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed<?> closed) {
            if (this.select.trySelect()) {
                this.select.resumeSelectWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.select.trySelectOther(prepareOp);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendSelect@" + DebugStringsKt.getHexAddress(this) + '(' + getPollResult() + ")[" + this.channel + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.select + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00028\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", ExifInterface.LONGITUDE_EAST, "kotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", SmsLoginView.f.l, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "element", "Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        @JvmField
        public final E element;

        public TryOfferDesc(E e, LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.element = e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (!(lockFreeLinkedListNode instanceof Closed)) {
                if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                    return AbstractChannelKt.OFFER_FAILED;
                }
                return null;
            }
            return lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode.PrepareOp prepareOp) {
            boolean z;
            LockFreeLinkedListNode lockFreeLinkedListNode = prepareOp.affected;
            if (lockFreeLinkedListNode != null) {
                Symbol tryResumeReceive = ((ReceiveOrClosed) lockFreeLinkedListNode).tryResumeReceive(this.element, prepareOp);
                if (tryResumeReceive != null) {
                    Object obj = AtomicKt.RETRY_ATOMIC;
                    if (tryResumeReceive == obj) {
                        return obj;
                    }
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                        return null;
                    }
                    return null;
                }
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
        }
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            int i = 0;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    i++;
                }
            }
            return i;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (!(nextNode instanceof Closed)) {
            nextNode = null;
        }
        Closed<?> closed = (Closed) nextNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    public final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        Closed<?> closed = (Closed) prevNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.SendChannel<? super E>>, kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> */
    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return (SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>() { // from class: kotlinx.coroutines.channels.AbstractSendChannel$onSend$1
            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
                AbstractSendChannel.this.registerSelectSend(selectInstance, e, function2);
            }
        };
    }

    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        if (getClosedForSend() != null) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return isFullImpl();
    }

    public final boolean isFullImpl() {
        if (!(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull()) {
            return true;
        }
        return false;
    }

    private final String getQueueDebugStateString() {
        String str;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            str = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            str = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + nextNode;
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode != nextNode) {
            String str2 = str + ",queueSize=" + countQueueSize();
            if (prevNode instanceof Closed) {
                return str2 + ",closedForSend=" + prevNode;
            }
            return str2;
        }
        return str;
    }

    private final void helpClose(Closed<?> closed) {
        Object m2106constructorimpl$default = InlineList.m2106constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if (!(prevNode instanceof Receive)) {
                prevNode = null;
            }
            Receive receive = (Receive) prevNode;
            if (receive == null) {
                break;
            } else if (!receive.remove()) {
                receive.helpRemove();
            } else {
                m2106constructorimpl$default = InlineList.m2111plusimpl(m2106constructorimpl$default, receive);
            }
        }
        if (m2106constructorimpl$default != null) {
            if (!(m2106constructorimpl$default instanceof ArrayList)) {
                ((Receive) m2106constructorimpl$default).resumeReceiveClosed(closed);
            } else if (m2106constructorimpl$default != null) {
                ArrayList arrayList = (ArrayList) m2106constructorimpl$default;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
        onClosedIdempotent(closed);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(E e) {
        Object offerInternal = offerInternal(e);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(closedForSend));
        } else if (offerInternal instanceof Closed) {
            throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed) offerInternal));
        } else {
            throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
        }
    }

    private final Throwable helpCloseAndGetSendException(Closed<?> closed) {
        helpClose(closed);
        return closed.getSendException();
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Object obj;
        Object obj2 = this.onCloseHandler;
        if (obj2 != null && obj2 != (obj = AbstractChannelKt.HANDLER_INVOKED) && onCloseHandler$FU.compareAndSet(this, obj2, obj)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 1)).invoke(th);
        }
    }

    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E e) {
        return new SendBufferedDesc(this.queue, e);
    }

    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendConflated(E e) {
        return new SendConflatedDesc(this.queue, e);
    }

    public final TryOfferDesc<E> describeTryOffer(E e) {
        return new TryOfferDesc<>(e, this.queue);
    }

    public Object offerInternal(E e) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        boolean z;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed != null) {
                tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
            } else {
                return AbstractChannelKt.OFFER_FAILED;
            }
        } while (tryResumeReceive == null);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    public final ReceiveOrClosed<?> sendBuffered(E e) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        SendBuffered sendBuffered = new SendBuffered(e);
        do {
            prevNode = lockFreeLinkedListNode.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListNode));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void helpCloseAndResumeWithSendException(Continuation<?> continuation, Closed<?> closed) {
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m698constructorimpl(ResultKt.createFailure(sendException)));
    }

    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        TryOfferDesc<E> describeTryOffer = describeTryOffer(e);
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
        result.completeResumeReceive(e);
        return result.getOfferResult();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        if (offerInternal(e) == AbstractChannelKt.OFFER_SUCCESS) {
            return Unit.INSTANCE;
        }
        Object sendSuspend = sendSuspend(e, continuation);
        if (sendSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return sendSuspend;
        }
        return Unit.INSTANCE;
    }

    public final Object sendFair$kotlinx_coroutines_core(E e, Continuation<? super Unit> continuation) {
        if (offerInternal(e) == AbstractChannelKt.OFFER_SUCCESS) {
            Object yield = YieldKt.yield(continuation);
            if (yield == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return yield;
            }
            return Unit.INSTANCE;
        }
        Object sendSuspend = sendSuspend(e, continuation);
        if (sendSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return sendSuspend;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (isFullImpl()) {
                SendSelect sendSelect = new SendSelect(e, this, selectInstance, function2);
                Object enqueueSend = enqueueSend(sendSelect);
                if (enqueueSend == null) {
                    selectInstance.disposeOnSelect(sendSelect);
                    return;
                } else if (!(enqueueSend instanceof Closed)) {
                    if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                        throw new IllegalStateException(("enqueueSend returned " + enqueueSend + WebvttCueParser.CHAR_SPACE).toString());
                    }
                } else {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed) enqueueSend));
                }
            }
            Object offerSelectInternal = offerSelectInternal(e, selectInstance);
            if (offerSelectInternal == SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED && offerSelectInternal != AtomicKt.RETRY_ATOMIC) {
                if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                    UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
                    return;
                } else if (offerSelectInternal instanceof Closed) {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed) offerSelectInternal));
                } else {
                    throw new IllegalStateException(("offerSelectInternal returned " + offerSelectInternal).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        boolean z;
        Closed<?> closed = new Closed<>(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
            z = true;
            if (!(!(prevNode instanceof Closed))) {
                z = false;
                break;
            } else if (prevNode.addNext(closed, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z) {
            LockFreeLinkedListNode prevNode2 = this.queue.getPrevNode();
            if (prevNode2 != null) {
                closed = (Closed) prevNode2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
        }
        helpClose(closed);
        if (z) {
            invokeOnCloseHandler(th);
        }
        return z;
    }

    public Object enqueueSend(final Send send) {
        boolean z;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            do {
                prevNode = lockFreeLinkedListNode.getPrevNode();
                if (prevNode instanceof ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(send, lockFreeLinkedListNode));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(send) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode3) {
                if (this.isBufferFull()) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        while (true) {
            LockFreeLinkedListNode prevNode2 = lockFreeLinkedListNode2.getPrevNode();
            if (prevNode2 instanceof ReceiveOrClosed) {
                return prevNode2;
            }
            int tryCondAddNext = prevNode2.tryCondAddNext(send, lockFreeLinkedListNode2, condAddOp);
            z = true;
            if (tryCondAddNext != 1) {
                if (tryCondAddNext == 2) {
                    z = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        if (!onCloseHandler$FU.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null && onCloseHandler$FU.compareAndSet(this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(closedForSend.closeCause);
        }
    }

    public final /* synthetic */ Object sendSuspend(E e, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (isFullImpl()) {
                SendElement sendElement = new SendElement(e, orCreateCancellableContinuation);
                Object enqueueSend = enqueueSend(sendElement);
                if (enqueueSend == null) {
                    CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, sendElement);
                    break;
                } else if (enqueueSend instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, (Closed) enqueueSend);
                    break;
                } else if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + enqueueSend).toString());
                }
            }
            Object offerInternal = offerInternal(e);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                orCreateCancellableContinuation.resumeWith(Result.m698constructorimpl(unit));
                break;
            } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, (Closed) offerInternal);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
                }
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                    if (((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                        break;
                    }
                    removeOrNext.helpRemovePrev();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            Object next = lockFreeLinkedListHead.getNext();
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                    if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                        break;
                    }
                    removeOrNext.helpRemovePrev();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (Send) lockFreeLinkedListNode;
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }
}
