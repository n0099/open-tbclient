package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0081\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u00050\tH\u0087Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aF\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0000\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a_\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0000\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0012\u001a@\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aY\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\"\u001d\u0010\u001b\u001a\u00020\u00168Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u001c"}, d2 = {"Lkotlin/coroutines/experimental/Continuation;", "completion", "Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", "processBareContinuationResume", "(Lkotlin/coroutines/experimental/Continuation;Lkotlin/Function0;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "suspendCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "Lkotlin/coroutines/experimental/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext$annotations", "()V", "coroutineContext", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "CoroutinesKt")
/* loaded from: classes7.dex */
public final class CoroutinesKt {
    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static /* synthetic */ void coroutineContext$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        return new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function2, r, continuation), IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED());
    }

    public static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @InlineOnly
    public static final void processBareContinuationResume(Continuation<?> continuation, Function0<? extends Object> function0) {
        try {
            Object invoke = function0.invoke();
            if (invoke != IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.resume(invoke);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @SinceKotlin(version = "1.1")
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function2, r, continuation).resume(Unit.INSTANCE);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        return safeContinuation.getResult();
    }

    @SinceKotlin(version = "1.1")
    public static final Object suspendCoroutine$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        Object result = safeContinuation.getResult();
        InlineMarker.mark(1);
        return result;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function1, continuation), IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(version = "1.1")
    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function1, continuation).resume(Unit.INSTANCE);
    }
}
