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
public abstract class qk8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<rk8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public qk8() {
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

    public sk8 addObserver(String str, sk8 sk8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, sk8Var, z)) == null) {
            if (sk8Var == null) {
                sk8Var = new sk8();
            }
            if (this.mNotificationNameList.contains(str)) {
                sk8Var.n(false);
                sk8Var.s(true);
                List<rk8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                rk8 rk8Var = new rk8();
                rk8Var.e(sk8Var.c());
                rk8Var.d(z);
                rk8Var.f(sk8Var.e());
                list.add(rk8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return sk8Var;
        }
        return (sk8) invokeLLZ.objValue;
    }

    public abstract sk8 dispatch(uk8 uk8Var, sk8 sk8Var);

    public abstract List<sk8> processNotification(String str, HashMap hashMap);
}
