package io.reactivex.internal.functions;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.functions.BiPredicate;
/* loaded from: classes2.dex */
public final class ObjectHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final BiPredicate<Object, Object> EQUALS;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BiObjectPredicate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? ObjectHelper.equals(obj, obj2) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-544417707, "Lio/reactivex/internal/functions/ObjectHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-544417707, "Lio/reactivex/internal/functions/ObjectHelper;");
                return;
            }
        }
        EQUALS = new BiObjectPredicate();
    }

    public ObjectHelper() {
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

    public static int compare(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            if (i2 < i3) {
                return -1;
            }
            return i2 > i3 ? 1 : 0;
        }
        return invokeII.intValue;
    }

    public static int compare(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 > 0 ? 1 : 0;
        }
        return invokeCommon.intValue;
    }

    public static boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (BiPredicate<T, T>) EQUALS : (BiPredicate) invokeV.objValue;
    }

    public static int hashCode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static <T> T requireNonNull(T t, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, t, str)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(str);
        }
        return (T) invokeLL.objValue;
    }

    public static int verifyPositive(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, str)) == null) {
            if (i2 > 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
        }
        return invokeIL.intValue;
    }

    public static long verifyPositive(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65545, null, j2, str)) == null) {
            if (j2 > 0) {
                return j2;
            }
            throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
        }
        return invokeJL.longValue;
    }
}
