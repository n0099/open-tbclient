package com.weibo.ssosdk;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WeiboSsoSdk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static WeiboSsoSdk f70440e;

    /* renamed from: f  reason: collision with root package name */
    public static b.p.a.c f70441f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile ReentrantLock f70442a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70443b;

    /* renamed from: c  reason: collision with root package name */
    public d f70444c;

    /* renamed from: d  reason: collision with root package name */
    public int f70445d;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WeiboSsoSdk f70446e;

        public a(WeiboSsoSdk weiboSsoSdk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70446e = weiboSsoSdk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                try {
                    Thread.sleep(86400000L);
                    WeiboSsoSdk.i().l((this.f70446e.f70444c == null || TextUtils.isEmpty(this.f70446e.f70444c.a())) ? this.f70446e.k() : this.f70446e.f70444c.a(), 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WeiboSsoSdk f70447e;

        public b(WeiboSsoSdk weiboSsoSdk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70447e = weiboSsoSdk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(60000L);
                    if (this.f70447e.f70443b) {
                        this.f70447e.l((this.f70447e.f70444c == null || TextUtils.isEmpty(this.f70447e.f70444c.a())) ? this.f70447e.k() : this.f70447e.f70444c.a(), 2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.p.a.b f70448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WeiboSsoSdk f70449f;

        public c(WeiboSsoSdk weiboSsoSdk, b.p.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70449f = weiboSsoSdk;
            this.f70448e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f70449f.l("", 1);
                } catch (Exception unused) {
                }
                if (this.f70449f.f70444c == null) {
                    this.f70449f.f70444c = new d();
                }
                this.f70448e.handler(this.f70449f.f70444c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70450a;

        /* renamed from: b  reason: collision with root package name */
        public String f70451b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70450a = "";
            this.f70451b = "";
        }

        public static d c(String str) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                d dVar = new d();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("retcode", "");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (optString.equals("20000000") && jSONObject2 != null) {
                        dVar.f70450a = jSONObject2.optString("aid", "");
                        dVar.f70451b = jSONObject2.optString("sub", "");
                        return dVar;
                    }
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                } catch (Exception e2) {
                    throw e2;
                }
            }
            return (d) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70450a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70451b : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1237084085, "Lcom/weibo/ssosdk/WeiboSsoSdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1237084085, "Lcom/weibo/ssosdk/WeiboSsoSdk;");
                return;
            }
        }
        System.loadLibrary("wind");
    }

    public WeiboSsoSdk() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70442a = new ReentrantLock(true);
        this.f70443b = true;
        b.p.a.c cVar = f70441f;
        if (cVar != null && cVar.o()) {
            this.f70445d = 0;
            new Thread(new a(this)).start();
            new Thread(new b(this)).start();
            return;
        }
        throw new Exception("config error");
    }

    public static synchronized WeiboSsoSdk i() throws Exception {
        InterceptResult invokeV;
        WeiboSsoSdk weiboSsoSdk;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (WeiboSsoSdk.class) {
                if (f70440e == null) {
                    f70440e = new WeiboSsoSdk();
                }
                weiboSsoSdk = f70440e;
            }
            return weiboSsoSdk;
        }
        return (WeiboSsoSdk) invokeV.objValue;
    }

    public static synchronized boolean j(b.p.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cVar)) == null) {
            synchronized (WeiboSsoSdk.class) {
                if (cVar == null) {
                    return false;
                }
                if (cVar.o()) {
                    if (f70441f == null) {
                        b.p.a.c cVar2 = (b.p.a.c) cVar.clone();
                        f70441f = cVar2;
                        b.p.a.a.w(cVar2.b());
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, int i3);

    public final synchronized void f(String str) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(h(1));
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                } catch (Exception unused3) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final File h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            File filesDir = f70441f.b().getFilesDir();
            return new File(filesDir, "weibo_sso_sdk_aid" + i2);
        }
        return (File) invokeI.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return (String) invokeV.objValue;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(h(1));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (IOException unused3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void l(String str, int i2) throws Exception {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) || TextUtils.isEmpty(f70441f.a(false))) {
            return;
        }
        if (!this.f70442a.tryLock()) {
            this.f70442a.lock();
            this.f70442a.unlock();
            return;
        }
        this.f70443b = false;
        String n = b.p.a.a.n(f70441f.b());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g2 = g(riseWind(f70441f.a(true), f70441f.b().getPackageName(), str2, n, f70441f.e(true), f70441f.f(true), f70441f.i(true), f70441f.h(true), f70441f.g(true), f70441f.c(true), i2, this.f70445d));
        this.f70445d++;
        if (g2 != null) {
            try {
                d c2 = d.c(g2);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i2 == 1) {
                    this.f70444c = c2;
                }
                this.f70442a.unlock();
                return;
            } catch (Exception e2) {
                this.f70442a.unlock();
                throw e2;
            }
        }
        this.f70442a.unlock();
        throw new Exception("network error.");
    }

    public void m(b.p.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            d dVar = this.f70444c;
            if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.f70444c.b())) {
                bVar.handler(this.f70444c);
            } else {
                Executors.newSingleThreadExecutor().execute(new c(this, bVar));
            }
        }
    }
}
