package kotlinx.coroutines.test;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.test.TestCoroutineContext;
@Deprecated(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001NB\u0013\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bL\u0010MJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0014\u0010\u0013J1\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0016\u0010\u0013J+\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0017\u0010\u0013J\r\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00028\u00002\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00028\u00000!H\u0016¢\u0006\u0004\b$\u0010%J*\u0010)\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010&*\u00020\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\u00012\n\u0010(\u001a\u0006\u0012\u0002\b\u00030'H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u00020/2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0002H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\t¢\u0006\u0004\b6\u0010\u0019J\u0017\u00106\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010;\u001a\u00060:R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0019\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020/0E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00109R\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "", "delayTime", "Ljava/util/concurrent/TimeUnit;", "unit", "advanceTimeBy", "(JLjava/util/concurrent/TimeUnit;)J", "targetTime", "", "advanceTimeTo", "(JLjava/util/concurrent/TimeUnit;)V", "", "message", "Lkotlin/Function1;", "", "", "predicate", "assertAllUnhandledExceptions", "(Ljava/lang/String;Lkotlin/Function1;)V", "assertAnyUnhandledException", "", "assertExceptions", "assertUnhandledException", "cancelAllActions", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "enqueue", "(Ljava/lang/Runnable;)V", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", AppDownloadNetworkStateReceiver.KEY_OPERATION, StatKey.EDITADDR_PASTE_ADDRESS_STAGE_FOLD, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "now", "(Ljava/util/concurrent/TimeUnit;)J", "Lkotlinx/coroutines/test/TimedRunnableObsolete;", "postDelayed", "(Ljava/lang/Runnable;J)Lkotlinx/coroutines/test/TimedRunnableObsolete;", "processNextEvent", "()J", "toString", "()Ljava/lang/String;", "triggerActions", "(J)V", "counter", "J", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxDispatcher", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptions", "()Ljava/util/List;", "exceptions", "name", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "queue", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "time", "", "uncaughtExceptions", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", com.baidu.android.imsdk.internal.Dispatcher.TAG, "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class TestCoroutineContext implements CoroutineContext {
    public long counter;
    public final Dispatcher ctxDispatcher;
    public final CoroutineExceptionHandler ctxHandler;
    public final String name;
    public final ThreadSafeHeap<TimedRunnableObsolete> queue;
    public long time;
    public final List<Throwable> uncaughtExceptions;

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/EventLoop;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", StatConstants.VALUE_TYPE_DISPATCH, "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "shouldBeProcessedFromContext", "()Z", "", "toString", "()Ljava/lang/String;", "<init>", "(Lkotlinx/coroutines/test/TestCoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public final class Dispatcher extends EventLoop implements Delay {
        @Override // kotlinx.coroutines.EventLoop
        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Dispatcher() {
            EventLoop.incrementUseCount$default(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        public Object delay(long j, Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, j, continuation);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        /* renamed from: dispatch */
        public void mo2237dispatch(CoroutineContext coroutineContext, Runnable runnable) {
            TestCoroutineContext.this.enqueue(runnable);
        }

        @Override // kotlinx.coroutines.Delay
        public DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
            final TimedRunnableObsolete postDelayed = TestCoroutineContext.this.postDelayed(runnable, j);
            return new DisposableHandle() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$invokeOnTimeout$1
                @Override // kotlinx.coroutines.DisposableHandle
                public void dispose() {
                    ThreadSafeHeap threadSafeHeap;
                    threadSafeHeap = TestCoroutineContext.this.queue;
                    threadSafeHeap.remove(postDelayed);
                }
            };
        }

        @Override // kotlinx.coroutines.Delay
        /* renamed from: scheduleResumeAfterDelay */
        public void mo2238scheduleResumeAfterDelay(long j, final CancellableContinuation<? super Unit> cancellableContinuation) {
            TestCoroutineContext.this.postDelayed(new Runnable() { // from class: kotlinx.coroutines.test.TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    cancellableContinuation.resumeUndispatched(TestCoroutineContext.Dispatcher.this, Unit.INSTANCE);
                }
            }, j);
        }

        @Override // kotlinx.coroutines.EventLoop
        public long processNextEvent() {
            return TestCoroutineContext.this.processNextEvent();
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }

    public TestCoroutineContext(String str) {
        this.name = str;
        this.uncaughtExceptions = new ArrayList();
        this.ctxDispatcher = new Dispatcher();
        this.ctxHandler = new TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        this.queue = new ThreadSafeHeap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueue(Runnable runnable) {
        ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.queue;
        long j = this.counter;
        this.counter = 1 + j;
        threadSafeHeap.addLast(new TimedRunnableObsolete(runnable, j, 0L, 4, null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (key == ContinuationInterceptor.Key) {
            Dispatcher dispatcher = this.ctxDispatcher;
            if (dispatcher == null) {
                throw new TypeCastException("null cannot be cast to non-null type E");
            }
            return dispatcher;
        } else if (key == CoroutineExceptionHandler.Key) {
            CoroutineExceptionHandler coroutineExceptionHandler = this.ctxHandler;
            if (coroutineExceptionHandler == null) {
                throw new TypeCastException("null cannot be cast to non-null type E");
            }
            return coroutineExceptionHandler;
        } else {
            return null;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        if (key == ContinuationInterceptor.Key) {
            return this.ctxHandler;
        }
        if (key == CoroutineExceptionHandler.Key) {
            return this.ctxDispatcher;
        }
        return this;
    }

    public final long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimedRunnableObsolete postDelayed(Runnable runnable, long j) {
        long j2 = this.counter;
        this.counter = 1 + j2;
        TimedRunnableObsolete timedRunnableObsolete = new TimedRunnableObsolete(runnable, j2, this.time + TimeUnit.MILLISECONDS.toNanos(j));
        this.queue.addLast(timedRunnableObsolete);
        return timedRunnableObsolete;
    }

    public final long advanceTimeBy(long j, TimeUnit timeUnit) {
        long j2 = this.time;
        advanceTimeTo(timeUnit.toNanos(j) + j2, TimeUnit.NANOSECONDS);
        return timeUnit.convert(this.time - j2, TimeUnit.NANOSECONDS);
    }

    public final void advanceTimeTo(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        triggerActions(nanos);
        if (nanos > this.time) {
            this.time = nanos;
        }
    }

    public final void assertExceptions(String str, Function1<? super List<? extends Throwable>, Boolean> function1) {
        if (function1.invoke(this.uncaughtExceptions).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void assertUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        if (this.uncaughtExceptions.size() == 1 && function1.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: R, ? super R */
    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return function2.invoke((R) function2.invoke(r, this.ctxDispatcher), this.ctxHandler);
    }

    public static /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public static /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public static /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public static /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public static /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long processNextEvent() {
        TimedRunnableObsolete peek = this.queue.peek();
        if (peek != null) {
            triggerActions(peek.time);
        }
        if (this.queue.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void cancelAllActions() {
        if (!this.queue.isEmpty()) {
            this.queue.clear();
        }
    }

    public final List<Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    public String toString() {
        String str = this.name;
        if (str == null) {
            return "TestCoroutineContext@" + DebugStringsKt.getHexAddress(this);
        }
        return str;
    }

    public final void triggerActions() {
        triggerActions(this.time);
    }

    private final void triggerActions(long j) {
        TimedRunnableObsolete timedRunnableObsolete;
        boolean z;
        while (true) {
            ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.queue;
            synchronized (threadSafeHeap) {
                TimedRunnableObsolete firstImpl = threadSafeHeap.firstImpl();
                timedRunnableObsolete = null;
                if (firstImpl != null) {
                    if (firstImpl.time <= j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        timedRunnableObsolete = threadSafeHeap.removeAtImpl(0);
                    }
                }
            }
            TimedRunnableObsolete timedRunnableObsolete2 = timedRunnableObsolete;
            if (timedRunnableObsolete2 != null) {
                long j2 = timedRunnableObsolete2.time;
                if (j2 != 0) {
                    this.time = j2;
                }
                timedRunnableObsolete2.run();
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: ? super java.lang.Throwable */
    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAllUnhandledExceptions(String str, Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!function1.invoke(it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: ? super java.lang.Throwable */
    /* JADX WARN: Multi-variable type inference failed */
    public final void assertAnyUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (function1.invoke(it.next()).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }
}
