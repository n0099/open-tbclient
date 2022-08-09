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
import com.baidubce.http.Headers;
import com.sdk.a.g;
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
    public h<T> y;
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

    public e(g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
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
        if (gVar != null) {
            h<T> hVar = gVar.f;
            this.y = hVar;
            if (hVar != null) {
                this.n = hVar.c;
                this.o = hVar.d;
                this.q = hVar.i;
                this.m = hVar.j;
            }
        }
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
                    com.sdk.n.a.a("PriorityAsyncTask", th.getMessage(), this.h);
                }
            }
            com.sdk.e.b<T> bVar = this.m;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public final i<T> b(g<T> gVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, gVar, httpURLConnection)) == null) {
            i<T> iVar = null;
            try {
            } catch (Throwable th) {
                com.sdk.n.b.c(th.toString());
                com.sdk.n.a.a("PriorityAsyncTask", "网络访问异常：" + th.toString(), this.h);
                int i = this.q;
                if (i > 0) {
                    this.q = i - 1;
                    iVar = b(gVar, httpURLConnection);
                }
            }
            if (!j.b(this.n) || (a2 = j.a(this.o)) == null) {
                if (this.v.booleanValue() && this.u) {
                    File file = new File(this.t);
                    long length = (file.isFile() && file.exists()) ? file.length() : 0L;
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bytes=");
                        sb.append(length);
                        sb.append("-");
                        httpURLConnection.setRequestProperty("RANGE", sb.toString());
                    }
                }
                if (!this.e.get()) {
                    this.z = System.currentTimeMillis();
                    iVar = a(gVar, gVar.a(httpURLConnection));
                }
                return iVar == null ? new i<>(1, "网络访问异常", false) : iVar;
            }
            return new i<>(0, a2, true);
        }
        return (i) invokeLL.objValue;
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

    public final i<T> a(g<T> gVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, httpURLConnection)) == null) {
            if (this.e.get()) {
                return new i<>(1, "网络访问已取消", false);
            }
            try {
                com.sdk.n.b.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.z);
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
                    com.sdk.n.a.b("PriorityAsyncTask", sb3.toString(), this.h);
                }
                if (httpURLConnection.getURL().getPath() == null) {
                    System.currentTimeMillis();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    String str = "qcandroidabc000" + System.currentTimeMillis();
                }
                if (responseCode < 300) {
                    this.r = false;
                    if (this.u) {
                        this.v = Boolean.valueOf(this.v.booleanValue() && com.sdk.l.a.b(httpURLConnection));
                        new com.sdk.c.a().a(httpURLConnection, this, this.t, this.v.booleanValue(), this.w.booleanValue() ? com.sdk.l.a.a(httpURLConnection) : null);
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
                    return new i<>(0, bArr, false);
                }
                if (responseCode == 301 || responseCode == 302) {
                    com.sdk.n.b.a(gVar.f.d, System.currentTimeMillis() - this.z);
                    String headerField = httpURLConnection.getHeaderField(Headers.LOCATION);
                    String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
                    String path = httpURLConnection.getURL().getPath();
                    if (headerField == null) {
                        System.currentTimeMillis();
                        new ArrayList();
                        new ArrayList();
                        new ArrayList();
                        String str2 = "qcandroidabc000" + System.currentTimeMillis();
                    }
                    if (com.sdk.n.a.b(headerField).booleanValue()) {
                        gVar.f.d = headerField;
                        HttpURLConnection a3 = gVar.a(headerField, com.sdk.l.a.a(headerField));
                        if (com.sdk.n.a.b(headerField2).booleanValue()) {
                            if ("/ctcnet/gctcmc.do".equals(path)) {
                                com.sdk.j.a.a(SDKManager.mContext, "ctc", headerField2);
                                com.sdk.n.a.b("PriorityAsyncTask", "mdb Cookie cache", this.h);
                            }
                            a3.setRequestProperty("Cookie", headerField2);
                        } else {
                            a3.setRequestProperty("Cookie", com.sdk.j.a.c(SDKManager.mContext, "ctc"));
                        }
                        if (a3 == null) {
                            return new i<>(0, b(), false);
                        }
                        gVar.f.a(g.a.a.l);
                        return b(gVar, a3);
                    }
                }
                com.sdk.n.b.c("服务异常 ResponseCode = " + responseCode);
                com.sdk.n.a.a("PriorityAsyncTask", "服务异常 ResponseCode = " + responseCode, this.h);
                return new i<>(0, "服务端数据格式出错", false);
            } catch (Exception e) {
                com.sdk.n.b.a(gVar.f.d, System.currentTimeMillis() - this.z);
                com.sdk.n.b.c(e.toString());
                com.sdk.n.a.a("PriorityAsyncTask", e.toString(), this.h);
                return new i<>(1, "网络访问异常", false);
            }
        }
        return (i) invokeLL.objValue;
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
            return this.p != a.e;
        }
        return invokeCommon.booleanValue;
    }
}
