package kotlinx.coroutines.intrinsics;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DispatchedContinuationKt;
import kotlinx.coroutines.InternalCoroutinesApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00032\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\b\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a@\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\r\u001aT\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\n*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "runSafely", "(Lkotlin/coroutines/Continuation;Lkotlin/Function0;)V", "fatalCompletion", "startCoroutineCancellable", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class CancellableKt {
    public static final void runSafely(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m635constructorimpl(ResultKt.createFailure(th)));
        }
    }

    @InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m635constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m635constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        try {
            Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m635constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m635constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m635constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m635constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
