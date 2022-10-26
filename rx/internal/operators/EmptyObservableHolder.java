package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.dy9;
import com.baidu.tieba.xx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class EmptyObservableHolder implements xx9.a {
    public static final /* synthetic */ EmptyObservableHolder[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final xx9 EMPTY;
    public static final EmptyObservableHolder INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-414572492, "Lrx/internal/operators/EmptyObservableHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-414572492, "Lrx/internal/operators/EmptyObservableHolder;");
                return;
            }
        }
        EmptyObservableHolder emptyObservableHolder = new EmptyObservableHolder("INSTANCE", 0);
        INSTANCE = emptyObservableHolder;
        $VALUES = new EmptyObservableHolder[]{emptyObservableHolder};
        EMPTY = xx9.a(emptyObservableHolder);
    }

    public EmptyObservableHolder(String str, int i) {
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

    public static xx9 instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EMPTY;
        }
        return (xx9) invokeV.objValue;
    }

    public static EmptyObservableHolder[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (EmptyObservableHolder[]) $VALUES.clone();
        }
        return (EmptyObservableHolder[]) invokeV.objValue;
    }

    public static EmptyObservableHolder valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (EmptyObservableHolder) Enum.valueOf(EmptyObservableHolder.class, str);
        }
        return (EmptyObservableHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
            dy9Var.onCompleted();
        }
    }
}
