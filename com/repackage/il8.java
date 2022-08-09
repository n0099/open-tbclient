package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class il8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wg a;
    public String b;
    public boolean c;

    public il8(String str) {
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
        ll8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || (c = c()) == null || c.f == null) {
            return;
        }
        long e = this.a.e();
        if (e > 3000) {
            kl8 kl8Var = c.f;
            kl8Var.a += e;
            kl8Var.b++;
            jl8.b(c, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        ll8 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.a == null || (c = c()) == null) {
            return;
        }
        if (z) {
            kl8 kl8Var = c.d;
            if (kl8Var == null) {
                return;
            }
            kl8Var.b++;
            if (z2) {
                kl8Var.a += j2;
                kl8Var.d += j;
            } else {
                kl8Var.c++;
            }
        } else {
            kl8 kl8Var2 = c.e;
            if (kl8Var2 == null) {
                return;
            }
            kl8Var2.b++;
            if (z2) {
                kl8Var2.a += j3;
                kl8Var2.d += j;
            } else {
                kl8Var2.c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            jl8.b(c, 10);
        }
        if (this.b == "frsStat") {
            if (!z2 || j2 > 3000) {
                wg wgVar = new wg("dbg");
                wgVar.b("act", "frs");
                wgVar.b(TiebaStatic.LogFields.RESULT, z2 ? "0" : "1");
                wgVar.b("isHttp", z ? "1" : "0");
                wgVar.b("timeCost", String.valueOf(j2));
                wgVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                wgVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                wgVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", wgVar);
            }
        }
    }

    public final ll8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? jl8.e(this.b, d(), this.c) : (ll8) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = oi.I();
            return I == 0 ? "N" : I == 1 ? "WIFI" : I == 3 ? "3G" : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.b = str;
            this.c = z;
            this.a = new wg("dbg");
            jl8.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g();
        }
    }
}
