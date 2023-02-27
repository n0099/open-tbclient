package com.vivo.push.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            u.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(j));
            String a = com.vivo.push.d.a.a().e().a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("remoteAppId", a);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(long j, HashMap<String, String> hashMap) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, hashMap)) == null) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j);
            xVar.a(hashMap);
            xVar.d();
            com.vivo.push.e.a().a(xVar);
            return true;
        }
        return invokeJL.booleanValue;
    }
}
