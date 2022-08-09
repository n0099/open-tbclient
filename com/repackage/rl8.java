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
public abstract class rl8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<sl8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public rl8() {
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

    public tl8 addObserver(String str, tl8 tl8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, tl8Var, z)) == null) {
            if (tl8Var == null) {
                tl8Var = new tl8();
            }
            if (this.mNotificationNameList.contains(str)) {
                tl8Var.n(false);
                tl8Var.s(true);
                List<sl8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                sl8 sl8Var = new sl8();
                sl8Var.e(tl8Var.c());
                sl8Var.d(z);
                sl8Var.f(tl8Var.e());
                list.add(sl8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return tl8Var;
        }
        return (tl8) invokeLLZ.objValue;
    }

    public abstract tl8 dispatch(vl8 vl8Var, tl8 tl8Var);

    public abstract List<tl8> processNotification(String str, HashMap hashMap);
}
