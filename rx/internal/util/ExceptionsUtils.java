package rx.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ExceptionsUtils {
    public static final /* synthetic */ ExceptionsUtils[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Throwable TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(918276006, "Lrx/internal/util/ExceptionsUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(918276006, "Lrx/internal/util/ExceptionsUtils;");
                return;
            }
        }
        $VALUES = new ExceptionsUtils[0];
        TERMINATED = new Throwable("Terminated");
    }

    public static ExceptionsUtils[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return (ExceptionsUtils[]) $VALUES.clone();
        }
        return (ExceptionsUtils[]) invokeV.objValue;
    }

    public ExceptionsUtils(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean addThrowable(AtomicReference atomicReference, Throwable th) {
        Throwable th2;
        Throwable compositeException;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, atomicReference, th)) == null) {
            do {
                th2 = (Throwable) atomicReference.get();
                if (th2 == TERMINATED) {
                    return false;
                }
                if (th2 == null) {
                    compositeException = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    compositeException = new CompositeException(arrayList);
                } else {
                    compositeException = new CompositeException(th2, th);
                }
            } while (!atomicReference.compareAndSet(th2, compositeException));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isTerminated(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            if (th == TERMINATED) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Throwable terminate(AtomicReference atomicReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, atomicReference)) == null) {
            Throwable th = (Throwable) atomicReference.get();
            Throwable th2 = TERMINATED;
            if (th != th2) {
                return (Throwable) atomicReference.getAndSet(th2);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static ExceptionsUtils valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return (ExceptionsUtils) Enum.valueOf(ExceptionsUtils.class, str);
        }
        return (ExceptionsUtils) invokeL.objValue;
    }

    public static boolean isTerminated(AtomicReference atomicReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReference)) == null) {
            return isTerminated((Throwable) atomicReference.get());
        }
        return invokeL.booleanValue;
    }
}
