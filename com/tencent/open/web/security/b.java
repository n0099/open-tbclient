package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends com.tencent.open.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.tencent.open.a
    public void a(String str, String str2, List<String> list, a.C0702a c0702a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, list, c0702a) == null) {
            SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                try {
                    list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            a.b bVar = this.a.get(str);
            if (bVar != null) {
                SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
                bVar.call(str2, list, c0702a);
                return;
            }
            SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
            if (c0702a != null) {
                c0702a.a();
            }
        }
    }

    @Override // com.tencent.open.a
    public boolean a(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
            if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
                ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
                if (arrayList.size() < 7) {
                    return false;
                }
                String str2 = (String) arrayList.get(2);
                String str3 = (String) arrayList.get(3);
                String str4 = (String) arrayList.get(4);
                String str5 = (String) arrayList.get(5);
                SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    try {
                        a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new c(webView, Long.parseLong(str4), str, str5));
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
