package com.repackage;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
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
public class tp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public List<ro> d;

    public tp5(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(wo5 wo5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wo5Var)) == null) {
            if (wo5Var == null) {
                return false;
            }
            boolean e = e(wo5Var);
            this.a = wo5Var.a;
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
            List<ro> list3 = this.d;
            if (list3 != null) {
                list3.clear();
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
            if (!ListUtils.isEmpty(this.d)) {
                arrayList.addAll(this.d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(wo5 wo5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wo5Var)) == null) {
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
                if (next != null && io5.c(next)) {
                    String str = next.liveId;
                    if (!this.b.contains(str)) {
                        arrayList2.add(next);
                        this.b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.c.addAll(arrayList2);
            ArrayList<ro> c = c(this.c);
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
