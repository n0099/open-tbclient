package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class ConnectionFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnectionFactory() {
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

    public static HttpURLConnection createConnect(String str, Context context) {
        InterceptResult invokeLL;
        Proxy proxy;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, context)) == null) {
            if (!TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"))) {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    URL url = new URL(str);
                    Pair<String, Integer> apn = NetStateManager.getAPN();
                    if (apn != null) {
                        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue()));
                    } else {
                        proxy = null;
                    }
                    if (str.startsWith("http://")) {
                        if (proxy == null) {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                        } else {
                            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                        }
                    } else if (proxy == null) {
                        httpURLConnection = (HttpsURLConnection) url.openConnection();
                    } else {
                        httpURLConnection = (HttpsURLConnection) url.openConnection(proxy);
                    }
                    httpURLConnection2 = httpURLConnection;
                } catch (MalformedURLException | IOException unused) {
                }
                httpURLConnection2.setUseCaches(false);
                try {
                    httpURLConnection2.setRequestMethod("POST");
                } catch (ProtocolException unused2) {
                }
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection2.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.setConnectTimeout(25000);
                return httpURLConnection2;
            }
            throw new RuntimeException("非法url请求");
        }
        return (HttpURLConnection) invokeLL.objValue;
    }
}
