package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.j;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class NeverObservableHolder implements d.a<Object> {
    public static final /* synthetic */ NeverObservableHolder[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NeverObservableHolder INSTANCE;
    public static final d<Object> NEVER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1040720085, "Lrx/internal/operators/NeverObservableHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1040720085, "Lrx/internal/operators/NeverObservableHolder;");
                return;
            }
        }
        NeverObservableHolder neverObservableHolder = new NeverObservableHolder("INSTANCE", 0);
        INSTANCE = neverObservableHolder;
        $VALUES = new NeverObservableHolder[]{neverObservableHolder};
        NEVER = d.b(neverObservableHolder);
    }

    public NeverObservableHolder(String str, int i2) {
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

    public static <T> d<T> instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (d<T>) NEVER : (d) invokeV.objValue;
    }

    public static NeverObservableHolder valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (NeverObservableHolder) Enum.valueOf(NeverObservableHolder.class, str) : (NeverObservableHolder) invokeL.objValue;
    }

    public static NeverObservableHolder[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (NeverObservableHolder[]) $VALUES.clone() : (NeverObservableHolder[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    public void call(j<? super Object> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
        }
    }
}
