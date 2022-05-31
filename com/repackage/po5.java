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
public class po5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public List<jn> d;
    public boolean e;
    public String f;
    public String g;

    public po5(pn5 pn5Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pn5Var, str, str2};
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
        a(pn5Var);
    }

    public boolean a(pn5 pn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pn5Var)) == null) {
            if (pn5Var == null) {
                return false;
            }
            boolean e = e(pn5Var.b);
            this.a = pn5Var.a;
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
            List<jn> list3 = this.d;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public final ArrayList<jn> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<jn> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                kn5 kn5Var = new kn5();
                nm5 nm5Var = new nm5();
                nm5Var.a = list.get(i);
                nm5Var.f = true;
                nm5Var.b = this.e;
                nm5Var.c = this.f;
                nm5Var.d = this.g;
                int i2 = i + 1;
                nm5Var.e = i2;
                kn5Var.a = nm5Var;
                if (i2 < size) {
                    nm5 nm5Var2 = new nm5();
                    nm5Var2.a = list.get(i2);
                    nm5Var2.b = this.e;
                    nm5Var2.c = this.f;
                    nm5Var2.d = this.g;
                    nm5Var2.e = i + 2;
                    kn5Var.b = nm5Var2;
                    nm5Var2.g = true;
                } else {
                    nm5Var.f = false;
                    nm5Var.h = true;
                }
                arrayList.add(kn5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<jn> d() {
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
            ArrayList<jn> c = c(this.c);
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
