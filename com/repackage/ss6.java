package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ss6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;
    public jm7 b;

    public ss6() {
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
        this.a = new ArrayList();
    }

    public final void a(v07 v07Var) {
        jm7 jm7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v07Var) == null) || (jm7Var = this.b) == null || ListUtils.isEmpty(jm7Var.b)) {
            return;
        }
        v07Var.a.add(0, this.b);
    }

    public v07 b(int i, boolean z, rs6 rs6Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), rs6Var})) == null) {
            v07 v07Var = new v07();
            v07Var.c = rs6Var.f();
            v07Var.e = rs6Var.a();
            v07Var.f = rs6Var.b();
            ArrayList<ThreadData> e = rs6Var.e();
            if (z) {
                this.b = rs6Var.d();
                if (!ListUtils.isEmpty(e)) {
                    this.a.clear();
                    this.a.addAll(e);
                    v07Var.d = 1;
                }
            } else if (!ListUtils.isEmpty(e)) {
                this.a.addAll(e);
                v07Var.d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            sz6.h(true, arrayList, rs6Var.c());
            v07Var.a = sz6.c(arrayList);
            a(v07Var);
            jm7 jm7Var = this.b;
            if (jm7Var != null && jm7Var.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                v07Var.a.add(0, new s07());
            }
            return v07Var;
        }
        return (v07) invokeCommon.objValue;
    }

    public List<ThreadData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
