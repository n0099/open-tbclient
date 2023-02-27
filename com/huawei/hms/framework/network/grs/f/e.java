package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends HashSet<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2128805159, "Lcom/huawei/hms/framework/network/grs/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2128805159, "Lcom/huawei/hms/framework/network/grs/f/e;");
                return;
            }
        }
        b = Collections.unmodifiableSet(new a(16));
    }

    public static String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        InterceptResult invokeCommon;
        String[] split;
        String str2;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, aVar, str, grsBaseInfo, Boolean.valueOf(z)})) == null) {
            String serCountry = grsBaseInfo.getSerCountry();
            String regCountry = grsBaseInfo.getRegCountry();
            String issueCountry = grsBaseInfo.getIssueCountry();
            for (String str4 : str.split(">")) {
                if (b.contains(str4.trim())) {
                    if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                        str2 = a;
                        sb = new StringBuilder();
                        str3 = "current route_by is serCountry and routerCountry is:";
                    } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                        Logger.i(a, "current route_by is regCountry and routerCountry is:" + regCountry);
                        return regCountry;
                    } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                        Logger.i(a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                        return issueCountry;
                    } else if ("geo_ip".equals(str4.trim())) {
                        serCountry = new com.huawei.hms.framework.network.grs.g.b(context, aVar, grsBaseInfo).a(z);
                        str2 = a;
                        sb = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                    sb.append(str3);
                    sb.append(serCountry);
                    Logger.i(str2, sb.toString());
                    return serCountry;
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, aVar, str, grsBaseInfo, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                Logger.w(a, "routeBy must be not empty string or null.");
                return null;
            } else if ("no_route".equals(str) || "unconditional".equals(str)) {
                Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
                return "no_route_country";
            } else {
                return a(context, aVar, str, grsBaseInfo, z);
            }
        }
        return (String) invokeCommon.objValue;
    }
}
