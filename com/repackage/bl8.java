package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ug a;
    public String b;
    public boolean c;

    public bl8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        e(str, false);
    }

    public void a() {
        el8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || (c = c()) == null || c.f == null) {
            return;
        }
        long e = this.a.e();
        if (e > 3000) {
            dl8 dl8Var = c.f;
            dl8Var.a += e;
            dl8Var.b++;
            cl8.b(c, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        el8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            dl8 dl8Var = c.d;
            if (dl8Var == null) {
                return;
            }
            dl8Var.b++;
            if (z2) {
                dl8Var.a += j2;
                dl8Var.d += j;
            } else {
                dl8Var.c++;
            }
        } else {
            dl8 dl8Var2 = c.e;
            if (dl8Var2 == null) {
                return;
            }
            dl8Var2.b++;
            if (z2) {
                dl8Var2.a += j3;
                dl8Var2.d += j;
            } else {
                dl8Var2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            cl8.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                ug ugVar = new ug("dbg");
                ugVar.b("act", "frs");
                ugVar.b("result", z2 ? "0" : "1");
                ugVar.b("isHttp", z ? "1" : "0");
                ugVar.b("timeCost", String.valueOf(j2));
                ugVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                ugVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                ugVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", ugVar);
            }
        }
    }

    public final el8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? cl8.e(this.b, d(), this.c) : (el8) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = mi.I();
            return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? "3G" : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.b = str;
            this.c = z;
            this.a = new ug("dbg");
            cl8.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g();
        }
    }
}
