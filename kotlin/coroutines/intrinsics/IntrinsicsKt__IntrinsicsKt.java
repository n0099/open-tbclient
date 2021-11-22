package kotlin.coroutines.intrinsics;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001aD\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\b\u0004\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0087Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u000b\u001a\u00020\u00038F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "suspendCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "getCOROUTINE_SUSPENDED$annotations", "()V", "COROUTINE_SUSPENDED", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes3.dex */
public class IntrinsicsKt__IntrinsicsKt extends IntrinsicsKt__IntrinsicsJvmKt {
    public static final Object getCOROUTINE_SUSPENDED() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getCOROUTINE_SUSPENDED$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> Object suspendCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
