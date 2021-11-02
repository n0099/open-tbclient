package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0013\u0010\u0005\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\u0019\u001a\u00020\u0018\"\u0004\b\u0001\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00122\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\b8P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CompletableDeferredImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlinx/coroutines/JobSupport;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", XAdRemoteEvent.COMPLETE, "(Ljava/lang/Object;)Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "getCompleted", "()Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", "registerSelectClause1", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwait", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T>, SelectClause1<T> {
    public CompletableDeferredImpl(Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // kotlinx.coroutines.Deferred
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object await(Continuation<? super T> continuation) {
        CompletableDeferredImpl$await$1 completableDeferredImpl$await$1;
        int i2;
        if (continuation instanceof CompletableDeferredImpl$await$1) {
            completableDeferredImpl$await$1 = (CompletableDeferredImpl$await$1) continuation;
            int i3 = completableDeferredImpl$await$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                completableDeferredImpl$await$1.label = i3 - Integer.MIN_VALUE;
                Object obj = completableDeferredImpl$await$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = completableDeferredImpl$await$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    completableDeferredImpl$await$1.L$0 = this;
                    completableDeferredImpl$await$1.label = 1;
                    obj = awaitInternal$kotlinx_coroutines_core(completableDeferredImpl$await$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    CompletableDeferredImpl completableDeferredImpl = (CompletableDeferredImpl) completableDeferredImpl$await$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }
        completableDeferredImpl$await$1 = new CompletableDeferredImpl$await$1(this, continuation);
        Object obj2 = completableDeferredImpl$await$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = completableDeferredImpl$await$1.label;
        if (i2 != 0) {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean complete(T t) {
        return makeCompleting$kotlinx_coroutines_core(t);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1<T> getOnAwait() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void registerSelectClause1(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        registerSelectClause1Internal$kotlinx_coroutines_core(selectInstance, function2);
    }
}
