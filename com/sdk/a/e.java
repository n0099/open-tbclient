package com.sdk.a;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.f;
import com.sdk.base.module.manager.SDKManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e<T> extends com.sdk.d.e<Object, Object, Void> implements com.sdk.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final d j;
    public static Map<String, Long> k;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;
    public com.sdk.e.b<T> m;
    public String n;
    public String o;
    public a p;
    public int q;
    public boolean r;
    public long s;
    public String t;
    public boolean u;
    public Boolean v;
    public Boolean w;
    public Boolean x;
    public g<T> y;
    public long z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final /* synthetic */ a[] g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2126463382, "Lcom/sdk/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2126463382, "Lcom/sdk/a/e$a;");
                    return;
                }
            }
            a = new a("WAITING", 0, 0);
            b = new a("STARTED", 1, 1);
            c = new a("LOADING", 2, 2);
            d = new a("FAILURE", 3, 3);
            e = new a("CANCELLED", 4, 4);
            a aVar = new a("SUCCESS", 5, 5);
            f = aVar;
            g = new a[]{a, b, c, d, e, aVar};
        }

        public a(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) g.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316173, "Lcom/sdk/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316173, "Lcom/sdk/a/e;");
                return;
            }
        }
        j = new d();
        k = new TreeMap();
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("status", 102001);
                jSONObject.put("msg", "选择流量通道失败");
                return jSONObject.toString();
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public e(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = d.a;
        this.p = a.a;
        this.r = true;
        this.t = null;
        this.u = false;
        Boolean bool = Boolean.FALSE;
        this.v = bool;
        this.w = bool;
        this.x = bool;
        if (fVar != null) {
            g<T> gVar = fVar.e;
            this.y = gVar;
            if (gVar != null) {
                this.n = gVar.c;
                this.o = gVar.d;
                this.q = gVar.i;
                this.m = gVar.j;
            }
        }
    }

    public final h<T> a(f<T> fVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        byte[] bArr;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, httpURLConnection)) == null) {
            if (this.e.get()) {
                return new h<>(1, "网络访问已取消", false);
            }
            try {
                com.sdk.o.b.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.z);
                int responseCode = httpURLConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                sb.append("net请求host：");
                sb.append(httpURLConnection.getURL().getHost());
                sb.append("\n net请求path：");
                sb.append(httpURLConnection.getURL().getPath());
                sb.append("\n  net请求码：");
                sb.append(responseCode);
                String sb2 = sb.toString();
                Boolean bool = this.h;
                if (sb2 == null) {
                    sb2 = "";
                }
                if (bool.booleanValue()) {
                    Log.d("PriorityAsyncTask", sb2);
                }
                if (this.h.booleanValue()) {
                    k.put(httpURLConnection.getURL().toString(), Long.valueOf(System.currentTimeMillis() - this.z));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("响应返回：code=");
                    sb3.append(responseCode);
                    sb3.append(";耗时=");
                    sb3.append(System.currentTimeMillis() - this.z);
                    com.sdk.o.a.b("PriorityAsyncTask", sb3.toString(), this.h);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("geturlgetpath: ");
                sb4.append(httpURLConnection.getURL().getPath());
                Log.d("PriorityAsyncTask", sb4.toString());
                if (httpURLConnection.getURL().getPath() == null) {
                    System.currentTimeMillis();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    String str2 = "qcandroidabc000" + System.currentTimeMillis();
                }
                if (responseCode < 300) {
                    this.r = false;
                    if (this.u) {
                        if (this.v.booleanValue() && com.sdk.m.a.b(httpURLConnection)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.v = Boolean.valueOf(z);
                        if (this.w.booleanValue()) {
                            str = com.sdk.m.a.a(httpURLConnection);
                        } else {
                            str = null;
                        }
                        new com.sdk.c.a().a(httpURLConnection, this, this.t, this.v.booleanValue(), str);
                    }
                    if (this.x.booleanValue()) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        bArr = byteArrayOutputStream.toByteArray();
                    } else {
                        String a2 = new com.sdk.c.c().a(httpURLConnection, this, "UTF-8");
                        bArr = a2;
                        if (j.b(this.n)) {
                            j.a(this.o, a2, this.l);
                            bArr = a2;
                        }
                    }
                    return new h<>(0, bArr, false);
                }
                if (responseCode == 301 || responseCode == 302) {
                    com.sdk.o.b.a(fVar.e.d, System.currentTimeMillis() - this.z);
                    String headerField = httpURLConnection.getHeaderField("Location");
                    String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
                    String path = httpURLConnection.getURL().getPath();
                    if (headerField == null) {
                        System.currentTimeMillis();
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        String str3 = "qcandroidabc000" + System.currentTimeMillis();
                    }
                    if (com.sdk.o.a.b(headerField).booleanValue()) {
                        fVar.e.d = headerField;
                        HttpURLConnection a3 = fVar.a(headerField, com.sdk.m.a.a(headerField));
                        if (com.sdk.o.a.b(headerField2).booleanValue()) {
                            if ("/ctcnet/gctcmc.do".equals(path)) {
                                com.sdk.k.a.a(SDKManager.mContext, "ctc", headerField2);
                                com.sdk.o.a.b("PriorityAsyncTask", "mdb Cookie cache", this.h);
                            }
                            a3.setRequestProperty("Cookie", headerField2);
                        } else {
                            a3.setRequestProperty("Cookie", com.sdk.k.a.c(SDKManager.mContext, "ctc"));
                        }
                        if (a3 == null) {
                            return new h<>(0, b(), false);
                        }
                        fVar.e.a(f.a.a.l);
                        return b(fVar, a3);
                    }
                }
                com.sdk.o.b.c("服务异常 ResponseCode = " + responseCode);
                com.sdk.o.a.a("PriorityAsyncTask", "服务异常 ResponseCode = " + responseCode, this.h);
                return new h<>(0, "服务端数据格式出错", false);
            } catch (Exception e) {
                com.sdk.o.b.a(fVar.e.d, System.currentTimeMillis() - this.z);
                com.sdk.o.b.c(e.toString());
                com.sdk.o.a.a("PriorityAsyncTask", e.toString(), this.h);
                Log.e("PriorityAsyncTask", "HttpHandler handleResponse");
                return new h<>(1, "网络访问异常", false);
            }
        }
        return (h) invokeLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p = a.e;
            if (!this.e.get()) {
                try {
                    this.e.set(true);
                    this.d.cancel(true);
                } catch (Throwable th) {
                    com.sdk.o.a.a("PriorityAsyncTask", th.getMessage(), this.h);
                }
            }
            com.sdk.e.b<T> bVar = this.m;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public boolean a(long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            if (this.m != null && this.p != a.e) {
                if (z) {
                    a(2, Long.valueOf(j2), Long.valueOf(j3));
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long j4 = uptimeMillis - this.s;
                    int i = this.m.a;
                    if (i < 200) {
                        i = 200;
                    }
                    if (j4 >= i) {
                        this.s = uptimeMillis;
                        a(2, Long.valueOf(j2), Long.valueOf(j3));
                    }
                }
            }
            if (this.p != a.e) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final h<T> b(f<T> fVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        long j2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, httpURLConnection)) == null) {
            h<T> hVar = null;
            try {
            } catch (Throwable th) {
                com.sdk.o.b.c(th.toString());
                com.sdk.o.a.a("PriorityAsyncTask", "访问异常HttpHandler：" + th.toString(), this.h);
                int i = this.q;
                if (i > 0) {
                    this.q = i - 1;
                    hVar = b(fVar, httpURLConnection);
                }
            }
            if (j.b(this.n) && (a2 = j.a(this.o)) != null) {
                return new h<>(0, a2, true);
            }
            Log.d("PriorityAsyncTask", "sendRequest: ");
            if (this.v.booleanValue() && this.u) {
                File file = new File(this.t);
                if (file.isFile() && file.exists()) {
                    j2 = file.length();
                } else {
                    j2 = 0;
                }
                if (j2 > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("bytes=");
                    sb.append(j2);
                    sb.append("-");
                    httpURLConnection.setRequestProperty("RANGE", sb.toString());
                }
            }
            if (!this.e.get()) {
                this.z = System.currentTimeMillis();
                hVar = a(fVar, fVar.a(httpURLConnection));
            }
            if (hVar == null) {
                h<T> hVar2 = new h<>(1, "网络访问异常", false);
                com.sdk.o.a.a("PriorityAsyncTask", "HttpHandler：responseInfo=null网络访问异常", this.h);
                return hVar2;
            }
            return hVar;
        }
        return (h) invokeLL.objValue;
    }
}
