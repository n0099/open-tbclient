package com.bytedance.sdk.openadsdk.q;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebView;
import com.bytedance.sdk.openadsdk.core.w;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Uri uri, w wVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, uri, wVar) == null) && wVar != null && wVar.a(uri)) {
            try {
                wVar.b(uri);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.k.d(WebView.LOGTAG, "TTAndroidObj handleUri exception: " + e2);
            }
        }
    }

    public static String a(android.webkit.WebView webView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, webView, i2)) == null) {
            if (webView == null) {
                return "";
            }
            String userAgentString = webView.getSettings().getUserAgentString();
            if (TextUtils.isEmpty(userAgentString)) {
                return "";
            }
            return userAgentString + " open_news open_news_u_s/" + i2;
        }
        return (String) invokeLI.objValue;
    }
}
