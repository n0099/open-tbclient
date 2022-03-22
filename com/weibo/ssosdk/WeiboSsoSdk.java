package com.weibo.ssosdk;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* loaded from: classes7.dex */
public class WeiboSsoSdk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static WeiboSsoSdk f43978e;

    /* renamed from: f  reason: collision with root package name */
    public static c.l.a.c f43979f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ReentrantLock a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43980b;

    /* renamed from: c  reason: collision with root package name */
    public d f43981c;

    /* renamed from: d  reason: collision with root package name */
    public int f43982d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeiboSsoSdk a;

        public a(WeiboSsoSdk weiboSsoSdk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weiboSsoSdk;
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
                    WeiboSsoSdk.i().l((this.a.f43981c == null || TextUtils.isEmpty(this.a.f43981c.a())) ? this.a.k() : this.a.f43981c.a(), 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeiboSsoSdk a;

        public b(WeiboSsoSdk weiboSsoSdk) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weiboSsoSdk;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(60000L);
                    if (this.a.f43980b) {
                        this.a.l((this.a.f43981c == null || TextUtils.isEmpty(this.a.f43981c.a())) ? this.a.k() : this.a.f43981c.a(), 2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.l.a.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeiboSsoSdk f43983b;

        public c(WeiboSsoSdk weiboSsoSdk, c.l.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43983b = weiboSsoSdk;
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f43983b.l("", 1);
                } catch (Exception unused) {
                }
                if (this.f43983b.f43981c == null) {
                    this.f43983b.f43981c = new d();
                }
                this.a.handler(this.f43983b.f43981c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f43984b;

        public d() {
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
            this.a = "";
            this.f43984b = "";
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
                        dVar.a = jSONObject2.optString("aid", "");
                        dVar.f43984b = jSONObject2.optString("sub", "");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43984b : (String) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ReentrantLock(true);
        this.f43980b = true;
        c.l.a.c cVar = f43979f;
        if (cVar != null && cVar.n()) {
            this.f43982d = 0;
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
                if (f43978e == null) {
                    f43978e = new WeiboSsoSdk();
                }
                weiboSsoSdk = f43978e;
            }
            return weiboSsoSdk;
        }
        return (WeiboSsoSdk) invokeV.objValue;
    }

    public static synchronized boolean j(c.l.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cVar)) == null) {
            synchronized (WeiboSsoSdk.class) {
                if (cVar == null) {
                    return false;
                }
                if (cVar.n()) {
                    if (f43979f == null) {
                        c.l.a.c cVar2 = (c.l.a.c) cVar.clone();
                        f43979f = cVar2;
                        c.l.a.a.w(cVar2.b());
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

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

    public final File h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            File filesDir = f43979f.b().getFilesDir();
            return new File(filesDir, "weibo_sso_sdk_aid" + i);
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

    public final void l(String str, int i) throws Exception {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, str, i) == null) || TextUtils.isEmpty(f43979f.a(false))) {
            return;
        }
        if (!this.a.tryLock()) {
            this.a.lock();
            this.a.unlock();
            return;
        }
        this.f43980b = false;
        String n = c.l.a.a.n(f43979f.b());
        try {
            str2 = URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g2 = g(riseWind(f43979f.a(true), f43979f.b().getPackageName(), str2, n, f43979f.d(true), f43979f.e(true), f43979f.h(true), f43979f.g(true), f43979f.f(true), f43979f.c(true), i, this.f43982d));
        this.f43982d++;
        if (g2 != null) {
            try {
                d c2 = d.c(g2);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i == 1) {
                    this.f43981c = c2;
                }
                this.a.unlock();
                return;
            } catch (Exception e2) {
                this.a.unlock();
                throw e2;
            }
        }
        this.a.unlock();
        throw new Exception("network error.");
    }

    public void m(c.l.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            d dVar = this.f43981c;
            if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.f43981c.b())) {
                bVar.handler(this.f43981c);
            } else {
                Executors.newSingleThreadExecutor().execute(new c(this, bVar));
            }
        }
    }
}
