package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0019\u0012\u0006\u0010:\u001a\u000200\u0012\b\b\u0002\u0010;\u001a\u00020\u0019¢\u0006\u0004\b<\u0010=J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0016\u0010\rJ\u001f\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001e\u0010\nJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010 \u001a\u00020\bH\u0014¢\u0006\u0004\b \u0010\u0014J\u000f\u0010\"\u001a\u00020\bH\u0000¢\u0006\u0004\b!\u0010\u0014J\u001e\u0010%\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#ø\u0001\u0000¢\u0006\u0004\b%\u0010\nJO\u0010(\u001a\u00020\b\"\u0004\b\u0001\u0010&2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00028\u00012'\u0010,\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060*¢\u0006\u0002\b+ø\u0001\u0000¢\u0006\u0004\b(\u0010-J6\u0010(\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u001c\u0010,\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060.ø\u0001\u0000¢\u0006\u0004\b(\u0010/R\u001f\u00101\u001a\u0002008\u0006@\u0006¢\u0006\u0012\n\u0004\b1\u00102\u0012\u0004\b5\u0010\u0014\u001a\u0004\b3\u00104R\u0016\u00107\u001a\u0002008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00104R\u0016\u00108\u001a\u00020\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010:\u001a\u0002008\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b:\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/JobSupport;", "", "state", "", "afterResume", "(Ljava/lang/Object;)V", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleOnCompletionException", "initParentJob$kotlinx_coroutines_core", "()V", "initParentJob", "nameString$kotlinx_coroutines_core", "nameString", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "onCompletionInternal", "onStart", "onStartInternal$kotlinx_coroutines_core", "onStartInternal", "Lkotlin/Result;", "result", "resumeWith", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", SocialConstants.PARAM_RECEIVER, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context$annotations", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext context;
    @JvmField
    public final CoroutineContext parentContext;

    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, (i2 & 2) != 0 ? true : z);
    }

    public static /* synthetic */ void context$annotations() {
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th);
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName != null) {
            return '\"' + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
        }
        return super.nameString$kotlinx_coroutines_core();
    }

    public void onCancelled(Throwable th, boolean z) {
    }

    public void onCompleted(T t) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, completedExceptionally.getHandled());
            return;
        }
        onCompleted(obj);
    }

    public void onStart() {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletedExceptionallyKt.toState(obj));
        if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(makeCompletingOnce$kotlinx_coroutines_core);
    }

    public final void start(CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function1, this);
    }

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.parentContext = coroutineContext;
        this.context = coroutineContext.plus(this);
    }

    public final <R> void start(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function2, r, this);
    }
}
