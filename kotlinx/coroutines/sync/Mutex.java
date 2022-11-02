package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;
import org.aspectj.lang.JoinPoint;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00000\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/Any;", "", "owner", "", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", JoinPoint.SYNCHRONIZATION_UNLOCK, "(Ljava/lang/Object;)V", "isLocked", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface Mutex {
    SelectClause2<Object, Mutex> getOnLock();

    boolean holdsLock(Object obj);

    boolean isLocked();

    Object lock(Object obj, Continuation<? super Unit> continuation);

    boolean tryLock(Object obj);

    void unlock(Object obj);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object lock$default(Mutex mutex, Object obj, Continuation continuation, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return mutex.lock(obj, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ boolean tryLock$default(Mutex mutex, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return mutex.tryLock(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void unlock$default(Mutex mutex, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                mutex.unlock(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }
}
