package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0012\u001a\u00020\u000f*\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0016\u001a\u00020\f*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0018\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/Choreographer;", "choreographer", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "postFrameCallback", "(Landroid/view/Choreographer;Lkotlinx/coroutines/CancellableContinuation;)V", "updateChoreographerAndPostFrameCallback", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/HandlerDispatcher;", "from", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/HandlerDispatcher;", "asCoroutineDispatcher", "Landroid/os/Looper;", "", "async", "asHandler", "(Landroid/os/Looper;Z)Landroid/os/Handler;", "MAX_DELAY", "J", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class HandlerDispatcherKt {
    public static final long MAX_DELAY = 4611686018427387903L;
    @JvmField
    public static final HandlerDispatcher Main;
    public static volatile Choreographer choreographer;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void Main$annotations() {
    }

    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher from(Handler handler) {
        return from$default(handler, null, 1, null);
    }

    static {
        Object m698constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m698constructorimpl = Result.m698constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), "Main"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m698constructorimpl = Result.m698constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m704isFailureimpl(m698constructorimpl)) {
            m698constructorimpl = null;
        }
        Main = (HandlerDispatcher) m698constructorimpl;
    }

    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher from(Handler handler, String str) {
        return new HandlerContext(handler, str);
    }

    public static final void postFrameCallback(Choreographer choreographer2, final CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.HandlerDispatcherKt$postFrameCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                CancellableContinuation.this.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(j));
            }
        });
    }

    public static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            if (choreographer2 == null) {
                Intrinsics.throwNpe();
            }
            choreographer = choreographer2;
        }
        postFrameCallback(choreographer2, cancellableContinuation);
    }

    @VisibleForTesting
    public static final Handler asHandler(Looper looper, boolean z) {
        int i;
        if (z && (i = Build.VERSION.SDK_INT) >= 16) {
            if (i >= 28) {
                Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                if (invoke != null) {
                    return (Handler) invoke;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
            }
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    public static final Object awaitFrame(Continuation<? super Long> continuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            postFrameCallback(choreographer2, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        final CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        Dispatchers.getMain().dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: kotlinx.coroutines.android.HandlerDispatcherKt$$special$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(CancellableContinuation.this);
            }
        });
        Object result2 = cancellableContinuationImpl2.getResult();
        if (result2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler handler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return from(handler, str);
    }
}
