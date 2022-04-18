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
public abstract class tl8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<ul8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public tl8() {
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

    public vl8 addObserver(String str, vl8 vl8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, vl8Var, z)) == null) {
            if (vl8Var == null) {
                vl8Var = new vl8();
            }
            if (this.mNotificationNameList.contains(str)) {
                vl8Var.n(false);
                vl8Var.s(true);
                List<ul8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ul8 ul8Var = new ul8();
                ul8Var.e(vl8Var.c());
                ul8Var.d(z);
                ul8Var.f(vl8Var.e());
                list.add(ul8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return vl8Var;
        }
        return (vl8) invokeLLZ.objValue;
    }

    public abstract vl8 dispatch(xl8 xl8Var, vl8 vl8Var);

    public abstract List<vl8> processNotification(String str, HashMap hashMap);
}
