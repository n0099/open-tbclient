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
/* loaded from: classes7.dex */
public abstract class MultiUriHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function f;

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

    public static Uri getMainUri(@Nullable Object obj, @Nullable Object obj2, @Nullable Object[] objArr, Fn fn) {
        InterceptResult invokeLLLL;
        Uri uri;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, obj2, objArr, fn)) == null) {
            if (obj != null && (uri2 = (Uri) fn.apply(obj)) != null) {
                return uri2;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null && (uri = (Uri) fn.apply(objArr[0])) != null) {
                return uri;
            }
            if (obj2 != null) {
                return (Uri) fn.apply(obj2);
            }
            return null;
        }
        return (Uri) invokeLLLL.objValue;
    }
}
