package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ^\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00022'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "Ljava/lang/Enum;", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "completion", "", "invoke", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$0[CoroutineStart.LAZY.ordinal()] = 4;
            int[] iArr2 = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$1[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$1[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$1[CoroutineStart.LAZY.ordinal()] = 4;
        }
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    @InternalCoroutinesApi
    public final <T> void invoke(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            CancellableKt.startCoroutineCancellable(function1, continuation);
        } else if (i2 == 2) {
            ContinuationKt.startCoroutine(function1, continuation);
        } else if (i2 == 3) {
            UndispatchedKt.startCoroutineUndispatched(function1, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i2 == 1) {
            CancellableKt.startCoroutineCancellable(function2, r, continuation);
        } else if (i2 == 2) {
            ContinuationKt.startCoroutine(function2, r, continuation);
        } else if (i2 == 3) {
            UndispatchedKt.startCoroutineUndispatched(function2, r, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
