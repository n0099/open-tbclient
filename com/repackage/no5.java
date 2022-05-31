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
public class no5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public mn5 b;
    public gn5 c;
    public jn5 d;
    public pn5 e;
    public List<jn> f;
    public List<jn> g;
    public List<SdkLiveInfoData> h;
    public List<jn> i;

    public no5(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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

    public boolean a(pn5 pn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pn5Var)) == null) {
            if (pn5Var == null) {
                return false;
            }
            boolean g = g(pn5Var);
            this.a = pn5Var.a;
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
            List<jn> list = this.f;
            if (list != null) {
                list.clear();
            }
            List<jn> list2 = this.g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.h;
            if (list3 != null) {
                list3.clear();
            }
            List<jn> list4 = this.i;
            if (list4 != null) {
                list4.clear();
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
                kn5Var.a = nm5Var;
                int i2 = i + 1;
                if (i2 < size) {
                    nm5 nm5Var2 = new nm5();
                    nm5Var2.a = list.get(i2);
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
            mn5 mn5Var = this.b;
            if (mn5Var != null && mn5Var.a()) {
                ln5 ln5Var = new ln5();
                ln5Var.a = this.b;
                this.f.add(ln5Var);
            }
            if (this.c != null) {
                ArrayList<jn> f = f();
                if (!ListUtils.isEmpty(f)) {
                    this.f.addAll(f);
                }
            }
            jn5 jn5Var = this.d;
            if (jn5Var != null && !ListUtils.isEmpty(jn5Var.a)) {
                in5 in5Var = new in5();
                in5Var.a = this.d;
                this.f.add(in5Var);
            }
            this.g = new ArrayList(this.f);
            a(this.e);
        }
    }

    public final ArrayList<jn> f() {
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

    public final boolean g(pn5 pn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pn5Var)) == null) {
            if (pn5Var == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = pn5Var.b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || bn5.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.h.addAll(arrayList2);
            ArrayList<jn> c = c(this.h);
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
