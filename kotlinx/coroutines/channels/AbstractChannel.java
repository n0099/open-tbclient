package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", StatConstants.VALUE_TYPE_RECEIVE, "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlinx/coroutines/selects/SelectInstance;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    public abstract boolean isBufferAlwaysEmpty();

    public abstract boolean isBufferEmpty();

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Itr<E> implements ChannelIterator<E> {
        @JvmField
        public final AbstractChannel<E> channel;
        public Object result = AbstractChannelKt.POLL_FAILED;

        public Itr(AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        private final boolean hasNextResult(Object obj) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.closeCause == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            Function1<Throwable, Unit> bindCancellationFun;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, orCreateCancellableContinuation);
            while (true) {
                if (this.channel.enqueueReceive(receiveHasNext)) {
                    this.channel.removeReceiveOnCancel(orCreateCancellableContinuation, receiveHasNext);
                    break;
                }
                Object pollInternal = this.channel.pollInternal();
                setResult(pollInternal);
                if (pollInternal instanceof Closed) {
                    Closed closed = (Closed) pollInternal;
                    if (closed.closeCause == null) {
                        Result.Companion companion = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m850constructorimpl(Boxing.boxBoolean(false)));
                    } else {
                        Result.Companion companion2 = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m850constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
                    }
                } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
                    if (function1 == null) {
                        bindCancellationFun = null;
                    } else {
                        bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(function1, pollInternal, orCreateCancellableContinuation.getContext());
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, bindCancellationFun);
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public final Object getResult() {
            return this.result;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.result;
            if (!(e instanceof Closed)) {
                Symbol symbol = AbstractChannelKt.POLL_FAILED;
                if (e != symbol) {
                    this.result = symbol;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) e).getReceiveException());
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            if (getResult() != AbstractChannelKt.POLL_FAILED) {
                return Boxing.boxBoolean(hasNextResult(getResult()));
            }
            setResult(this.channel.pollInternal());
            if (getResult() != AbstractChannelKt.POLL_FAILED) {
                return Boxing.boxBoolean(hasNextResult(getResult()));
            }
            return hasNextSuspend(continuation);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static class ReceiveElement<E> extends Receive<E> {
        @JvmField
        public final CancellableContinuation<Object> cont;
        @JvmField
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.cont = cancellableContinuation;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            if (this.receiveMode == 1) {
                CancellableContinuation<Object> cancellableContinuation = this.cont;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m850constructorimpl(ChannelResult.m2304boximpl(ChannelResult.Companion.m2317closedJP2dKIU(closed.closeCause))));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.cont;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m850constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
        }

        public final Object resumeValue(E e) {
            if (this.receiveMode == 1) {
                return ChannelResult.m2304boximpl(ChannelResult.Companion.m2319successJP2dKIU(e));
            }
            return e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            boolean z;
            CancellableContinuation<Object> cancellableContinuation = this.cont;
            Object resumeValue = resumeValue(e);
            if (prepareOp == null) {
                abstractAtomicDesc = null;
            } else {
                abstractAtomicDesc = prepareOp.desc;
            }
            Object tryResume = cancellableContinuation.tryResume(resumeValue, abstractAtomicDesc, resumeOnCancellationFun(e));
            if (tryResume == null) {
                return null;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (tryResume == CancellableContinuationImplKt.RESUME_TOKEN) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        @JvmField
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super E, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.onUndeliveredElement = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, e, this.cont.getContext());
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static class ReceiveHasNext<E> extends Receive<E> {
        @JvmField
        public final CancellableContinuation<Boolean> cont;
        @JvmField
        public final Itr<E> iterator;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            this.iterator.setResult(e);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e) {
            Function1<E, Unit> function1 = this.iterator.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.bindCancellationFun(function1, e, this.cont.getContext());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Object tryResumeWithException;
            if (closed.closeCause == null) {
                tryResumeWithException = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.FALSE, null, 2, null);
            } else {
                tryResumeWithException = this.cont.tryResumeWithException(closed.getReceiveException());
            }
            if (tryResumeWithException != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(tryResumeWithException);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return Intrinsics.stringPlus("ReceiveHasNext@", DebugStringsKt.getHexAddress(this));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            boolean z;
            CancellableContinuation<Boolean> cancellableContinuation = this.cont;
            Boolean bool = Boolean.TRUE;
            if (prepareOp == null) {
                abstractAtomicDesc = null;
            } else {
                abstractAtomicDesc = prepareOp.desc;
            }
            Object tryResume = cancellableContinuation.tryResume(bool, abstractAtomicDesc, resumeOnCancellationFun(e));
            if (tryResume == null) {
                return null;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (tryResume == CancellableContinuationImplKt.RESUME_TOKEN) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00028\u00022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#R3\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlinx/coroutines/selects/SelectInstance;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        @JvmField
        public final Function2<Object, Continuation<? super R>, Object> block;
        @JvmField
        public final AbstractChannel<E> channel;
        @JvmField
        public final int receiveMode;
        @JvmField
        public final SelectInstance<R> select;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> abstractChannel, SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.channel = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            Object obj;
            Function2<Object, Continuation<? super R>, Object> function2 = this.block;
            if (this.receiveMode == 1) {
                obj = ChannelResult.m2304boximpl(ChannelResult.Companion.m2319successJP2dKIU(e));
            } else {
                obj = e;
            }
            CancellableKt.startCoroutineCancellable(function2, obj, this.select.getCompletion(), resumeOnCancellationFun(e));
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e) {
            Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.bindCancellationFun(function1, e, this.select.getCompletion().getContext());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (mo2344remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.getHexAddress(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            if (!this.select.trySelect()) {
                return;
            }
            int i = this.receiveMode;
            if (i != 0) {
                if (i == 1) {
                    CancellableKt.startCoroutineCancellable$default(this.block, ChannelResult.m2304boximpl(ChannelResult.Companion.m2317closedJP2dKIU(closed.closeCause)), this.select.getCompletion(), null, 4, null);
                    return;
                }
                return;
            }
            this.select.resumeSelectWithException(closed.getReceiveException());
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.select.trySelectOther(prepareOp);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", StatConstants.VALUE_TYPE_RECEIVE, "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        public final Receive<?> receive;

        public RemoveReceiveOnCancel(Receive<?> receive) {
            this.receive = receive;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (this.receive.mo2344remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", SmsLoginView.f.l, "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "onRemoved", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (!(lockFreeLinkedListNode instanceof Closed)) {
                if (!(lockFreeLinkedListNode instanceof Send)) {
                    return AbstractChannelKt.POLL_FAILED;
                }
                return null;
            }
            return lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode.PrepareOp prepareOp) {
            boolean z;
            Symbol tryResumeSend = ((Send) prepareOp.affected).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeSend == obj) {
                return obj;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
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

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void onRemoved(LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((Send) lockFreeLinkedListNode).undeliveredElement();
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean enqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (isClosedForReceive()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(Intrinsics.stringPlus(DebugStringsKt.getClassSimpleName(this), " was cancelled"));
        }
        cancel(cancellationException);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancelInternal$kotlinx_coroutines_core */
    public final boolean cancel(Throwable th) {
        boolean close = close(th);
        onCancelIdempotent(close);
        return close;
    }

    public Object pollSelectInternal(SelectInstance<?> selectInstance) {
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        describeTryPoll.getResult().completeResumeSend();
        return describeTryPoll.getResult().getPollResult();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal != AbstractChannelKt.POLL_FAILED && !(pollInternal instanceof Closed)) {
            return pollInternal;
        }
        return receiveSuspend(0, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    /* renamed from: onCancelIdempotentList-w-w6eGU  reason: not valid java name */
    public void mo2296onCancelIdempotentListww6eGU(Object obj, Closed<?> closed) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((Send) obj).resumeSendClosed(closed);
            } else if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size < 0) {
                    return;
                }
                while (true) {
                    int i = size - 1;
                    ((Send) arrayList.get(size)).resumeSendClosed(closed);
                    if (i >= 0) {
                        size = i;
                    } else {
                        return;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i);
        boolean enqueueReceive = enqueueReceive(receiveSelect);
        if (enqueueReceive) {
            selectInstance.disposeOnSelect(receiveSelect);
        }
        return enqueueReceive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceiveMode(SelectInstance<? super R> selectInstance, int i, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (isEmptyImpl()) {
                if (enqueueReceiveSelect(selectInstance, function2, i)) {
                    return;
                }
            } else {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != AbstractChannelKt.POLL_FAILED && pollSelectInternal != AtomicKt.RETRY_ATOMIC) {
                    tryStartBlockUnintercepted(function2, selectInstance, i, pollSelectInternal);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$ReceiveElement] */
    public final <R> Object receiveSuspend(int i, Continuation<? super R> continuation) {
        ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (this.onUndeliveredElement == null) {
            receiveElementWithUndeliveredHandler = new ReceiveElement(orCreateCancellableContinuation, i);
        } else {
            receiveElementWithUndeliveredHandler = new ReceiveElementWithUndeliveredHandler(orCreateCancellableContinuation, i, this.onUndeliveredElement);
        }
        while (true) {
            if (enqueueReceive(receiveElementWithUndeliveredHandler)) {
                removeReceiveOnCancel(orCreateCancellableContinuation, receiveElementWithUndeliveredHandler);
                break;
            }
            Object pollInternal = pollInternal();
            if (pollInternal instanceof Closed) {
                receiveElementWithUndeliveredHandler.resumeReceiveClosed((Closed) pollInternal);
                break;
            } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                orCreateCancellableContinuation.resume(receiveElementWithUndeliveredHandler.resumeValue(pollInternal), receiveElementWithUndeliveredHandler.resumeOnCancellationFun(pollInternal));
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final <R> void tryStartBlockUnintercepted(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i, Object obj) {
        Object m2319successJP2dKIU;
        boolean z = obj instanceof Closed;
        if (z) {
            if (i != 0) {
                if (i != 1 || !selectInstance.trySelect()) {
                    return;
                }
                UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m2304boximpl(ChannelResult.Companion.m2317closedJP2dKIU(((Closed) obj).closeCause)), selectInstance.getCompletion());
                return;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) obj).getReceiveException());
        } else if (i == 1) {
            ChannelResult.Companion companion = ChannelResult.Companion;
            if (z) {
                m2319successJP2dKIU = companion.m2317closedJP2dKIU(((Closed) obj).closeCause);
            } else {
                m2319successJP2dKIU = companion.m2319successJP2dKIU(obj);
            }
            UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m2304boximpl(m2319successJP2dKIU), selectInstance.getCompletion());
        } else {
            UndispatchedKt.startCoroutineUnintercepted(function2, obj, selectInstance.getCompletion());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceive() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            public final /* synthetic */ AbstractChannel<E> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                this.this$0.registerSelectReceiveMode(selectInstance, 0, function2);
            }
        };
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<kotlinx.coroutines.channels.ChannelResult<? extends E>>, kotlinx.coroutines.selects.SelectClause1<kotlinx.coroutines.channels.ChannelResult<E>> */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return (SelectClause1<ChannelResult<? extends E>>) new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1
            public final /* synthetic */ AbstractChannel<E> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(SelectInstance<? super R> selectInstance, Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.this$0.registerSelectReceiveMode(selectInstance, 1, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        if (getClosedForReceive() != null && isBufferEmpty()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return isEmptyImpl();
    }

    public final boolean isEmptyImpl() {
        if (!(getQueue().getNextNode() instanceof Send) && isBufferEmpty()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    public Object pollInternal() {
        boolean z;
        while (true) {
            Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
            if (tryResumeSend != null) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                takeFirstSendOrPeekClosed.completeResumeSend();
                return takeFirstSendOrPeekClosed.getPollResult();
            }
            takeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: kotlinx.coroutines.channels.ChannelResult$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public final Object mo2298tryReceivePtdJZtk() {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return ChannelResult.Companion.m2318failurePtdJZtk();
        }
        if (pollInternal instanceof Closed) {
            return ChannelResult.Companion.m2317closedJP2dKIU(((Closed) pollInternal).closeCause);
        }
        return ChannelResult.Companion.m2319successJP2dKIU(pollInternal);
    }

    public boolean enqueueReceiveInternal(final Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
        } else {
            LockFreeLinkedListNode queue2 = getQueue();
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                public final /* synthetic */ AbstractChannel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(LockFreeLinkedListNode.this);
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlinx.coroutines.internal.AtomicOp
                public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
                    if (this.this$0.isBufferEmpty()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
            do {
                LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
                if (!(!(prevNode2 instanceof Send))) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive, queue2, condAddOp);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        return true;
    }

    public void onCancelIdempotent(boolean z) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null) {
            Object m2336constructorimpl$default = InlineList.m2336constructorimpl$default(null, 1, null);
            while (true) {
                LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
                if (prevNode instanceof LockFreeLinkedListHead) {
                    mo2296onCancelIdempotentListww6eGU(m2336constructorimpl$default, closedForSend);
                    return;
                } else if (DebugKt.getASSERTIONS_ENABLED() && !(prevNode instanceof Send)) {
                    throw new AssertionError();
                } else {
                    if (!prevNode.mo2344remove()) {
                        prevNode.helpRemove();
                    } else {
                        m2336constructorimpl$default = InlineList.m2341plusFjFbRPM(m2336constructorimpl$default, (Send) prevNode);
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: kotlinx.coroutines.channels.ChannelResult$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo2297receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        AbstractChannel$receiveCatching$1 abstractChannel$receiveCatching$1;
        int i;
        if (continuation instanceof AbstractChannel$receiveCatching$1) {
            abstractChannel$receiveCatching$1 = (AbstractChannel$receiveCatching$1) continuation;
            int i2 = abstractChannel$receiveCatching$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                abstractChannel$receiveCatching$1.label = i2 - Integer.MIN_VALUE;
                Object obj = abstractChannel$receiveCatching$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = abstractChannel$receiveCatching$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Object pollInternal = pollInternal();
                    if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                        if (pollInternal instanceof Closed) {
                            return ChannelResult.Companion.m2317closedJP2dKIU(((Closed) pollInternal).closeCause);
                        }
                        return ChannelResult.Companion.m2319successJP2dKIU(pollInternal);
                    }
                    abstractChannel$receiveCatching$1.label = 1;
                    obj = receiveSuspend(1, abstractChannel$receiveCatching$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return ((ChannelResult) obj).m2316unboximpl();
            }
        }
        abstractChannel$receiveCatching$1 = new AbstractChannel$receiveCatching$1(this, continuation);
        Object obj2 = abstractChannel$receiveCatching$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = abstractChannel$receiveCatching$1.label;
        if (i == 0) {
        }
        return ((ChannelResult) obj2).m2316unboximpl();
    }
}
