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
/* loaded from: classes7.dex */
public class rp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public qo5 b;
    public ko5 c;
    public no5 d;
    public to5 e;
    public List<uo> f;
    public List<uo> g;
    public List<SdkLiveInfoData> h;
    public List<uo> i;

    public rp5(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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

    public boolean a(to5 to5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, to5Var)) == null) {
            if (to5Var == null) {
                return false;
            }
            boolean g = g(to5Var);
            this.a = to5Var.a;
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
            List<uo> list = this.f;
            if (list != null) {
                list.clear();
            }
            List<uo> list2 = this.g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.h;
            if (list3 != null) {
                list3.clear();
            }
            List<uo> list4 = this.i;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final ArrayList<uo> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<uo> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                oo5 oo5Var = new oo5();
                rn5 rn5Var = new rn5();
                rn5Var.a = list.get(i);
                rn5Var.f = true;
                oo5Var.a = rn5Var;
                int i2 = i + 1;
                if (i2 < size) {
                    rn5 rn5Var2 = new rn5();
                    rn5Var2.a = list.get(i2);
                    oo5Var.b = rn5Var2;
                    rn5Var2.g = true;
                } else {
                    rn5Var.f = false;
                    rn5Var.h = true;
                }
                arrayList.add(oo5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<uo> d() {
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
            qo5 qo5Var = this.b;
            if (qo5Var != null && qo5Var.a()) {
                po5 po5Var = new po5();
                po5Var.a = this.b;
                this.f.add(po5Var);
            }
            if (this.c != null) {
                ArrayList<uo> f = f();
                if (!ListUtils.isEmpty(f)) {
                    this.f.addAll(f);
                }
            }
            no5 no5Var = this.d;
            if (no5Var != null && !ListUtils.isEmpty(no5Var.a)) {
                mo5 mo5Var = new mo5();
                mo5Var.a = this.d;
                this.f.add(mo5Var);
            }
            this.g = new ArrayList(this.f);
            a(this.e);
        }
    }

    public final ArrayList<uo> f() {
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

    public final boolean g(to5 to5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, to5Var)) == null) {
            if (to5Var == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = to5Var.b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || fo5.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.h.addAll(arrayList2);
            ArrayList<uo> c = c(this.h);
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
