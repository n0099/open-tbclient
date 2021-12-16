package com.kwad.sdk.core.videocache.kwai;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.videocache.l;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes3.dex */
public class f implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
        }
        return (String) invokeL.objValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse.getHost() == null || !parse.getHost().contains("yximgs.com")) {
                return str;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            HashMap hashMap = new HashMap();
            if (parse.isHierarchical()) {
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                for (String str2 : queryParameterNames) {
                    hashMap.put(str2, parse.getQueryParameter(str2));
                }
                buildUpon.clearQuery();
                for (String str3 : queryParameterNames) {
                    if (!"tag".equals(str3) && !AppIconSetting.DEFAULT_LARGE_ICON.equals(str3) && str3 != null) {
                        buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                    }
                }
            }
            return buildUpon.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.c
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str);
            String b2 = b(c2);
            String d2 = l.d(c2);
            if (TextUtils.isEmpty(b2)) {
                return d2;
            }
            return d2 + "." + b2;
        }
        return (String) invokeL.objValue;
    }
}
