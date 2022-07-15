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
/* loaded from: classes6.dex */
public class ns3 implements cm1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ms3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755458973, "Lcom/repackage/ns3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755458973, "Lcom/repackage/ns3;");
                return;
            }
        }
        b = rg1.a;
    }

    public ns3() {
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

    @Override // com.repackage.cm1
    public hs1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ld2 ld2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ld2Var)) == null) ? b(str, jSONObject, ld2Var) : (hs1) invokeLLL.objValue;
    }

    public final hs1 b(String str, JSONObject jSONObject, ld2 ld2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, ld2Var)) == null) {
            ms3 ms3Var = this.a.get(str);
            if (ms3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return ms3Var.a(jSONObject, ld2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new hs1(10002, "no such api.");
        }
        return (hs1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new ks3());
            d(new ls3());
            d(new ir3());
            d(new mr3());
            d(new jr3());
            d(new bt3());
            d(new kr3());
            d(new rs3());
            d(new ys3());
            d(new hr3());
            d(new or3());
            d(new lr3());
            d(new nr3());
            d(new us3());
            d(new at3());
            d(new vs3());
            d(new xs3());
            d(new ws3());
        }
    }

    public void d(ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ms3Var) == null) {
            if (b && TextUtils.isEmpty(ms3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(ms3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + ms3Var);
            }
            this.a.put(ms3Var.a, ms3Var);
        }
    }
}
