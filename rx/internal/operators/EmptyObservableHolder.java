package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as9;
import com.repackage.ur9;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class EmptyObservableHolder implements ur9.a<Object> {
    public static final /* synthetic */ EmptyObservableHolder[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ur9<Object> EMPTY;
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
        EMPTY = ur9.a(emptyObservableHolder);
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

    public static <T> ur9<T> instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (ur9<T>) EMPTY : (ur9) invokeV.objValue;
    }

    public static EmptyObservableHolder valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (EmptyObservableHolder) Enum.valueOf(EmptyObservableHolder.class, str) : (EmptyObservableHolder) invokeL.objValue;
    }

    public static EmptyObservableHolder[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (EmptyObservableHolder[]) $VALUES.clone() : (EmptyObservableHolder[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ur9.a, com.repackage.is9
    public void call(as9<? super Object> as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
            as9Var.onCompleted();
        }
    }
}
