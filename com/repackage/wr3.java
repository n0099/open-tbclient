package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wr3 extends mr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755191815, "Lcom/repackage/wr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755191815, "Lcom/repackage/wr3;");
                return;
            }
        }
        c = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr3() {
        super("GetSwanGameDuration");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean b(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    @Override // com.repackage.mr3
    public hr1 a(@NonNull JSONObject jSONObject, @NonNull lc2 lc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lc2Var)) == null) {
            if (jSONObject == null) {
                lc2Var.onFail(202, "params may be error");
                return null;
            }
            if (c) {
                Log.e("GetSwanGameDuration", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("swanGameId");
            if (TextUtils.isEmpty(optString)) {
                lc2Var.onFail(202, "params may be error");
            } else {
                p73 a = v73.a();
                if (!b(Long.valueOf(a.getLong(optString + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                    p73 a2 = v73.a();
                    a2.putLong(optString + "_Duration", 0L);
                }
                p73 a3 = v73.a();
                long j = a3.getLong(optString + "_Duration", 0L);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("swanGameDuration", j);
                    jSONObject2.put("data", jSONObject3);
                } catch (JSONException e) {
                    if (c) {
                        e.printStackTrace();
                    }
                }
                lc2Var.a(jSONObject2);
            }
            return null;
        }
        return (hr1) invokeLL.objValue;
    }
}
