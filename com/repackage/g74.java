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
/* loaded from: classes6.dex */
public class g74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, f74> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public g74() {
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

    public <T> f74<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.a.get(cls) : (f74) invokeL.objValue;
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
            this.a.put(e84.class, new j74());
            this.a.put(f84.class, new k74());
            this.a.put(c84.class, new i74());
            this.a.put(a84.class, new h74());
            this.a.put(PMSAppInfo.class, new e74());
            this.a.put(g84.class, new l74());
            this.a.put(h84.class, new m74());
            this.b.put(e84.class, w74.f);
            this.b.put(f84.class, w74.g);
            this.b.put(c84.class, w74.d);
            this.b.put(a84.class, w74.h);
            this.b.put(PMSAppInfo.class, w74.e);
            this.b.put(g84.class, w74.i);
            this.b.put(h84.class, w74.j);
        }
    }
}
