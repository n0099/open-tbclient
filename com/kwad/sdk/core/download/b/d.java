package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, AdTemplate adTemplate, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, adTemplate, i2)) == null) {
            if (adTemplate == null || context == null) {
                return 0;
            }
            int a2 = a(context, com.kwad.sdk.core.response.b.c.i(adTemplate).adConversionInfo.deeplinkUrl);
            if (a2 == 1) {
                com.kwad.sdk.core.report.a.a(adTemplate, i2);
            } else if (a2 == -1) {
                com.kwad.sdk.core.report.a.b(adTemplate, i2);
            }
            return a2;
        }
        return invokeLLI.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return 0;
            }
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setAction("android.intent.action.VIEW");
                parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    return 0;
                }
                context.startActivity(parseUri);
                return 1;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return -1;
            }
        }
        return invokeLL.intValue;
    }
}
