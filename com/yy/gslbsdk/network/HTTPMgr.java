package com.yy.gslbsdk.network;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.network.TlsSniSocketFactory;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public class HTTPMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HTTPMgr";
    public transient /* synthetic */ FieldHolder $fh;

    public HTTPMgr() {
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ee, code lost:
        if (r2 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010f, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0114, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0116: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:46:0x0116 */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] doHttpURLConnection(String str, String str2, HashMap hashMap, String str3) {
        InterceptResult invokeLLLL;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, hashMap, str3)) == null) {
            HttpURLConnection httpURLConnection3 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    if (httpURLConnection == null) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                    if (hashMap != null) {
                        try {
                            for (String str4 : hashMap.keySet()) {
                                httpURLConnection.addRequestProperty(str4, (String) hashMap.get(str4));
                            }
                        } catch (Exception e) {
                            e = e;
                            LogTools.printWarning(TAG, "doHttpURLConnection: " + e.getMessage());
                        }
                    }
                    httpURLConnection.setRequestMethod(str3);
                    httpURLConnection.setConnectTimeout(GlobalTools.HTTP_TIMEOUT);
                    httpURLConnection.setReadTimeout(GlobalTools.HTTP_TIMEOUT);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "Close");
                    httpURLConnection.setDoInput(true);
                    if (str2 != null && str2.length() > 0) {
                        httpURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes("UTF-8"));
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        httpURLConnection.setDoOutput(false);
                        str2 = StringUtil.NULL_STRING;
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        StringBuffer stringBuffer = new StringBuffer();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                            stringBuffer.append("\n");
                        }
                        bufferedReader.close();
                        String[] strArr = {String.valueOf(responseCode), stringBuffer.toString()};
                        LogTools.printDebug(TAG, String.format(Locale.US, "http %s url: %s, content: %s, code: %d, json: %s", str3, str, str2, Integer.valueOf(responseCode), strArr[1]));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return strArr;
                    }
                    LogTools.printDebug(TAG, String.format(Locale.US, "http %s data failed, code = %d", str3, Integer.valueOf(responseCode)));
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection3 = httpURLConnection2;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection3 != null) {
                }
                throw th;
            }
        } else {
            return (String[]) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f9, code lost:
        if (r2 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011a, code lost:
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011c, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011f, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0121: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:51:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] doHttpsURLConnection(String str, String str2, String str3, HashMap hashMap, String str4) {
        InterceptResult invokeLLLLL;
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, str, str2, str3, hashMap, str4)) == null) {
            HttpsURLConnection httpsURLConnection3 = null;
            try {
                try {
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        if (httpsURLConnection == null) {
                            LogTools.printDebug(TAG, "conn == null");
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            return null;
                        }
                        httpsURLConnection.setSSLSocketFactory(new TlsOnlySocketFactory());
                        if (hashMap != null) {
                            for (String str5 : hashMap.keySet()) {
                                httpsURLConnection.addRequestProperty(str5, (String) hashMap.get(str5));
                            }
                        }
                        httpsURLConnection.setRequestMethod(str4);
                        httpsURLConnection.setConnectTimeout(GlobalTools.HTTP_TIMEOUT);
                        httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "Close");
                        httpsURLConnection.setReadTimeout(GlobalTools.HTTP_TIMEOUT);
                        httpsURLConnection.setRequestProperty("Host", str2);
                        httpsURLConnection.setHostnameVerifier(new TlsSniSocketFactory.HostnameVerifierEx(httpsURLConnection) { // from class: com.yy.gslbsdk.network.HTTPMgr.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(httpsURLConnection);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {httpsURLConnection};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super((HttpsURLConnection) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                            }

                            @Override // com.yy.gslbsdk.network.TlsSniSocketFactory.HostnameVerifierEx, javax.net.ssl.HostnameVerifier
                            public boolean verify(String str6, SSLSession sSLSession) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str6, sSLSession)) == null) {
                                    String requestProperty = this.mConn.getRequestProperty("Host");
                                    if (requestProperty == null) {
                                        requestProperty = this.mConn.getURL().getHost();
                                    }
                                    if (!TextUtils.isEmpty(requestProperty) && requestProperty.equals(GlobalTools.HTTPDNS_SERVER_HOST)) {
                                        return true;
                                    }
                                    return false;
                                }
                                return invokeLL.booleanValue;
                            }
                        });
                        httpsURLConnection.setDoInput(true);
                        if (str3 != null && str3.length() > 0) {
                            httpsURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpsURLConnection.getOutputStream();
                            outputStream.write(str3.getBytes("UTF-8"));
                            outputStream.flush();
                            outputStream.close();
                        } else {
                            httpsURLConnection.setDoOutput(false);
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            StringBuffer stringBuffer = new StringBuffer();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8"));
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                                stringBuffer.append("\n");
                            }
                            bufferedReader.close();
                            String[] strArr = {String.valueOf(responseCode), stringBuffer.toString()};
                            Locale locale = Locale.US;
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            if (str3 == null) {
                                str3 = "";
                            }
                            objArr[1] = str3;
                            LogTools.printDebug(TAG, String.format(locale, "doHttpsURLConnection url: %s, content: %s", objArr));
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            return strArr;
                        }
                        LogTools.printDebug(TAG, String.format(Locale.US, "doHttpsURLConnection data failed, code = %d", Integer.valueOf(responseCode)));
                    } catch (Exception e) {
                        e = e;
                        LogTools.printWarning(TAG, "doHttpsURLConnection：" + e.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection3 = httpsURLConnection2;
                    if (httpsURLConnection3 != null) {
                        httpsURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpsURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (httpsURLConnection3 != null) {
                }
                throw th;
            }
        } else {
            return (String[]) invokeLLLLL.objValue;
        }
    }

    public static void exceptionLog(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, stackTraceElementArr) == null) && stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                stringBuffer.append("\tat ");
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
            LogTools.printWarning(TAG, stringBuffer.toString());
        }
    }

    public static String[] getHttp(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, hashMap)) == null) {
            return doHttpURLConnection(str, null, hashMap, "GET");
        }
        return (String[]) invokeLL.objValue;
    }

    public static String[] headHttp(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, hashMap)) == null) {
            return doHttpURLConnection(str, null, hashMap, "HEAD");
        }
        return (String[]) invokeLL.objValue;
    }

    public static String[] getHttps(String str, String str2, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, hashMap)) == null) {
            return doHttpsURLConnection(str, str2, null, hashMap, "GET");
        }
        return (String[]) invokeLLL.objValue;
    }

    public static String[] postHttp(String str, String str2, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, str2, hashMap)) == null) {
            return doHttpURLConnection(str, str2, hashMap, "POST");
        }
        return (String[]) invokeLLL.objValue;
    }

    public static String inputStreamToString(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, inputStream)) == null) {
            String str = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine;
                }
            } catch (IOException e) {
                LogTools.printError(TAG, "inputStreamToString：" + e.getMessage());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String[] post(String str, String str2, HashMap hashMap, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, hashMap, Boolean.valueOf(z)})) == null) {
            if (str != null) {
                if (z && str.startsWith("http://")) {
                    str = str.replace("http://", "https://");
                } else if (!z && str.startsWith("https://")) {
                    str = str.replace("https://", "http://");
                }
            }
            if (z) {
                return doHttpsURLConnection(str, GlobalTools.HTTPDNS_REPORT_HOST, str2, hashMap, "POST");
            }
            return doHttpURLConnection(str, str2, hashMap, "POST");
        }
        return (String[]) invokeCommon.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b0: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x00b0 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] postHttp(String str, String str2) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            HttpURLConnection httpURLConnection3 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(new String(str)).openConnection();
                    try {
                        if (httpURLConnection == null) {
                            LogTools.printError(TAG, "postHttp：fail to url.openConnection");
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setConnectTimeout(GlobalTools.HTTP_TIMEOUT);
                        httpURLConnection.setReadTimeout(GlobalTools.HTTP_TIMEOUT);
                        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "Close");
                        if (str2 != null && str2.length() > 0) {
                            httpURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(str2.getBytes("UTF-8"));
                            outputStream.flush();
                            outputStream.close();
                        } else {
                            httpURLConnection.setDoOutput(false);
                        }
                        String[] strArr = {String.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage()};
                        LogTools.printDebug(TAG, "postHttp " + str);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return strArr;
                    } catch (Exception e) {
                        e = e;
                        LogTools.printWarning(TAG, "postHttp：" + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection3 = httpURLConnection2;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection3 != null) {
                }
                throw th;
            }
        } else {
            return (String[]) invokeLL.objValue;
        }
    }

    public static String[] postSniHttps(String str, String str2, String str3, HashMap hashMap) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, str, str2, str3, hashMap)) == null) {
            return doHttpsURLConnection(str, str2, str3, hashMap, "POST");
        }
        return (String[]) invokeLLLL.objValue;
    }
}
