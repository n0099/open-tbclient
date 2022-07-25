package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class uj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vj4 a;

    public uj4() {
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
        this.a = new vj4();
    }

    public tj4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = null;
            if (oi.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("\\$[0-9A-Za-z@_]{5,300}[#$]", 2).matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                Matcher matcher2 = Pattern.compile("\\$[0-9A-Za-z@_]{1,100}[!]", 2).matcher(str);
                String d = matcher2.find() ? xj4.d(matcher2.group()) : null;
                if (d != null && d.startsWith("Y")) {
                    wj4.a(d);
                    str2 = b(group);
                }
                return new tj4(group, str2, d);
            }
            return null;
        }
        return (tj4) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.a.a(xj4.f(str.replaceAll("\\$", "")));
        }
        return (String) invokeL.objValue;
    }
}
