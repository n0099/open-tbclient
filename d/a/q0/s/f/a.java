package d.a.q0.s.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<e> f62599a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f62600b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<e> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f62599a == null) {
                this.f62599a = new ArrayList();
            }
            return this.f62599a;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(List<e> list, d.a.p0.t.f.a aVar) {
        InterceptResult invokeLL;
        List<d.a.p0.t.f.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, aVar)) == null) {
            if (list != null && aVar != null) {
                for (e eVar : list) {
                    if (eVar != null && (a2 = eVar.a()) != null) {
                        for (d.a.p0.t.f.a aVar2 : a2) {
                            if (aVar2 != null && aVar2.e() == aVar.e()) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean c(DataRes dataRes) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes)) == null) {
            if (dataRes == null || dataRes.robots_list == null) {
                z = false;
            } else {
                this.f62600b = new ArrayList();
                z = false;
                for (robotsList robotslist : dataRes.robots_list) {
                    if (TextUtils.isEmpty(robotslist.key)) {
                        z = true;
                    } else {
                        e eVar = new e();
                        eVar.d(robotslist);
                        this.f62600b.add(eVar);
                    }
                }
            }
            if (dataRes != null && dataRes.address_list != null) {
                this.f62599a = new ArrayList();
                for (listData listdata : dataRes.address_list) {
                    if (TextUtils.isEmpty(listdata.key)) {
                        z = true;
                    } else {
                        e eVar2 = new e();
                        eVar2.c(listdata);
                        if (eVar2.a() != null) {
                            for (d.a.p0.t.f.a aVar : eVar2.a()) {
                                if (b(this.f62600b, aVar)) {
                                    aVar.r(1);
                                } else {
                                    aVar.r(0);
                                }
                            }
                        }
                        this.f62599a.add(eVar2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
