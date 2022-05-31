package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class co5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<jn> b;
    public List<jn> c;
    public List<jn> d;
    public List<jn> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755790456, "Lcom/repackage/co5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755790456, "Lcom/repackage/co5;");
        }
    }

    public co5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<jn> list = this.c;
            if (list != null) {
                list.clear();
            }
            List<jn> list2 = this.d;
            if (list2 != null) {
                list2.clear();
            }
            List<jn> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
            List<jn> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final List<jn> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse != null && alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new yn5());
                }
                if (!ListUtils.isEmpty(this.d)) {
                    sp5 sp5Var = new sp5();
                    sp5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1b, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(sp5Var);
                }
                if (!ListUtils.isEmpty(this.d)) {
                    for (jn jnVar : this.d) {
                        arrayList.add(jnVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<jn> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                sp5 sp5Var = new sp5();
                sp5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1c, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(sp5Var);
            }
            if (!ListUtils.isEmpty(this.c)) {
                arrayList.addAll(f());
            } else if (z) {
                qp5 qp5Var = new qp5();
                qp5Var.a = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(qp5Var);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public final List<jn> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                sp5 sp5Var = new sp5();
                sp5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a20);
                arrayList.add(sp5Var);
                arrayList.addAll(g(this.e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void e(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, alaLiveTabMyConcernResponse, z) == null) || alaLiveTabMyConcernResponse == null) {
            return;
        }
        if (z) {
            this.b.clear();
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList)) {
            this.c.addAll(alaLiveTabMyConcernResponse.followList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
            this.d.addAll(alaLiveTabMyConcernResponse.followCloseList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
            this.e.addAll(alaLiveTabMyConcernResponse.recommendList);
        }
        this.b = i(alaLiveTabMyConcernResponse, z);
    }

    public final List<jn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.c)) {
                int size = this.c.size();
                for (int i = 0; i < size; i += 2) {
                    qn5 qn5Var = new qn5();
                    pm5 pm5Var = new pm5();
                    pm5Var.d = (ThreadData) this.c.get(i);
                    pm5Var.f = true;
                    qn5Var.a = pm5Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        pm5 pm5Var2 = new pm5();
                        pm5Var2.d = (ThreadData) this.c.get(i2);
                        qn5Var.b = pm5Var2;
                        pm5Var2.g = true;
                    } else {
                        pm5Var.f = false;
                        pm5Var.h = true;
                    }
                    int i3 = size % 2;
                    if ((i3 == 0 && i == size - 2) || (i3 != 0 && i == size - 1)) {
                        qn5Var.c = true;
                    }
                    arrayList.add(qn5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<jn> g(List<jn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i += 3) {
                    ao5 ao5Var = new ao5();
                    pm5 pm5Var = new pm5();
                    pm5Var.d = (ThreadData) list.get(i);
                    ao5Var.a = pm5Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        pm5 pm5Var2 = new pm5();
                        pm5Var2.d = (ThreadData) list.get(i2);
                        ao5Var.b = pm5Var2;
                    }
                    int i3 = i + 2;
                    if (i3 < size) {
                        pm5 pm5Var3 = new pm5();
                        pm5Var3.d = (ThreadData) list.get(i3);
                        ao5Var.c = pm5Var3;
                    }
                    arrayList.add(ao5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<jn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final List<jn> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<jn> c = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c)) {
                arrayList.addAll(c);
            }
            List<jn> b = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
            List<jn> d = d();
            if (!ListUtils.isEmpty(d)) {
                arrayList.addAll(d);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void j(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cls) == null) || ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int size = this.b.size() - 1; size >= 0; size--) {
            jn jnVar = (jn) ListUtils.getItem(this.b, size);
            if (jnVar != null && jnVar.getClass().equals(cls)) {
                this.b.remove(size);
            }
        }
    }

    public final boolean k(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, alaLiveTabMyConcernResponse)) == null) {
            if (alaLiveTabMyConcernResponse == null) {
                return false;
            }
            return (alaLiveTabMyConcernResponse.followStatus == 1 || bo5.a(this.a) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > f ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == f ? 0 : -1)) > 0)) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
