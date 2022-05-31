package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zr0;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ss0 extends lv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public ss0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashMap<>();
        this.e = new HashMap<>();
    }

    @Override // com.repackage.lv0, com.repackage.fs0
    public void a(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, er0Var) == null) {
            p(er0Var);
        }
    }

    @Override // com.repackage.lv0, com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, er0Var) == null) {
            p(er0Var);
        }
    }

    @Override // com.repackage.fs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{2, 4, 6} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.lv0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            this.d.clear();
            this.e.clear();
        }
    }

    public final void p(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, er0Var) == null) && w()) {
            su0 su0Var = new su0();
            su0Var.h(er0.a(er0Var));
            su0Var.b(v());
            su0Var.c(s());
            su0Var.d(q());
            su0Var.e(u());
            su0Var.g(t());
            lo0 lo0Var = (lo0) i();
            BdVideoSeries o1 = lo0Var == null ? null : lo0Var.o1();
            if (o1 != null) {
                String extLog = o1.getExtLog();
                String str = this.d.get(extLog);
                String str2 = this.e.get(extLog);
                if (str == null) {
                    JSONObject c = hx0.c(extLog);
                    String optString = c.optString("ad_extra_param");
                    String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                    this.d.put(extLog, optString);
                    this.e.put(extLog, optString2);
                    str2 = optString2;
                    str = optString;
                }
                su0Var.f(str);
                su0Var.a(str2);
            }
            zr0.a.a().a(su0Var);
            zr0.a.a().b(su0Var);
            er0 er0Var2 = su0Var.a;
            if (er0Var2 != null) {
                er0Var2.o();
            }
        }
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null && i().K().e > 0) {
                return String.valueOf(i().K().e);
            }
            return String.valueOf(i().r());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lv0, com.repackage.fs0
    public void r(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
            p(er0Var);
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i() == null ? "0" : String.valueOf(i().C()) : (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i() == null ? "0" : String.valueOf(i().D()) : (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().K() != null ? i().K().d : 0);
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((i() instanceof lo0) && ((lo0) i()).l1() == 0) ? "1" : "0" : (String) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (i() instanceof lo0) {
                lo0 lo0Var = (lo0) i();
                return (lo0Var.o1() == null || TextUtils.isEmpty(lo0Var.o1().getExtLog())) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
