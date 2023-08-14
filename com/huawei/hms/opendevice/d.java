package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tieba.bqb;
import com.baidu.tieba.qqb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final /* synthetic */ a[] c;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(244988986, "Lcom/huawei/hms/opendevice/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(244988986, "Lcom/huawei/hms/opendevice/d$a;");
                    return;
                }
            }
            a = new a("GET", 0, "GET");
            a aVar = new a("POST", 1, "POST");
            b = aVar;
            c = new a[]{a, aVar};
        }

        public a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) c.clone();
            }
            return (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x00be */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x00f0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.OutputStream, java.io.FilterOutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v31 */
    public static String a(Context context, String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLLL;
        ?? r8;
        InputStream inputStream;
        ?? r10;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        InputStream inputStream5;
        ?? r82;
        InputStream inputStream6;
        InputStream inputStream7;
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, str, str2, map)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            if (str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            int i = -1;
            try {
                try {
                    httpURLConnection = a(context, str, map, a.b.a());
                    if (httpURLConnection == null) {
                        qqb.c(null);
                        qqb.b(null);
                        qqb.b(null);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    }
                    try {
                        r82 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    } catch (IOException unused) {
                        inputStream4 = null;
                        inputStream5 = inputStream4;
                        r82 = inputStream4;
                        inputStream6 = inputStream5;
                        StringBuilder sb = new StringBuilder();
                        sb.append("http execute encounter IOException - http code:");
                        sb.append(i);
                        HMSLog.w("PushHttpClient", sb.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException unused2) {
                        inputStream3 = null;
                        inputStream5 = inputStream3;
                        r82 = inputStream3;
                        inputStream6 = inputStream5;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("http execute encounter RuntimeException - http code:");
                        sb2.append(i);
                        HMSLog.w("PushHttpClient", sb2.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception unused3) {
                        inputStream2 = null;
                        inputStream5 = inputStream2;
                        r82 = inputStream2;
                        inputStream6 = inputStream5;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("http execute encounter unknown exception - http code:");
                        sb3.append(i);
                        HMSLog.w("PushHttpClient", sb3.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th) {
                        inputStream = null;
                        r10 = 0;
                        httpURLConnection2 = httpURLConnection;
                        th = th;
                        r8 = 0;
                    }
                    try {
                        r82.write(str2.getBytes("UTF-8"));
                        r82.flush();
                        i = httpURLConnection.getResponseCode();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("http post response code: ");
                        sb4.append(i);
                        HMSLog.d("PushHttpClient", sb4.toString());
                        if (i >= 400) {
                            inputStream5 = httpURLConnection.getErrorStream();
                        } else {
                            inputStream5 = httpURLConnection.getInputStream();
                        }
                        try {
                            inputStream6 = new BufferedInputStream(inputStream5);
                            try {
                                String a2 = s.a(inputStream6);
                                qqb.c(r82);
                                qqb.b(inputStream5);
                                qqb.b(inputStream6);
                                s.a(httpURLConnection);
                                HMSLog.i("PushHttpClient", "close connection");
                                return a2;
                            } catch (IOException unused4) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("http execute encounter IOException - http code:");
                                sb5.append(i);
                                HMSLog.w("PushHttpClient", sb5.toString());
                                outputStream = r82;
                                inputStream7 = inputStream5;
                                qqb.c(outputStream);
                                qqb.b(inputStream7);
                                qqb.b(inputStream6);
                                s.a(httpURLConnection);
                                HMSLog.i("PushHttpClient", "close connection");
                                return null;
                            } catch (RuntimeException unused5) {
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("http execute encounter RuntimeException - http code:");
                                sb22.append(i);
                                HMSLog.w("PushHttpClient", sb22.toString());
                                outputStream = r82;
                                inputStream7 = inputStream5;
                                qqb.c(outputStream);
                                qqb.b(inputStream7);
                                qqb.b(inputStream6);
                                s.a(httpURLConnection);
                                HMSLog.i("PushHttpClient", "close connection");
                                return null;
                            } catch (Exception unused6) {
                                StringBuilder sb32 = new StringBuilder();
                                sb32.append("http execute encounter unknown exception - http code:");
                                sb32.append(i);
                                HMSLog.w("PushHttpClient", sb32.toString());
                                outputStream = r82;
                                inputStream7 = inputStream5;
                                qqb.c(outputStream);
                                qqb.b(inputStream7);
                                qqb.b(inputStream6);
                                s.a(httpURLConnection);
                                HMSLog.i("PushHttpClient", "close connection");
                                return null;
                            }
                        } catch (IOException unused7) {
                            inputStream6 = null;
                        } catch (RuntimeException unused8) {
                            inputStream6 = null;
                        } catch (Exception unused9) {
                            inputStream6 = null;
                        } catch (Throwable th2) {
                            httpURLConnection2 = httpURLConnection;
                            th = th2;
                            r10 = 0;
                            r8 = r82;
                            inputStream = inputStream5;
                            qqb.c(r8);
                            qqb.b(inputStream);
                            qqb.b(r10);
                            s.a(httpURLConnection2);
                            HMSLog.i("PushHttpClient", "close connection");
                            throw th;
                        }
                    } catch (IOException unused10) {
                        inputStream5 = null;
                        r82 = r82;
                        inputStream6 = inputStream5;
                        StringBuilder sb52 = new StringBuilder();
                        sb52.append("http execute encounter IOException - http code:");
                        sb52.append(i);
                        HMSLog.w("PushHttpClient", sb52.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException unused11) {
                        inputStream5 = null;
                        r82 = r82;
                        inputStream6 = inputStream5;
                        StringBuilder sb222 = new StringBuilder();
                        sb222.append("http execute encounter RuntimeException - http code:");
                        sb222.append(i);
                        HMSLog.w("PushHttpClient", sb222.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception unused12) {
                        inputStream5 = null;
                        r82 = r82;
                        inputStream6 = inputStream5;
                        StringBuilder sb322 = new StringBuilder();
                        sb322.append("http execute encounter unknown exception - http code:");
                        sb322.append(i);
                        HMSLog.w("PushHttpClient", sb322.toString());
                        outputStream = r82;
                        inputStream7 = inputStream5;
                        qqb.c(outputStream);
                        qqb.b(inputStream7);
                        qqb.b(inputStream6);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th3) {
                        r10 = 0;
                        httpURLConnection2 = httpURLConnection;
                        th = th3;
                        inputStream = null;
                        r8 = r82;
                    }
                } catch (Throwable th4) {
                    httpURLConnection2 = context;
                    th = th4;
                    r8 = str;
                    inputStream = str2;
                    r10 = map;
                }
            } catch (IOException unused13) {
                httpURLConnection = null;
                inputStream4 = null;
            } catch (RuntimeException unused14) {
                httpURLConnection = null;
                inputStream3 = null;
            } catch (Exception unused15) {
                httpURLConnection = null;
                inputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                r8 = 0;
                inputStream = null;
                r10 = 0;
            }
        } else {
            return (String) invokeLLLL.objValue;
        }
    }

    public static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        InterceptResult invokeLLLL;
        String value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, map, str2)) == null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a(context, httpURLConnection);
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "close");
            if (map != null && map.size() >= 1) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null && !TextUtils.isEmpty(key)) {
                        if (entry.getValue() == null) {
                            value = "";
                        } else {
                            value = entry.getValue();
                        }
                        httpURLConnection.setRequestProperty(key, URLEncoder.encode(value, "UTF-8"));
                    }
                }
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeLLLL.objValue;
    }

    public static void a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, httpURLConnection) == null) && (httpURLConnection instanceof HttpsURLConnection)) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            bqb bqbVar = null;
            try {
                bqbVar = bqb.b(context);
            } catch (IOException unused) {
                HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
            } catch (IllegalAccessException unused2) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
            } catch (IllegalArgumentException unused3) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
            } catch (KeyStoreException unused4) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
            } catch (NoSuchAlgorithmException unused5) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
            } catch (GeneralSecurityException unused6) {
                HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
            }
            if (bqbVar != null) {
                httpsURLConnection.setSSLSocketFactory(bqbVar);
                httpsURLConnection.setHostnameVerifier(bqb.i);
                return;
            }
            throw new Exception("No ssl socket factory set.");
        }
    }
}
