package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u001a \u0010\u0004\u001a\u00020\u00032\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\u000b\u001a\u0013\u0010\u000e\u001a\u00020\u0001*\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u000e\u001a\u00020\u0012*\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u000e\u0010\u0013\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u000e\u0010\u0016\u001a%\u0010\u000e\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001c\u001a\u00020\u0001*\u00020\rH\u0007¢\u0006\u0004\b\u001c\u0010\u000f\u001a\u001f\u0010\u001c\u001a\u00020\u0001*\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001c\u001a\u00020\u0001*\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u001c\u0010\u0016\u001a\u0013\u0010\u001c\u001a\u00020\u0001*\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001f\u0010\u001c\u001a\u00020\u0001*\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u001c\u0010\u001f\u001a#\u0010\u001c\u001a\u00020\u0001*\u00020\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u001c\u0010 \u001a\u001b\u0010\"\u001a\u00020\u0003*\u00020\u00062\u0006\u0010!\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010$\u001a\u00020\u0001*\u00020\r¢\u0006\u0004\b$\u0010\u000f\u001a\u0011\u0010$\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b$\u0010\u001e\u001a\u001d\u0010(\u001a\u00020\u0010*\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'\"\u0017\u0010)\u001a\u00020\u0012*\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlinx/coroutines/DisposableHandle;", "DisposableHandle", "(Lkotlin/Function0;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "Job", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "Job0", "Lkotlin/coroutines/CoroutineContext;", QueryResponse.Options.CANCEL, "(Lkotlin/coroutines/CoroutineContext;)V", "", "cause", "", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "", "message", "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "(Lkotlinx/coroutines/Job;)V", "(Lkotlinx/coroutines/Job;Ljava/lang/Throwable;)V", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "handle", "disposeOnCompletion", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", "ensureActive", "job", "orCancellation$JobKt__JobKt", "(Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "orCancellation", "isActive", "(Lkotlin/coroutines/CoroutineContext;)Z", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class JobKt__JobKt {
    @InternalCoroutinesApi
    public static final DisposableHandle DisposableHandle(final Function0<Unit> function0) {
        return new DisposableHandle() { // from class: kotlinx.coroutines.JobKt__JobKt$DisposableHandle$1
            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                Function0.this.invoke();
            }
        };
    }

    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        return join == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        for (Job job2 : job.getChildren()) {
            job2.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        return job != null && job.isActive();
    }

    public static final Throwable orCancellation$JobKt__JobKt(Throwable th, Job job) {
        return th != null ? th : new JobCancellationException("Job was cancelled", null, job);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.JobKt__JobKt.Job$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job, kotlinx.coroutines.JobKt__JobKt.Job$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    /* renamed from: Job */
    public static final /* synthetic */ Job m1970Job(Job job) {
        return JobKt.Job(job);
    }

    /* renamed from: Job$default */
    public static /* synthetic */ Job m1971Job$default(Job job, int i2, Object obj) {
        Job m1970Job;
        if ((i2 & 1) != 0) {
            job = null;
        }
        m1970Job = m1970Job(job);
        return m1970Job;
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
            return;
        }
        throw new IllegalStateException(("Context cannot be checked for liveness because it does not have a job: " + coroutineContext).toString());
    }

    public static final void cancel(Job job, String str, Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        boolean cancel;
        if ((i2 & 1) != 0) {
            th = null;
        }
        cancel = cancel(coroutineContext, th);
        return cancel;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        if (!(element instanceof JobSupport)) {
            element = null;
        }
        JobSupport jobSupport = (JobSupport) element;
        if (jobSupport != null) {
            jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, jobSupport));
            return true;
        }
        return false;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job, Throwable th) {
        for (Job job2 : job.getChildren()) {
            if (!(job2 instanceof JobSupport)) {
                job2 = null;
            }
            JobSupport jobSupport = (JobSupport) job2;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        for (Job job2 : children) {
            job2.cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            for (Job job2 : job.getChildren()) {
                if (!(job2 instanceof JobSupport)) {
                    job2 = null;
                }
                JobSupport jobSupport = (JobSupport) job2;
                if (jobSupport != null) {
                    jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
                }
            }
        }
    }
}
