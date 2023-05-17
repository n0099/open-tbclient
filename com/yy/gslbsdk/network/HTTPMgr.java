package com.yy.gslbsdk.network;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes10.dex */
public class HTTPMgr {
    public static final String TAG = "HTTPMgr";

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ea, code lost:
        if (r2 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010b, code lost:
        if (r2 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010d, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0112: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:44:0x0112 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] doHttpURLConnection(String str, String str2, HashMap<String, String> hashMap, String str3) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
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
                            httpURLConnection.addRequestProperty(str4, hashMap.get(str4));
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f5, code lost:
        if (r2 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0116, code lost:
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0118, code lost:
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x011d: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:49:0x011d */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] doHttpsURLConnection(String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
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
                            httpsURLConnection.addRequestProperty(str5, hashMap.get(str5));
                        }
                    }
                    httpsURLConnection.setRequestMethod(str4);
                    httpsURLConnection.setConnectTimeout(GlobalTools.HTTP_TIMEOUT);
                    httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "Close");
                    httpsURLConnection.setReadTimeout(GlobalTools.HTTP_TIMEOUT);
                    httpsURLConnection.setRequestProperty("Host", str2);
                    httpsURLConnection.setHostnameVerifier(new TlsSniSocketFactory.HostnameVerifierEx(httpsURLConnection) { // from class: com.yy.gslbsdk.network.HTTPMgr.1
                        @Override // com.yy.gslbsdk.network.TlsSniSocketFactory.HostnameVerifierEx, javax.net.ssl.HostnameVerifier
                        public boolean verify(String str6, SSLSession sSLSession) {
                            String requestProperty = this.mConn.getRequestProperty("Host");
                            if (requestProperty == null) {
                                requestProperty = this.mConn.getURL().getHost();
                            }
                            if (!TextUtils.isEmpty(requestProperty) && requestProperty.equals(GlobalTools.HTTPDNS_SERVER_HOST)) {
                                return true;
                            }
                            return false;
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
    }

    public static void exceptionLog(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                stringBuffer.append("\tat ");
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
            LogTools.printWarning(TAG, stringBuffer.toString());
        }
    }

    public static String[] getHttp(String str, HashMap<String, String> hashMap) {
        return doHttpURLConnection(str, null, hashMap, "GET");
    }

    public static String[] headHttp(String str, HashMap<String, String> hashMap) {
        return doHttpURLConnection(str, null, hashMap, "HEAD");
    }

    public static String[] getHttps(String str, String str2, HashMap<String, String> hashMap) {
        return doHttpsURLConnection(str, str2, null, hashMap, "GET");
    }

    public static String[] postHttp(String str, String str2, HashMap<String, String> hashMap) {
        return doHttpURLConnection(str, str2, hashMap, "POST");
    }

    public static String inputStreamToString(InputStream inputStream) {
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

    public static String[] post(String str, String str2, HashMap<String, String> hashMap, boolean z) {
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

    public static String[] postSniHttps(String str, String str2, String str3, HashMap<String, String> hashMap) {
        return doHttpsURLConnection(str, str2, str3, hashMap, "POST");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ac: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x00ac */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] postHttp(String str, String str2) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
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
    }
}
