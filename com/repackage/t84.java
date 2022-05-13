package com.repackage;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class t84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, s84> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public t84() {
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
        c();
    }

    public <T> s84<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.a.get(cls) : (s84) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap<>();
            this.b = new ConcurrentHashMap<>();
            this.a.put(r94.class, new w84());
            this.a.put(s94.class, new x84());
            this.a.put(p94.class, new v84());
            this.a.put(n94.class, new u84());
            this.a.put(PMSAppInfo.class, new r84());
            this.a.put(t94.class, new y84());
            this.a.put(u94.class, new z84());
            this.b.put(r94.class, j94.f);
            this.b.put(s94.class, j94.g);
            this.b.put(p94.class, j94.d);
            this.b.put(n94.class, j94.h);
            this.b.put(PMSAppInfo.class, j94.e);
            this.b.put(t94.class, j94.i);
            this.b.put(u94.class, j94.j);
        }
    }
}
