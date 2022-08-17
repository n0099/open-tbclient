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
public abstract class ql8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<rl8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public ql8() {
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

    public sl8 addObserver(String str, sl8 sl8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, sl8Var, z)) == null) {
            if (sl8Var == null) {
                sl8Var = new sl8();
            }
            if (this.mNotificationNameList.contains(str)) {
                sl8Var.n(false);
                sl8Var.s(true);
                List<rl8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                rl8 rl8Var = new rl8();
                rl8Var.e(sl8Var.c());
                rl8Var.d(z);
                rl8Var.f(sl8Var.e());
                list.add(rl8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return sl8Var;
        }
        return (sl8) invokeLLZ.objValue;
    }

    public abstract sl8 dispatch(ul8 ul8Var, sl8 sl8Var);

    public abstract List<sl8> processNotification(String str, HashMap hashMap);
}
