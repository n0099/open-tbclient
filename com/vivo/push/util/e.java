package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(j));
            String b = z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
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
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65536, null, j, hashMap)) == null) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j);
            xVar.a(hashMap);
            xVar.d();
            com.vivo.push.e.a().a(xVar);
            return true;
        }
        return invokeJL.booleanValue;
    }
}
