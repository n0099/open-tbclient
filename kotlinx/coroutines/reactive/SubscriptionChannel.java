package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u001c2\b\u0012\u0004\u0012\u00028\u00000\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", ExifInterface.GPS_DIRECTION_TRUE, "", "request", "<init>", "(I)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", GameAssistConstKt.TYPE_CALLBACK_COMPLETE, "()V", "", "e", GameAssistConstKt.TYPE_CALLBACK_ERROR, "(Ljava/lang/Throwable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "I", "kotlinx-coroutines-reactive", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lorg/reactivestreams/Subscriber;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Subscriber<T> {
    public volatile /* synthetic */ int _requested;
    public volatile /* synthetic */ Object _subscription;
    public final int request;
    public static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _requested$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested");

    public SubscriptionChannel(int i) {
        super(null);
        boolean z;
        this.request = i;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this._subscription = null;
            this._requested = 0;
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid request size: ", Integer.valueOf(this.request)).toString());
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Subscription subscription = (Subscription) _subscription$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        close(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        _requested$FU.decrementAndGet(this);
        mo2308trySendJP2dKIU(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this._subscription = subscription;
        while (!isClosedForSend()) {
            int i = this._requested;
            int i2 = this.request;
            if (i >= i2) {
                return;
            }
            if (_requested$FU.compareAndSet(this, i, i2)) {
                subscription.request(this.request - i);
                return;
            }
        }
        subscription.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        close(null);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onReceiveDequeued() {
        _requested$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onReceiveEnqueued() {
        Subscription subscription;
        int i;
        while (true) {
            int i2 = this._requested;
            subscription = (Subscription) this._subscription;
            i = i2 - 1;
            if (subscription != null && i < 0) {
                int i3 = this.request;
                if (i2 == i3 || _requested$FU.compareAndSet(this, i2, i3)) {
                    break;
                }
            } else if (_requested$FU.compareAndSet(this, i2, i)) {
                return;
            }
        }
        subscription.request(this.request - i);
    }
}
