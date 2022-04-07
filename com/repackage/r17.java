package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
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
public class r17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    public r17() {
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

    public p17 a(boolean z, n17 n17Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, n17Var)) == null) {
            p17 p17Var = new p17();
            p17Var.c = n17Var.i();
            p17Var.e = n17Var.a();
            p17Var.f = n17Var.c();
            ArrayList<ThreadData> h = n17Var.h();
            if (z) {
                if (!ListUtils.isEmpty(h)) {
                    this.a.clear();
                    this.a.addAll(h);
                }
            } else if (!ListUtils.isEmpty(h)) {
                this.a.addAll(h);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            m07.e(true, arrayList, n17Var.e());
            m07.e(true, arrayList, n17Var.f());
            m07.e(true, arrayList, n17Var.d());
            m07.e(true, arrayList, n17Var.g());
            p17Var.a = m07.c(arrayList);
            return p17Var;
        }
        return (p17) invokeZL.objValue;
    }

    public List<ThreadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
