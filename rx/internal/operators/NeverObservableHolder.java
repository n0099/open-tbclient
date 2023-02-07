package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.tca;
import com.baidu.tieba.zca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class NeverObservableHolder implements tca.a<Object> {
    public static final /* synthetic */ NeverObservableHolder[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NeverObservableHolder INSTANCE;
    public static final tca<Object> NEVER;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
    public void call(zca<? super Object> zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zcaVar) == null) {
        }
    }

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
        NEVER = tca.a(neverObservableHolder);
    }

    public NeverObservableHolder(String str, int i) {
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

    public static <T> tca<T> instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (tca<T>) NEVER;
        }
        return (tca) invokeV.objValue;
    }

    public static NeverObservableHolder[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (NeverObservableHolder[]) $VALUES.clone();
        }
        return (NeverObservableHolder[]) invokeV.objValue;
    }

    public static NeverObservableHolder valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (NeverObservableHolder) Enum.valueOf(NeverObservableHolder.class, str);
        }
        return (NeverObservableHolder) invokeL.objValue;
    }
}
