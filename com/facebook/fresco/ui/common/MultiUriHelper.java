package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Fn;
import java.util.function.Function;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public abstract class MultiUriHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function<Integer, Integer> f;

    public MultiUriHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> Uri getMainUri(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, Fn<T, Uri> fn) {
        InterceptResult invokeLLLL;
        Uri apply;
        Uri apply2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, t, t2, tArr, fn)) == null) {
            if (t == null || (apply2 = fn.apply(t)) == null) {
                if (tArr == null || tArr.length <= 0 || tArr[0] == null || (apply = fn.apply(tArr[0])) == null) {
                    if (t2 != null) {
                        return fn.apply(t2);
                    }
                    return null;
                }
                return apply;
            }
            return apply2;
        }
        return (Uri) invokeLLLL.objValue;
    }
}
