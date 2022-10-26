package io.reactivex;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class BackpressureOverflowStrategy {
    public static final /* synthetic */ BackpressureOverflowStrategy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BackpressureOverflowStrategy DROP_LATEST;
    public static final BackpressureOverflowStrategy DROP_OLDEST;
    public static final BackpressureOverflowStrategy ERROR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638903219, "Lio/reactivex/BackpressureOverflowStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1638903219, "Lio/reactivex/BackpressureOverflowStrategy;");
                return;
            }
        }
        ERROR = new BackpressureOverflowStrategy("ERROR", 0);
        DROP_OLDEST = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
        BackpressureOverflowStrategy backpressureOverflowStrategy = new BackpressureOverflowStrategy("DROP_LATEST", 2);
        DROP_LATEST = backpressureOverflowStrategy;
        $VALUES = new BackpressureOverflowStrategy[]{ERROR, DROP_OLDEST, backpressureOverflowStrategy};
    }

    public BackpressureOverflowStrategy(String str, int i) {
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

    public static BackpressureOverflowStrategy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BackpressureOverflowStrategy) Enum.valueOf(BackpressureOverflowStrategy.class, str);
        }
        return (BackpressureOverflowStrategy) invokeL.objValue;
    }

    public static BackpressureOverflowStrategy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BackpressureOverflowStrategy[]) $VALUES.clone();
        }
        return (BackpressureOverflowStrategy[]) invokeV.objValue;
    }
}
