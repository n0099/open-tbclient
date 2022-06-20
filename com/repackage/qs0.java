package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class qs0 implements as0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zt0 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755369693, "Lcom/repackage/qs0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755369693, "Lcom/repackage/qs0;");
                return;
            }
        }
        no0.f();
    }

    public qs0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(map);
    }

    @Override // com.repackage.bs0
    public final void c(ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ir0Var) == null) || ir0Var == null || this.a == null) {
            return;
        }
        int type = ir0Var.getType();
        if (type == 1) {
            i(ir0Var);
        } else if (type == 2) {
            f(ir0Var);
        } else if (type == 3) {
            g(ir0Var);
        } else if (type != 4) {
        } else {
            h(ir0Var);
        }
    }

    @Override // com.repackage.as0
    public final <T extends vt0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (zt0) t;
        }
    }

    public abstract void f(ir0 ir0Var);

    public abstract void g(ir0 ir0Var);

    public abstract void h(ir0 ir0Var);

    public abstract void i(ir0 ir0Var);

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
            String str = (String) mx0.b(map, WriteActivityConfig.VIDEO_INFO);
        }
        if (map.containsKey("channel_id")) {
            String str2 = (String) mx0.b(map, "channel_id");
        }
        if (map.containsKey("channel_title")) {
            String str3 = (String) mx0.b(map, "channel_title");
        }
        if (map.containsKey("type")) {
            String str4 = (String) mx0.b(map, "type");
        }
        if (map.containsKey("source")) {
            String str5 = (String) mx0.b(map, "source");
        }
        if (map.containsKey("from")) {
            String str6 = (String) mx0.b(map, "from");
        }
        if (map.containsKey(Config.EVENT_PAGE_MAPPING)) {
            String str7 = (String) mx0.b(map, Config.EVENT_PAGE_MAPPING);
        }
        if (map.containsKey("tpl")) {
            String str8 = (String) mx0.b(map, "tpl");
        }
        if (map.containsKey("ext_request")) {
            String str9 = (String) mx0.b(map, "ext_request");
        }
    }
}
