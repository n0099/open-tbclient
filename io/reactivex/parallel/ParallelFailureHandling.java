package io.reactivex.parallel;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.Experimental;
import io.reactivex.functions.BiFunction;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Experimental
/* loaded from: classes8.dex */
public final class ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    public static final /* synthetic */ ParallelFailureHandling[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParallelFailureHandling ERROR;
    public static final ParallelFailureHandling RETRY;
    public static final ParallelFailureHandling SKIP;
    public static final ParallelFailureHandling STOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1303308110, "Lio/reactivex/parallel/ParallelFailureHandling;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1303308110, "Lio/reactivex/parallel/ParallelFailureHandling;");
                return;
            }
        }
        STOP = new ParallelFailureHandling("STOP", 0);
        ERROR = new ParallelFailureHandling("ERROR", 1);
        SKIP = new ParallelFailureHandling("SKIP", 2);
        ParallelFailureHandling parallelFailureHandling = new ParallelFailureHandling("RETRY", 3);
        RETRY = parallelFailureHandling;
        $VALUES = new ParallelFailureHandling[]{STOP, ERROR, SKIP, parallelFailureHandling};
    }

    public ParallelFailureHandling(String str, int i) {
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

    public static ParallelFailureHandling valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ParallelFailureHandling) Enum.valueOf(ParallelFailureHandling.class, str) : (ParallelFailureHandling) invokeL.objValue;
    }

    public static ParallelFailureHandling[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ParallelFailureHandling[]) $VALUES.clone() : (ParallelFailureHandling[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l, th)) == null) ? this : (ParallelFailureHandling) invokeLL.objValue;
    }
}
