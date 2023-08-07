package com.weibo.ssosdk;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xrb;
import com.baidu.tieba.yrb;
import com.baidu.tieba.zrb;
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
/* loaded from: classes10.dex */
public class WeiboSsoSdk {
    public static /* synthetic */ Interceptable $ic;
    public static WeiboSsoSdk e;
    public static zrb f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ReentrantLock a;
    public boolean b;
    public d c;
    public int d;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    /* loaded from: classes10.dex */
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
            String k;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                try {
                    Thread.sleep(86400000L);
                    if (this.a.c != null && !TextUtils.isEmpty(this.a.c.a())) {
                        k = this.a.c.a();
                    } else {
                        k = this.a.k();
                    }
                    WeiboSsoSdk.i().l(k, 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
            String k;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(60000L);
                    if (!this.a.b) {
                        return;
                    }
                    if (this.a.c != null && !TextUtils.isEmpty(this.a.c.a())) {
                        k = this.a.c.a();
                    } else {
                        k = this.a.k();
                    }
                    this.a.l(k, 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yrb a;
        public final /* synthetic */ WeiboSsoSdk b;

        public c(WeiboSsoSdk weiboSsoSdk, yrb yrbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSsoSdk, yrbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = weiboSsoSdk;
            this.a = yrbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                this.b.l("", 1);
            } catch (Exception unused) {
            }
            if (this.b.c == null) {
                this.b.c = new d();
            }
            this.a.handler(this.b.c);
        }
    }

    /* loaded from: classes10.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

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
            this.b = "";
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
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
                        dVar.b = jSONObject2.optString("sub", "");
                        return dVar;
                    }
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                } catch (Exception e) {
                    throw e;
                }
            }
            return (d) invokeL.objValue;
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

    public static synchronized WeiboSsoSdk i() throws Exception {
        InterceptResult invokeV;
        WeiboSsoSdk weiboSsoSdk;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (WeiboSsoSdk.class) {
                if (e == null) {
                    e = new WeiboSsoSdk();
                }
                weiboSsoSdk = e;
            }
            return weiboSsoSdk;
        }
        return (WeiboSsoSdk) invokeV.objValue;
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
        this.b = true;
        zrb zrbVar = f;
        if (zrbVar != null && zrbVar.n()) {
            this.d = 0;
            new Thread(new a(this)).start();
            new Thread(new b(this)).start();
            return;
        }
        throw new Exception("config error");
    }

    public static synchronized boolean j(zrb zrbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zrbVar)) == null) {
            synchronized (WeiboSsoSdk.class) {
                if (zrbVar == null) {
                    return false;
                }
                if (!zrbVar.n()) {
                    return false;
                }
                if (f != null) {
                    return false;
                }
                zrb zrbVar2 = (zrb) zrbVar.clone();
                f = zrbVar2;
                xrb.w(zrbVar2.b());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

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

    public final File h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            File filesDir = f.b().getFilesDir();
            return new File(filesDir, "weibo_sso_sdk_aid" + i);
        }
        return (File) invokeI.objValue;
    }

    public void m(yrb yrbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yrbVar) == null) {
            d dVar = this.c;
            if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.c.b())) {
                yrbVar.handler(this.c);
            } else {
                Executors.newSingleThreadExecutor().execute(new c(this, yrbVar));
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
        } else {
            return (String) invokeL.objValue;
        }
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        } else {
            return (String) invokeV.objValue;
        }
    }

    public final void l(String str, int i) throws Exception {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, str, i) != null) || TextUtils.isEmpty(f.a(false))) {
            return;
        }
        if (!this.a.tryLock()) {
            this.a.lock();
            this.a.unlock();
            return;
        }
        this.b = false;
        String n = xrb.n(f.b());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g = g(riseWind(f.a(true), f.b().getPackageName(), str2, n, f.d(true), f.e(true), f.h(true), f.g(true), f.f(true), f.c(true), i, this.d));
        this.d++;
        if (g != null) {
            try {
                d c2 = d.c(g);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i == 1) {
                    this.c = c2;
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
}
