package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\u0012\u0006\u0010H\u001a\u000209\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E\u0012\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00060#¢\u0006\u0004\bI\u0010JJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJX\u0010(\u001a\u00020\u0006\"\u0004\b\u0001\u0010 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0019\u001a\u00028\u00002(\u0010'\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%\u0012\u0006\u0012\u0004\u0018\u00010&0#H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b0\u0010/J!\u00101\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u0010\u0013J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\bJ\u0013\u00103\u001a\u00020\u000b*\u00020\tH\u0002¢\u0006\u0004\b3\u0010\rR\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000$8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R(\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00060#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u00105\u001a\u0004\b>\u0010=R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR(\u0010D\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E8\b@\bX\u0088\u0004¢\u0006\u0006\n\u0004\bF\u0010G\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "cancel", "()V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "elem", "doLockedNext", "(Ljava/lang/Object;)V", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "element", "offer", "(Ljava/lang/Object;)Z", "onCancelled", "value", "onCompleted", "(Lkotlin/Unit;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "n", "request", "(J)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSuspend", "signalCompleted", "unlockAndCheckCompleted", "isFatal", "cancelled", "Z", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "Lkotlin/coroutines/CoroutineContext;", "exceptionOnCancelHandler", "Lkotlin/jvm/functions/Function2;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lorg/reactivestreams/Subscriber;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription, SelectClause2<T, SendChannel<? super T>> {
    public static final AtomicLongFieldUpdater _nRequested$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    public volatile long _nRequested;
    public volatile boolean cancelled;
    public final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    public final boolean isFull;
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.CoroutineContext, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext coroutineContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
        this._nRequested = 0L;
        this.isFull = this.mutex.isLocked();
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, T t, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2) {
        this.mutex.getOnLock().registerSelectClause2(selectInstance, null, new PublisherCoroutine$registerSelectClause2$1(this, t, function2, null));
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(Throwable th, boolean z) {
        signalCompleted(th, z);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation<? super Unit> continuation) {
        if (offer(t)) {
            return Unit.INSTANCE;
        }
        Object sendSuspend = sendSuspend(t, continuation);
        if (sendSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return sendSuspend;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doLockedNext(T t) {
        if (isActive()) {
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
                            return;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return;
            } catch (Throwable th) {
                cancelCoroutine(th);
                unlockAndCheckCompleted();
                throw th;
            }
        }
        unlockAndCheckCompleted();
        throw getCancellationException();
    }

    private final void doLockedSignalCompleted(Throwable th, boolean z) {
        try {
            if (this._nRequested >= -1) {
                this._nRequested = -2L;
                if (this.cancelled) {
                    if (th != null && !z) {
                        this.exceptionOnCancelHandler.invoke(th, getContext());
                    }
                } else if (th != null && !(th instanceof CancellationException)) {
                    this.subscriber.onError(th);
                    if (!z && isFatal(th)) {
                        this.exceptionOnCancelHandler.invoke(th, getContext());
                    }
                } else {
                    this.subscriber.onComplete();
                }
            }
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object sendSuspend(T t, Continuation<? super Unit> continuation) {
        PublisherCoroutine$sendSuspend$1 publisherCoroutine$sendSuspend$1;
        int i;
        PublisherCoroutine<T> publisherCoroutine;
        if (continuation instanceof PublisherCoroutine$sendSuspend$1) {
            publisherCoroutine$sendSuspend$1 = (PublisherCoroutine$sendSuspend$1) continuation;
            int i2 = publisherCoroutine$sendSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                publisherCoroutine$sendSuspend$1.label = i2 - Integer.MIN_VALUE;
                Object obj = publisherCoroutine$sendSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = publisherCoroutine$sendSuspend$1.label;
                if (i == 0) {
                    if (i == 1) {
                        t = (T) publisherCoroutine$sendSuspend$1.L$1;
                        publisherCoroutine = (PublisherCoroutine) publisherCoroutine$sendSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    publisherCoroutine$sendSuspend$1.L$0 = this;
                    publisherCoroutine$sendSuspend$1.L$1 = t;
                    publisherCoroutine$sendSuspend$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, publisherCoroutine$sendSuspend$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    publisherCoroutine = this;
                }
                publisherCoroutine.doLockedNext(t);
                return Unit.INSTANCE;
            }
        }
        publisherCoroutine$sendSuspend$1 = new PublisherCoroutine$sendSuspend$1(this, continuation);
        Object obj2 = publisherCoroutine$sendSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = publisherCoroutine$sendSuspend$1.label;
        if (i == 0) {
        }
        publisherCoroutine.doLockedNext(t);
        return Unit.INSTANCE;
    }

    private final boolean isFatal(Throwable th) {
        if (!(th instanceof VirtualMachineError) && !(th instanceof ThreadDeath) && !(th instanceof LinkageError)) {
            return false;
        }
        return true;
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
    public boolean offer(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return false;
        }
        doLockedNext(t);
        return true;
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
        return isCompleted();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this.isFull;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo2242invokeOnClose(Function1 function1) {
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
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + j));
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
