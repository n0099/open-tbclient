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
public abstract class ji8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<ki8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public ji8() {
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

    public li8 addObserver(String str, li8 li8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, li8Var, z)) == null) {
            if (li8Var == null) {
                li8Var = new li8();
            }
            if (this.mNotificationNameList.contains(str)) {
                li8Var.n(false);
                li8Var.s(true);
                List<ki8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ki8 ki8Var = new ki8();
                ki8Var.e(li8Var.c());
                ki8Var.d(z);
                ki8Var.f(li8Var.e());
                list.add(ki8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return li8Var;
        }
        return (li8) invokeLLZ.objValue;
    }

    public abstract li8 dispatch(ni8 ni8Var, li8 li8Var);

    public abstract List<li8> processNotification(String str, HashMap hashMap);
}
