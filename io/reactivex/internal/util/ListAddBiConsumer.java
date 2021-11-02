package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.functions.BiFunction;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ListAddBiConsumer implements BiFunction<List, Object, List> {
    public static final /* synthetic */ ListAddBiConsumer[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ListAddBiConsumer INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(866688131, "Lio/reactivex/internal/util/ListAddBiConsumer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(866688131, "Lio/reactivex/internal/util/ListAddBiConsumer;");
                return;
            }
        }
        ListAddBiConsumer listAddBiConsumer = new ListAddBiConsumer("INSTANCE", 0);
        INSTANCE = listAddBiConsumer;
        $VALUES = new ListAddBiConsumer[]{listAddBiConsumer};
    }

    public ListAddBiConsumer(String str, int i2) {
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

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? INSTANCE : (BiFunction) invokeV.objValue;
    }

    public static ListAddBiConsumer valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ListAddBiConsumer) Enum.valueOf(ListAddBiConsumer.class, str) : (ListAddBiConsumer) invokeL.objValue;
    }

    public static ListAddBiConsumer[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ListAddBiConsumer[]) $VALUES.clone() : (ListAddBiConsumer[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.BiFunction
    public List apply(List list, Object obj) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, obj)) == null) {
            list.add(obj);
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
