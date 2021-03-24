package kotlin.coroutines.experimental.jvm.internal;

import androidx.core.app.NotificationCompatJellybean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\tJ%\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00018\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/jvm/internal/Lambda;", "", "value", "completion", "", "create", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "(Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "data", "", "exception", "doResume", "(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;", "resume", "(Ljava/lang/Object;)V", "resumeWithException", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/experimental/CoroutineContext;", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "Lkotlin/coroutines/experimental/Continuation;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "context", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "facade", "", NotificationCompatJellybean.KEY_LABEL, "I", "arity", "<init>", "(ILkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class CoroutineImpl extends Lambda<Object> implements Continuation<Object> {
    public final CoroutineContext _context;
    public Continuation<Object> _facade;
    @JvmField
    public Continuation<Object> completion;
    @JvmField
    public int label;

    public CoroutineImpl(int i, Continuation<Object> continuation) {
        super(i);
        this.completion = continuation;
        this.label = continuation != null ? 0 : -1;
        Continuation<Object> continuation2 = this.completion;
        this._context = continuation2 != null ? continuation2.getContext() : null;
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    public abstract Object doResume(Object obj, Throwable th);

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        if (coroutineContext == null) {
            Intrinsics.throwNpe();
        }
        return coroutineContext;
    }

    public final Continuation<Object> getFacade() {
        if (this._facade == null) {
            CoroutineContext coroutineContext = this._context;
            if (coroutineContext == null) {
                Intrinsics.throwNpe();
            }
            this._facade = CoroutineIntrinsics.interceptContinuationIfNeeded(coroutineContext, this);
        }
        Continuation<Object> continuation = this._facade;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        return continuation;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(Object obj) {
        Continuation<Object> continuation = this.completion;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        try {
            Object doResume = doResume(obj, null);
            if (doResume != IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(doResume);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        Continuation<Object> continuation = this.completion;
        if (continuation == null) {
            Intrinsics.throwNpe();
        }
        try {
            Object doResume = doResume(null, th);
            if (doResume != IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(doResume);
            }
        } catch (Throwable th2) {
            continuation.resumeWithException(th2);
        }
    }

    public Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
