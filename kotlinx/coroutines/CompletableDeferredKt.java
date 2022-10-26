package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.tbadk.core.util.TiebaStatic;
import kotlin.Metadata;
import kotlin.Result;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a0\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/CompletableDeferred;", "CompletableDeferred", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/Job;", "parent", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", TiebaStatic.LogFields.RESULT, "", "completeWith", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class CompletableDeferredKt {
    public static final CompletableDeferred CompletableDeferred(Object obj) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(null);
        completableDeferredImpl.complete(obj);
        return completableDeferredImpl;
    }

    public static final CompletableDeferred CompletableDeferred(Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }

    public static final boolean completeWith(CompletableDeferred completableDeferred, Object obj) {
        Throwable m701exceptionOrNullimpl = Result.m701exceptionOrNullimpl(obj);
        if (m701exceptionOrNullimpl == null) {
            return completableDeferred.complete(obj);
        }
        return completableDeferred.completeExceptionally(m701exceptionOrNullimpl);
    }
}
