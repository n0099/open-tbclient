package com.kwad.sdk.emotion.b;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.services.vod.VodClient;
import com.kwad.sdk.emotion.model.CDNUrl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (URLUtil.isNetworkUrl(str)) {
                return true;
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return true;
            }
            return TextUtils.equals("content", Uri.parse(str).getScheme()) && TextUtils.equals(VodClient.PATH_MEDIA, Uri.parse(str).getHost());
        }
        return invokeL.booleanValue;
    }

    public static String[] a(List<CDNUrl> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (CDNUrl cDNUrl : list) {
                    if (a(cDNUrl.getUrl()) && !arrayList.contains(cDNUrl.getUrl())) {
                        arrayList.add(cDNUrl.getUrl());
                    }
                }
            }
            if (a(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeLL.objValue;
    }
}
