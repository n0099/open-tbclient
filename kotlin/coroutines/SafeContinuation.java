package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u0003:\u0001 B\u0017\b\u0011\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001c\u0010\u001dB!\b\u0000\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001fJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "getOrThrow", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "delegate", "Lkotlin/coroutines/Continuation;", "Ljava/lang/Object;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@PublishedApi
/* loaded from: classes7.dex */
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    @Deprecated
    public static final Companion Companion = new Companion(null);
    public static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    public final Continuation<T> delegate;
    public volatile Object result;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR`\u0010\u0005\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0003*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00010\u00018\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "RESULT$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> continuation, Object obj) {
        this.delegate = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @PublishedApi
    public final Object getOrThrow() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (RESULT.compareAndSet(this, coroutineSingletons, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (RESULT.compareAndSet(this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (RESULT.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) {
                    this.delegate.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    @PublishedApi
    public SafeContinuation(Continuation<? super T> continuation) {
        this(continuation, CoroutineSingletons.UNDECIDED);
    }
}
