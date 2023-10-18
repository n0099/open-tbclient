package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\b0H2\b\u0012\u0004\u0012\u00028\u00000I2\u00020J2\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%0BB7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001f\u0010 JX\u0010)\u001a\u00020\b\"\u0004\b\u0001\u0010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010$\u001a\u00028\u00002(\u0010(\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0012\u0004\u0018\u00010'0\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\b2\u0006\u0010$\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b/\u00100J!\u00101\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u0010\u0017J&\u00105\u001a\b\u0012\u0004\u0012\u00020\b022\u0006\u0010$\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\rR\u0016\u00107\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010<R\u0014\u0010=\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010E\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%0B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lkotlin/Function2;", "", "", "exceptionOnCancelHandler", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "cancel", "()V", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "elem", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "onCancelled", "value", "onCompleted", "(Lkotlin/Unit;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "element", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "n", "request", "(J)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "unlockAndCheckCompleted", "cancelled", "Z", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "Lkotlin/jvm/functions/Function2;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lorg/reactivestreams/Subscriber;", "kotlinx-coroutines-reactive", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription, SelectClause2<T, SendChannel<? super T>> {
    public static final /* synthetic */ AtomicLongFieldUpdater _nRequested$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    public volatile /* synthetic */ long _nRequested;
    public volatile boolean cancelled;
    public final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    public final Mutex mutex;
    public final Subscriber<T> subscriber;

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.CoroutineContext, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext coroutineContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
        this._nRequested = 0L;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, T t, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2) {
        BuildersKt__Builders_commonKt.launch$default(this, null, CoroutineStart.UNDISPATCHED, new PublisherCoroutine$registerSelectClause2$1(this, selectInstance, new PublisherCoroutine$registerSelectClause2$clause$1(this, t, function2, null), null), 1, null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(Throwable th, boolean z) {
        signalCompleted(th, z);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return cancelCoroutine(th);
    }

    /* JADX DEBUG: Possible override for method kotlinx.coroutines.channels.SendChannel.invokeOnClose(Lkotlin/jvm/functions/Function1;)V */
    public Void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo2300trySendJP2dKIU(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.Companion.m2319failurePtdJZtk();
        }
        Throwable doLockedNext = doLockedNext(t);
        if (doLockedNext == null) {
            return ChannelResult.Companion.m2320successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.Companion.m2318closedJP2dKIU(doLockedNext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable doLockedNext(T t) {
        if (t != null) {
            if (!isActive()) {
                unlockAndCheckCompleted();
                return getCancellationException();
            }
            try {
                this.subscriber.onNext(t);
                while (true) {
                    long j = this._nRequested;
                    if (j < 0 || j == Long.MAX_VALUE) {
                        break;
                    }
                    long j2 = j - 1;
                    if (_nRequested$FU.compareAndSet(this, j, j2)) {
                        if (j2 == 0) {
                            return null;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean close = close(th);
                unlockAndCheckCompleted();
                if (!close) {
                    this.exceptionOnCancelHandler.invoke(th, getContext());
                    return getCancellationException();
                }
                return th;
            }
        }
        unlockAndCheckCompleted();
        throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
    }

    private final void doLockedSignalCompleted(Throwable th, boolean z) {
        try {
            if (this._nRequested != -2) {
                this._nRequested = -2L;
                if (this.cancelled) {
                    if (th != null && !z) {
                        this.exceptionOnCancelHandler.invoke(th, getContext());
                    }
                } else {
                    if (th == null) {
                        this.subscriber.onComplete();
                    } else {
                        this.subscriber.onError(th);
                    }
                }
            }
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(T t, Continuation<? super Unit> continuation) {
        PublisherCoroutine$send$1 publisherCoroutine$send$1;
        int i;
        PublisherCoroutine<T> publisherCoroutine;
        Throwable doLockedNext;
        if (continuation instanceof PublisherCoroutine$send$1) {
            publisherCoroutine$send$1 = (PublisherCoroutine$send$1) continuation;
            int i2 = publisherCoroutine$send$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                publisherCoroutine$send$1.label = i2 - Integer.MIN_VALUE;
                Object obj = publisherCoroutine$send$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = publisherCoroutine$send$1.label;
                if (i == 0) {
                    if (i == 1) {
                        t = (T) publisherCoroutine$send$1.L$1;
                        publisherCoroutine = (PublisherCoroutine) publisherCoroutine$send$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    publisherCoroutine$send$1.L$0 = this;
                    publisherCoroutine$send$1.L$1 = t;
                    publisherCoroutine$send$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, publisherCoroutine$send$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    publisherCoroutine = this;
                }
                doLockedNext = publisherCoroutine.doLockedNext(t);
                if (doLockedNext != null) {
                    return Unit.INSTANCE;
                }
                throw doLockedNext;
            }
        }
        publisherCoroutine$send$1 = new PublisherCoroutine$send$1(this, continuation);
        Object obj2 = publisherCoroutine$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = publisherCoroutine$send$1.label;
        if (i == 0) {
        }
        doLockedNext = publisherCoroutine.doLockedNext(t);
        if (doLockedNext != null) {
        }
    }

    private final void signalCompleted(Throwable th, boolean z) {
        long j;
        int i;
        boolean z2;
        do {
            j = this._nRequested;
            if (j == -2) {
                return;
            }
            i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!_nRequested$FU.compareAndSet(this, j, -1L));
        if (i == 0) {
            doLockedSignalCompleted(th, z);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(th, z);
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo2359invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit unit) {
        signalCompleted(null, false);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        long j2;
        int i;
        long j3;
        if (j <= 0) {
            cancelCoroutine(new IllegalArgumentException(Intrinsics.stringPlus("non-positive subscription request ", Long.valueOf(j))));
            return;
        }
        do {
            j2 = this._nRequested;
            i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i < 0) {
                return;
            }
            long j4 = j2 + j;
            j3 = Long.MAX_VALUE;
            if (j4 >= 0 && j != Long.MAX_VALUE) {
                j3 = j4;
            }
            if (j2 == j3) {
                return;
            }
        } while (!_nRequested$FU.compareAndSet(this, j2, j3));
        if (i == 0) {
            unlockAndCheckCompleted();
        }
    }
}
