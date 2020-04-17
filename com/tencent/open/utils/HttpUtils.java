package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.j;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileInputStream;
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
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
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
/* loaded from: classes8.dex */
public class HttpUtils {
    private HttpUtils() {
    }

    /* loaded from: classes8.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* loaded from: classes8.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01ce A[LOOP:0: B:9:0x00e8->B:58:0x01ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject request(QQToken qQToken, Context context, String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        String str3;
        String str4;
        int i;
        ConnectTimeoutException connectTimeoutException;
        JSONObject jSONObject;
        SocketTimeoutException socketTimeoutException;
        JSONObject jSONObject2;
        int i2;
        long j;
        JSONObject jSONObject3;
        long j2;
        JSONObject jSONObject4;
        long j3;
        j.a openUrl2;
        JSONObject d;
        com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "OpenApi request");
        if (str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            str3 = str;
            str4 = str;
        } else {
            str4 = g.a().a(context, "https://openmobile.qq.com/") + str;
            str3 = g.a().a(context, "https://openmobile.qq.com/") + str;
        }
        a(context, qQToken, str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int a2 = f.a(context, qQToken.getAppId()).a("Common_HttpRetryCount");
        com.tencent.open.a.f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + a2 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
        int i3 = a2 == 0 ? 3 : a2;
        com.tencent.open.a.f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i3 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
        long j4 = elapsedRealtime;
        int i4 = 0;
        JSONObject jSONObject5 = null;
        while (true) {
            int i5 = i4 + 1;
            try {
                try {
                    try {
                        openUrl2 = openUrl2(context, str4, str2, bundle);
                        d = j.d(openUrl2.a);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, -4);
                        throw e;
                    }
                } catch (SocketTimeoutException e2) {
                    socketTimeoutException = e2;
                    jSONObject2 = jSONObject5;
                } catch (ConnectTimeoutException e3) {
                    connectTimeoutException = e3;
                    jSONObject = jSONObject5;
                }
                try {
                    try {
                        i2 = d.getInt("ret");
                    } catch (JSONException e4) {
                        i2 = -4;
                    }
                    j3 = openUrl2.b;
                    j = openUrl2.c;
                    jSONObject4 = d;
                    break;
                } catch (SocketTimeoutException e5) {
                    jSONObject2 = d;
                    socketTimeoutException = e5;
                    socketTimeoutException.printStackTrace();
                    i2 = -8;
                    j = 0;
                    if (i5 >= i3) {
                        com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, -8);
                        throw socketTimeoutException;
                    }
                    j4 = SystemClock.elapsedRealtime();
                    jSONObject3 = jSONObject2;
                    j2 = 0;
                    if (i5 < i3) {
                        jSONObject4 = jSONObject3;
                        j3 = j2;
                        com.tencent.open.b.g.a().a(str3, j4, j3, j, i2);
                        return jSONObject4;
                    }
                    jSONObject5 = jSONObject3;
                    i4 = i5;
                } catch (ConnectTimeoutException e6) {
                    jSONObject = d;
                    connectTimeoutException = e6;
                    connectTimeoutException.printStackTrace();
                    i2 = -7;
                    j = 0;
                    if (i5 >= i3) {
                        com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, -7);
                        throw connectTimeoutException;
                    }
                    j4 = SystemClock.elapsedRealtime();
                    jSONObject3 = jSONObject;
                    j2 = 0;
                    if (i5 < i3) {
                    }
                }
                jSONObject5 = jSONObject3;
                i4 = i5;
            } catch (HttpStatusException e7) {
                e7.printStackTrace();
                try {
                    i = Integer.parseInt(e7.getMessage().replace(HttpStatusException.ERROR_INFO, ""));
                } catch (Exception e8) {
                    e8.printStackTrace();
                    i = -9;
                }
                com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, i);
                throw e7;
            } catch (NetworkUnavailableException e9) {
                e9.printStackTrace();
                throw e9;
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, -3);
                throw e10;
            } catch (IOException e11) {
                e11.printStackTrace();
                com.tencent.open.b.g.a().a(str3, j4, 0L, 0L, getErrorCodeFromException(e11));
                throw e11;
            }
        }
        com.tencent.open.b.g.a().a(str3, j4, j3, j, i2);
        return jSONObject4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.open.utils.HttpUtils$1] */
    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new Thread() { // from class: com.tencent.open.utils.HttpUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(QQToken.this, context, str, bundle, str2);
                    if (iRequestListener != null) {
                        iRequestListener.onComplete(request);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (HttpStatusException e) {
                    if (iRequestListener != null) {
                        iRequestListener.onHttpStatusException(e);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e);
                    }
                } catch (NetworkUnavailableException e2) {
                    if (iRequestListener != null) {
                        iRequestListener.onNetworkUnavailableException(e2);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e2);
                    }
                } catch (MalformedURLException e3) {
                    if (iRequestListener != null) {
                        iRequestListener.onMalformedURLException(e3);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e3);
                    }
                } catch (SocketTimeoutException e4) {
                    if (iRequestListener != null) {
                        iRequestListener.onSocketTimeoutException(e4);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e4);
                    }
                } catch (ConnectTimeoutException e5) {
                    if (iRequestListener != null) {
                        iRequestListener.onConnectTimeoutException(e5);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e5);
                    }
                } catch (IOException e6) {
                    if (iRequestListener != null) {
                        iRequestListener.onIOException(e6);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e6);
                    }
                } catch (JSONException e7) {
                    if (iRequestListener != null) {
                        iRequestListener.onJSONException(e7);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e7);
                    }
                } catch (Exception e8) {
                    if (iRequestListener != null) {
                        iRequestListener.onUnknowException(e8);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e8);
                    }
                }
            }
        }.start();
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    public static int getErrorCodeFromException(IOException iOException) {
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
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }

    public static j.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        HttpGet httpGet;
        int i;
        String str3;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
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
        if (str2.equals("GET")) {
            String encodeUrl = encodeUrl(bundle2);
            int length = 0 + encodeUrl.length();
            com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            if (str.indexOf("?") == -1) {
                str3 = str + "?";
            } else {
                str3 = str + ETAG.ITEM_SEPARATOR;
            }
            com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
            HttpGet httpGet2 = new HttpGet(str3 + encodeUrl);
            httpGet2.addHeader(Headers.ACCEPT_ENCODING, "gzip");
            httpGet = httpGet2;
            i = length;
        } else if (!str2.equals("POST")) {
            httpGet = null;
            i = 0;
        } else {
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader(Headers.ACCEPT_ENCODING, "gzip");
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
            byteArrayOutputStream.write(j.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(j.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                int i2 = -1;
                for (String str5 : bundle3.keySet()) {
                    i2++;
                    byteArrayOutputStream.write(j.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                    byteArrayOutputStream.write(j.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i2 < size - 1) {
                        byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            i = byteArray2.length + 0;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(byteArray2));
            httpGet = httpPost;
        }
        HttpResponse execute = httpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
        }
        return new j.a(a(execute), i);
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                gZIPInputStream.close();
                return str;
            }
        }
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int i;
        int i2 = 0;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 16) {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                a aVar = new a(keyStore);
                aVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", aVar, Constants.SOCKET_PORT_SSL));
            } catch (Exception e) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        f a2 = context != null ? f.a(context, str) : null;
        if (a2 != null) {
            i = a2.a("Common_HttpConnectionTimeout");
            i2 = a2.a("Common_SocketConnectionTimeout");
        } else {
            i = 0;
        }
        if (i == 0) {
            i = 15000;
        }
        if (i2 == 0) {
            i2 = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DEVICE + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        c proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxy.a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static String encodeUrl(Bundle bundle) {
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
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(URLEncoder.encode(str) + ETAG.EQUAL);
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(URLEncoder.encode(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(URLEncoder.encode(str) + ETAG.EQUAL + URLEncoder.encode(bundle.getString(str)));
                }
                z = z;
            }
        }
        return sb.toString();
    }

    public static String encodePostBody(Bundle bundle, String str) {
        Object obj;
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            if (bundle.get(str2) instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
                i = i2;
            } else {
                i = i2;
            }
        }
        return sb.toString();
    }

    public static c getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0) {
                String b2 = b(context);
                int a2 = a(context);
                if (!TextUtils.isEmpty(b2) && a2 >= 0) {
                    return new c(b2, a2);
                }
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public final String a;
        public final int b;

        private c(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    private static int a(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                int port = Proxy.getPort(context);
                if (port < 0) {
                    return Proxy.getDefaultPort();
                }
                return port;
            }
            return Proxy.getDefaultPort();
        }
        String property = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return -1;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                String host = Proxy.getHost(context);
                if (TextUtils.isEmpty(host)) {
                    return Proxy.getDefaultHost();
                }
                return host;
            }
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    /* loaded from: classes8.dex */
    public static class a extends SSLSocketFactory {
        private final SSLContext a;

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            b bVar;
            this.a = SSLContext.getInstance("TLS");
            try {
                bVar = new b();
            } catch (Exception e) {
                bVar = null;
            }
            this.a.init(null, new TrustManager[]{bVar}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements X509TrustManager {
        X509TrustManager a;

        b() throws Exception {
            KeyStore keyStore;
            FileInputStream fileInputStream;
            Throwable th;
            TrustManager[] trustManagers;
            try {
                keyStore = KeyStore.getInstance("JKS");
            } catch (Exception e) {
                keyStore = null;
            }
            TrustManager[] trustManagerArr = new TrustManager[0];
            if (keyStore != null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream("trustedCerts");
                    try {
                        keyStore.load(fileInputStream2, "passphrase".toCharArray());
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                        trustManagerFactory.init(keyStore);
                        trustManagers = trustManagerFactory.getTrustManagers();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileInputStream = null;
                    th = th3;
                }
            } else {
                TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory2.init((KeyStore) null);
                trustManagers = trustManagerFactory2.getTrustManagers();
            }
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.a = (X509TrustManager) trustManagers[i];
                    return;
                }
            }
            throw new Exception("Couldn't initialize");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.a.getAcceptedIssuers();
        }
    }
}
