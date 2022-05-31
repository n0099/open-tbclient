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
/* loaded from: classes7.dex */
public abstract class rh8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<sh8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public rh8() {
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

    public th8 addObserver(String str, th8 th8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, th8Var, z)) == null) {
            if (th8Var == null) {
                th8Var = new th8();
            }
            if (this.mNotificationNameList.contains(str)) {
                th8Var.n(false);
                th8Var.s(true);
                List<sh8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                sh8 sh8Var = new sh8();
                sh8Var.e(th8Var.c());
                sh8Var.d(z);
                sh8Var.f(th8Var.e());
                list.add(sh8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return th8Var;
        }
        return (th8) invokeLLZ.objValue;
    }

    public abstract th8 dispatch(vh8 vh8Var, th8 th8Var);

    public abstract List<th8> processNotification(String str, HashMap hashMap);
}
