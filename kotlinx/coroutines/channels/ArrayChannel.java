package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", StatConstants.VALUE_TYPE_RECEIVE, "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {
    public Object[] buffer;
    public final int capacity;
    public int head;
    public final ReentrantLock lock;
    public final BufferOverflow onBufferOverflow;
    public volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (i >= 1) {
            this.lock = new ReentrantLock();
            Object[] objArr = new Object[Math.min(this.capacity, 8)];
            ArraysKt___ArraysJvmKt.fill$default(objArr, AbstractChannelKt.EMPTY, 0, 0, 6, (Object) null);
            this.buffer = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    private final void enqueueElement(int i, E e) {
        boolean z;
        if (i < this.capacity) {
            ensureCapacity(i);
            Object[] objArr = this.buffer;
            objArr[(this.head + i) % objArr.length] = e;
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (this.onBufferOverflow == BufferOverflow.DROP_OLDEST) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.buffer;
        int i2 = this.head;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.head = (i2 + 1) % objArr2.length;
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[min];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.fill((Symbol[]) objArr2, AbstractChannelKt.EMPTY, i, min);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    private final Symbol updateBufferSize(int i) {
        if (i < this.capacity) {
            this.size = i + 1;
            return null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        return AbstractChannelKt.OFFER_FAILED;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object enqueueSend(Send send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        if (this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return isEmptyImpl();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerInternal(E e) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        boolean z;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                Symbol updateBufferSize = updateBufferSize(i);
                if (updateBufferSize == null) {
                    if (i == 0) {
                        do {
                            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed != null) {
                                if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                    this.size = i;
                                    return takeFirstReceiveOrPeekClosed;
                                }
                                tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
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
                        this.size = i;
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                        return takeFirstReceiveOrPeekClosed.getOfferResult();
                    }
                    enqueueElement(i, e);
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
                return updateBufferSize;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                Symbol updateBufferSize = updateBufferSize(i);
                if (updateBufferSize == null) {
                    if (i == 0) {
                        while (true) {
                            AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(e);
                            Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                            if (performAtomicTrySelect == null) {
                                this.size = i;
                                ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
                                Unit unit = Unit.INSTANCE;
                                reentrantLock.unlock();
                                Intrinsics.checkNotNull(result);
                                ReceiveOrClosed<? super E> receiveOrClosed = result;
                                receiveOrClosed.completeResumeReceive(e);
                                return receiveOrClosed.getOfferResult();
                            } else if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                                break;
                            } else if (performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                                if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED() && !(performAtomicTrySelect instanceof Closed)) {
                                    throw new IllegalStateException(Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                                }
                                this.size = i;
                                return performAtomicTrySelect;
                            }
                        }
                    }
                    if (!selectInstance.trySelect()) {
                        this.size = i;
                        return SelectKt.getALREADY_SELECTED();
                    }
                    enqueueElement(i, e);
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
                return updateBufferSize;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean z) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            int i2 = 0;
            while (i2 < i) {
                i2++;
                Object obj = this.buffer[this.head];
                if (function1 != null && obj != AbstractChannelKt.EMPTY) {
                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                this.buffer[this.head] = AbstractChannelKt.EMPTY;
                this.head = (this.head + 1) % this.buffer.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(z);
            if (undeliveredElementException == null) {
                return;
            }
            throw undeliveredElementException;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.buffer[this.head];
            Send send = null;
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i == this.capacity) {
                Send send2 = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                    if (tryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                    } else {
                        takeFirstSendOrPeekClosed.undeliveredElement();
                        send2 = takeFirstSendOrPeekClosed;
                    }
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.buffer.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            if (z) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0097 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000f, B:10:0x0015, B:12:0x002d, B:14:0x0037, B:33:0x007b, B:35:0x007f, B:37:0x0083, B:43:0x00a7, B:38:0x0091, B:40:0x0097, B:16:0x0047, B:19:0x004c, B:22:0x0051, B:24:0x0057, B:27:0x0063, B:30:0x006a, B:31:0x0079), top: B:51:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object pollSelectInternal(SelectInstance<?> selectInstance) {
        boolean z;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.buffer[this.head];
            Send send = null;
            this.buffer[this.head] = null;
            this.size = i - 1;
            Symbol symbol = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                while (true) {
                    AbstractChannel.TryPollDesc<E> describeTryPoll = describeTryPoll();
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
                    if (performAtomicTrySelect == null) {
                        send = describeTryPoll.getResult();
                        Intrinsics.checkNotNull(send);
                        symbol = send.getPollResult();
                        break;
                    } else if (performAtomicTrySelect == AbstractChannelKt.POLL_FAILED) {
                        break;
                    } else if (performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                        if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                            this.size = i;
                            this.buffer[this.head] = obj;
                            return performAtomicTrySelect;
                        } else if (performAtomicTrySelect instanceof Closed) {
                            symbol = performAtomicTrySelect;
                            send = symbol;
                        } else {
                            throw new IllegalStateException(Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                        }
                    }
                }
                z = true;
                if (symbol == AbstractChannelKt.POLL_FAILED && !(symbol instanceof Closed)) {
                    this.size = i;
                    this.buffer[(this.head + i) % this.buffer.length] = symbol;
                } else if (!selectInstance.trySelect()) {
                    this.size = i;
                    this.buffer[this.head] = obj;
                    return SelectKt.getALREADY_SELECTED();
                }
                this.head = (this.head + 1) % this.buffer.length;
                Unit unit = Unit.INSTANCE;
                if (z) {
                    Intrinsics.checkNotNull(send);
                    send.completeResumeSend();
                }
                return obj;
            }
            z = false;
            if (symbol == AbstractChannelKt.POLL_FAILED) {
            }
            if (!selectInstance.trySelect()) {
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit2 = Unit.INSTANCE;
            if (z) {
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
