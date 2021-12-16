package kotlinx.coroutines.channels;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010@\u001a\u00020?\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010A\u001a\u00020\t¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\nJ\u001d\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\nJ5\u0010\u0015\u001a\u00020\u00042#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0097\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0097Aø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010 J\u0015\u0010#\u001a\u0004\u0018\u00018\u0000H\u0097Aø\u0001\u0000¢\u0006\u0004\b#\u0010 J\u001b\u0010$\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010%R\"\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0016\u0010-\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u0010.R\u0016\u00100\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0016\u00101\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b1\u0010.R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!028\u0016@\u0017X\u0097\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b6\u00104R\u001e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000028\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b8\u00104R(\u0010>\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0:8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006D"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/AbstractCoroutine;", "", QueryResponse.Options.CANCEL, "()V", "", "cause", "", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "(Ljava/lang/Throwable;)V", IntentConfig.CLOSE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ValueOrClosed;", "receiveOrClosed", "receiveOrNull", ReturnKeyType.SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFair", "_channel", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "getChannel", "channel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "isFull", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveOrClosed", "onReceiveOrClosed", "getOnReceiveOrNull", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", GrowthConstant.UBC_VALUE_TYPE_DEFAULT, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    public final Channel<E> _channel;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, z);
        this._channel = channel;
    }

    public static /* synthetic */ Object receive$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receive(continuation);
    }

    public static /* synthetic */ Object receiveOrClosed$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receiveOrClosed(continuation);
    }

    public static /* synthetic */ Object receiveOrNull$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.receiveOrNull(continuation);
    }

    public static /* synthetic */ Object send$suspendImpl(ChannelCoroutine channelCoroutine, Object obj, Continuation continuation) {
        return channelCoroutine._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed() {
        return this._channel.getOnReceiveOrClosed();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    public final Channel<E> get_channel() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @ExperimentalCoroutinesApi
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this._channel.isFull();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e2) {
        return this._channel.offer(e2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return this._channel.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @InternalCoroutinesApi
    public Object receiveOrClosed(Continuation<? super ValueOrClosed<? extends E>> continuation) {
        return receiveOrClosed$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    @ObsoleteCoroutinesApi
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return receiveOrNull$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e2, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e2, continuation);
    }

    public final Object sendFair(E e2, Continuation<? super Unit> continuation) {
        Channel<E> channel = this._channel;
        if (channel != null) {
            Object sendFair$kotlinx_coroutines_core = ((AbstractSendChannel) channel).sendFair$kotlinx_coroutines_core(e2, continuation);
            return sendFair$kotlinx_coroutines_core == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendFair$kotlinx_coroutines_core : Unit.INSTANCE;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.AbstractSendChannel<E>");
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable th) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
