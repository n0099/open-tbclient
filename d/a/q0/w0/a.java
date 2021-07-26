package d.a.q0.w0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66361a;

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

    public static a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && d()) {
                return new a();
            }
            return null;
        }
        return (a) invokeZ.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d.a.p0.b.d.x() : invokeV.booleanValue;
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, frsTabInfo, i2)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                return false;
            }
            if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
                return false;
            }
            return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i2 == 2) ? false : true;
        }
        return invokeLI.booleanValue;
    }

    public void b(List<n> list, boolean z, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), str}) == null) {
            int e2 = d.a.q0.v0.a.i().e();
            if (z) {
                i2 = d.a.q0.v0.a.i().f() - 1;
                for (n nVar : list) {
                    if (nVar instanceof b2) {
                        if (((b2) nVar).n0() != 1) {
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                i2 = this.f66361a;
            }
            this.f66361a = c(i2, e2, list, str);
        }
    }

    public final int c(int i2, int i3, List<n> list, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, str})) == null) {
            if (list == null || list.size() == 0 || i2 > list.size() - 1) {
                return 0;
            }
            for (int i4 = 0; i4 < list.size(); i4++) {
                b2 b2Var = new b2();
                d.a.q0.h3.h0.n nVar = new d.a.q0.h3.h0.n();
                nVar.k(true);
                b2Var.G2 = nVar;
                nVar.j(str);
                list.add(i2, b2Var);
                i2 = i2 + i3 + 1;
                if (i2 > list.size() - 1) {
                    return (i2 - (list.size() - 1)) - 1;
                }
            }
            return 0;
        }
        return invokeCommon.intValue;
    }
}
