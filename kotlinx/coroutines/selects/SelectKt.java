package kotlinx.coroutines.selects;

import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aK\u0010\u000f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\"\"\u0010\u0010\u001a\u00020\u000b8\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\"\u001c\u0010\u0016\u001a\u00020\u000b8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u0012\u0004\b\u0017\u0010\u0015\"\u001c\u0010\u0018\u001a\u00020\u000b8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u0012\u0004\b\u0019\u0010\u0015\"\u001c\u0010\u001b\u001a\u00020\u001a8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "onTimeout-0lHKgQg", "(Lkotlinx/coroutines/selects/SelectBuilder;DLkotlin/jvm/functions/Function1;)V", "onTimeout", "ALREADY_SELECTED", "Ljava/lang/Object;", "getALREADY_SELECTED", "()Ljava/lang/Object;", "ALREADY_SELECTED$annotations", "()V", "RESUMED", "RESUMED$annotations", "UNDECIDED", "UNDECIDED$annotations", "Lkotlinx/coroutines/selects/SeqNumber;", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "selectOpSequenceNumber$annotations", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SelectKt {
    public static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
    public static final Object UNDECIDED = new Symbol("UNDECIDED");
    public static final Object RESUMED = new Symbol("RESUMED");
    public static final SeqNumber selectOpSequenceNumber = new SeqNumber();

    public static /* synthetic */ void ALREADY_SELECTED$annotations() {
    }

    public static /* synthetic */ void RESUMED$annotations() {
    }

    public static /* synthetic */ void UNDECIDED$annotations() {
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.selects.SelectBuilderImpl.doResume(kotlin.jvm.functions.Function0<? extends java.lang.Object>, kotlin.jvm.functions.Function0<kotlin.Unit>):void, kotlinx.coroutines.selects.SelectBuilderImpl.getResult():java.lang.Object, kotlinx.coroutines.selects.SelectBuilderImpl.resumeSelectWithException(java.lang.Throwable):void, kotlinx.coroutines.selects.SelectBuilderImpl.resumeWith(java.lang.Object):void] */
    public static final /* synthetic */ Object access$getRESUMED$p() {
        return RESUMED;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp.<init>(kotlinx.coroutines.selects.SelectBuilderImpl<?>, kotlinx.coroutines.internal.AtomicDesc):void] */
    public static final /* synthetic */ SeqNumber access$getSelectOpSequenceNumber$p() {
        return selectOpSequenceNumber;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.selects.SelectBuilderImpl.<init>(kotlin.coroutines.Continuation<? super R>):void, kotlinx.coroutines.selects.SelectBuilderImpl.doResume(kotlin.jvm.functions.Function0<? extends java.lang.Object>, kotlin.jvm.functions.Function0<kotlin.Unit>):void, kotlinx.coroutines.selects.SelectBuilderImpl.getResult():java.lang.Object, kotlinx.coroutines.selects.SelectBuilderImpl.resumeSelectWithException(java.lang.Throwable):void, kotlinx.coroutines.selects.SelectBuilderImpl.resumeWith(java.lang.Object):void] */
    public static final /* synthetic */ Object access$getUNDECIDED$p() {
        return UNDECIDED;
    }

    public static final Object getALREADY_SELECTED() {
        return ALREADY_SELECTED;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalTime
    @ExperimentalCoroutinesApi
    /* renamed from: onTimeout-0lHKgQg  reason: not valid java name */
    public static final <R> void m1987onTimeout0lHKgQg(SelectBuilder<? super R> selectBuilder, double d2, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.onTimeout(DelayKt.m1950toDelayMillisLRDsOJo(d2), function1);
    }

    public static final <R> Object select(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final Object select$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static /* synthetic */ void selectOpSequenceNumber$annotations() {
    }
}
