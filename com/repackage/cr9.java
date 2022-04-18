package com.repackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final cr9 a;
    public static ConcurrentHashMap b;
    public static Context c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755787449, "Lcom/repackage/cr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755787449, "Lcom/repackage/cr9;");
                return;
            }
        }
        a = new cr9();
        b = new ConcurrentHashMap();
    }

    public cr9() {
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

    public static cr9 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            c = context.getApplicationContext();
            return a;
        }
        return (cr9) invokeL.objValue;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Long l = (Long) b.get(str);
            if (l == null || l.longValue() <= 0) {
                try {
                    String C = mr9.C(c);
                    if (!TextUtils.isEmpty(C)) {
                        JSONObject jSONObject = new JSONObject(C);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (TextUtils.equals(str, next)) {
                                return jSONObject.optLong(next, 0L);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0L;
            }
            return l.longValue();
        }
        return invokeL.longValue;
    }

    public void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            b.put(str, Long.valueOf(j));
            try {
                String C = mr9.C(c);
                JSONObject jSONObject = !TextUtils.isEmpty(C) ? new JSONObject(C) : new JSONObject();
                jSONObject.put(str, j);
                Context context = c;
                String jSONObject2 = jSONObject.toString();
                SharedPreferences.Editor edit = context.getSharedPreferences("res_prefs", 0).edit();
                edit.putString("key_local_res", jSONObject2);
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
