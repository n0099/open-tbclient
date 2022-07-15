package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dj2;
import java.io.File;
/* loaded from: classes6.dex */
public class n52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755518586, "Lcom/repackage/n52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755518586, "Lcom/repackage/n52;");
                return;
            }
        }
        a = rg1.a;
    }

    public static m52 a(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
                return null;
            }
            File i = dj2.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
            if (!i.exists()) {
                if (a) {
                    Log.w("PrefetchUtils", "aiapp dir not exist ");
                }
                return null;
            }
            m52 m52Var = new m52();
            if (new File(i, "app.json").exists()) {
                if (a) {
                    Log.d("PrefetchUtils", "find main pkg's app config file");
                }
                m52Var.a = i;
                return m52Var;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                String g = zd3.g(str);
                int lastIndexOf = g.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    g = g.substring(0, lastIndexOf);
                }
                if (new File(i, g).exists()) {
                    int lastIndexOf2 = g.lastIndexOf(File.separator);
                    while (lastIndexOf2 >= 0) {
                        g = g.substring(0, lastIndexOf2);
                        if (new File(i, g + File.separator + "app.json").exists()) {
                            if (a) {
                                Log.d("PrefetchUtils", "isInDependentPkg=true, pagePath=" + g);
                            }
                            m52Var.b = true;
                            m52Var.c = g;
                            m52Var.a = new File(i, g);
                            return m52Var;
                        }
                        lastIndexOf2 = g.lastIndexOf(File.separator);
                    }
                    return null;
                }
                return null;
            }
        }
        return (m52) invokeLL.objValue;
    }
}
