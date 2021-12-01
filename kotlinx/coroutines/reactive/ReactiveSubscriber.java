package kotlinx.coroutines.reactive;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "", "T", "Lorg/reactivestreams/Subscriber;", "", QueryResponse.Options.CANCEL, "()V", "makeRequest", "onComplete", "", "t", "onError", "(Ljava/lang/Throwable;)V", "value", "onNext", "(Ljava/lang/Object;)V", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "requestSize", "J", IMConstants.SERVICE_TYPE_SUBSCRIPTION, "Lorg/reactivestreams/Subscription;", "", "capacity", "<init>", "(IJ)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ReactiveSubscriber<T> implements Subscriber<T> {
    public final Channel<T> channel;
    public final long requestSize;
    public Subscription subscription;

    public ReactiveSubscriber(int i2, long j2) {
        this.requestSize = j2;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel(i2);
    }

    public final void cancel() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
        }
        subscription.cancel();
    }

    public final void makeRequest() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
        }
        subscription.request(this.requestSize);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.channel.close(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.channel.offer(t)) {
            return;
        }
        throw new IllegalArgumentException(("Element " + t + " was not added to channel because it was full, " + this.channel).toString());
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        makeRequest();
    }

    public final Object takeNextOrNull(Continuation<? super T> continuation) {
        return ChannelsKt.receiveOrNull(this.channel, continuation);
    }
}
