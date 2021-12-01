package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.j;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class EmptyObservableHolder implements d.a<Object> {
    public static final /* synthetic */ EmptyObservableHolder[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final d<Object> EMPTY;
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
        EMPTY = d.a(emptyObservableHolder);
    }

    public EmptyObservableHolder(String str, int i2) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (d<T>) EMPTY : (d) invokeV.objValue;
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
    @Override // i.d.a, i.n.b
    public void call(j<? super Object> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            jVar.onCompleted();
        }
    }
}
