package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yr3 implements nl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, xr3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755132233, "Lcom/repackage/yr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755132233, "Lcom/repackage/yr3;");
                return;
            }
        }
        b = cg1.a;
    }

    public yr3() {
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
        this.a = new HashMap<>();
        c();
    }

    @Override // com.repackage.nl1
    public sr1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull wc2 wc2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, wc2Var)) == null) ? b(str, jSONObject, wc2Var) : (sr1) invokeLLL.objValue;
    }

    public final sr1 b(String str, JSONObject jSONObject, wc2 wc2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, wc2Var)) == null) {
            xr3 xr3Var = this.a.get(str);
            if (xr3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return xr3Var.a(jSONObject, wc2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new sr1(10002, "no such api.");
        }
        return (sr1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new vr3());
            d(new wr3());
            d(new tq3());
            d(new xq3());
            d(new uq3());
            d(new ms3());
            d(new vq3());
            d(new cs3());
            d(new js3());
            d(new sq3());
            d(new zq3());
            d(new wq3());
            d(new yq3());
            d(new fs3());
            d(new ls3());
            d(new gs3());
            d(new is3());
            d(new hs3());
        }
    }

    public void d(xr3 xr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xr3Var) == null) {
            if (b && TextUtils.isEmpty(xr3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(xr3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + xr3Var);
            }
            this.a.put(xr3Var.a, xr3Var);
        }
    }
}
