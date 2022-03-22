package com.kuaishou.weapon.un;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes7.dex */
public class p1 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final int f38942g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38943h = 1024;
    public static final String i = "gzip";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f38944b;

    /* renamed from: c  reason: collision with root package name */
    public String f38945c;

    /* renamed from: d  reason: collision with root package name */
    public int f38946d;

    /* renamed from: e  reason: collision with root package name */
    public int f38947e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38948f;

    public p1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38946d = 60000;
        this.f38947e = 60000;
        this.f38948f = false;
        this.a = context;
    }

    public p1(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38946d = 60000;
        this.f38947e = 60000;
        this.f38948f = false;
        this.a = context;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, httpURLConnection)) == null) {
            if (httpURLConnection != null && httpURLConnection != null) {
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.f38948f = true;
                    } else {
                        this.f38948f = false;
                    }
                    return httpURLConnection.getInputStream();
                } catch (IOException e2) {
                    l1.a(e2);
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bArr, httpURLConnection)) == null) {
            if (httpURLConnection == null) {
                return null;
            }
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (TextUtils.isEmpty(contentEncoding) || !"gzip".equalsIgnoreCase(contentEncoding)) {
                            this.f38948f = false;
                        } else {
                            this.f38948f = true;
                        }
                        return httpURLConnection.getInputStream();
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode));
                }
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 == 200) {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.f38948f = true;
                    } else {
                        this.f38948f = false;
                    }
                    return httpURLConnection.getInputStream();
                }
                throw new NetworkErrorException(String.valueOf(responseCode2));
            } catch (NetworkErrorException e2) {
                throw e2;
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
                l1.a(th);
                throw new IOException();
            }
        }
        return (InputStream) invokeLL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            try {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                String a = s1.a(str + str2 + valueOf);
                return "appkey=" + str + "&secretkey=" + URLEncoder.encode(str2, IMAudioTransRequest.CHARSET) + "&timestamp=" + valueOf + "&sign=" + a;
            } catch (Throwable th) {
                l1.a(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    private HttpURLConnection a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (TextUtils.isEmpty(this.f38944b) || TextUtils.isEmpty(this.f38945c)) {
                throw new IllegalArgumentException();
            }
            if (!this.f38944b.equals("POST") && !this.f38944b.equals("GET")) {
                this.f38944b = "POST";
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f38945c).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                a((HttpsURLConnection) httpURLConnection);
            }
            httpURLConnection.setRequestMethod(this.f38944b);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f38944b)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f38946d);
            httpURLConnection.setReadTimeout(this.f38947e);
            String[] a = l1.a(this.a);
            String str = (a == null || a.length != 2 || TextUtils.isEmpty(a[0])) ? "16" : a[0];
            httpURLConnection.setRequestProperty("User-Agent", "Android/" + str + "/" + a2.b(this.a) + "/2.8.3");
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, httpsURLConnection) == null) {
            try {
                SSLSocketFactory a = h1.b().a();
                if (httpsURLConnection == null || a == null) {
                    return;
                }
                httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(a);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    private boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (this.f38948f) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e2) {
                l1.a(e2);
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
                try {
                    bufferedOutputStream.close();
                } catch (IOException e3) {
                    l1.a(e3);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    l1.a(th);
                    return false;
                } finally {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            l1.a(e4);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    private byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, this, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, inputStream)) == null) {
            if (inputStream != null) {
                try {
                    byte[] a = a(inputStream);
                    if (a != null) {
                        if (this.f38948f) {
                            a = o1.b(a);
                        }
                        if (a != null) {
                            return new String(a);
                        }
                        throw new IOException();
                    }
                    throw new NullPointerException("responseBytes");
                } catch (Throwable th) {
                    l1.a(th);
                    throw new IOException();
                }
            }
            throw new NullPointerException("InputStream");
        }
        return (String) invokeL.objValue;
    }

    private void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) {
            this.f38944b = str;
            this.f38945c = str2;
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            b("GET", str);
            httpURLConnection = a();
            try {
                inputStream = a((byte[]) null, httpURLConnection);
                String b2 = b(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return b2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    public String a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            b("POST", str);
            InputStream inputStream = null;
            try {
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                String c2 = l1.c(this.a);
                if (!TextUtils.isEmpty(c2) && httpURLConnection != null) {
                    httpURLConnection.setRequestProperty("Cookie", c2);
                }
                inputStream = a(bArr, httpURLConnection);
                String b2 = b(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return b2;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f38946d = i2;
        }
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, str, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            b("GET", str);
            httpURLConnection = a();
            try {
                inputStream = a(httpURLConnection);
                boolean a = a(inputStream, file);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        l1.a(th);
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                try {
                    l1.a(th);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            l1.a(th3);
                            return false;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (Throwable th4) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            l1.a(th5);
                            return false;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38947e = i2;
        }
    }
}
