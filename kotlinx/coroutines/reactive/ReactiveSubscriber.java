package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/reactivestreams/Subscriber;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "requestSize", "", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", IMConstants.SERVICE_TYPE_SUBSCRIPTION, "Lorg/reactivestreams/Subscription;", "cancel", "", "makeRequest", GameAssistConstKt.TYPE_CALLBACK_COMPLETE, GameAssistConstKt.TYPE_CALLBACK_ERROR, "t", "", "onNext", "value", "(Ljava/lang/Object;)V", "onSubscribe", "s", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReactiveSubscriber<T> implements Subscriber<T> {
    public final Channel<T> channel;
    public final long requestSize;
    public Subscription subscription;

    public ReactiveSubscriber(int i, BufferOverflow bufferOverflow, long j) {
        this.requestSize = j;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel$default(i == 0 ? 1 : i, bufferOverflow, null, 4, null);
    }

    public final void cancel() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
            subscription = null;
        }
        subscription.cancel();
    }

    public final void makeRequest() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
            subscription = null;
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
        if (ChannelResult.m2311isSuccessimpl(this.channel.mo2296trySendJP2dKIU(t))) {
            return;
        }
        throw new IllegalArgumentException(("Element " + t + " was not added to channel because it was full, " + this.channel).toString());
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        makeRequest();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object takeNextOrNull(Continuation<? super T> continuation) {
        ReactiveSubscriber$takeNextOrNull$1 reactiveSubscriber$takeNextOrNull$1;
        int i;
        Object mo2294receiveCatchingJP2dKIU;
        Throwable m2305exceptionOrNullimpl;
        if (continuation instanceof ReactiveSubscriber$takeNextOrNull$1) {
            reactiveSubscriber$takeNextOrNull$1 = (ReactiveSubscriber$takeNextOrNull$1) continuation;
            int i2 = reactiveSubscriber$takeNextOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                reactiveSubscriber$takeNextOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = reactiveSubscriber$takeNextOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = reactiveSubscriber$takeNextOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        mo2294receiveCatchingJP2dKIU = ((ChannelResult) obj).m2313unboximpl();
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Channel<T> channel = this.channel;
                    reactiveSubscriber$takeNextOrNull$1.label = 1;
                    mo2294receiveCatchingJP2dKIU = channel.mo2294receiveCatchingJP2dKIU(reactiveSubscriber$takeNextOrNull$1);
                    if (mo2294receiveCatchingJP2dKIU == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                m2305exceptionOrNullimpl = ChannelResult.m2305exceptionOrNullimpl(mo2294receiveCatchingJP2dKIU);
                if (m2305exceptionOrNullimpl != null) {
                    if (mo2294receiveCatchingJP2dKIU instanceof ChannelResult.Failed) {
                        ChannelResult.m2305exceptionOrNullimpl(mo2294receiveCatchingJP2dKIU);
                        return null;
                    }
                    return mo2294receiveCatchingJP2dKIU;
                }
                throw m2305exceptionOrNullimpl;
            }
        }
        reactiveSubscriber$takeNextOrNull$1 = new ReactiveSubscriber$takeNextOrNull$1(this, continuation);
        Object obj2 = reactiveSubscriber$takeNextOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = reactiveSubscriber$takeNextOrNull$1.label;
        if (i == 0) {
        }
        m2305exceptionOrNullimpl = ChannelResult.m2305exceptionOrNullimpl(mo2294receiveCatchingJP2dKIU);
        if (m2305exceptionOrNullimpl != null) {
        }
    }
}
