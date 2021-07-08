package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "Lorg/reactivestreams/Subscriber;", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "", "request", "I", "<init>", "(I)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Subscriber<T> {
    public volatile int _requested;
    public volatile Object _subscription;
    public final int request;
    public static final AtomicReferenceFieldUpdater _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    public static final AtomicIntegerFieldUpdater _requested$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested");

    public SubscriptionChannel(int i2) {
        this.request = i2;
        if (i2 >= 0) {
            this._subscription = null;
            this._requested = 0;
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + this.request).toString());
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Subscription subscription = (Subscription) _subscription$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        close(null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        close(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        _requested$FU.decrementAndGet(this);
        offer(t);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onReceiveDequeued() {
        _requested$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onReceiveEnqueued() {
        Subscription subscription;
        int i2;
        while (true) {
            int i3 = this._requested;
            subscription = (Subscription) this._subscription;
            i2 = i3 - 1;
            if (subscription != null && i2 < 0) {
                int i4 = this.request;
                if (i3 == i4 || _requested$FU.compareAndSet(this, i3, i4)) {
                    break;
                }
            } else if (_requested$FU.compareAndSet(this, i3, i2)) {
                return;
            }
        }
        subscription.request(this.request - i2);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this._subscription = subscription;
        while (!isClosedForSend()) {
            int i2 = this._requested;
            int i3 = this.request;
            if (i2 >= i3) {
                return;
            }
            if (_requested$FU.compareAndSet(this, i2, i3)) {
                subscription.request(this.request - i2);
                return;
            }
        }
        subscription.cancel();
    }
}
