package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public List<nn> d;
    public boolean e;
    public String f;
    public String g;

    public mq5(pp5 pp5Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pp5Var, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.e = false;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.e = true;
        }
        this.f = str;
        this.g = str2;
        a(pp5Var);
    }

    public boolean a(pp5 pp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pp5Var)) == null) {
            if (pp5Var == null) {
                return false;
            }
            boolean e = e(pp5Var.b);
            this.a = pp5Var.a;
            return e;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.c;
            if (list2 != null) {
                list2.clear();
            }
            List<nn> list3 = this.d;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public final ArrayList<nn> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<nn> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                lp5 lp5Var = new lp5();
                oo5 oo5Var = new oo5();
                oo5Var.a = list.get(i);
                oo5Var.f = true;
                oo5Var.b = this.e;
                oo5Var.c = this.f;
                oo5Var.d = this.g;
                int i2 = i + 1;
                oo5Var.e = i2;
                lp5Var.a = oo5Var;
                if (i2 < size) {
                    oo5 oo5Var2 = new oo5();
                    oo5Var2.a = list.get(i2);
                    oo5Var2.b = this.e;
                    oo5Var2.c = this.f;
                    oo5Var2.d = this.g;
                    oo5Var2.e = i + 2;
                    lp5Var.b = oo5Var2;
                    oo5Var2.g = true;
                } else {
                    oo5Var.f = false;
                    oo5Var.h = true;
                }
                arrayList.add(lp5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<nn> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.d)) {
                arrayList.addAll(this.d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : list) {
                if (sdkLiveInfoData != null) {
                    String str = sdkLiveInfoData.liveId;
                    if (!this.b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.c.addAll(arrayList);
            ArrayList<nn> c = c(this.c);
            this.d = c;
            return !ListUtils.isEmpty(c);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
