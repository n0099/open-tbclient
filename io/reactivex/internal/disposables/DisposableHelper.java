package io.reactivex.internal.disposables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class DisposableHelper implements Disposable {
    public static final /* synthetic */ DisposableHelper[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DisposableHelper DISPOSED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1827789388, "Lio/reactivex/internal/disposables/DisposableHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1827789388, "Lio/reactivex/internal/disposables/DisposableHelper;");
                return;
            }
        }
        DisposableHelper disposableHelper = new DisposableHelper("DISPOSED", 0);
        DISPOSED = disposableHelper;
        $VALUES = new DisposableHelper[]{disposableHelper};
    }

    public DisposableHelper(String str, int i) {
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

    public static boolean dispose(AtomicReference<Disposable> atomicReference) {
        InterceptResult invokeL;
        Disposable andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, atomicReference)) == null) {
            Disposable disposable = atomicReference.get();
            DisposableHelper disposableHelper = DISPOSED;
            if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            if (andSet != null) {
                andSet.dispose();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isDisposed(Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, disposable)) == null) ? disposable == DISPOSED : invokeL.booleanValue;
    }

    public static boolean replace(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReference, disposable)) == null) {
            do {
                disposable2 = atomicReference.get();
                if (disposable2 == DISPOSED) {
                    if (disposable != null) {
                        disposable.dispose();
                        return false;
                    }
                    return false;
                }
            } while (!atomicReference.compareAndSet(disposable2, disposable));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void reportDisposableSet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
        }
    }

    public static boolean set(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, atomicReference, disposable)) == null) {
            do {
                disposable2 = atomicReference.get();
                if (disposable2 == DISPOSED) {
                    if (disposable != null) {
                        disposable.dispose();
                        return false;
                    }
                    return false;
                }
            } while (!atomicReference.compareAndSet(disposable2, disposable));
            if (disposable2 != null) {
                disposable2.dispose();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, atomicReference, disposable)) == null) {
            ObjectHelper.requireNonNull(disposable, "d is null");
            if (atomicReference.compareAndSet(null, disposable)) {
                return true;
            }
            disposable.dispose();
            if (atomicReference.get() != DISPOSED) {
                reportDisposableSet();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean trySet(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, atomicReference, disposable)) == null) {
            if (atomicReference.compareAndSet(null, disposable)) {
                return true;
            }
            if (atomicReference.get() == DISPOSED) {
                disposable.dispose();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, disposable, disposable2)) == null) {
            if (disposable2 == null) {
                RxJavaPlugins.onError(new NullPointerException("next is null"));
                return false;
            } else if (disposable != null) {
                disposable2.dispose();
                reportDisposableSet();
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static DisposableHelper valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (DisposableHelper) Enum.valueOf(DisposableHelper.class, str) : (DisposableHelper) invokeL.objValue;
    }

    public static DisposableHelper[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? (DisposableHelper[]) $VALUES.clone() : (DisposableHelper[]) invokeV.objValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
