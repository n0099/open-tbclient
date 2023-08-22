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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u001f\b\u0004\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0017\u001aN\u0010\u0018\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\u001b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0007ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"ALREADY_SELECTED", "", "getALREADY_SELECTED$annotations", "()V", "getALREADY_SELECTED", "()Ljava/lang/Object;", "NOT_SELECTED", "getNOT_SELECTED$annotations", "getNOT_SELECTED", "RESUMED", "getRESUMED$annotations", "UNDECIDED", "getUNDECIDED$annotations", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "getSelectOpSequenceNumber$annotations", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTimeout", "timeout", "Lkotlin/time/Duration;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/coroutines/Continuation;", "onTimeout-8Mi8wO0", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelectKt {
    public static final Object NOT_SELECTED = new Symbol("NOT_SELECTED");
    public static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
    public static final Object UNDECIDED = new Symbol("UNDECIDED");
    public static final Object RESUMED = new Symbol("RESUMED");
    public static final SeqNumber selectOpSequenceNumber = new SeqNumber();

    public static /* synthetic */ void getALREADY_SELECTED$annotations() {
    }

    public static /* synthetic */ void getNOT_SELECTED$annotations() {
    }

    public static /* synthetic */ void getRESUMED$annotations() {
    }

    public static /* synthetic */ void getSelectOpSequenceNumber$annotations() {
    }

    public static /* synthetic */ void getUNDECIDED$annotations() {
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

    public static final Object getNOT_SELECTED() {
        return NOT_SELECTED;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalCoroutinesApi
    /* renamed from: onTimeout-8Mi8wO0  reason: not valid java name */
    public static final <R> void m2358onTimeout8Mi8wO0(SelectBuilder<? super R> selectBuilder, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.onTimeout(DelayKt.m2283toDelayMillisLRDsOJo(j), function1);
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

    public static final <R> Object select$$forInline(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
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
}
