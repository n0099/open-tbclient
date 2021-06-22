package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.qq.e.comm.constants.Constants;
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
/* loaded from: classes7.dex */
public class HttpUtils {

    /* loaded from: classes7.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends SSLSocketFactory {

        /* renamed from: a  reason: collision with root package name */
        public final SSLContext f40232a;

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            b bVar;
            this.f40232a = SSLContext.getInstance("TLS");
            try {
                bVar = new b();
            } catch (Exception unused) {
                bVar = null;
            }
            this.f40232a.init(null, new TrustManager[]{bVar}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException, UnknownHostException {
            return this.f40232a.getSocketFactory().createSocket(socket, str, i2, z);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.f40232a.getSocketFactory().createSocket();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f40233a;

        public b() throws Exception {
            KeyStore keyStore;
            FileInputStream fileInputStream;
            Throwable th;
            TrustManager[] trustManagers;
            try {
                keyStore = KeyStore.getInstance("JKS");
            } catch (Exception unused) {
                keyStore = null;
            }
            if (keyStore != null) {
                try {
                    fileInputStream = new FileInputStream("trustedCerts");
                    try {
                        keyStore.load(fileInputStream, "passphrase".toCharArray());
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                        trustManagerFactory.init(keyStore);
                        trustManagers = trustManagerFactory.getTrustManagers();
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
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
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f40233a = (X509TrustManager) trustManagers[i2];
                    return;
                }
            }
            throw new Exception("Couldn't initialize");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f40233a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f40233a.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f40233a.getAcceptedIssuers();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f40234a;

        /* renamed from: b  reason: collision with root package name */
        public final int f40235b;

        public c(String str, int i2) {
            this.f40234a = str;
            this.f40235b = i2;
        }
    }

    public static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                String host = Proxy.getHost(context);
                return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
            }
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            i2++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + Part.CRLF + Part.CRLF + ((String) obj));
                if (i2 < size - 1) {
                    sb.append("\r\n--" + str + Part.CRLF);
                }
            }
        }
        return sb.toString();
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
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            if (i2 == 0) {
                                sb.append(URLEncoder.encode(stringArray[i2]));
                            } else {
                                sb.append(URLEncoder.encode("," + stringArray[i2]));
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
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int i2;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 16) {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                a aVar = new a(keyStore);
                aVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", aVar, com.baidu.android.imsdk.internal.Constants.SOCKET_PORT_SSL));
            } catch (Exception unused) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), com.baidu.android.imsdk.internal.Constants.SOCKET_PORT_SSL));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), com.baidu.android.imsdk.internal.Constants.SOCKET_PORT_SSL));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        f a2 = context != null ? f.a(context, str) : null;
        int i3 = 0;
        if (a2 != null) {
            i3 = a2.a("Common_HttpConnectionTimeout");
            i2 = a2.a("Common_SocketConnectionTimeout");
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            i3 = 15000;
        }
        if (i2 == 0) {
            i2 = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i3);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        c proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxy.f40234a, proxy.f40235b));
        }
        return defaultHttpClient;
    }

    public static c getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
            String b2 = b(context);
            int a2 = a(context);
            if (!TextUtils.isEmpty(b2) && a2 >= 0) {
                return new c(b2, a2);
            }
        }
        return null;
    }

    public static j.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
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
        HttpGet httpGet = null;
        int i2 = 0;
        int i3 = -1;
        if (str2.equals("GET")) {
            String encodeUrl = encodeUrl(bundle2);
            i2 = 0 + encodeUrl.length();
            com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            String str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
            com.tencent.open.a.f.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(encodeUrl);
            HttpGet httpGet2 = new HttpGet(sb.toString());
            httpGet2.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpGet = httpGet2;
        } else if (str2.equals("POST")) {
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
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
                for (String str5 : bundle3.keySet()) {
                    i3++;
                    byteArrayOutputStream.write(j.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"" + Part.CRLF));
                    byteArrayOutputStream.write(j.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i3 < size - 1) {
                        byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            i2 = 0 + byteArray2.length;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(byteArray2));
            httpGet = httpPost;
        }
        HttpResponse execute = httpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return new j.a(a(execute), i2);
        }
        throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
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
    /* JADX WARN: Code restructure failed: missing block: B:48:0x016f, code lost:
        r0 = r3;
        r7 = 0;
        r11 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r18, android.content.Context r19, java.lang.String r20, android.os.Bundle r21, java.lang.String r22) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            r1 = r19
            r0 = r20
            java.lang.String r2 = "openSDK_LOG.HttpUtils"
            java.lang.String r3 = "OpenApi request"
            com.tencent.open.a.f.a(r2, r3)
            java.lang.String r2 = r20.toLowerCase()
            java.lang.String r3 = "http"
            boolean r2 = r2.startsWith(r3)
            if (r2 != 0) goto L4b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.tencent.open.utils.g r3 = com.tencent.open.utils.g.a()
            java.lang.String r4 = "https://openmobile.qq.com/"
            java.lang.String r3 = r3.a(r1, r4)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.tencent.open.utils.g r5 = com.tencent.open.utils.g.a()
            java.lang.String r4 = r5.a(r1, r4)
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4 = r3
            r3 = r18
            goto L4f
        L4b:
            r3 = r18
            r2 = r0
            r4 = r2
        L4f:
            a(r1, r3, r0)
            r0 = 0
            long r5 = android.os.SystemClock.elapsedRealtime()
            r7 = 0
            java.lang.String r8 = r18.getAppId()
            com.tencent.open.utils.f r8 = com.tencent.open.utils.f.a(r1, r8)
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
            com.tencent.open.a.f.a(r12, r9)
            if (r8 != 0) goto L93
            r8 = 3
        L93:
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
            com.tencent.open.a.f.a(r12, r3)
            r3 = r0
        Lb8:
            int r7 = r7 + 1
            r9 = 0
            r11 = r21
            r12 = r22
            com.tencent.open.utils.j$a r0 = openUrl2(r1, r2, r12, r11)     // Catch: org.json.JSONException -> Ldc java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            java.lang.String r13 = r0.f40277a     // Catch: org.json.JSONException -> Ldc java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            org.json.JSONObject r3 = com.tencent.open.utils.j.d(r13)     // Catch: org.json.JSONException -> Ldc java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            java.lang.String r13 = "ret"
            int r13 = r3.getInt(r13)     // Catch: org.json.JSONException -> Ld1 java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            goto Ld2
        Ld1:
            r13 = -4
        Ld2:
            long r14 = r0.f40278b     // Catch: org.json.JSONException -> Ldc java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            long r0 = r0.f40279c     // Catch: org.json.JSONException -> Ldc java.io.IOException -> Led java.net.MalformedURLException -> L101 com.tencent.open.utils.HttpUtils.NetworkUnavailableException -> L112 com.tencent.open.utils.HttpUtils.HttpStatusException -> L117 java.net.SocketTimeoutException -> L142 org.apache.http.conn.ConnectTimeoutException -> L15e
            r9 = r0
            r0 = r3
            r11 = r13
            r7 = r14
            goto L172
        Ldc:
            r0 = move-exception
            r0.printStackTrace()
            r11 = -4
            r7 = 0
            r9 = 0
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        Led:
            r0 = move-exception
            r0.printStackTrace()
            int r11 = getErrorCodeFromException(r0)
            r7 = 0
            r9 = 0
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L101:
            r0 = move-exception
            r0.printStackTrace()
            r11 = -3
            r7 = 0
            r9 = 0
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L112:
            r0 = move-exception
            r0.printStackTrace()
            throw r0
        L117:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            java.lang.String r0 = r1.getMessage()
            java.lang.String r2 = "http status code error:"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch: java.lang.Exception -> L12e
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L12e
            r11 = r0
            goto L136
        L12e:
            r0 = move-exception
            r0.printStackTrace()
            r0 = -9
            r11 = -9
        L136:
            r7 = 0
            r9 = 0
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r3.a(r4, r5, r7, r9, r11)
            throw r1
        L142:
            r0 = move-exception
            r0.printStackTrace()
            r13 = -8
            r14 = 0
            r16 = 0
            if (r7 >= r8) goto L152
            long r5 = android.os.SystemClock.elapsedRealtime()
            goto L16d
        L152:
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r7 = r14
            r9 = r16
            r11 = r13
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        L15e:
            r0 = move-exception
            r0.printStackTrace()
            r13 = -7
            r14 = 0
            r16 = 0
            if (r7 >= r8) goto L17a
            long r5 = android.os.SystemClock.elapsedRealtime()
        L16d:
            if (r7 < r8) goto Lb8
            r0 = r3
            r7 = r9
            r11 = r13
        L172:
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r3.a(r4, r5, r7, r9, r11)
            return r0
        L17a:
            com.tencent.open.b.g r3 = com.tencent.open.b.g.a()
            r7 = r14
            r9 = r16
            r11 = r13
            r3.a(r4, r5, r7, r9, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

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
                } catch (HttpStatusException e2) {
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onHttpStatusException(e2);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e2);
                    }
                } catch (NetworkUnavailableException e3) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onNetworkUnavailableException(e3);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e3);
                    }
                } catch (MalformedURLException e4) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onMalformedURLException(e4);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e4);
                    }
                } catch (SocketTimeoutException e5) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onSocketTimeoutException(e5);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e5);
                    }
                } catch (ConnectTimeoutException e6) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onConnectTimeoutException(e6);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e6);
                    }
                } catch (IOException e7) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onIOException(e7);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e7);
                    }
                } catch (JSONException e8) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onJSONException(e8);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e8);
                    }
                } catch (Exception e9) {
                    IRequestListener iRequestListener9 = iRequestListener;
                    if (iRequestListener9 != null) {
                        iRequestListener9.onUnknowException(e9);
                        com.tencent.open.a.f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e9);
                    }
                }
            }
        }.start();
    }

    public static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf(AsyncHttpClient.ENCODING_GZIP) > -1) {
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
}
