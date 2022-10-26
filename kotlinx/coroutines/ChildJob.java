package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "Lkotlin/Any;", "Lkotlinx/coroutines/ParentJob;", "parentJob", "", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface ChildJob extends Job {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class DefaultImpls {
        public static Object fold(ChildJob childJob, Object obj, Function2 function2) {
            return Job.DefaultImpls.fold(childJob, obj, function2);
        }

        public static CoroutineContext.Element get(ChildJob childJob, CoroutineContext.Key key) {
            return Job.DefaultImpls.get(childJob, key);
        }

        public static CoroutineContext minusKey(ChildJob childJob, CoroutineContext.Key key) {
            return Job.DefaultImpls.minusKey(childJob, key);
        }

        public static CoroutineContext plus(ChildJob childJob, CoroutineContext coroutineContext) {
            return Job.DefaultImpls.plus(childJob, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(ChildJob childJob, Job job) {
            return Job.DefaultImpls.plus((Job) childJob, job);
        }
    }

    void parentCancelled(ParentJob parentJob);
}
