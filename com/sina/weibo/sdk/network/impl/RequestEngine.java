package com.sina.weibo.sdk.network.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.base.RequestBodyHelper;
import com.sina.weibo.sdk.network.base.UriUtils;
import com.sina.weibo.sdk.network.base.WbResponse;
import com.sina.weibo.sdk.network.base.WbResponseBody;
import com.sina.weibo.sdk.network.exception.RequestException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class RequestEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static WbResponse request(IRequestParam iRequestParam) throws RequestException {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iRequestParam)) == null) {
            String url = iRequestParam.getUrl();
            if (!TextUtils.isEmpty(url) && (url.startsWith("http") || url.startsWith("https"))) {
                String buildCompleteUri = UriUtils.buildCompleteUri(url, iRequestParam.getGetBundle());
                Pair<String, Integer> apn = NetStateManager.getAPN();
                Proxy proxy = apn != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue())) : null;
                try {
                    URL url2 = new URL(buildCompleteUri);
                    if ("https".startsWith(buildCompleteUri)) {
                        if (proxy == null) {
                            httpURLConnection = (HttpsURLConnection) url2.openConnection();
                        } else {
                            httpURLConnection = (HttpsURLConnection) url2.openConnection(proxy);
                        }
                    } else if (proxy == null) {
                        httpURLConnection = (HttpURLConnection) url2.openConnection();
                    } else {
                        httpURLConnection = (HttpURLConnection) url2.openConnection(proxy);
                    }
                    setRequestHeader(httpURLConnection, iRequestParam.getHeader());
                    Bundle bundle = new Bundle();
                    String str = "------------" + RequestBodyHelper.getBoundry();
                    if (iRequestParam.getMethod() == IRequestParam.RequestType.POST) {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                        httpURLConnection.setUseCaches(false);
                        if (iRequestParam.getPostBundle().getByteArray(RequestParam.KEY_PARAM_BODY_BYTE_ARRAY) != null) {
                            bundle.putString("Content-Type", "application/octet-stream");
                        } else if (RequestBodyHelper.isMultipartRequest(iRequestParam)) {
                            bundle.putString("Content-Type", "multipart/form-data;boundary=" + str);
                        } else {
                            bundle.putString("Content-Type", "application/x-www-form-urlencoded");
                        }
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                    } else if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
                        httpURLConnection.setRequestMethod("GET");
                    } else if (iRequestParam.getMethod() == IRequestParam.RequestType.PATCH) {
                        httpURLConnection.setRequestMethod("PATCH");
                    }
                    httpURLConnection.setReadTimeout(iRequestParam.getResponseTimeout());
                    httpURLConnection.setConnectTimeout(iRequestParam.getRequestTimeout());
                    setRequestHeader(httpURLConnection, bundle);
                    httpURLConnection.connect();
                    if (iRequestParam.getMethod() != IRequestParam.RequestType.GET) {
                        RequestBodyHelper.fillRequestBody(iRequestParam, httpURLConnection, str);
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        return new WbResponse(new WbResponseBody(httpURLConnection.getInputStream(), httpURLConnection.getContentLength()));
                    }
                    if (responseCode != 302 && responseCode != 301) {
                        WbResponseBody wbResponseBody = new WbResponseBody(httpURLConnection.getErrorStream(), httpURLConnection.getContentLength());
                        throw new RequestException("服务器异常" + wbResponseBody.string());
                    }
                    iRequestParam.setUrl(httpURLConnection.getHeaderField("Location"));
                    return request(iRequestParam);
                } catch (MalformedURLException e2) {
                    LogUtil.v("weibosdk", e2.toString());
                    throw new RequestException("请求异常" + e2.toString());
                } catch (IOException e3) {
                    LogUtil.v("weibosdk", e3.toString());
                    throw new RequestException("请求异常" + e3.toString());
                }
            }
            throw new RequestException("非法的请求地址");
        }
        return (WbResponse) invokeL.objValue;
    }

    public static void setRequestHeader(HttpURLConnection httpURLConnection, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, httpURLConnection, bundle) == null) || bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }
}
