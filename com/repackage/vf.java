package com.repackage;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes7.dex */
public class vf {
    public static /* synthetic */ Interceptable $ic;
    public static vf b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, uf> a;

    /* loaded from: classes7.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wf a;

        public a(vf vfVar, wf wfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vfVar, wfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wfVar;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
                if (!verify) {
                    this.a.e(true);
                }
                return verify;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964025003, "Lcom/repackage/vf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964025003, "Lcom/repackage/vf;");
        }
    }

    public vf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static vf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (vf.class) {
                    if (b == null) {
                        b = new vf();
                    }
                }
            }
            return b;
        }
        return (vf) invokeV.objValue;
    }

    public wf b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            wf wfVar = new wf();
            uf ufVar = this.a.get(str);
            if (ufVar != null && !ufVar.c(System.currentTimeMillis()) && ufVar.a() != null && ufVar.a().size() > 0) {
                wfVar.g(ufVar.a().get(0));
            }
            return wfVar;
        }
        return (wf) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00e3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0125 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010a A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:22:0x00b1, B:24:0x00b7, B:25:0x00bb, B:50:0x00fb, B:52:0x010a, B:53:0x010d), top: B:81:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117 A[Catch: Exception -> 0x0124, TryCatch #10 {Exception -> 0x0124, blocks: (B:55:0x0112, B:57:0x0117, B:59:0x011c, B:61:0x0121), top: B:84:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011c A[Catch: Exception -> 0x0124, TryCatch #10 {Exception -> 0x0124, blocks: (B:55:0x0112, B:57:0x0117, B:59:0x011c, B:61:0x0121), top: B:84:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0121 A[Catch: Exception -> 0x0124, TRY_LEAVE, TryCatch #10 {Exception -> 0x0124, blocks: (B:55:0x0112, B:57:0x0117, B:59:0x011c, B:61:0x0121), top: B:84:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e A[Catch: Exception -> 0x013b, TryCatch #7 {Exception -> 0x013b, blocks: (B:66:0x0129, B:68:0x012e, B:70:0x0133, B:72:0x0138), top: B:82:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133 A[Catch: Exception -> 0x013b, TryCatch #7 {Exception -> 0x013b, blocks: (B:66:0x0129, B:68:0x012e, B:70:0x0133, B:72:0x0138), top: B:82:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0138 A[Catch: Exception -> 0x013b, TRY_LEAVE, TryCatch #7 {Exception -> 0x013b, blocks: (B:66:0x0129, B:68:0x012e, B:70:0x0133, B:72:0x0138), top: B:82:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final uf c(String str, wf wfVar) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        InputStream inputStream3;
        ?? r5;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, wfVar)) != null) {
            return (uf) invokeLL.objValue;
        }
        InputStreamReader inputStreamReader = null;
        if (ni.isEmpty(str)) {
            return null;
        }
        wfVar.i(true);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                if (wfVar.c()) {
                    HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL("http://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    try {
                        httpURLConnection4.setDoOutput(true);
                        httpURLConnection4.setDoInput(true);
                        httpURLConnection4.setUseCaches(false);
                        httpURLConnection4.setConnectTimeout(5000);
                        httpURLConnection4.setReadTimeout(10000);
                        httpURLConnection4.setRequestMethod("GET");
                        httpURLConnection4.connect();
                        inputStream3 = httpURLConnection4.getInputStream();
                        str = httpURLConnection4;
                    } catch (Exception e) {
                        e = e;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection4;
                        inputStream2 = inputStream;
                        inputStream3 = inputStream;
                        str = httpURLConnection2;
                        r5 = inputStream2;
                        wfVar.h(e.getClass().getName());
                        if (e instanceof SSLException) {
                        }
                        e.printStackTrace();
                        if (inputStream2 != null) {
                        }
                        if (inputStream3 != null) {
                        }
                        if (r5 != 0) {
                        }
                        if (str != 0) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection4;
                        bufferedReader2 = bufferedReader;
                        inputStream4 = bufferedReader;
                        httpURLConnection3 = httpURLConnection;
                        if (inputStreamReader != null) {
                        }
                        if (inputStream4 != 0) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        throw th;
                    }
                } else {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
                    httpsURLConnection.setHostnameVerifier(new a(this, wfVar));
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.connect();
                    inputStream3 = httpsURLConnection.getInputStream();
                    str = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                inputStream2 = new InputStreamReader(inputStream3, IMAudioTransRequest.CHARSET);
            } catch (Exception e2) {
                e = e2;
                inputStream2 = null;
                inputStream3 = inputStream3;
                str = str;
                r5 = inputStream2;
                wfVar.h(e.getClass().getName());
                if (e instanceof SSLException) {
                }
                e.printStackTrace();
                if (inputStream2 != null) {
                }
                if (inputStream3 != null) {
                }
                if (r5 != 0) {
                }
                if (str != 0) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                inputStream4 = inputStream3;
                httpURLConnection3 = str;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused) {
                        throw th;
                    }
                }
                if (inputStream4 != 0) {
                    inputStream4.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
            try {
                r5 = new BufferedReader(inputStream2);
                while (true) {
                    try {
                        String readLine = r5.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (Exception e3) {
                        e = e3;
                        wfVar.h(e.getClass().getName());
                        if (e instanceof SSLException) {
                            wfVar.e(true);
                        }
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (r5 != 0) {
                            r5.close();
                        }
                        if (str != 0) {
                            str.disconnect();
                        }
                        return null;
                    }
                }
                uf ufVar = new uf();
                ufVar.e(System.currentTimeMillis());
                wfVar.d();
                uf b2 = ufVar.b(stringBuffer.toString());
                try {
                    inputStream2.close();
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    r5.close();
                    if (str != 0) {
                        str.disconnect();
                    }
                } catch (Exception unused3) {
                }
                return b2;
            } catch (Exception e4) {
                e = e4;
                r5 = 0;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                inputStreamReader = inputStream2;
                inputStream4 = inputStream3;
                httpURLConnection3 = str;
                if (inputStreamReader != null) {
                }
                if (inputStream4 != 0) {
                }
                if (bufferedReader2 != null) {
                }
                if (httpURLConnection3 != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection2 = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public wf d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            wf wfVar = new wf();
            if (ni.isEmpty(str)) {
                return wfVar;
            }
            uf ufVar = this.a.get(str);
            if (ufVar != null && !ufVar.c(System.currentTimeMillis()) && ufVar.a() != null && ufVar.a().size() > 0) {
                for (int i = 0; i < ufVar.a().size(); i++) {
                    if (!ni.isEquals(str2, ufVar.a().get(i))) {
                        wfVar.j(i);
                        wfVar.g(ufVar.a().get(i));
                        return wfVar;
                    } else if (i == ufVar.a().size() - 1) {
                        wfVar.j(0);
                        wfVar.g(ufVar.a().get(0));
                        return wfVar;
                    }
                }
            }
            for (int i2 = 0; i2 < 3; i2++) {
                wfVar.d();
                wfVar.l(i2);
                long currentTimeMillis = System.currentTimeMillis();
                uf c = c(str, wfVar);
                wfVar.f(System.currentTimeMillis() - currentTimeMillis);
                if (c != null && c.a() != null && c.a().size() > 0) {
                    c.d(300L);
                    this.a.put(str, c);
                    for (int i3 = 0; i3 < c.a().size(); i3++) {
                        if (!ni.isEquals(str2, c.a().get(i2))) {
                            wfVar.j(i3);
                            wfVar.g(c.a().get(i3));
                            return wfVar;
                        } else if (i3 == c.a().size() - 1) {
                            wfVar.j(0);
                            wfVar.g(c.a().get(0));
                            return wfVar;
                        }
                    }
                    continue;
                } else {
                    uf ufVar2 = this.a.get(str);
                    if (ufVar2 != null && ufVar2.a() != null && ufVar2.a().size() > 0) {
                        wfVar.g(ufVar2.a().get(0));
                        return wfVar;
                    }
                }
            }
            return wfVar;
        }
        return (wf) invokeLL.objValue;
    }
}
