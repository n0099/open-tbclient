package com.repackage;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
/* loaded from: classes7.dex */
public class wl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<Long, StackTraceElement[]> a;
    public int b;

    public wl9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap<>();
        this.b = 100;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int size = this.a.size();
            int i = this.b;
            if (size == i && i > 0) {
                LinkedHashMap<Long, StackTraceElement[]> linkedHashMap = this.a;
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
            this.a.put(Long.valueOf(System.currentTimeMillis()), Looper.getMainLooper().getThread().getStackTrace());
        }
    }

    public LinkedHashMap<Long, StackTraceElement[]> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (LinkedHashMap) invokeV.objValue;
    }
}
