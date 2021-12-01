package kotlinx.coroutines.channels;

import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001KB\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\bJ\u0010AJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u00002\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b \u0010!J4\u0010%\u001a\u00020\u000b2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"H\u0082\u0010¢\u0006\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u00100\u001a\u00060.j\u0002`/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u0010;\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00068T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00068T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010=R$\u0010B\u001a\u0002022\u0006\u00107\u001a\u0002028B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b?\u00106\"\u0004\b@\u0010AR2\u0010E\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0Cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"`D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010I\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010:¨\u0006L"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "", "cause", "", QueryResponse.Options.CANCEL, "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", IntentConfig.CLOSE, "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "capacity", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", "(I)V", "size", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getTail", "setTail", "tail", "<init>", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    public volatile long _head;
    public volatile int _size;
    public volatile long _tail;
    public final Object[] buffer;
    public final ReentrantLock bufferLock;
    public final int capacity;
    public final List<Subscriber<E>> subscribers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b&\u0010'J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0018\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0016\u0010\u001a\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\u00060\"j\u0002`#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "checkOffer", "()Z", "needsToCheckOfferWithoutLock", "wasClosed", "", "onCancelIdempotent", "(Z)V", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        public final ArrayBroadcastChannel<E> broadcastChannel;
        public final ReentrantLock subLock = new ReentrantLock();
        public volatile long _subHead = 0;

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            this.broadcastChannel = arrayBroadcastChannel;
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        private final Object peekUnderLock() {
            long subHead = getSubHead();
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (subHead >= this.broadcastChannel.getTail()) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object elementAt = this.broadcastChannel.elementAt(subHead);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : elementAt;
        }

        public final boolean checkOffer() {
            Closed closed;
            boolean z = false;
            while (true) {
                closed = null;
                if (!needsToCheckOfferWithoutLock() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    E e2 = (E) peekUnderLock();
                    if (e2 != AbstractChannelKt.POLL_FAILED) {
                        if (e2 instanceof Closed) {
                            closed = (Closed) e2;
                            break;
                        }
                        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed == null || (takeFirstReceiveOrPeekClosed instanceof Closed)) {
                            break;
                        }
                        Symbol tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, null);
                        if (tryResumeReceive != null) {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                                    throw new AssertionError();
                                }
                            }
                            setSubHead(getSubHead() + 1);
                            this.subLock.unlock();
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            takeFirstReceiveOrPeekClosed.completeResumeReceive(e2);
                            z = true;
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        public final long getSubHead() {
            return this._subHead;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferAlwaysEmpty() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferEmpty() {
            return getSubHead() >= this.broadcastChannel.getTail();
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public void onCancelIdempotent(boolean z) {
            if (z) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
                ReentrantLock reentrantLock = this.subLock;
                reentrantLock.lock();
                try {
                    setSubHead(this.broadcastChannel.getTail());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object pollInternal() {
            boolean z;
            Closed closed;
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    setSubHead(getSubHead() + 1);
                    z = true;
                    reentrantLock.unlock();
                    closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                    if (closed != null) {
                        close(closed.closeCause);
                    }
                    if (checkOffer() ? true : z) {
                        ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                    }
                    return peekUnderLock;
                }
                z = false;
                reentrantLock.unlock();
                closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                if (closed != null) {
                }
                if (checkOffer() ? true : z) {
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public Object pollSelectInternal(SelectInstance<?> selectInstance) {
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = false;
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (!selectInstance.trySelect()) {
                        peekUnderLock = SelectKt.getALREADY_SELECTED();
                    } else {
                        setSubHead(getSubHead() + 1);
                        z = true;
                    }
                }
                reentrantLock.unlock();
                Closed closed = (Closed) (!(peekUnderLock instanceof Closed) ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() ? true : z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final void setSubHead(long j2) {
            this._subHead = j2;
        }
    }

    public ArrayBroadcastChannel(int i2) {
        this.capacity = i2;
        if (i2 >= 1) {
            this.bufferLock = new ReentrantLock();
            this.buffer = new Object[this.capacity];
            this._head = 0L;
            this._tail = 0L;
            this._size = 0;
            this.subscribers = ConcurrentKt.subscriberList();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: cancelInternal */
    public final boolean cancel(Throwable th) {
        boolean close = close(th);
        for (Subscriber<E> subscriber : this.subscribers) {
            subscriber.cancel(th);
        }
        return close;
    }

    private final void checkSubOffers() {
        boolean z = false;
        boolean z2 = false;
        for (Subscriber<E> subscriber : this.subscribers) {
            if (subscriber.checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    private final long computeMinHead() {
        long j2 = Long.MAX_VALUE;
        for (Subscriber<E> subscriber : this.subscribers) {
            j2 = RangesKt___RangesKt.coerceAtMost(j2, subscriber.getSubHead());
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E elementAt(long j2) {
        return (E) this.buffer[(int) (j2 % this.capacity)];
    }

    private final long getHead() {
        return this._head;
    }

    private final int getSize() {
        return this._size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTail() {
        return this._tail;
    }

    private final void setHead(long j2) {
        this._head = j2;
    }

    private final void setSize(int i2) {
        this._size = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTail(long j2) {
        this._tail = j2;
    }

    private final void updateHead(Subscriber<E> subscriber, Subscriber<E> subscriber2) {
        Send takeFirstSendOrPeekClosed;
        Symbol tryResumeSend;
        while (true) {
            ReentrantLock reentrantLock = this.bufferLock;
            reentrantLock.lock();
            if (subscriber != null) {
                try {
                    subscriber.setSubHead(getTail());
                    boolean isEmpty = this.subscribers.isEmpty();
                    this.subscribers.add(subscriber);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (subscriber2 != null) {
                this.subscribers.remove(subscriber2);
                if (getHead() != subscriber2.getSubHead()) {
                    return;
                }
            }
            long computeMinHead = computeMinHead();
            long tail = getTail();
            long head = getHead();
            long coerceAtMost = RangesKt___RangesKt.coerceAtMost(computeMinHead, tail);
            if (coerceAtMost <= head) {
                return;
            }
            int size = getSize();
            while (head < coerceAtMost) {
                this.buffer[(int) (head % this.capacity)] = null;
                boolean z = size >= this.capacity;
                head++;
                setHead(head);
                size--;
                setSize(size);
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed != null && !(takeFirstSendOrPeekClosed instanceof Closed)) {
                            if (takeFirstSendOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                        }
                    } while (tryResumeSend == null);
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                            throw new AssertionError();
                        }
                    }
                    Object[] objArr = this.buffer;
                    int i2 = (int) (tail % this.capacity);
                    if (takeFirstSendOrPeekClosed != null) {
                        objArr[i2] = takeFirstSendOrPeekClosed.getPollResult();
                        setSize(size + 1);
                        setTail(tail + 1);
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        takeFirstSendOrPeekClosed.completeResumeSend();
                        checkSubOffers();
                        subscriber = null;
                        subscriber2 = null;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                    }
                }
            }
            return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ArrayBroadcastChannel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            subscriber = null;
        }
        if ((i2 & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        if (super.close(th)) {
            checkSubOffers();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + getSize() + ')';
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferFull() {
        return getSize() >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerInternal(E e2) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int size = getSize();
            if (size >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            long tail = getTail();
            this.buffer[(int) (tail % this.capacity)] = e2;
            setSize(size + 1);
            setTail(tail + 1);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerSelectInternal(E e2, SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int size = getSize();
            if (size >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (!selectInstance.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            long tail = getTail();
            this.buffer[(int) (tail % this.capacity)] = e2;
            setSize(size + 1);
            setTail(tail + 1);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }
}
