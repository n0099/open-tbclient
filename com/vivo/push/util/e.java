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

    public static boolean a(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            p.d("ClientReportUtil", "report message: " + j2 + ", reportType: " + j3);
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j3);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(j2));
            String b2 = aa.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(long j2, HashMap<String, String> hashMap) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65536, null, j2, hashMap)) == null) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
            xVar.a(hashMap);
            xVar.d();
            com.vivo.push.e.a().a(xVar);
            return true;
        }
        return invokeJL.booleanValue;
    }
}
