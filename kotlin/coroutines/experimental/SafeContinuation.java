package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002:\u0002\u001a\u001bB\u0017\b\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0016\u0010\u0017B!\b\u0000\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0019J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lkotlin/coroutines/experimental/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "", "getResult", "()Ljava/lang/Object;", "value", "", "resume", "(Ljava/lang/Object;)V", "", "exception", "resumeWithException", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "context", "delegate", "Lkotlin/coroutines/experimental/Continuation;", "result", "Ljava/lang/Object;", "<init>", "(Lkotlin/coroutines/experimental/Continuation;)V", "initialResult", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", "Companion", "Fail", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@PublishedApi
/* loaded from: classes7.dex */
public final class SafeContinuation<T> implements Continuation<T> {
    public final Continuation<T> delegate;
    public volatile Object result;
    public static final Companion Companion = new Companion(null);
    public static final Object UNDECIDED = new Object();
    public static final Object RESUMED = new Object();
    public static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\bR`\u0010\u0005\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0003*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00010\u00018\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/coroutines/experimental/SafeContinuation$Companion;", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/experimental/SafeContinuation;", "kotlin.jvm.PlatformType", "", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "RESULT$annotations", "()V", "RESUMED", "Ljava/lang/Object;", "UNDECIDED", "<init>", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void RESULT$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u0000B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/coroutines/experimental/SafeContinuation$Fail;", "", "exception", "Ljava/lang/Throwable;", "getException", "()Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Fail {
        public final Throwable exception;

        public Fail(Throwable th) {
            this.exception = th;
        }

        public final Throwable getException() {
            return this.exception;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.experimental.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> continuation, Object obj) {
        this.delegate = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @PublishedApi
    public final Object getResult() {
        Object obj = this.result;
        Object obj2 = UNDECIDED;
        if (obj == obj2) {
            if (RESULT.compareAndSet(this, obj2, IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == RESUMED) {
            return IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof Fail) {
            throw ((Fail) obj).getException();
        }
        return obj;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(T t) {
        while (true) {
            Object obj = this.result;
            Object obj2 = UNDECIDED;
            if (obj == obj2) {
                if (RESULT.compareAndSet(this, obj2, t)) {
                    return;
                }
            } else if (obj != IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (RESULT.compareAndSet(this, IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED(), RESUMED)) {
                    this.delegate.resume(t);
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        while (true) {
            Object obj = this.result;
            Object obj2 = UNDECIDED;
            if (obj == obj2) {
                if (RESULT.compareAndSet(this, obj2, new Fail(th))) {
                    return;
                }
            } else if (obj != IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (RESULT.compareAndSet(this, IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED(), RESUMED)) {
                    this.delegate.resumeWithException(th);
                    return;
                }
            }
        }
    }

    @PublishedApi
    public SafeContinuation(Continuation<? super T> continuation) {
        this(continuation, UNDECIDED);
    }
}
