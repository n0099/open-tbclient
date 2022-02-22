package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class FuturesGetChecked {
    public static /* synthetic */ Interceptable $ic;
    public static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    /* loaded from: classes3.dex */
    public static class GetCheckedTypeValidatorHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final GetCheckedTypeValidator BEST_VALIDATOR;
        public static final String CLASS_VALUE_VALIDATOR_NAME;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class ClassValueValidator implements GetCheckedTypeValidator {
            public static final /* synthetic */ ClassValueValidator[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ClassValueValidator INSTANCE;
            public static final ClassValue<Boolean> isValidClass;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1231734537, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1231734537, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator;");
                        return;
                    }
                }
                ClassValueValidator classValueValidator = new ClassValueValidator("INSTANCE", 0);
                INSTANCE = classValueValidator;
                $VALUES = new ClassValueValidator[]{classValueValidator};
                isValidClass = new ClassValue<Boolean>() { // from class: com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.ClassValueValidator.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* renamed from: computeValue  reason: collision with other method in class */
                    public /* bridge */ /* synthetic */ Object m116computeValue(Class cls) {
                        return computeValue((Class<?>) cls);
                    }

                    public Boolean computeValue(Class<?> cls) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) {
                            FuturesGetChecked.checkExceptionClassValidity(cls.asSubclass(Exception.class));
                            return Boolean.TRUE;
                        }
                        return (Boolean) invokeL.objValue;
                    }
                };
            }

            public ClassValueValidator(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static ClassValueValidator valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ClassValueValidator) Enum.valueOf(ClassValueValidator.class, str) : (ClassValueValidator) invokeL.objValue;
            }

            public static ClassValueValidator[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ClassValueValidator[]) $VALUES.clone() : (ClassValueValidator[]) invokeV.objValue;
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> cls) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
                    isValidClass.get(cls);
                }
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class WeakSetValidator implements GetCheckedTypeValidator {
            public static final /* synthetic */ WeakSetValidator[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final WeakSetValidator INSTANCE;
            public static final Set<WeakReference<Class<? extends Exception>>> validClasses;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1109705268, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1109705268, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator;");
                        return;
                    }
                }
                WeakSetValidator weakSetValidator = new WeakSetValidator("INSTANCE", 0);
                INSTANCE = weakSetValidator;
                $VALUES = new WeakSetValidator[]{weakSetValidator};
                validClasses = new CopyOnWriteArraySet();
            }

            public WeakSetValidator(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static WeakSetValidator valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WeakSetValidator) Enum.valueOf(WeakSetValidator.class, str) : (WeakSetValidator) invokeL.objValue;
            }

            public static WeakSetValidator[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WeakSetValidator[]) $VALUES.clone() : (WeakSetValidator[]) invokeV.objValue;
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> cls) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
                    for (WeakReference<Class<? extends Exception>> weakReference : validClasses) {
                        if (cls.equals(weakReference.get())) {
                            return;
                        }
                    }
                    FuturesGetChecked.checkExceptionClassValidity(cls);
                    if (validClasses.size() > 1000) {
                        validClasses.clear();
                    }
                    validClasses.add(new WeakReference<>(cls));
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(680868254, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(680868254, "Lcom/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder;");
                    return;
                }
            }
            CLASS_VALUE_VALIDATOR_NAME = GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator";
            BEST_VALIDATOR = getBestValidator();
        }

        public GetCheckedTypeValidatorHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static GetCheckedTypeValidator getBestValidator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                try {
                    return (GetCheckedTypeValidator) Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
                } catch (Throwable unused) {
                    return FuturesGetChecked.weakSetValidator();
                }
            }
            return (GetCheckedTypeValidator) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-927072435, "Lcom/google/common/util/concurrent/FuturesGetChecked;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-927072435, "Lcom/google/common/util/concurrent/FuturesGetChecked;");
                return;
            }
        }
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new g<Constructor<?>, Boolean>() { // from class: com.google.common.util.concurrent.FuturesGetChecked.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.a.g
            public Boolean apply(Constructor<?> constructor) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, constructor)) == null) ? Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class)) : (Boolean) invokeL.objValue;
            }
        }).reverse();
    }

    public FuturesGetChecked() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? GetCheckedTypeValidatorHolder.BEST_VALIDATOR : (GetCheckedTypeValidator) invokeV.objValue;
    }

    public static void checkExceptionClassValidity(Class<? extends Exception> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cls) == null) {
            n.k(isCheckedException(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
            n.k(hasConstructorUsableByGetChecked(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
        }
    }

    public static GetCheckedTypeValidator classValueValidator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE : (GetCheckedTypeValidator) invokeV.objValue;
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, future, cls)) == null) ? (V) getChecked(bestGetCheckedTypeValidator(), future, cls) : (V) invokeLL.objValue;
    }

    public static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            try {
                newWithCause(cls, new Exception());
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isCheckedException(Class<? extends Exception> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? !RuntimeException.class.isAssignableFrom(cls) : invokeL.booleanValue;
    }

    public static <X> X newFromConstructor(Constructor<X> constructor, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, constructor, th)) == null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] objArr = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                Class<?> cls = parameterTypes[i2];
                if (cls.equals(String.class)) {
                    objArr[i2] = th.toString();
                } else if (!cls.equals(Throwable.class)) {
                    return null;
                } else {
                    objArr[i2] = th;
                }
            }
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
                return null;
            }
        }
        return (X) invokeLL.objValue;
    }

    public static <X extends Exception> X newWithCause(Class<X> cls, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, th)) == null) {
            for (Constructor constructor : preferringStrings(Arrays.asList(cls.getConstructors()))) {
                X x = (X) newFromConstructor(constructor, th);
                if (x != null) {
                    if (x.getCause() == null) {
                        x.initCause(th);
                    }
                    return x;
                }
            }
            throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
        }
        return (X) invokeLL.objValue;
    }

    public static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) ? (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(list) : (List) invokeL.objValue;
    }

    public static GetCheckedTypeValidator weakSetValidator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE : (GetCheckedTypeValidator) invokeV.objValue;
    }

    public static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable th, Class<X> cls) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, th, cls) == null) {
            if (!(th instanceof Error)) {
                if (th instanceof RuntimeException) {
                    throw new UncheckedExecutionException(th);
                }
                throw newWithCause(cls, th);
            }
            throw new ExecutionError((Error) th);
        }
    }

    public static <V, X extends Exception> V getChecked(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, getCheckedTypeValidator, future, cls)) == null) {
            getCheckedTypeValidator.validateClass(cls);
            try {
                return future.get();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw newWithCause(cls, e2);
            } catch (ExecutionException e3) {
                wrapAndThrowExceptionOrError(e3.getCause(), cls);
                throw new AssertionError();
            }
        }
        return (V) invokeLLL.objValue;
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j2, TimeUnit timeUnit) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{future, cls, Long.valueOf(j2), timeUnit})) == null) {
            bestGetCheckedTypeValidator().validateClass(cls);
            try {
                return future.get(j2, timeUnit);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw newWithCause(cls, e2);
            } catch (ExecutionException e3) {
                wrapAndThrowExceptionOrError(e3.getCause(), cls);
                throw new AssertionError();
            } catch (TimeoutException e4) {
                throw newWithCause(cls, e4);
            }
        }
        return (V) invokeCommon.objValue;
    }
}
