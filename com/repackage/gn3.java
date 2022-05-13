package com.repackage;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class gn3 implements hg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755672315, "Lcom/repackage/gn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755672315, "Lcom/repackage/gn3;");
                return;
            }
        }
        a = eh1.a;
    }

    public gn3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.hg4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            ln3 ln3Var = new ln3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", zf4.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", zf4.g().p(AppRuntime.getApplication()));
            kn3.d().g(hashMap, jSONArray.toString().getBytes(), null, ln3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + ln3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + ln3Var.b);
            }
            int i = ln3Var.a;
            if (i == 1 || i == 2 || i == 4) {
                sg4.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
