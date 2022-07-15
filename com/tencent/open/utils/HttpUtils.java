package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.l;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HttpUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class HttpStatusException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ERROR_INFO = "http status code error:";
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HttpStatusException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = objArr;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class NetworkUnavailableException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ERROR_INFO = "network unavailable";
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkUnavailableException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = objArr;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final int b;

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = objArr;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }
    }

    public HttpUtils() {
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

    public static void a(Context context, QQToken qQToken, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, qQToken, str) == null) {
            if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
                com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 11) {
                if (context != null) {
                    String host = Proxy.getHost(context);
                    return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
                }
                return Proxy.getDefaultHost();
            }
            return System.getProperty("http.proxyHost");
        }
        return (String) invokeL.objValue;
    }

    public static String encodePostBody(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bundle, str)) == null) {
            if (bundle == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = -1;
            int size = bundle.size();
            for (String str2 : bundle.keySet()) {
                i++;
                Object obj = bundle.get(str2);
                if (obj instanceof String) {
                    sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                    if (i < size - 1) {
                        sb.append("\r\n--" + str + "\r\n");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String encodeUrl(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bundle)) == null) {
            if (bundle == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if ((obj instanceof String) || (obj instanceof String[])) {
                    if (obj instanceof String[]) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(str) + "=");
                        String[] stringArray = bundle.getStringArray(str);
                        if (stringArray != null) {
                            for (int i = 0; i < stringArray.length; i++) {
                                if (i == 0) {
                                    sb.append(URLEncoder.encode(stringArray[i]));
                                } else {
                                    sb.append(URLEncoder.encode("," + stringArray[i]));
                                }
                            }
                        }
                    } else {
                        if (z) {
                            z = false;
                        } else {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getErrorCodeFromException(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iOException)) == null) {
            if (iOException instanceof CharConversionException) {
                return -20;
            }
            if (iOException instanceof MalformedInputException) {
                return -21;
            }
            if (iOException instanceof UnmappableCharacterException) {
                return -22;
            }
            if (iOException instanceof HttpResponseException) {
                return -23;
            }
            if (iOException instanceof ClosedChannelException) {
                return -24;
            }
            if (iOException instanceof ConnectionClosedException) {
                return -25;
            }
            if (iOException instanceof EOFException) {
                return -26;
            }
            if (iOException instanceof FileLockInterruptionException) {
                return -27;
            }
            if (iOException instanceof FileNotFoundException) {
                return -28;
            }
            if (iOException instanceof HttpRetryException) {
                return -29;
            }
            if (iOException instanceof ConnectTimeoutException) {
                return -7;
            }
            if (iOException instanceof SocketTimeoutException) {
                return -8;
            }
            if (iOException instanceof InvalidPropertiesFormatException) {
                return -30;
            }
            if (iOException instanceof MalformedChunkCodingException) {
                return -31;
            }
            if (iOException instanceof MalformedURLException) {
                return -3;
            }
            if (iOException instanceof NoHttpResponseException) {
                return -32;
            }
            if (iOException instanceof InvalidClassException) {
                return -33;
            }
            if (iOException instanceof InvalidObjectException) {
                return -34;
            }
            if (iOException instanceof NotActiveException) {
                return -35;
            }
            if (iOException instanceof NotSerializableException) {
                return -36;
            }
            if (iOException instanceof OptionalDataException) {
                return -37;
            }
            if (iOException instanceof StreamCorruptedException) {
                return -38;
            }
            if (iOException instanceof WriteAbortedException) {
                return -39;
            }
            if (iOException instanceof ProtocolException) {
                return -40;
            }
            if (iOException instanceof SSLHandshakeException) {
                return -41;
            }
            if (iOException instanceof SSLKeyException) {
                return -42;
            }
            if (iOException instanceof SSLPeerUnverifiedException) {
                return -43;
            }
            if (iOException instanceof SSLProtocolException) {
                return -44;
            }
            if (iOException instanceof BindException) {
                return -45;
            }
            if (iOException instanceof ConnectException) {
                return -46;
            }
            if (iOException instanceof NoRouteToHostException) {
                return -47;
            }
            if (iOException instanceof PortUnreachableException) {
                return -48;
            }
            if (iOException instanceof SyncFailedException) {
                return -49;
            }
            if (iOException instanceof UTFDataFormatException) {
                return -50;
            }
            if (iOException instanceof UnknownHostException) {
                return -51;
            }
            if (iOException instanceof UnknownServiceException) {
                return -52;
            }
            if (iOException instanceof UnsupportedEncodingException) {
                return -53;
            }
            return iOException instanceof ZipException ? -54 : -2;
        }
        return invokeL.intValue;
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                    socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    schemeRegistry.register(new Scheme("https", socketFactory, 443));
                } else {
                    schemeRegistry.register(new Scheme("https", new k(), 443));
                }
            } catch (Exception unused) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            g a2 = context != null ? g.a(context, str) : null;
            int i2 = 0;
            if (a2 != null) {
                i2 = a2.a("Common_HttpConnectionTimeout");
                i = a2.a("Common_SocketConnectionTimeout");
            } else {
                i = 0;
            }
            if (i2 == 0) {
                i2 = 15000;
            }
            if (i == 0) {
                i = 30000;
            }
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, i2);
            HttpConnectionParams.setSoTimeout(basicHttpParams, i);
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            a proxy = getProxy(context);
            if (proxy != null) {
                defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxy.a, proxy.b));
            }
            return defaultHttpClient;
        }
        return (HttpClient) invokeLLL.objValue;
    }

    public static a getProxy(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
                String b = b(context);
                int a2 = a(context);
                if (!TextUtils.isEmpty(b) && a2 >= 0) {
                    return new a(b, a2);
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static l.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        InterceptResult invokeLLLL;
        Bundle bundle2;
        Bundle b;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, context, str, str2, bundle)) == null) {
            if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
                throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
            }
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            String string = bundle2.getString("appid_for_getting_config");
            bundle2.remove("appid_for_getting_config");
            HttpClient httpClient = getHttpClient(context, string, str);
            HttpGet httpGet = null;
            int i = 0;
            int i2 = -1;
            if (str2.equals("GET")) {
                String encodeUrl = encodeUrl(bundle2);
                i = 0 + encodeUrl.length();
                SLog.v("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
                String str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
                if (com.tencent.open.log.d.b(bundle2) != bundle2) {
                    SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl(b) + " -- url = " + str3);
                } else {
                    SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
                }
                HttpGet httpGet2 = new HttpGet(str3 + encodeUrl);
                httpGet2.addHeader("Accept-Encoding", "gzip");
                httpGet = httpGet2;
            } else if (str2.equals("POST")) {
                HttpPost httpPost = new HttpPost(str);
                httpPost.addHeader("Accept-Encoding", "gzip");
                Bundle bundle3 = new Bundle();
                for (String str4 : bundle2.keySet()) {
                    Object obj = bundle2.get(str4);
                    if (obj instanceof byte[]) {
                        bundle3.putByteArray(str4, (byte[]) obj);
                    }
                }
                if (!bundle2.containsKey("method")) {
                    bundle2.putString("method", str2);
                }
                httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
                httpPost.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(l.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                byteArrayOutputStream.write(l.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
                if (!bundle3.isEmpty()) {
                    int size = bundle3.size();
                    byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    for (String str5 : bundle3.keySet()) {
                        i2++;
                        byteArrayOutputStream.write(l.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                        byteArrayOutputStream.write(l.i("Content-Type: content/unknown\r\n\r\n"));
                        byte[] byteArray = bundle3.getByteArray(str5);
                        if (byteArray != null) {
                            byteArrayOutputStream.write(byteArray);
                        }
                        if (i2 < size - 1) {
                            byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        }
                    }
                }
                byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                i = 0 + byteArray2.length;
                byteArrayOutputStream.close();
                httpPost.setEntity(new ByteArrayEntity(byteArray2));
                httpGet = httpPost;
            }
            HttpResponse execute = httpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =" + statusCode);
            if (statusCode == 200) {
                return new l.a(a(execute), i);
            }
            throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
        }
        return (l.a) invokeLLLL.objValue;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0173, code lost:
        r0 = r3;
        r7 = 0;
        r11 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r18, android.content.Context r19, java.lang.String r20, android.os.Bundle r21, java.lang.String r22) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.tencent.open.utils.HttpUtils.$ic
            if (r0 != 0) goto L18a
        L4:
            r1 = r19
            r0 = r20
            java.lang.String r2 = "openSDK_LOG.HttpUtils"
            java.lang.String r3 = "OpenApi request"
            com.tencent.open.log.SLog.i(r2, r3)
            java.lang.String r2 = r20.toLowerCase()
            java.lang.String r3 = "http"
            boolean r2 = r2.startsWith(r3)
            if (r2 != 0) goto L4f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.tencent.open.utils.h r3 = com.tencent.open.utils.h.a()
            java.lang.String r4 = "https://openmobile.qq.com/"
            java.lang.String r3 = r3.a(r1, r4)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.tencent.open.utils.h r5 = com.tencent.open.utils.h.a()
            java.lang.String r4 = r5.a(r1, r4)
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4 = r3
            r3 = r18
            goto L53
        L4f:
            r3 = r18
            r2 = r0
            r4 = r2
        L53:
            a(r1, r3, r0)
            r0 = 0
            long r5 = android.os.SystemClock.elapsedRealtime()
            r7 = 0
            java.lang.String r8 = r18.getAppId()
            com.tencent.open.utils.g r8 = com.tencent.open.utils.g.a(r1, r8)
            java.lang.String r9 = "Common_HttpRetryCount"
            int r8 = r8.a(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "config 1:Common_HttpRetryCount            config_value:"
            r9.append(r10)
            r9.append(r8)
            java.lang.String r10 = "   appid:"
            r9.append(r10)
            java.lang.String r11 = r18.getAppId()
            r9.append(r11)
            java.lang.String r11 = "     url:"
            r9.append(r11)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.String r12 = "OpenConfig_test"
            com.tencent.open.log.SLog.v(r12, r9)
            if (r8 != 0) goto L97
            r8 = 3
        L97:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "config 1:Common_HttpRetryCount            result_value:"
            r9.append(r13)
            r9.append(r8)
            r9.append(r10)
            java.lang.String r3 = r18.getAppId()
            r9.append(r3)
            r9.append(r11)
            r9.append(r4)
            java.lang.String r3 = r9.toString()
            com.tencent.open.log.SLog.v(r12, r3)
            r3 = r0
        Lbc:
            int r7 = r7 + 1
            r9 = 0
            r11 = r21
            r12 = r22
            com.tencent.open.utils.l$a r0 = openUrl2(r1, r2, r12, r11)     // Catch: org.json.JSONException -> Le0 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            java.lang.String r13 = r0.a     // Catch: org.json.JSONException -> Le0 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            org.json.JSONObject r3 = com.tencent.open.utils.l.d(r13)     // Catch: org.json.JSONException -> Le0 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            java.lang.String r13 = "ret"
            int r13 = r3.getInt(r13)     // Catch: org.json.JSONException -> Ld5 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            goto Ld6
        Ld5:
            r13 = -4
        Ld6:
            long r14 = r0.b     // Catch: org.json.JSONException -> Le0 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            long r0 = r0.c     // Catch: org.json.JSONException -> Le0 java.io.IOException -> Lf1 java.net.MalformedURLException -> L105 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L116 com.tencent.open.utils.HttpUtils.HttpStatusException -> L11b java.net.SocketTimeoutException -> L146 org.apache.http.conn.ConnectTimeoutException -> L162
            r9 = r0
            r0 = r3
            r11 = r13
            r7 = r14
            goto L176
        Le0:
            r0 = move-exception
            r0.printStackTrace()
            r11 = -4
            r7 = 0
            r9 = 0
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        Lf1:
            r0 = move-exception
            r0.printStackTrace()
            int r11 = getErrorCodeFromException(r0)
            r7 = 0
            r9 = 0
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L105:
            r0 = move-exception
            r0.printStackTrace()
            r11 = -3
            r7 = 0
            r9 = 0
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L116:
            r0 = move-exception
            r0.printStackTrace()
            throw r0
        L11b:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            java.lang.String r0 = r1.getMessage()
            java.lang.String r2 = "http status code error:"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch: java.lang.Exception -> L132
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L132
            r11 = r0
            goto L13a
        L132:
            r0 = move-exception
            r0.printStackTrace()
            r0 = -9
            r11 = -9
        L13a:
            r7 = 0
            r9 = 0
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r1
        L146:
            r0 = move-exception
            r0.printStackTrace()
            r13 = -8
            r14 = 0
            r16 = 0
            if (r7 >= r8) goto L156
            long r5 = android.os.SystemClock.elapsedRealtime()
            goto L171
        L156:
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r7 = r14
            r9 = r16
            r11 = r13
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L162:
            r0 = move-exception
            r0.printStackTrace()
            r13 = -7
            r14 = 0
            r16 = 0
            if (r7 >= r8) goto L17e
            long r5 = android.os.SystemClock.elapsedRealtime()
        L171:
            if (r7 < r8) goto Lbc
            r0 = r3
            r7 = r9
            r11 = r13
        L176:
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r3.a(r4, r5, r7, r9, r11)
            return r0
        L17e:
            com.tencent.open.a.g r3 = com.tencent.open.a.g.a()
            r7 = r14
            r9 = r16
            r11 = r13
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L18a:
            r15 = r0
            r16 = 65547(0x1000b, float:9.1851E-41)
            r17 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r15.invokeLLLLL(r16, r17, r18, r19, r20, r21, r22)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{qQToken, context, str, bundle, str2, iRequestListener}) == null) {
            SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
            new Thread(qQToken, context, str, bundle, str2, iRequestListener) { // from class: com.tencent.open.utils.HttpUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ QQToken a;
                public final /* synthetic */ Context b;
                public final /* synthetic */ String c;
                public final /* synthetic */ Bundle d;
                public final /* synthetic */ String e;
                public final /* synthetic */ IRequestListener f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {qQToken, context, str, bundle, str2, iRequestListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = qQToken;
                    this.b = context;
                    this.c = str;
                    this.d = bundle;
                    this.e = str2;
                    this.f = iRequestListener;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            JSONObject request = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
                            if (this.f != null) {
                                this.f.onComplete(request);
                                SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                            }
                        } catch (HttpStatusException e) {
                            IRequestListener iRequestListener2 = this.f;
                            if (iRequestListener2 != null) {
                                iRequestListener2.onHttpStatusException(e);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e.toString());
                            }
                        } catch (NetworkUnavailableException e2) {
                            IRequestListener iRequestListener3 = this.f;
                            if (iRequestListener3 != null) {
                                iRequestListener3.onNetworkUnavailableException(e2);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e2.toString());
                            }
                        } catch (MalformedURLException e3) {
                            IRequestListener iRequestListener4 = this.f;
                            if (iRequestListener4 != null) {
                                iRequestListener4.onMalformedURLException(e3);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e3.toString());
                            }
                        } catch (SocketTimeoutException e4) {
                            IRequestListener iRequestListener5 = this.f;
                            if (iRequestListener5 != null) {
                                iRequestListener5.onSocketTimeoutException(e4);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e4.toString());
                            }
                        } catch (ConnectTimeoutException e5) {
                            IRequestListener iRequestListener6 = this.f;
                            if (iRequestListener6 != null) {
                                iRequestListener6.onConnectTimeoutException(e5);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException" + e5.toString());
                            }
                        } catch (IOException e6) {
                            IRequestListener iRequestListener7 = this.f;
                            if (iRequestListener7 != null) {
                                iRequestListener7.onIOException(e6);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                            }
                        } catch (JSONException e7) {
                            IRequestListener iRequestListener8 = this.f;
                            if (iRequestListener8 != null) {
                                iRequestListener8.onJSONException(e7);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                            }
                        } catch (Exception e8) {
                            IRequestListener iRequestListener9 = this.f;
                            if (iRequestListener9 != null) {
                                iRequestListener9.onUnknowException(e8);
                                SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                            }
                        }
                    }
                }
            }.start();
        }
    }

    public static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, httpResponse)) != null) {
            return (String) invokeL.objValue;
        }
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
            content = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = content.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                content.close();
                return str;
            }
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 11) {
                if (context != null) {
                    int port = Proxy.getPort(context);
                    return port < 0 ? Proxy.getDefaultPort() : port;
                }
                return Proxy.getDefaultPort();
            }
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
