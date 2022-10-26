package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004CBDEB\u0011\b\u0016\u0012\u0006\u0010=\u001a\u00028\u0000¢\u0006\u0004\b@\u0010AB\u0007¢\u0006\u0004\b@\u0010<J?\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\f\u001a\u00020\u00102\u000e\u0010\n\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0016¢\u0006\u0004\b\f\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\rJ\u001d\u0010\u0013\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\u00020\u00102\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00100\u0015j\u0002`\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\b#\u0010$JX\u0010-\u001a\u00020\u0010\"\u0004\b\u0001\u0010%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&2\u0006\u0010\u001c\u001a\u00028\u00002(\u0010,\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010*\u0012\u0006\u0012\u0004\u0018\u00010+0(H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.J?\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b/\u0010\bJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00103R(\u00108\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0019\u0010=\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u0015\u0010?\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010:\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value$annotations", "()V", "value", "getValueOrNull", "valueOrNull", "<init>", "(Ljava/lang/Object;)V", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ConflatedBroadcastChannel implements BroadcastChannel {
    public static final State INITIAL_STATE;
    public static final Symbol UNDEFINED;
    public static final AtomicReferenceFieldUpdater _state$FU;
    public static final AtomicIntegerFieldUpdater _updating$FU;
    public static final AtomicReferenceFieldUpdater onCloseHandler$FU;
    public volatile Object _state;
    public volatile int _updating;
    public volatile Object onCloseHandler;
    public static final Companion Companion = new Companion(null);
    public static final Closed CLOSED = new Closed(null);

    public static /* synthetic */ void value$annotations() {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u0000B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0006\u001a\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\b\u001a\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "Ljava/lang/Throwable;", "getSendException", "()Ljava/lang/Throwable;", "sendException", "getValueException", "valueException", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable th) {
            this.closeCause = th;
        }

        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            if (th == null) {
                return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
            }
            return th;
        }

        public final Throwable getValueException() {
            Throwable th = this.closeCause;
            if (th == null) {
                return new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
            }
            return th;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u00018\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u0005¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "CLOSED$annotations", "()V", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class Companion {
        public static /* synthetic */ void CLOSED$annotations() {
        }

        public static /* synthetic */ void UNDEFINED$annotations() {
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001B'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscribers", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "value", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class State {
        public final Subscriber[] subscribers;
        public final Object value;

        public State(Object obj, Subscriber[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ConflatedChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "wasClosed", "", "onCancelIdempotent", "(Z)V", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "<init>", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class Subscriber extends ConflatedChannel implements ReceiveChannel {
        public final ConflatedBroadcastChannel broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel conflatedBroadcastChannel) {
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        public Object offerInternal(Object obj) {
            return super.offerInternal(obj);
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public void onCancelIdempotent(boolean z) {
            if (!z) {
                return;
            }
            this.broadcastChannel.closeSubscriber(this);
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        UNDEFINED = symbol;
        INITIAL_STATE = new State(symbol, null);
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    public final Object getValue() {
        Object obj = this._state;
        if (!(obj instanceof Closed)) {
            if (obj instanceof State) {
                Object obj2 = ((State) obj).value;
                if (obj2 != UNDEFINED) {
                    return obj2;
                }
                throw new IllegalStateException("No value");
            }
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        throw ((Closed) obj).getValueException();
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        return new SelectClause2() { // from class: kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1
            @Override // kotlinx.coroutines.selects.SelectClause2
            public void registerSelectClause2(SelectInstance selectInstance, Object obj, Function2 function2) {
                ConflatedBroadcastChannel.this.registerSelectSend(selectInstance, obj, function2);
            }
        };
    }

    public final Object getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            Symbol symbol = UNDEFINED;
            Object obj2 = ((State) obj).value;
            if (obj2 == symbol) {
                return null;
            }
            return obj2;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    public ConflatedBroadcastChannel(Object obj) {
        this();
        _state$FU.lazySet(this, new State(obj, null));
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Object obj;
        Object obj2 = this.onCloseHandler;
        if (obj2 != null && obj2 != (obj = AbstractChannelKt.HANDLER_INVOKED) && onCloseHandler$FU.compareAndSet(this, obj2, obj)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 1)).invoke(th);
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(Object obj) {
        Closed offerInternal = offerInternal(obj);
        if (offerInternal == null) {
            return true;
        }
        throw offerInternal.getSendException();
    }

    private final Subscriber[] addSubscriber(Subscriber[] subscriberArr, Subscriber subscriber) {
        if (subscriberArr == null) {
            Subscriber[] subscriberArr2 = new Subscriber[1];
            for (int i = 0; i < 1; i++) {
                subscriberArr2[i] = subscriber;
            }
            return subscriberArr2;
        }
        return (Subscriber[]) ArraysKt___ArraysJvmKt.plus(subscriberArr, subscriber);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) {
        Closed offerInternal = offerInternal(obj);
        if (offerInternal == null) {
            if (offerInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return offerInternal;
            }
            return Unit.INSTANCE;
        }
        throw offerInternal.getSendException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeSubscriber(Subscriber subscriber) {
        Object obj;
        Object obj2;
        Subscriber[] subscriberArr;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return;
            }
            if (obj instanceof State) {
                State state = (State) obj;
                obj2 = state.value;
                if (obj != null) {
                    subscriberArr = state.subscribers;
                    if (subscriberArr == null) {
                        Intrinsics.throwNpe();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: close */
    public boolean cancel(Throwable th) {
        Object obj;
        int i;
        Closed closed;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (obj instanceof State) {
                if (th == null) {
                    closed = CLOSED;
                } else {
                    closed = new Closed(th);
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, closed));
        if (obj != null) {
            Subscriber[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr != null) {
                for (Subscriber subscriber : subscriberArr) {
                    subscriber.close(th);
                }
            }
            invokeOnCloseHandler(th);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    }

    private final Closed offerInternal(Object obj) {
        Object obj2;
        if (!_updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj2 = this._state;
                if (obj2 instanceof Closed) {
                    return (Closed) obj2;
                }
                if (obj2 instanceof State) {
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } else {
                    throw new IllegalStateException(("Invalid state " + obj2).toString());
                }
            } finally {
                this._updating = 0;
            }
        } while (!_state$FU.compareAndSet(this, obj2, new State(obj, ((State) obj2).subscribers)));
        Subscriber[] subscriberArr = ((State) obj2).subscribers;
        if (subscriberArr != null) {
            for (Subscriber subscriber : subscriberArr) {
                subscriber.offerInternal(obj);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectSend(SelectInstance selectInstance, Object obj, Function2 function2) {
        if (!selectInstance.trySelect()) {
            return;
        }
        Closed offerInternal = offerInternal(obj);
        if (offerInternal != null) {
            selectInstance.resumeSelectWithException(offerInternal.getSendException());
        } else {
            UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
        }
    }

    private final Subscriber[] removeSubscriber(Subscriber[] subscriberArr, Subscriber subscriber) {
        boolean z;
        int length = subscriberArr.length;
        int indexOf = ArraysKt___ArraysKt.indexOf(subscriberArr, subscriber);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (indexOf >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        Subscriber[] subscriberArr2 = new Subscriber[length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(subscriberArr, subscriberArr2, 0, 0, indexOf, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto$default(subscriberArr, subscriberArr2, indexOf, indexOf + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 function1) {
        if (!onCloseHandler$FU.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && onCloseHandler$FU.compareAndSet(this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(((Closed) obj2).closeCause);
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel openSubscription() {
        Object obj;
        State state;
        Object obj2;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                Object obj3 = state.value;
                if (obj3 != UNDEFINED) {
                    subscriber.offerInternal(obj3);
                }
                obj2 = state.value;
                if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }
}
