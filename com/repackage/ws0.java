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
import com.repackage.ds0;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ws0 extends pv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public ws0() {
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

    @Override // com.repackage.pv0, com.repackage.js0
    public void a(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ir0Var) == null) {
            p(ir0Var);
        }
    }

    @Override // com.repackage.pv0, com.repackage.js0
    public void d(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ir0Var) == null) {
            p(ir0Var);
        }
    }

    @Override // com.repackage.js0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{2, 4, 6} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.pv0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            this.d.clear();
            this.e.clear();
        }
    }

    public final void p(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ir0Var) == null) && w()) {
            wu0 wu0Var = new wu0();
            wu0Var.h(ir0.a(ir0Var));
            wu0Var.b(v());
            wu0Var.c(s());
            wu0Var.d(r());
            wu0Var.e(u());
            wu0Var.g(t());
            po0 po0Var = (po0) i();
            BdVideoSeries o1 = po0Var == null ? null : po0Var.o1();
            if (o1 != null) {
                String extLog = o1.getExtLog();
                String str = this.d.get(extLog);
                String str2 = this.e.get(extLog);
                if (str == null) {
                    JSONObject c = lx0.c(extLog);
                    String optString = c.optString("ad_extra_param");
                    String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                    this.d.put(extLog, optString);
                    this.e.put(extLog, optString2);
                    str2 = optString2;
                    str = optString;
                }
                wu0Var.f(str);
                wu0Var.a(str2);
            }
            ds0.a.a().a(wu0Var);
            ds0.a.a().b(wu0Var);
            ir0 ir0Var2 = wu0Var.a;
            if (ir0Var2 != null) {
                ir0Var2.o();
            }
        }
    }

    @Override // com.repackage.pv0, com.repackage.js0
    public void q(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ir0Var) == null) {
            p(ir0Var);
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((i() instanceof po0) && ((po0) i()).l1() == 0) ? "1" : "0" : (String) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (i() instanceof po0) {
                po0 po0Var = (po0) i();
                return (po0Var.o1() == null || TextUtils.isEmpty(po0Var.o1().getExtLog())) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
