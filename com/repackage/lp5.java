package com.repackage;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class lp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ko5 b;
    public eo5 c;
    public ho5 d;
    public no5 e;
    public List<nn> f;
    public List<nn> g;
    public List<SdkLiveInfoData> h;
    public List<nn> i;

    public lp5(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaTabLiveResponsedMessage};
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
        this.b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.h = new ArrayList();
        this.i = new ArrayList();
        e();
    }

    public boolean a(no5 no5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, no5Var)) == null) {
            if (no5Var == null) {
                return false;
            }
            boolean g = g(no5Var);
            this.a = no5Var.a;
            return g;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = false;
            List<nn> list = this.f;
            if (list != null) {
                list.clear();
            }
            List<nn> list2 = this.g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.h;
            if (list3 != null) {
                list3.clear();
            }
            List<nn> list4 = this.i;
            if (list4 != null) {
                list4.clear();
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
                io5 io5Var = new io5();
                ln5 ln5Var = new ln5();
                ln5Var.a = list.get(i);
                ln5Var.f = true;
                io5Var.a = ln5Var;
                int i2 = i + 1;
                if (i2 < size) {
                    ln5 ln5Var2 = new ln5();
                    ln5Var2.a = list.get(i2);
                    io5Var.b = ln5Var2;
                    ln5Var2.g = true;
                } else {
                    ln5Var.f = false;
                    ln5Var.h = true;
                }
                arrayList.add(io5Var);
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
            if (!ListUtils.isEmpty(this.g)) {
                arrayList.addAll(this.g);
            }
            if (!ListUtils.isEmpty(this.i)) {
                arrayList.addAll(this.i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = new ArrayList();
            ko5 ko5Var = this.b;
            if (ko5Var != null && ko5Var.a()) {
                jo5 jo5Var = new jo5();
                jo5Var.a = this.b;
                this.f.add(jo5Var);
            }
            if (this.c != null) {
                ArrayList<nn> f = f();
                if (!ListUtils.isEmpty(f)) {
                    this.f.addAll(f);
                }
            }
            ho5 ho5Var = this.d;
            if (ho5Var != null && !ListUtils.isEmpty(ho5Var.a)) {
                go5 go5Var = new go5();
                go5Var.a = this.d;
                this.f.add(go5Var);
            }
            this.g = new ArrayList(this.f);
            a(this.e);
        }
    }

    public final ArrayList<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.c.a;
            if (arrayList == null || arrayList.size() < 2) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
                if (sdkLiveInfoData != null) {
                    arrayList2.add(sdkLiveInfoData);
                }
            }
            if (arrayList2.size() < 2) {
                return null;
            }
            return c(arrayList2);
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean g(no5 no5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, no5Var)) == null) {
            if (no5Var == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = no5Var.b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || zn5.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.h.addAll(arrayList2);
            ArrayList<nn> c = c(this.h);
            this.i = c;
            return !ListUtils.isEmpty(c);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
