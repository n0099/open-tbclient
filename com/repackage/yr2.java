package com.repackage;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class yr2 implements df4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755132264, "Lcom/repackage/yr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755132264, "Lcom/repackage/yr2;");
                return;
            }
        }
        c = cg1.a;
    }

    public yr2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = AppRuntime.getAppContext();
    }

    @Override // com.repackage.df4
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? zi2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dg1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public boolean c(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            oj1 g0 = zi2.g0();
            if (g0 != null) {
                g0.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
            }
            if (TextUtils.isEmpty("")) {
                return false;
            }
            try {
                i = new JSONObject("").getInt("probability");
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            return new Random().nextInt(100) < i;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.df4
    public ExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? zi2.z0().d() : (ExecutorService) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public void e(String str, int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, jSONArray) == null) {
            zi2.z0().e(str, i, jSONArray);
        }
    }

    @Override // com.repackage.df4
    public void f(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            zi2.z0().f(str, i);
        }
    }

    @Override // com.repackage.df4
    public void g(String str, String str2, int i, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)}) == null) {
            zi2.z0().g(str, str2, i, str3, i2);
        }
    }

    @Override // com.repackage.df4
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            sz2 D = fl2.U().D();
            return D != null ? D.b : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            sz2 D = fl2.U().D();
            return D != null ? D.Y().v1() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? zi2.h0().i(zi2.c()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.df4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            oj1 g0 = zi2.g0();
            return g0 != null ? g0.p() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public void i(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
            zi2.z0().i(str, i, str2);
        }
    }

    @Override // com.repackage.df4
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? zi2.g0().j() : invokeV.booleanValue;
    }

    @Override // com.repackage.df4
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            sz2 D = fl2.U().D();
            return D != null ? D.W().T() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? rz2.K().l() : invokeV.intValue;
    }

    @Override // com.repackage.df4
    public ef4 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? zi2.O().m() : (ef4) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? x83.h(l()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public void o(String str, String str2, int i, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            zi2.z0().o(str, str2, i, str3, j, i2);
        }
    }

    @Override // com.repackage.df4
    public String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? cg4.b(context).a() : (String) invokeL.objValue;
    }

    @Override // com.repackage.df4
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.b == null) {
                zi2.g0().getSwitch("swan_ceres_add_counter", false);
                this.b = false;
            }
            return this.b.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.df4
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? rv2.X() && (s() || cg1.b) : invokeV.booleanValue;
    }

    @Override // com.repackage.df4
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return c && PreferenceManager.getDefaultSharedPreferences(zi2.c()).getBoolean("KEY_UBC_DEBUG", true);
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.df4
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String b = zi2.n().b();
            if (md3.G() || TextUtils.isEmpty(b)) {
                return null;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? mw1.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.df4
    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? zi2.h0().h(zi2.c()) : (String) invokeL.objValue;
    }
}
