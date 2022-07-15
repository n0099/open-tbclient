package com.kwad.components.core.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, adTemplate)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (com.kwad.sdk.core.response.a.a.i(i) || TextUtils.isEmpty(j.a(context, "com.tencent.mm"))) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{i.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, i.adConversionInfo.smallAppJumpInfo.originId, i.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
                if (cursor != null) {
                    com.kwad.sdk.crash.utils.b.a(cursor);
                }
                return true;
            } catch (Exception unused) {
                return false;
            } finally {
                com.kwad.sdk.crash.utils.b.a(cursor);
            }
        }
        return invokeLL.booleanValue;
    }
}
