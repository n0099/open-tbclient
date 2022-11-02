package com.yy.hiidostatis.inner.util.http;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class HttpUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern ipv4Pattern;
    public transient /* synthetic */ FieldHolder $fh;

    public static String getContentType(File file) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) ? "application/octet-stream" : (String) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static class HttpResp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isSucceed;
        public String reason;
        public String remoteIp;
        public String result;
        public int statusCode;

        public HttpResp() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isSucceed = false;
            this.statusCode = -1;
            this.reason = null;
            this.result = null;
            this.remoteIp = null;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282563701, "Lcom/yy/hiidostatis/inner/util/http/HttpUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282563701, "Lcom/yy/hiidostatis/inner/util/http/HttpUtil;");
                return;
            }
        }
        ipv4Pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
    }

    public HttpUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String get(String str, Map<String, String> map) throws IOException {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static String getAddressInfo(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpURLConnection)) == null) {
            if (Build.VERSION.SDK_INT > 27) {
                return "";
            }
            try {
                Field declaredField = httpURLConnection.getClass().getDeclaredField("route");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(httpURLConnection);
                Field declaredField2 = obj.getClass().getDeclaredField(IMTrack.AckBuilder.PROXY_TYPE);
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
        return (String) invokeL.objValue;
    }

    public static HttpURLConnection urlToUrlConnection(String str) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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
        return (HttpURLConnection) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7 A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #1 {all -> 0x00f3, blocks: (B:37:0x00ef, B:41:0x00f7), top: B:61:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpResp getByUrlConn(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        InputStream inputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
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
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th2) {
                                L.debug("HttpUtil", th2.getMessage(), new Object[0]);
                            }
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
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th3;
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
                    } catch (Throwable th5) {
                        L.debug("HttpUtil", th5.getMessage(), new Object[0]);
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = urlToUrlConnection;
                inputStream = null;
                L.error("HttpUtil", "getByUrlConn exception e:" + th.getMessage(), new Object[0]);
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                return httpResp;
            }
            return httpResp;
        }
        return (HttpResp) invokeLL.objValue;
    }

    public static HttpResp postByUrlConn(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
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
        return (HttpResp) invokeLL.objValue;
    }

    public static boolean isIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return ipv4Pattern.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String post(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            return postByUrlConn(str, str2).result;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpResp postFileByUrlConn(String str, Map<String, String> map, Map<String, String> map2) throws Exception {
        InterceptResult invokeLLL;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection2;
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, map, map2)) == null) {
            HttpResp httpResp = new HttpResp();
            boolean z = true;
            String format = String.format("---------%d---------", Long.valueOf(System.currentTimeMillis()));
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
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
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
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
                                } catch (Throwable th3) {
                                    th = th3;
                                    dataInputStream = dataInputStream2;
                                    if (dataInputStream != null) {
                                        dataInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
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
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                throw th;
            }
        }
        return (HttpResp) invokeLLL.objValue;
    }
}
