package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ExceptionHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Throwable TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class Termination extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4649703670690200604L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Termination() {
            super("No further exceptions");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Throwable) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1828199974, "Lio/reactivex/internal/util/ExceptionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1828199974, "Lio/reactivex/internal/util/ExceptionHelper;");
                return;
            }
        }
        TERMINATED = new Termination();
    }

    public ExceptionHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, atomicReference, th)) == null) {
            do {
                th2 = atomicReference.get();
                if (th2 == TERMINATED) {
                    return false;
                }
            } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static List<Throwable> flatten(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.offer(th);
            while (!arrayDeque.isEmpty()) {
                Throwable th2 = (Throwable) arrayDeque.removeFirst();
                if (th2 instanceof CompositeException) {
                    List<Throwable> exceptions = ((CompositeException) th2).getExceptions();
                    for (int size = exceptions.size() - 1; size >= 0; size--) {
                        arrayDeque.offerFirst(exceptions.get(size));
                    }
                } else {
                    arrayList.add(th2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> atomicReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReference)) == null) {
            Throwable th = atomicReference.get();
            Throwable th2 = TERMINATED;
            return th != th2 ? atomicReference.getAndSet(th2) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable th) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, th)) == null) {
            if (th instanceof Exception) {
                return (Exception) th;
            }
            throw th;
        }
        return (Exception) invokeL.objValue;
    }

    public static RuntimeException wrapOrThrow(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th)) == null) {
            if (!(th instanceof Error)) {
                if (th instanceof RuntimeException) {
                    return (RuntimeException) th;
                }
                return new RuntimeException(th);
            }
            throw ((Error) th);
        }
        return (RuntimeException) invokeL.objValue;
    }
}
