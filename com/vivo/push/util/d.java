package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.vivo.push.b.aa;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            p.d("ClientReportUtil", "report message: " + j2 + ", reportType: " + j3);
            aa aaVar = new aa(j3);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(j2));
            String b2 = z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
