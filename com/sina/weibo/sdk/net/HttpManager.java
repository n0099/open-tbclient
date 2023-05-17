package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.Set;
/* loaded from: classes9.dex */
public class HttpManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BOUNDARY;
    public static final String END_MP_BOUNDARY;
    public static final String MP_BOUNDARY;
    public static final String TAG = "HttpManager";
    public transient /* synthetic */ FieldHolder $fh;

    public static native String calcOauthSignNative(Context context, String str, String str2);

    public static void fillCommonRequestParam(IRequestParam iRequestParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iRequestParam) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(367038736, "Lcom/sina/weibo/sdk/net/HttpManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(367038736, "Lcom/sina/weibo/sdk/net/HttpManager;");
                return;
            }
        }
        System.loadLibrary("weibosdkcore");
        BOUNDARY = getBoundry();
        MP_BOUNDARY = "--" + BOUNDARY;
        END_MP_BOUNDARY = "--" + BOUNDARY + "--";
    }

    public static String getBoundry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i < 12; i++) {
                long currentTimeMillis = System.currentTimeMillis() + i;
                long j = currentTimeMillis % 3;
                if (j == 0) {
                    stringBuffer.append(((char) currentTimeMillis) % '\t');
                } else if (j == 1) {
                    stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
                } else {
                    stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public HttpManager() {
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

    public static String getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
        return (String) invokeV.objValue;
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, outputStream, weiboParameters) == null) {
            try {
                Set<String> keySet = weiboParameters.keySet();
                for (String str : keySet) {
                    if (weiboParameters.get(str) instanceof String) {
                        StringBuilder sb = new StringBuilder(100);
                        sb.setLength(0);
                        sb.append(MP_BOUNDARY);
                        sb.append("\r\n");
                        sb.append("content-disposition: form-data; name=\"");
                        sb.append(str);
                        sb.append("\"\r\n\r\n");
                        sb.append(weiboParameters.get(str));
                        sb.append("\r\n");
                        outputStream.write(sb.toString().getBytes());
                    }
                }
                for (String str2 : keySet) {
                    Object obj = weiboParameters.get(str2);
                    if (obj instanceof Bitmap) {
                        outputStream.write((MP_BOUNDARY + "\r\ncontent-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        outputStream.write(byteArrayOutputStream.toByteArray());
                        outputStream.write("\r\n".getBytes());
                    } else if (obj instanceof ByteArrayOutputStream) {
                        outputStream.write((MP_BOUNDARY + "\r\ncontent-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                        ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                        outputStream.write(byteArrayOutputStream2.toByteArray());
                        outputStream.write("\r\n".getBytes());
                        byteArrayOutputStream2.close();
                    }
                }
                outputStream.write(("\r\n" + END_MP_BOUNDARY).getBytes());
            } catch (IOException e) {
                throw new WeiboException(e);
            }
        }
    }

    public static synchronized String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        InterceptResult invokeLLLL;
        long j;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3)) == null) {
            synchronized (HttpManager.class) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str3);
                if (file2.exists()) {
                    return file2.getPath();
                }
                if (!URLUtil.isValidUrl(str)) {
                    return "";
                }
                File file3 = new File(str2, str3 + "_temp");
                HttpURLConnection createConnect = ConnectionFactory.createConnect(str, context);
                createConnect.setConnectTimeout(300000);
                createConnect.setReadTimeout(300000);
                try {
                    createConnect.setRequestMethod("GET");
                } catch (Exception unused) {
                }
                try {
                    if (file3.exists()) {
                        j = file3.length();
                    } else {
                        file3.createNewFile();
                        j = 0;
                    }
                    createConnect.setRequestProperty("RANGE", "bytes=" + j);
                    int responseCode = createConnect.getResponseCode();
                    if (responseCode == 206) {
                        contentLength = 0;
                    } else if (responseCode == 200) {
                        contentLength = createConnect.getContentLength();
                    } else {
                        throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                    }
                    InputStream inputStream = createConnect.getInputStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(0L);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    inputStream.close();
                    if (contentLength != 0 && file3.length() >= contentLength) {
                        file3.renameTo(file2);
                        return file2.getPath();
                    }
                    file3.delete();
                } catch (Exception unused2) {
                }
                return "";
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, context, str, str2, str3, str4)) == null) {
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
        return (String) invokeLLLLL.objValue;
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        InterceptResult invokeLLLL;
        HttpURLConnection createConnect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, context, str, str2, weiboParameters)) == null) {
            if (str2.equals("GET")) {
                if (str.endsWith("?")) {
                    str = str + weiboParameters.encodeUrl();
                } else {
                    str = str + "?" + weiboParameters.encodeUrl();
                }
                createConnect = ConnectionFactory.createConnect(str, context);
            } else {
                createConnect = ConnectionFactory.createConnect(str, context);
            }
            try {
                createConnect.setInstanceFollowRedirects(false);
                createConnect.connect();
                int responseCode = createConnect.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    if (responseCode != 200) {
                        str = "";
                    }
                    return str;
                }
                str = createConnect.getHeaderField("Location");
                return str;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, context, str, str2, weiboParameters)) == null) {
            String requestHttpExecute = requestHttpExecute(context, str, str2, weiboParameters);
            LogUtil.d("HttpManager", "Response : " + requestHttpExecute);
            return requestHttpExecute;
        }
        return (String) invokeLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readConnectResponse(HttpURLConnection httpURLConnection, boolean z) {
        InterceptResult invokeLZ;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, httpURLConnection, z)) == null) {
            InputStream inputStream2 = null;
            String str = null;
            inputStream2 = null;
            try {
                byte[] bArr = new byte[8192];
                if (z) {
                    inputStream = httpURLConnection.getErrorStream();
                } else {
                    inputStream = httpURLConnection.getInputStream();
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    if (inputStream != null) {
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (IOException e) {
                                inputStream2 = inputStream;
                                e = e;
                                try {
                                    throw new WeiboException(e);
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                inputStream2 = inputStream;
                                th = th2;
                                if (inputStream2 != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused4) {
                    }
                    return str;
                } catch (IOException e2) {
                    inputStream2 = inputStream;
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    inputStream2 = inputStream;
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        } else {
            return (String) invokeLZ.objValue;
        }
    }

    public static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, weiboParameters) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(weiboParameters.getAppKey())) {
                str = "";
            } else {
                str = Utility.getAid(context, weiboParameters.getAppKey());
                if (!TextUtils.isEmpty(str)) {
                    weiboParameters.put("aid", str);
                }
            }
            String timestamp = getTimestamp();
            weiboParameters.put("oauth_timestamp", timestamp);
            Object obj = weiboParameters.get("access_token");
            Object obj2 = weiboParameters.get("refresh_token");
            Object obj3 = weiboParameters.get("phone");
            if (obj != null && (obj instanceof String)) {
                str2 = (String) obj;
            } else if (obj2 != null && (obj2 instanceof String)) {
                str2 = (String) obj2;
            } else if (obj3 != null && (obj3 instanceof String)) {
                str2 = (String) obj3;
            }
            weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
        }
    }

    public static String requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        InterceptResult invokeLLLL;
        HttpURLConnection createConnect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, context, str, str2, weiboParameters)) == null) {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    setHttpCommonParam(context, weiboParameters);
                    if ("GET".equals(str2)) {
                        createConnect = ConnectionFactory.createConnect(str + "?" + weiboParameters.encodeUrl(), context);
                        createConnect.setRequestMethod("GET");
                        createConnect.setInstanceFollowRedirects(true);
                        createConnect.connect();
                    } else {
                        createConnect = ConnectionFactory.createConnect(str, context);
                        createConnect.setInstanceFollowRedirects(true);
                        createConnect.connect();
                        if (weiboParameters.hasBinaryData()) {
                            DataOutputStream dataOutputStream = new DataOutputStream(createConnect.getOutputStream());
                            buildParams(dataOutputStream, weiboParameters);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } else {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(createConnect.getOutputStream());
                            dataOutputStream2.write(weiboParameters.encodeUrl().getBytes("UTF-8"));
                            dataOutputStream2.flush();
                            dataOutputStream2.close();
                        }
                    }
                    int responseCode = createConnect.getResponseCode();
                    if (responseCode == 200) {
                        String readConnectResponse = readConnectResponse(createConnect, false);
                        if (createConnect != null) {
                            createConnect.disconnect();
                        }
                        return readConnectResponse;
                    }
                    throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new WeiboException(e);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        return (String) invokeLLLL.objValue;
    }
}
