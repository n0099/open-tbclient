package com.repackage;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class fe0 {
    public static /* synthetic */ Interceptable $ic;
    public static fe0 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ge0 a;
    public ge0 b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ fe0 d;

        public a(fe0 fe0Var, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe0Var, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fe0Var;
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a == 24) {
                    this.d.b(this.b, this.c, 24);
                }
                this.d.b(this.b, this.c, 1);
            }
        }
    }

    public fe0() {
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
        this.a = new ge0();
        this.b = new ge0("live_show_session");
    }

    public static byte[] e(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) {
            if (z) {
                try {
                    return ce0.b(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return Base64.encode(bArr, 2);
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static synchronized fe0 g() {
        InterceptResult invokeV;
        fe0 fe0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (fe0.class) {
                if (c == null) {
                    c = new fe0();
                }
                fe0Var = c;
            }
            return fe0Var;
        }
        return (fe0) invokeV.objValue;
    }

    public final void b(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) {
            String str3 = WebSettingsGlobalBlink.SESSION_UPLOAD_URL + str2;
            boolean z = true;
            byte[] e = e(str.getBytes(), true);
            if (e == null) {
                e = e(str.getBytes(), false);
                z = false;
            }
            if (d(ce0.a(e), str3, z)) {
                f();
            } else {
                c(Base64.encode(ce0.a(e(str.getBytes(), false)), 2), i);
            }
        }
    }

    public final void c(byte[] bArr, int i) {
        ge0 ge0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i) == null) {
            if (i == 24) {
                ge0Var = this.b;
                if (ge0Var == null) {
                    return;
                }
            } else {
                ge0Var = this.a;
                if (ge0Var == null) {
                    return;
                }
            }
            ge0Var.e(bArr);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00b2 */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        r9.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        r8 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        HttpURLConnection httpURLConnection;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                        httpURLConnection.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                        if (z) {
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                        }
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        i = httpURLConnection.getResponseCode();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Error e2) {
                        e = e2;
                        ae0.e("DpSessionDatasUploader", "[sendStatisticsDataToServer()] upload error " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        ae0.e("DpSessionDatasUploader", "[sendStatisticsDataToServer()] upload error " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (str != 0) {
                        try {
                            str.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Error e7) {
                e = e7;
                httpURLConnection = null;
            } catch (Exception e8) {
                e = e8;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (0 != 0) {
                }
                if (str != 0) {
                }
                throw th;
            }
            return i != 200;
        }
        return invokeLLZ.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ge0 ge0Var = this.a;
            if (ge0Var != null) {
                ge0Var.a();
            }
            ge0 ge0Var2 = this.b;
            if (ge0Var2 != null) {
                ge0Var2.a();
            }
        }
    }

    public void h(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, str2, i) == null) {
            wd0.b().a(new a(this, i, str, str2));
        }
    }
}
