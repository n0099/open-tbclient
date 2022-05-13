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
public class up5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public to5 b;
    public no5 c;
    public qo5 d;
    public wo5 e;
    public List<ro> f;
    public List<ro> g;
    public List<SdkLiveInfoData> h;
    public List<ro> i;

    public up5(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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

    public boolean a(wo5 wo5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wo5Var)) == null) {
            if (wo5Var == null) {
                return false;
            }
            boolean g = g(wo5Var);
            this.a = wo5Var.a;
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
            List<ro> list = this.f;
            if (list != null) {
                list.clear();
            }
            List<ro> list2 = this.g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.h;
            if (list3 != null) {
                list3.clear();
            }
            List<ro> list4 = this.i;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final ArrayList<ro> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<ro> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                ro5 ro5Var = new ro5();
                un5 un5Var = new un5();
                un5Var.a = list.get(i);
                un5Var.f = true;
                ro5Var.a = un5Var;
                int i2 = i + 1;
                if (i2 < size) {
                    un5 un5Var2 = new un5();
                    un5Var2.a = list.get(i2);
                    ro5Var.b = un5Var2;
                    un5Var2.g = true;
                } else {
                    un5Var.f = false;
                    un5Var.h = true;
                }
                arrayList.add(ro5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<ro> d() {
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
            to5 to5Var = this.b;
            if (to5Var != null && to5Var.a()) {
                so5 so5Var = new so5();
                so5Var.a = this.b;
                this.f.add(so5Var);
            }
            if (this.c != null) {
                ArrayList<ro> f = f();
                if (!ListUtils.isEmpty(f)) {
                    this.f.addAll(f);
                }
            }
            qo5 qo5Var = this.d;
            if (qo5Var != null && !ListUtils.isEmpty(qo5Var.a)) {
                po5 po5Var = new po5();
                po5Var.a = this.d;
                this.f.add(po5Var);
            }
            this.g = new ArrayList(this.f);
            a(this.e);
        }
    }

    public final ArrayList<ro> f() {
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

    public final boolean g(wo5 wo5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wo5Var)) == null) {
            if (wo5Var == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = wo5Var.b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || io5.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.h.addAll(arrayList2);
            ArrayList<ro> c = c(this.h);
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
