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
public abstract class ml8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<nl8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public ml8() {
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

    public ol8 addObserver(String str, ol8 ol8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, ol8Var, z)) == null) {
            if (ol8Var == null) {
                ol8Var = new ol8();
            }
            if (this.mNotificationNameList.contains(str)) {
                ol8Var.n(false);
                ol8Var.s(true);
                List<nl8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                nl8 nl8Var = new nl8();
                nl8Var.e(ol8Var.c());
                nl8Var.d(z);
                nl8Var.f(ol8Var.e());
                list.add(nl8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return ol8Var;
        }
        return (ol8) invokeLLZ.objValue;
    }

    public abstract ol8 dispatch(ql8 ql8Var, ol8 ol8Var);

    public abstract List<ol8> processNotification(String str, HashMap hashMap);
}
