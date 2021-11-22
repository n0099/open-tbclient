package com.sdk.base.framework.a;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.module.manager.SDKManager;
import java.io.File;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f<T> extends com.sdk.base.framework.a.c.c<Object, Object, Void> implements com.sdk.base.framework.a.b.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f69064b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long f69065c;

    /* renamed from: d  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f69066d;

    /* renamed from: e  reason: collision with root package name */
    public String f69067e;

    /* renamed from: f  reason: collision with root package name */
    public String f69068f;

    /* renamed from: g  reason: collision with root package name */
    public g f69069g;

    /* renamed from: h  reason: collision with root package name */
    public int f69070h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69071i;
    public long j;
    public String k;
    public boolean l;
    public Boolean m;
    public Boolean n;
    public Boolean o;
    public k<T> p;
    public long q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379453, "Lcom/sdk/base/framework/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379453, "Lcom/sdk/base/framework/a/f;");
                return;
            }
        }
        f69064b = new d();
    }

    public f(h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69065c = d.a();
        this.f69069g = g.f69072a;
        this.f69071i = true;
        this.k = null;
        this.l = false;
        Boolean bool = Boolean.FALSE;
        this.m = bool;
        this.n = bool;
        this.o = bool;
        k<T> b2 = hVar.b();
        this.p = b2;
        if (b2 != null) {
            this.f69067e = b2.a();
            this.f69068f = this.p.d();
            this.f69070h = this.p.f();
            this.f69066d = this.p.g();
        }
    }

    private l<T> a(h<T> hVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, hVar, httpURLConnection)) == null) {
            l<T> lVar = null;
            try {
            } catch (Throwable th) {
                com.sdk.base.framework.f.f.a.b(th.toString());
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：" + th.toString(), this.f69031a);
                int i2 = this.f69070h;
                if (i2 > 0) {
                    this.f69070h = i2 - 1;
                    lVar = a(hVar, httpURLConnection);
                }
            }
            if (!d.b(this.f69067e) || (a2 = f69064b.a(this.f69068f)) == null) {
                if (this.m.booleanValue() && this.l) {
                    File file = new File(this.k);
                    long length = (file.isFile() && file.exists()) ? file.length() : 0L;
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder("bytes=");
                        sb.append(length);
                        sb.append("-");
                        httpURLConnection.setRequestProperty("RANGE", sb.toString());
                    }
                }
                if (!b()) {
                    this.q = System.currentTimeMillis();
                    lVar = b(hVar, hVar.a(httpURLConnection));
                }
                return lVar == null ? new l<>(1, "网络访问异常", false) : lVar;
            }
            return new l<>(0, a2, true);
        }
        return (l) invokeLL.objValue;
    }

    private l<T> b(h<T> hVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, hVar, httpURLConnection)) == null) {
            if (b()) {
                return new l<>(1, "网络访问已取消", false);
            }
            int i2 = -1;
            try {
                com.sdk.base.framework.f.f.a.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.q);
                if (httpURLConnection != null) {
                    i2 = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder("net请求host：");
                    sb.append(httpURLConnection.getURL().getHost());
                    sb.append("\n net请求path：");
                    sb.append(httpURLConnection.getURL().getPath());
                    sb.append("\n  net请求码：");
                    sb.append(i2);
                    sb.toString();
                    this.f69031a.booleanValue();
                }
                if (this.f69031a.booleanValue()) {
                    StringBuilder sb2 = new StringBuilder("响应返回：code=");
                    sb2.append(i2);
                    sb2.append(";耗时=");
                    sb2.append(System.currentTimeMillis() - this.q);
                    com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", sb2.toString(), this.f69031a);
                }
                if (i2 < 300) {
                    byte[] bArr = null;
                    if (httpURLConnection != null) {
                        this.f69071i = false;
                        if (this.l) {
                            this.m = Boolean.valueOf(this.m.booleanValue() && com.sdk.base.framework.f.d.a.a(httpURLConnection));
                            String b2 = this.n.booleanValue() ? com.sdk.base.framework.f.d.a.b(httpURLConnection) : null;
                            new com.sdk.base.framework.a.b.b();
                            com.sdk.base.framework.a.b.b.a(httpURLConnection, this, this.k, this.m.booleanValue(), b2);
                        }
                        if (this.o.booleanValue()) {
                            new com.sdk.base.framework.a.b.a();
                            bArr = com.sdk.base.framework.a.b.a.a(httpURLConnection);
                        } else {
                            new com.sdk.base.framework.a.b.d();
                            String a2 = com.sdk.base.framework.a.b.d.a(httpURLConnection, this, "UTF-8");
                            bArr = a2;
                            if (d.b(this.f69067e)) {
                                f69064b.a(this.f69068f, a2, this.f69065c);
                                bArr = a2;
                            }
                        }
                    }
                    return new l<>(0, bArr, false);
                }
                if (i2 == 301 || i2 == 302) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
                    String path = httpURLConnection.getURL().getPath();
                    if (com.sdk.base.framework.a.a.c.b(headerField).booleanValue() && hVar != null) {
                        hVar.b().b(headerField);
                        HttpURLConnection a3 = hVar.a(headerField, com.sdk.base.framework.f.d.a.a(headerField));
                        if (com.sdk.base.framework.a.a.c.b(headerField2).booleanValue()) {
                            if ("/ctcnet/gctcmc.do".equals(path)) {
                                com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), "ctc", headerField2);
                                com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", "mdb Cookie cache", this.f69031a);
                            }
                            a3.setRequestProperty("Cookie", headerField2);
                        } else {
                            a3.setRequestProperty("Cookie", com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), "ctc"));
                        }
                        if (a3 == null) {
                            return new l<>(0, c(), false);
                        }
                        if (a3 != null) {
                            hVar.c();
                            return a(hVar, a3);
                        }
                    }
                }
                com.sdk.base.framework.f.f.a.b("服务异常 ResponseCode = " + i2);
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "服务异常 ResponseCode = " + i2, this.f69031a);
                return new l<>(0, "服务端数据格式出错", false);
            } catch (Exception e2) {
                com.sdk.base.framework.f.f.a.b(e2.toString());
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e2.toString(), this.f69031a);
                return new l<>(1, "网络访问异常", false);
            }
        }
        return (l) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sdk.base.framework.a.c.c
    /* renamed from: e */
    public Void b(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, objArr)) == null) {
            if (this.f69069g != g.f69076e && objArr != null && objArr.length != 0) {
                if (objArr.length == 4) {
                    String valueOf = String.valueOf(objArr[1]);
                    this.k = valueOf;
                    this.l = valueOf != null;
                    this.m = (Boolean) objArr[2];
                    this.n = (Boolean) objArr[3];
                }
                if (objArr.length == 2) {
                    this.o = (Boolean) objArr[1];
                }
                try {
                    this.j = SystemClock.uptimeMillis();
                    d(1);
                    h<T> hVar = (h) objArr[0];
                    String a2 = hVar.a();
                    this.f69068f = a2;
                    HttpURLConnection a3 = hVar.a(a2, false);
                    if (a3 == null) {
                        d(4, new l(0, c(), false));
                        return null;
                    }
                    l<T> a4 = a(hVar, a3);
                    if (a4 != null) {
                        if (a4.a() == 0) {
                            d(4, a4);
                        } else {
                            d(3, Integer.valueOf(a4.a()), a4.b());
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    com.sdk.base.framework.f.f.a.b(e2.toString());
                    com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：\n" + e2.toString(), this.f69031a);
                    d(3, 302002, "网络访问异常");
                }
            }
            return null;
        }
        return (Void) invokeL.objValue;
    }

    @Override // com.sdk.base.framework.a.c.c
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f69069g = g.f69076e;
            if (b()) {
                return;
            }
            try {
                a(true);
            } catch (Throwable th) {
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", th.getMessage(), this.f69031a);
            }
        }
    }

    @Override // com.sdk.base.framework.a.c.c
    public final void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) || this.f69069g == g.f69076e || objArr == null || objArr.length == 0 || this.f69066d == null) {
            return;
        }
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue == 1) {
            this.f69069g = g.f69073b;
        } else if (intValue == 2) {
            if (objArr.length != 3) {
                return;
            }
            this.f69069g = g.f69074c;
            Long.parseLong(String.valueOf(objArr[1]));
            Long.parseLong(String.valueOf(objArr[2]));
        } else if (intValue == 3) {
            if (objArr.length != 3) {
                return;
            }
            this.f69069g = g.f69075d;
            this.f69066d.a(((Integer) objArr[1]).intValue(), (String) objArr[2]);
        } else if (intValue == 4 && objArr.length == 2) {
            this.f69069g = g.f69077f;
            this.p.d();
            this.f69066d.a((l) objArr[1]);
        }
    }

    @Override // com.sdk.base.framework.a.b.c
    public final boolean a(long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (this.f69066d != null && this.f69069g != g.f69076e) {
                if (z) {
                    d(2, Long.valueOf(j), Long.valueOf(j2));
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis - this.j >= this.f69066d.a()) {
                        this.j = uptimeMillis;
                        d(2, Long.valueOf(j), Long.valueOf(j2));
                    }
                }
            }
            return this.f69069g != g.f69076e;
        }
        return invokeCommon.booleanValue;
    }
}
