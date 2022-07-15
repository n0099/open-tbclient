package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class fj8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<gj8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public fj8() {
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

    public hj8 addObserver(String str, hj8 hj8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, hj8Var, z)) == null) {
            if (hj8Var == null) {
                hj8Var = new hj8();
            }
            if (this.mNotificationNameList.contains(str)) {
                hj8Var.n(false);
                hj8Var.s(true);
                List<gj8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                gj8 gj8Var = new gj8();
                gj8Var.e(hj8Var.c());
                gj8Var.d(z);
                gj8Var.f(hj8Var.e());
                list.add(gj8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return hj8Var;
        }
        return (hj8) invokeLLZ.objValue;
    }

    public abstract hj8 dispatch(jj8 jj8Var, hj8 hj8Var);

    public abstract List<hj8> processNotification(String str, HashMap hashMap);
}
