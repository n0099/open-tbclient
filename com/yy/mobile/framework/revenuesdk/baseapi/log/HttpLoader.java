package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class HttpLoader {

    /* loaded from: classes7.dex */
    public static class MyHostnameVerifier implements HostnameVerifier {
        public MyHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class MyX509TrustManager implements X509TrustManager {
        public MyX509TrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static void ignoreSSLCertError(HttpsURLConnection httpsURLConnection) {
        try {
            TrustManager[] trustManagerArr = {new MyX509TrustManager()};
            SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new MyHostnameVerifier());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String postData(String str, Map<String, String> map) {
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (URLUtil.isHttpsUrl(str)) {
                    ignoreSSLCertError((HttpsURLConnection) httpURLConnection);
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    StringBuilder sb = new StringBuilder();
                    for (String str2 : map.keySet()) {
                        sb.append(str2);
                        sb.append("=");
                        sb.append(map.get(str2));
                        sb.append("&");
                    }
                    dataOutputStream2.write(sb.toString().getBytes("UTF-8"));
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                        }
                        String sb3 = sb2.toString();
                        bufferedReader.close();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        return sb3;
                    } catch (Exception e5) {
                        dataOutputStream = dataOutputStream2;
                        e = e5;
                        inputStream = inputStream2;
                        try {
                            e.printStackTrace();
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                try {
                                    httpURLConnection2.disconnect();
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        httpURLConnection2 = httpURLConnection;
                        dataOutputStream = dataOutputStream2;
                        th = th2;
                        inputStream = inputStream2;
                        if (httpURLConnection2 != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    inputStream = null;
                    dataOutputStream = dataOutputStream2;
                    e = e12;
                } catch (Throwable th3) {
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    dataOutputStream = dataOutputStream2;
                    th = th3;
                }
            } catch (Exception e13) {
                e = e13;
                dataOutputStream = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                inputStream = null;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                }
                if (dataOutputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            dataOutputStream = null;
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0098 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00e2 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.zip.GZIPInputStream, java.io.InputStream] */
    public static String postJson(String str, String str2) {
        GZIPInputStream gZIPInputStream;
        BufferedReader bufferedReader;
        String str3 = "";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(Config.LAUNCH_REFERER, "https://www.yy.com/index.html");
                    httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "application/json");
                    if (str2 != 0 && !TextUtils.isEmpty(str2)) {
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        str2 = new GZIPInputStream(httpURLConnection.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) str2, "UTF-8"));
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            str3 = bufferedReader.readLine();
                            bufferedReader2 = bufferedReader;
                            gZIPInputStream = str2;
                        } catch (Exception e3) {
                            bufferedReader2 = bufferedReader;
                            e = e3;
                            e.printStackTrace();
                            Log.e("yyrevenue", "xxxxx > " + e.toString());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                str2.close();
                            }
                            return str3;
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader;
                            th = th;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        gZIPInputStream = null;
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e8) {
                e = e8;
                str2 = 0;
            } catch (Throwable th3) {
                th = th3;
                str2 = 0;
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        return str3;
    }
}
