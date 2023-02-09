package io.reactivex;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class BackpressureStrategy {
    public static final /* synthetic */ BackpressureStrategy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BackpressureStrategy BUFFER;
    public static final BackpressureStrategy DROP;
    public static final BackpressureStrategy ERROR;
    public static final BackpressureStrategy LATEST;
    public static final BackpressureStrategy MISSING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(721648431, "Lio/reactivex/BackpressureStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(721648431, "Lio/reactivex/BackpressureStrategy;");
                return;
            }
        }
        MISSING = new BackpressureStrategy("MISSING", 0);
        ERROR = new BackpressureStrategy("ERROR", 1);
        BUFFER = new BackpressureStrategy("BUFFER", 2);
        DROP = new BackpressureStrategy("DROP", 3);
        BackpressureStrategy backpressureStrategy = new BackpressureStrategy("LATEST", 4);
        LATEST = backpressureStrategy;
        $VALUES = new BackpressureStrategy[]{MISSING, ERROR, BUFFER, DROP, backpressureStrategy};
    }

    public BackpressureStrategy(String str, int i) {
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

    public static BackpressureStrategy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, str);
        }
        return (BackpressureStrategy) invokeL.objValue;
    }

    public static BackpressureStrategy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BackpressureStrategy[]) $VALUES.clone();
        }
        return (BackpressureStrategy[]) invokeV.objValue;
    }
}
