package com.repackage;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class b60 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755875179, "Lcom/repackage/b60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755875179, "Lcom/repackage/b60;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        c = hashMap;
        hashMap.put("WIFI", 1);
        c.put("3GNET", 21);
        c.put("3GWAP", 22);
        c.put("CMNET", 31);
        c.put("UNINET", 32);
        c.put("CTNET", 33);
        c.put("CMWAP", 41);
        c.put("UNIWAP", 42);
        c.put("CTWAP", 43);
    }

    public b60(Context context) {
        String upperCase;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        NetworkInfo a = c60.a(context);
        if (a != null) {
            if (!"wifi".equals(a.getTypeName().toLowerCase())) {
                String extraInfo = a.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.b = a.getSubtype();
            }
            "wifi".toUpperCase();
            this.a = upperCase;
            this.b = a.getSubtype();
        }
    }
}
