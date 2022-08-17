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
/* loaded from: classes7.dex */
public class ur5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<on> b;
    public List<on> c;
    public List<on> d;
    public List<on> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755251335, "Lcom/repackage/ur5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755251335, "Lcom/repackage/ur5;");
        }
    }

    public ur5(TbPageContext tbPageContext) {
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
            List<on> list = this.c;
            if (list != null) {
                list.clear();
            }
            List<on> list2 = this.d;
            if (list2 != null) {
                list2.clear();
            }
            List<on> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
            List<on> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final List<on> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse != null && alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new qr5());
                }
                if (!ListUtils.isEmpty(this.d)) {
                    gt5 gt5Var = new gt5();
                    gt5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a19, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(gt5Var);
                }
                if (!ListUtils.isEmpty(this.d)) {
                    for (on onVar : this.d) {
                        arrayList.add(onVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<on> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                gt5 gt5Var = new gt5();
                gt5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1a, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gt5Var);
            }
            if (!ListUtils.isEmpty(this.c)) {
                arrayList.addAll(f());
            } else if (z) {
                et5 et5Var = new et5();
                et5Var.a = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(et5Var);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public final List<on> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                gt5 gt5Var = new gt5();
                gt5Var.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1e);
                arrayList.add(gt5Var);
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

    public final List<on> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.c)) {
                int size = this.c.size();
                for (int i = 0; i < size; i += 2) {
                    ir5 ir5Var = new ir5();
                    iq5 iq5Var = new iq5();
                    iq5Var.d = (ThreadData) this.c.get(i);
                    iq5Var.f = true;
                    ir5Var.a = iq5Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        iq5 iq5Var2 = new iq5();
                        iq5Var2.d = (ThreadData) this.c.get(i2);
                        ir5Var.b = iq5Var2;
                        iq5Var2.g = true;
                    } else {
                        iq5Var.f = false;
                        iq5Var.h = true;
                    }
                    int i3 = size % 2;
                    if ((i3 == 0 && i == size - 2) || (i3 != 0 && i == size - 1)) {
                        ir5Var.c = true;
                    }
                    arrayList.add(ir5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<on> g(List<on> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i += 3) {
                    sr5 sr5Var = new sr5();
                    iq5 iq5Var = new iq5();
                    iq5Var.d = (ThreadData) list.get(i);
                    sr5Var.a = iq5Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        iq5 iq5Var2 = new iq5();
                        iq5Var2.d = (ThreadData) list.get(i2);
                        sr5Var.b = iq5Var2;
                    }
                    int i3 = i + 2;
                    if (i3 < size) {
                        iq5 iq5Var3 = new iq5();
                        iq5Var3.d = (ThreadData) list.get(i3);
                        sr5Var.c = iq5Var3;
                    }
                    arrayList.add(sr5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<on> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final List<on> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<on> c = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c)) {
                arrayList.addAll(c);
            }
            List<on> b = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
            List<on> d = d();
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
            on onVar = (on) ListUtils.getItem(this.b, size);
            if (onVar != null && onVar.getClass().equals(cls)) {
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
            return (alaLiveTabMyConcernResponse.followStatus == 1 || tr5.a(this.a) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > f ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == f ? 0 : -1)) > 0)) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
