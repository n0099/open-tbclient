package kotlinx.coroutines;

import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b5\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u000f2\u000e\u0010\t\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0017¢\u0006\u0004\b\u000b\u0010\u0010J\u0013\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012JH\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\u0015j\u0002`\u0018H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001b\u001a\u00020\u001a2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\u0015j\u0002`\u0018H\u0017¢\u0006\u0004\b\u001b\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u000fH\u0097@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0017¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010%8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001c\u0010+\u001a\u00020\n8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010)\u001a\u0004\b+\u0010!R\u001c\u0010-\u001a\u00020\n8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010)\u001a\u0004\b-\u0010!R\u001c\u0010/\u001a\u00020\n8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b0\u0010)\u001a\u0004\b/\u0010!R\u0016\u00104\u001a\u0002018V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "cause", "", QueryResponse.Options.CANCEL, "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children$annotations", "()V", "children", "isActive", "isActive$annotations", "isCancelled", "isCancelled$annotations", "isCompleted", "isCompleted$annotations", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable INSTANCE = new NonCancellable();

    public NonCancellable() {
        super(Job.Key);
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void children$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isActive$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public ChildHandle attachChild(ChildJob childJob) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public void cancel(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Sequence<Job> getChildren() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public Object join(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.INSTANCE;
    }
}
