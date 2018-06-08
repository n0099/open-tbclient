package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.Utility;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
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
import org.apache.http.protocol.HttpContext;
/* loaded from: classes3.dex */
public class HttpManager {
    private static final String BOUNDARY;
    private static final int BUFFER_SIZE = 8192;
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String END_MP_BOUNDARY;
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String MP_BOUNDARY;
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final int SOCKET_TIMEOUT = 20000;
    private static final String TAG = "HttpManager";
    private static SSLSocketFactory sSSLSocketFactory;

    private static native String calcOauthSignNative(Context context, String str, String str2);

    static {
        System.loadLibrary("weibosdkcore");
        BOUNDARY = getBoundry();
        MP_BOUNDARY = "--" + BOUNDARY;
        END_MP_BOUNDARY = "--" + BOUNDARY + "--";
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String readRsponse = readRsponse(requestHttpExecute(context, str, str2, weiboParameters));
        LogUtil.d(TAG, "Response : " + readRsponse);
        return readRsponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [192=4] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpResponse requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpClient httpClient;
        HttpClient httpClient2;
        HttpUriRequest httpDelete;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpClient = getNewHttpClient();
            try {
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.getAPN());
                setHttpCommonParam(context, weiboParameters);
                if (str2.equals("GET")) {
                    String str3 = String.valueOf(str) + "?" + weiboParameters.encodeUrl();
                    httpDelete = new HttpGet(str3);
                    LogUtil.d(TAG, "requestHttpExecute GET Url : " + str3);
                } else if (str2.equals("POST")) {
                    LogUtil.d(TAG, "requestHttpExecute POST Url : " + str);
                    HttpPost httpPost = new HttpPost(str);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        if (weiboParameters.hasBinaryData()) {
                            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                            buildParams(byteArrayOutputStream2, weiboParameters);
                        } else {
                            Object obj = weiboParameters.get(Headers.CONTENT_TYPE);
                            if (obj == null || !(obj instanceof String)) {
                                httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                            } else {
                                weiboParameters.remove(Headers.CONTENT_TYPE);
                                httpPost.setHeader("Content-Type", (String) obj);
                            }
                            String encodeUrl = weiboParameters.encodeUrl();
                            LogUtil.d(TAG, "requestHttpExecute POST postParam : " + encodeUrl);
                            byteArrayOutputStream2.write(encodeUrl.getBytes("UTF-8"));
                        }
                        httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream2.toByteArray()));
                        httpDelete = httpPost;
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (IOException e) {
                        e = e;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        httpClient2 = httpClient;
                        try {
                            e.printStackTrace();
                            throw new WeiboException(e);
                        } catch (Throwable th) {
                            th = th;
                            httpClient = httpClient2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            shutdownHttpClient(httpClient);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                        }
                        shutdownHttpClient(httpClient);
                        throw th;
                    }
                } else {
                    httpDelete = str2.equals(HttpDelete.METHOD_NAME) ? new HttpDelete(str) : null;
                }
                HttpResponse execute = httpClient.execute(httpDelete);
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new WeiboHttpException(readRsponse(execute), statusCode);
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                shutdownHttpClient(httpClient);
                return execute;
            } catch (IOException e4) {
                e = e4;
                httpClient2 = httpClient;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            httpClient2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpClient = null;
        }
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        String str2 = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str2 = Utility.getAid(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str2)) {
                weiboParameters.put("aid", str2);
            }
        }
        String str3 = str2;
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = weiboParameters.get(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str = (String) obj2;
        } else if (obj3 == null || !(obj3 instanceof String)) {
            str = "";
        } else {
            str = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str3, str, weiboParameters.getAppKey(), timestamp));
    }

    public static void shutdownHttpClient(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }

    public static String openUrl4RdirectURL(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        DefaultHttpClient defaultHttpClient;
        DefaultHttpClient defaultHttpClient2 = null;
        HttpUriRequest httpPost = null;
        defaultHttpClient2 = null;
        try {
            try {
                defaultHttpClient = (DefaultHttpClient) getNewHttpClient();
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            defaultHttpClient.setRedirectHandler(new RedirectHandler() { // from class: com.sina.weibo.sdk.net.HttpManager.1
                @Override // org.apache.http.client.RedirectHandler
                public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                    LogUtil.d(HttpManager.TAG, "openUrl4RdirectURL isRedirectRequested method");
                    return false;
                }

                @Override // org.apache.http.client.RedirectHandler
                public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                    LogUtil.d(HttpManager.TAG, "openUrl4RdirectURL getLocationURI method");
                    return null;
                }
            });
            setHttpCommonParam(context, weiboParameters);
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.getAPN());
            if (str2.equals("GET")) {
                String str3 = String.valueOf(str) + "?" + weiboParameters.encodeUrl();
                LogUtil.d(TAG, "openUrl4RdirectURL GET url : " + str3);
                httpPost = new HttpGet(str3);
            } else if (str2.equals("POST")) {
                httpPost = new HttpPost(str);
                LogUtil.d(TAG, "openUrl4RdirectURL POST url : " + str);
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode == 301 || statusCode == 302) {
                String value = execute.getFirstHeader("Location").getValue();
                LogUtil.d(TAG, "RedirectURL = " + value);
                shutdownHttpClient(defaultHttpClient);
                return value;
            } else if (statusCode == 200) {
                String readRsponse = readRsponse(execute);
                shutdownHttpClient(defaultHttpClient);
                return readRsponse;
            } else {
                throw new WeiboHttpException(readRsponse(execute), statusCode);
            }
        } catch (IOException e2) {
            defaultHttpClient2 = defaultHttpClient;
            e = e2;
            throw new WeiboException(e);
        } catch (Throwable th2) {
            defaultHttpClient2 = defaultHttpClient;
            th = th2;
            shutdownHttpClient(defaultHttpClient2);
            throw th;
        }
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        CustomRedirectHandler customRedirectHandler;
        DefaultHttpClient defaultHttpClient;
        DefaultHttpClient defaultHttpClient2 = null;
        HttpUriRequest httpPost = null;
        try {
            try {
                customRedirectHandler = new CustomRedirectHandler() { // from class: com.sina.weibo.sdk.net.HttpManager.2
                    @Override // com.sina.weibo.sdk.net.CustomRedirectHandler
                    public boolean shouldRedirectUrl(String str3) {
                        return true;
                    }

                    @Override // com.sina.weibo.sdk.net.CustomRedirectHandler
                    public void onReceivedException() {
                    }
                };
                defaultHttpClient = (DefaultHttpClient) getNewHttpClient();
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            defaultHttpClient.setRedirectHandler(customRedirectHandler);
            setHttpCommonParam(context, weiboParameters);
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.getAPN());
            if (str2.equals("GET")) {
                httpPost = new HttpGet(String.valueOf(str) + "?" + weiboParameters.encodeUrl());
            } else if (str2.equals("POST")) {
                httpPost = new HttpPost(str);
            }
            httpPost.setHeader(HTTP.USER_AGENT, NetworkHelper.generateUA(context));
            defaultHttpClient.execute(httpPost);
            String redirectUrl = customRedirectHandler.getRedirectUrl();
            shutdownHttpClient(defaultHttpClient);
            return redirectUrl;
        } catch (IOException e2) {
            e = e2;
            throw new WeiboException(e);
        } catch (Throwable th2) {
            defaultHttpClient2 = defaultHttpClient;
            th = th2;
            shutdownHttpClient(defaultHttpClient2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [477=4, 478=4, 479=4] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb A[Catch: IOException -> 0x0121, all -> 0x016a, TryCatch #0 {IOException -> 0x0121, blocks: (B:16:0x004b, B:18:0x0051, B:19:0x0055, B:21:0x0089, B:23:0x0092, B:25:0x0095, B:26:0x00ae, B:28:0x00bb, B:30:0x00cd, B:31:0x00d6, B:32:0x00e5, B:34:0x00ec, B:36:0x00f8, B:67:0x018c, B:38:0x0100, B:66:0x0186, B:65:0x0180, B:56:0x0146, B:58:0x014f, B:59:0x0160, B:60:0x0169, B:43:0x011c), top: B:72:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8 A[Catch: IOException -> 0x0121, all -> 0x016a, TryCatch #0 {IOException -> 0x0121, blocks: (B:16:0x004b, B:18:0x0051, B:19:0x0055, B:21:0x0089, B:23:0x0092, B:25:0x0095, B:26:0x00ae, B:28:0x00bb, B:30:0x00cd, B:31:0x00d6, B:32:0x00e5, B:34:0x00ec, B:36:0x00f8, B:67:0x018c, B:38:0x0100, B:66:0x0186, B:65:0x0180, B:56:0x0146, B:58:0x014f, B:59:0x0160, B:60:0x0169, B:43:0x011c), top: B:72:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0105 A[Catch: all -> 0x013d, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x000e, B:7:0x0011, B:9:0x001c, B:12:0x0022, B:15:0x002c, B:69:0x0195, B:40:0x0105, B:48:0x012a, B:16:0x004b, B:18:0x0051, B:19:0x0055, B:21:0x0089, B:23:0x0092, B:25:0x0095, B:26:0x00ae, B:28:0x00bb, B:30:0x00cd, B:31:0x00d6, B:32:0x00e5, B:34:0x00ec, B:36:0x00f8, B:67:0x018c, B:38:0x0100, B:66:0x0186, B:65:0x0180, B:56:0x0146, B:58:0x014f, B:59:0x0160, B:60:0x0169, B:43:0x011c, B:46:0x0122), top: B:73:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186 A[Catch: IOException -> 0x0121, all -> 0x016a, LOOP:0: B:32:0x00e5->B:66:0x0186, LOOP_END, TryCatch #0 {IOException -> 0x0121, blocks: (B:16:0x004b, B:18:0x0051, B:19:0x0055, B:21:0x0089, B:23:0x0092, B:25:0x0095, B:26:0x00ae, B:28:0x00bb, B:30:0x00cd, B:31:0x00d6, B:32:0x00e5, B:34:0x00ec, B:36:0x00f8, B:67:0x018c, B:38:0x0100, B:66:0x0186, B:65:0x0180, B:56:0x0146, B:58:0x014f, B:59:0x0160, B:60:0x0169, B:43:0x011c), top: B:72:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ec A[EDGE_INSN: B:74:0x00ec->B:34:0x00ec ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        String str4;
        HttpResponse execute;
        int statusCode;
        long intValue;
        long j;
        InputStream content;
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        int read;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                str4 = file2.getPath();
            } else if (URLUtil.isValidUrl(str)) {
                HttpClient newHttpClient = getNewHttpClient();
                long j2 = 0;
                File file3 = new File(str2, String.valueOf(str3) + "_temp");
                try {
                    if (file3.exists()) {
                        j2 = file3.length();
                    } else {
                        file3.createNewFile();
                    }
                    HttpGet httpGet = new HttpGet(str);
                    httpGet.setHeader("RANGE", "bytes=" + j2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    execute = newHttpClient.execute(httpGet);
                    statusCode = execute.getStatusLine().getStatusCode();
                } catch (IOException e) {
                    e.printStackTrace();
                    file3.delete();
                    if (newHttpClient != null) {
                        newHttpClient.getConnectionManager().closeExpiredConnections();
                        newHttpClient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
                    }
                }
                if (statusCode == 206) {
                    Header[] headers = execute.getHeaders("Content-Range");
                    if (headers != null && headers.length != 0) {
                        String value = headers[0].getValue();
                        intValue = Long.parseLong(value.substring(value.indexOf(47) + 1));
                        j = j2;
                        HttpEntity entity = execute.getEntity();
                        Header firstHeader = execute.getFirstHeader(HTTP.CONTENT_ENCODING);
                        content = (firstHeader != null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) ? entity.getContent() : new GZIPInputStream(entity.getContent());
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                        randomAccessFile.seek(j);
                        bArr = new byte[1024];
                        while (true) {
                            read = content.read(bArr);
                            if (read != -1) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                        }
                        randomAccessFile.close();
                        content.close();
                        if (intValue != 0 || file3.length() < intValue) {
                            file3.delete();
                            if (newHttpClient != null) {
                                newHttpClient.getConnectionManager().closeExpiredConnections();
                                newHttpClient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
                            }
                            str4 = "";
                        } else {
                            file3.renameTo(file2);
                            str4 = file2.getPath();
                            if (newHttpClient != null) {
                                newHttpClient.getConnectionManager().closeExpiredConnections();
                                newHttpClient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
                            }
                        }
                    }
                    intValue = 0;
                    j = j2;
                    HttpEntity entity2 = execute.getEntity();
                    Header firstHeader2 = execute.getFirstHeader(HTTP.CONTENT_ENCODING);
                    if (firstHeader2 != null) {
                    }
                    randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(j);
                    bArr = new byte[1024];
                    while (true) {
                        read = content.read(bArr);
                        if (read != -1) {
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    content.close();
                    if (intValue != 0) {
                    }
                    file3.delete();
                    if (newHttpClient != null) {
                    }
                    str4 = "";
                } else if (statusCode != 200) {
                    throw new WeiboHttpException(readRsponse(execute), statusCode);
                } else {
                    j2 = 0;
                    Header firstHeader3 = execute.getFirstHeader(HTTP.CONTENT_LEN);
                    if (firstHeader3 != null) {
                        intValue = Integer.valueOf(firstHeader3.getValue()).intValue();
                        j = 0;
                        HttpEntity entity22 = execute.getEntity();
                        Header firstHeader22 = execute.getFirstHeader(HTTP.CONTENT_ENCODING);
                        if (firstHeader22 != null) {
                        }
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                        randomAccessFile.seek(j);
                        bArr = new byte[1024];
                        while (true) {
                            read = content.read(bArr);
                            if (read != -1) {
                            }
                            randomAccessFile.write(bArr, 0, read);
                        }
                        randomAccessFile.close();
                        content.close();
                        if (intValue != 0) {
                        }
                        file3.delete();
                        if (newHttpClient != null) {
                        }
                        str4 = "";
                    }
                    intValue = 0;
                    j = j2;
                    HttpEntity entity222 = execute.getEntity();
                    Header firstHeader222 = execute.getFirstHeader(HTTP.CONTENT_ENCODING);
                    if (firstHeader222 != null) {
                    }
                    randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(j);
                    bArr = new byte[1024];
                    while (true) {
                        read = content.read(bArr);
                        if (read != -1) {
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    content.close();
                    if (intValue != 0) {
                    }
                    file3.delete();
                    if (newHttpClient != null) {
                    }
                    str4 = "";
                }
            } else {
                str4 = "";
            }
        }
        return str4;
    }

    public static HttpClient getNewHttpClient() {
        try {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", getSSLSocketFactory(), 443));
            ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            return new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    StringBuilder sb = new StringBuilder(100);
                    sb.setLength(0);
                    sb.append(MP_BOUNDARY).append(SystemInfoUtil.LINE_END);
                    sb.append("content-disposition: form-data; name=\"").append(str).append("\"\r\n\r\n");
                    sb.append(weiboParameters.get(str)).append(SystemInfoUtil.LINE_END);
                    outputStream.write(sb.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(MP_BOUNDARY).append(SystemInfoUtil.LINE_END);
                    sb2.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    sb2.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(sb2.toString().getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write(SystemInfoUtil.LINE_END.getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MP_BOUNDARY).append(SystemInfoUtil.LINE_END);
                    sb3.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    sb3.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(sb3.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write(SystemInfoUtil.LINE_END.getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write((SystemInfoUtil.LINE_END + END_MP_BOUNDARY).getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readRsponse(HttpResponse httpResponse) throws WeiboException {
        InputStream inputStream;
        Throwable th;
        IOException e;
        String str = null;
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = entity.getContent();
                try {
                    try {
                        Header firstHeader = httpResponse.getFirstHeader(HTTP.CONTENT_ENCODING);
                        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                            inputStream = new GZIPInputStream(inputStream);
                        }
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        LogUtil.d(TAG, "readRsponse result : " + str);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        throw new WeiboException(e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                inputStream = null;
                e = e7;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        }
        return str;
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + i;
            if (currentTimeMillis % 3 == 0) {
                stringBuffer.append(((char) currentTimeMillis) % '\t');
            } else if (currentTimeMillis % 3 == 1) {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
            } else {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
            }
        }
        return stringBuffer.toString();
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        if (sSSLSocketFactory == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                Certificate certificate = getCertificate("cacert_cn.cer");
                Certificate certificate2 = getCertificate("cacert_com.cer");
                keyStore.setCertificateEntry("cnca", certificate);
                keyStore.setCertificateEntry("comca", certificate2);
                sSSLSocketFactory = new SSLSocketFactoryEx(keyStore);
                LogUtil.d(TAG, "getSSLSocketFactory noraml !!!!!");
            } catch (Exception e) {
                e.printStackTrace();
                sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
                LogUtil.d(TAG, "getSSLSocketFactory error default !!!!!");
            }
        }
        return sSSLSocketFactory;
    }

    private static Certificate getCertificate(String str) throws CertificateException, IOException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = HttpManager.class.getResourceAsStream(str);
        try {
            return certificateFactory.generateCertificate(resourceAsStream);
        } finally {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }
}
