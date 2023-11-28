package com.yy.hiidostatis.inner.util.http;

import android.os.Build;
import com.baidu.mobads.sdk.internal.cl;
import com.yy.hiidostatis.inner.AppInfo;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class HttpUtil {
    public static final Pattern ipv4Pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");

    /* loaded from: classes2.dex */
    public static class HttpResp {
        public boolean isSucceed = false;
        public int statusCode = -1;
        public String reason = null;
        public String result = null;
        public String remoteIp = null;
    }

    public static String getContentType(File file) throws Exception {
        return "application/octet-stream";
    }

    public static String get(String str, Map<String, String> map) throws IOException {
        String str2;
        if (map != null && map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int i2 = i + 1;
                if (i > 0) {
                    stringBuffer.append("&");
                }
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                i = i2;
            }
            str2 = stringBuffer.toString();
            stringBuffer.setLength(0);
        } else {
            str2 = null;
        }
        return getByUrlConn(str, str2).result;
    }

    public static String getAddressInfo(HttpURLConnection httpURLConnection) {
        if (Build.VERSION.SDK_INT > 27) {
            return "";
        }
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("route");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField(cl.c);
            declaredField2.setAccessible(true);
            Field declaredField3 = obj.getClass().getDeclaredField("inetSocketAddress");
            declaredField3.setAccessible(true);
            String inetSocketAddress = ((InetSocketAddress) declaredField3.get(obj)).toString();
            Proxy.Type type = ((Proxy) declaredField2.get(obj)).type();
            return inetSocketAddress + ":" + type;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f3 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #5 {all -> 0x00ef, blocks: (B:35:0x00eb, B:39:0x00f3), top: B:62:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpResp getByUrlConn(String str, String str2) throws IOException {
        InputStream inputStream;
        boolean z;
        HttpResp httpResp = new HttpResp();
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    str = String.format("%s?%s", str, str2);
                }
            } catch (Throwable th) {
                th = th;
                inputStream = null;
                try {
                    L.error("HttpUtil", "getByUrlConn exception e:" + th.getMessage(), new Object[0]);
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    return httpResp;
                } catch (Throwable th2) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th3) {
                            L.debug("HttpUtil", th3.getMessage(), new Object[0]);
                            throw th2;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th2;
                }
            }
        }
        HttpURLConnection urlToUrlConnection = urlToUrlConnection(str);
        try {
            urlToUrlConnection.setConnectTimeout(30000);
            urlToUrlConnection.setReadTimeout(60000);
            urlToUrlConnection.setUseCaches(false);
            urlToUrlConnection.setRequestMethod("GET");
            urlToUrlConnection.setInstanceFollowRedirects(true);
            urlToUrlConnection.setRequestProperty("User-Agent", "Hiido");
            urlToUrlConnection.connect();
            if (urlToUrlConnection.getResponseCode() == 200) {
                z = true;
            } else {
                z = false;
            }
            httpResp.isSucceed = z;
            httpResp.statusCode = urlToUrlConnection.getResponseCode();
            httpResp.reason = urlToUrlConnection.getResponseMessage();
            if (urlToUrlConnection.getResponseCode() == 200) {
                L.infoLimitTime("HttpUtil", "get url=[%s] is ok", str);
                inputStream2 = urlToUrlConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                httpResp.result = str3;
                L.verbose("HttpUtil", "the result is %s", str3);
                byteArrayOutputStream.close();
            } else {
                L.warn("HttpUtil", "http get [%s] error! status:%d", str, Integer.valueOf(urlToUrlConnection.getResponseCode()));
            }
            if (urlToUrlConnection != null) {
                try {
                    urlToUrlConnection.disconnect();
                } catch (Throwable th4) {
                    L.debug("HttpUtil", th4.getMessage(), new Object[0]);
                }
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = urlToUrlConnection;
            inputStream = null;
            L.error("HttpUtil", "getByUrlConn exception e:" + th.getMessage(), new Object[0]);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th6) {
                    L.debug("HttpUtil", th6.getMessage(), new Object[0]);
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return httpResp;
        }
        return httpResp;
    }

    public static boolean isIpAddress(String str) {
        return ipv4Pattern.matcher(str).matches();
    }

    public static String post(String str, String str2) throws IOException {
        return postByUrlConn(str, str2).result;
    }

    public static HttpResp postByUrlConn(String str, String str2) throws IOException {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        boolean z;
        HttpResp httpResp = new HttpResp();
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        try {
            HttpURLConnection urlToUrlConnection = urlToUrlConnection(str);
            try {
                urlToUrlConnection.setConnectTimeout(30000);
                urlToUrlConnection.setReadTimeout(60000);
                urlToUrlConnection.setDoOutput(true);
                urlToUrlConnection.setUseCaches(false);
                urlToUrlConnection.setRequestMethod("POST");
                urlToUrlConnection.setInstanceFollowRedirects(true);
                urlToUrlConnection.setRequestProperty("Accept-Charset", "text/html;charset=UTF-8");
                urlToUrlConnection.setRequestProperty("User-Agent", "Hiido");
                urlToUrlConnection.connect();
                dataOutputStream = new DataOutputStream(urlToUrlConnection.getOutputStream());
                try {
                    dataOutputStream.write(str2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (urlToUrlConnection.getResponseCode() == 200) {
                        z = true;
                    } else {
                        z = false;
                    }
                    httpResp.isSucceed = z;
                    httpResp.statusCode = urlToUrlConnection.getResponseCode();
                    httpResp.reason = urlToUrlConnection.getResponseMessage();
                    httpResp.remoteIp = getAddressInfo(urlToUrlConnection);
                    if (urlToUrlConnection.getResponseCode() == 200) {
                        L.infoLimitTime("HttpUtil", "post url=[%s] is ok", str);
                        inputStream = urlToUrlConnection.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                            httpResp.result = str3;
                            L.verbose("HttpUtil", "the result is %s", str3);
                            byteArrayOutputStream.close();
                            inputStream2 = inputStream;
                        } catch (Throwable th) {
                            th = th;
                            dataOutputStream = null;
                            httpURLConnection = urlToUrlConnection;
                            try {
                                L.error("HttpUtil", "postByUrlConn exception e:" + th.getMessage(), new Object[0]);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th2) {
                                        L.debug("HttpUtil", th2.getMessage(), new Object[0]);
                                    }
                                }
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return httpResp;
                            } catch (Throwable th3) {
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th4) {
                                        L.debug("HttpUtil", th4.getMessage(), new Object[0]);
                                        throw th3;
                                    }
                                }
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th3;
                            }
                        }
                    } else {
                        L.warn("HttpUtil", "http post [%s] error! status:%d", str, Integer.valueOf(urlToUrlConnection.getResponseCode()));
                    }
                    if (urlToUrlConnection != null) {
                        try {
                            urlToUrlConnection.disconnect();
                        } catch (Throwable th5) {
                            L.debug("HttpUtil", th5.getMessage(), new Object[0]);
                        }
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                dataOutputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            dataOutputStream = null;
        }
        return httpResp;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpResp postFileByUrlConn(String str, Map<String, String> map, Map<String, String> map2) throws Exception {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        HttpResp httpResp = new HttpResp();
        boolean z = true;
        String format = String.format("---------%d---------", Long.valueOf(System.currentTimeMillis()));
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", format));
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                if (map != null) {
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (value != null) {
                                stringBuffer.append("\r\n");
                                stringBuffer.append("--");
                                stringBuffer.append(format);
                                stringBuffer.append("\r\n");
                                stringBuffer.append("Content-Disposition: form-data; name=\"");
                                stringBuffer.append(key);
                                stringBuffer.append("\"\r\n\r\n");
                                stringBuffer.append(value);
                            }
                        }
                        dataOutputStream.write(stringBuffer.toString().getBytes());
                        stringBuffer.setLength(0);
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        throw th;
                    }
                }
                if (map2 != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                        String key2 = entry2.getKey();
                        String value2 = entry2.getValue();
                        if (value2 != null) {
                            File file = new File(value2);
                            stringBuffer2.setLength(0);
                            stringBuffer2.append("\r\n");
                            stringBuffer2.append("--");
                            stringBuffer2.append(format);
                            stringBuffer2.append("\r\n");
                            stringBuffer2.append("Content-Disposition: form-data; name=\"");
                            stringBuffer2.append(key2);
                            stringBuffer2.append("\"; filename=\"");
                            stringBuffer2.append(file.getName());
                            stringBuffer2.append("\"\r\n");
                            stringBuffer2.append("Content-Type:");
                            stringBuffer2.append(getContentType(file));
                            stringBuffer2.append("\r\n\r\n");
                            dataOutputStream.write(stringBuffer2.toString().getBytes());
                            try {
                                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = dataInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        dataOutputStream.write(bArr, 0, read);
                                    }
                                    dataInputStream2.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataInputStream = dataInputStream2;
                                    if (dataInputStream != null) {
                                        dataInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataInputStream = null;
                            }
                        }
                    }
                    stringBuffer2.setLength(0);
                }
                dataOutputStream.write(String.format("\r\n--%s--\r\n", format).getBytes());
                dataOutputStream.flush();
                if (httpURLConnection2.getResponseCode() != 200) {
                    z = false;
                }
                httpResp.isSucceed = z;
                httpResp.statusCode = httpURLConnection2.getResponseCode();
                httpResp.reason = httpURLConnection2.getResponseMessage();
                if (httpURLConnection2.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read2 = inputStream.read(bArr2);
                        if (read2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read2);
                    }
                    httpResp.result = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    inputStream.close();
                    byteArrayOutputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                dataOutputStream.close();
                return httpResp;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
    }

    public static HttpURLConnection urlToUrlConnection(String str) throws IOException {
        int i;
        URL url = new URL(str);
        if (Build.VERSION.SDK_INT > 27 && ((i = AppInfo.INSTANCE.targetSdkVersion) > 27 || i == 0)) {
            if (!url.getProtocol().equalsIgnoreCase("https")) {
                url = new URL("https" + str.substring(url.getProtocol().length()));
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            if (isIpAddress(url.getHost())) {
                httpsURLConnection.setSSLSocketFactory(SSLSocketClient.getSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(SSLSocketClient.getHostnameVerifier());
            }
            return httpsURLConnection;
        }
        return (HttpURLConnection) url.openConnection();
    }
}
