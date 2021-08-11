package i.o.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 + j3;
            if (j4 < 0) {
                return Long.MAX_VALUE;
            }
            return j4;
        }
        return invokeCommon.longValue;
    }

    public static long b(AtomicLong atomicLong, long j2) {
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
            } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
            return j3;
        }
        return invokeLJ.longValue;
    }

    public static long c(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 * j3;
            if (((j2 | j3) >>> 31) == 0 || j3 == 0 || j4 / j3 == j2) {
                return j4;
            }
            return Long.MAX_VALUE;
        }
        return invokeCommon.longValue;
    }

    /* JADX DEBUG: Type inference failed for r10v3. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r8v4. Raw type applied. Possible types: R, ? super R */
    public static <T, R> void d(AtomicLong atomicLong, Queue<T> queue, i.j<? super R> jVar, i.n.f<? super T, ? extends R> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, atomicLong, queue, jVar, fVar) == null) {
            long j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                while (!jVar.isUnsubscribed()) {
                    Object poll = queue.poll();
                    if (poll == null) {
                        jVar.onCompleted();
                        return;
                    }
                    jVar.onNext((R) fVar.call(poll));
                }
                return;
            }
            do {
                long j3 = Long.MIN_VALUE;
                while (true) {
                    int i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 != 0) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        Object poll2 = queue.poll();
                        if (poll2 == null) {
                            jVar.onCompleted();
                            return;
                        } else {
                            jVar.onNext((R) fVar.call(poll2));
                            j3++;
                        }
                    } else {
                        if (i2 == 0) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            if (queue.isEmpty()) {
                                jVar.onCompleted();
                                return;
                            }
                        }
                        j2 = atomicLong.get();
                        if (j2 == j3) {
                            j2 = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                        }
                    }
                }
            } while (j2 != Long.MIN_VALUE);
        }
    }

    public static <T> boolean e(AtomicLong atomicLong, long j2, Queue<T> queue, i.j<? super T> jVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{atomicLong, Long.valueOf(j2), queue, jVar})) == null) ? f(atomicLong, j2, queue, jVar, UtilityFunctions.b()) : invokeCommon.booleanValue;
    }

    public static <T, R> boolean f(AtomicLong atomicLong, long j2, Queue<T> queue, i.j<? super R> jVar, i.n.f<? super T, ? extends R> fVar) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{atomicLong, Long.valueOf(j2), queue, jVar, fVar})) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j2);
            } else if (i2 == 0) {
                return (atomicLong.get() & Long.MIN_VALUE) == 0;
            } else {
                while (true) {
                    j3 = atomicLong.get();
                    j4 = j3 & Long.MIN_VALUE;
                    if (atomicLong.compareAndSet(j3, a(Long.MAX_VALUE & j3, j2) | j4)) {
                        break;
                    }
                }
                if (j3 != Long.MIN_VALUE) {
                    return j4 == 0;
                }
                d(atomicLong, queue, jVar, fVar);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static long g(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced than requested: " + j4);
                }
            } while (!atomicLong.compareAndSet(j3, j4));
            return j4;
        }
        return invokeLJ.longValue;
    }

    public static boolean h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                return i2 != 0;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j2);
        }
        return invokeJ.booleanValue;
    }
}
