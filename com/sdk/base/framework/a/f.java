package com.sdk.base.framework.a;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.kuaishou.weapon.un.x;
import com.sdk.base.module.manager.SDKManager;
import java.io.File;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class f<T> extends com.sdk.base.framework.a.c.c<Object, Object, Void> implements com.sdk.base.framework.a.b.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f42520b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long f42521c;

    /* renamed from: d  reason: collision with root package name */
    public com.sdk.base.framework.b.b<T> f42522d;

    /* renamed from: e  reason: collision with root package name */
    public String f42523e;

    /* renamed from: f  reason: collision with root package name */
    public String f42524f;

    /* renamed from: g  reason: collision with root package name */
    public g f42525g;

    /* renamed from: h  reason: collision with root package name */
    public int f42526h;
    public boolean i;
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
        f42520b = new d();
    }

    public f(h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42521c = d.a();
        this.f42525g = g.a;
        this.i = true;
        this.k = null;
        this.l = false;
        Boolean bool = Boolean.FALSE;
        this.m = bool;
        this.n = bool;
        this.o = bool;
        k<T> b2 = hVar.b();
        this.p = b2;
        if (b2 != null) {
            this.f42523e = b2.a();
            this.f42524f = this.p.d();
            this.f42526h = this.p.f();
            this.f42522d = this.p.g();
        }
    }

    private l<T> a(h<T> hVar, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, hVar, httpURLConnection)) == null) {
            l<T> lVar = null;
            try {
            } catch (Throwable th) {
                com.sdk.base.framework.f.f.a.b(th.toString());
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：" + th.toString(), this.a);
                int i = this.f42526h;
                if (i > 0) {
                    this.f42526h = i - 1;
                    lVar = a(hVar, httpURLConnection);
                }
            }
            if (!d.b(this.f42523e) || (a = f42520b.a(this.f42524f)) == null) {
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
            return new l<>(0, a, true);
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
            int i = -1;
            try {
                com.sdk.base.framework.f.f.a.a(httpURLConnection.getURL().toString(), System.currentTimeMillis() - this.q);
                if (httpURLConnection != null) {
                    i = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder("net请求host：");
                    sb.append(httpURLConnection.getURL().getHost());
                    sb.append("\n net请求path：");
                    sb.append(httpURLConnection.getURL().getPath());
                    sb.append("\n  net请求码：");
                    sb.append(i);
                    String sb2 = sb.toString();
                    Boolean bool = this.a;
                    if (sb2 == null) {
                        sb2 = "";
                    }
                    if (bool.booleanValue()) {
                        Log.d("PriorityAsyncTask", sb2);
                    }
                }
                if (this.a.booleanValue()) {
                    StringBuilder sb3 = new StringBuilder("响应返回：code=");
                    sb3.append(i);
                    sb3.append(";耗时=");
                    sb3.append(System.currentTimeMillis() - this.q);
                    com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", sb3.toString(), this.a);
                }
                if (i < 300) {
                    byte[] bArr = null;
                    if (httpURLConnection != null) {
                        this.i = false;
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
                            String a = com.sdk.base.framework.a.b.d.a(httpURLConnection, this, "UTF-8");
                            bArr = a;
                            if (d.b(this.f42523e)) {
                                f42520b.a(this.f42524f, a, this.f42521c);
                                bArr = a;
                            }
                        }
                    }
                    return new l<>(0, bArr, false);
                }
                if (i == 301 || i == 302) {
                    String headerField = httpURLConnection.getHeaderField(Headers.LOCATION);
                    String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
                    String path = httpURLConnection.getURL().getPath();
                    if (com.sdk.base.framework.a.a.c.b(headerField).booleanValue() && hVar != null) {
                        hVar.b().b(headerField);
                        HttpURLConnection a2 = hVar.a(headerField, com.sdk.base.framework.f.d.a.a(headerField));
                        if (com.sdk.base.framework.a.a.c.b(headerField2).booleanValue()) {
                            if ("/ctcnet/gctcmc.do".equals(path)) {
                                com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), x.F, headerField2);
                                com.sdk.base.framework.a.a.c.a("PriorityAsyncTask", "mdb Cookie cache", this.a);
                            }
                            a2.setRequestProperty("Cookie", headerField2);
                        } else {
                            a2.setRequestProperty("Cookie", com.sdk.base.framework.f.b.a.b(SDKManager.getContext(), x.F));
                        }
                        if (a2 == null) {
                            return new l<>(0, c(), false);
                        }
                        if (a2 != null) {
                            hVar.c();
                            return a(hVar, a2);
                        }
                    }
                }
                com.sdk.base.framework.f.f.a.b("服务异常 ResponseCode = " + i);
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "服务异常 ResponseCode = " + i, this.a);
                return new l<>(0, "服务端数据格式出错", false);
            } catch (Exception e2) {
                com.sdk.base.framework.f.f.a.b(e2.toString());
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e2.toString(), this.a);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, objArr)) == null) {
            if (this.f42525g != g.f42530e && objArr != null && objArr.length != 0) {
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
                    String a = hVar.a();
                    this.f42524f = a;
                    HttpURLConnection a2 = hVar.a(a, false);
                    if (a2 == null) {
                        d(4, new l(0, c(), false));
                        return null;
                    }
                    l<T> a3 = a(hVar, a2);
                    if (a3 != null) {
                        if (a3.a() == 0) {
                            d(4, a3);
                        } else {
                            d(3, Integer.valueOf(a3.a()), a3.b());
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    com.sdk.base.framework.f.f.a.b(e2.toString());
                    com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", "网络访问异常：\n" + e2.toString(), this.a);
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
            this.f42525g = g.f42530e;
            if (b()) {
                return;
            }
            try {
                a(true);
            } catch (Throwable th) {
                com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", th.getMessage(), this.a);
            }
        }
    }

    @Override // com.sdk.base.framework.a.c.c
    public final void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) || this.f42525g == g.f42530e || objArr == null || objArr.length == 0 || this.f42522d == null) {
            return;
        }
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue == 1) {
            this.f42525g = g.f42527b;
        } else if (intValue == 2) {
            if (objArr.length != 3) {
                return;
            }
            this.f42525g = g.f42528c;
            Long.parseLong(String.valueOf(objArr[1]));
            Long.parseLong(String.valueOf(objArr[2]));
        } else if (intValue == 3) {
            if (objArr.length != 3) {
                return;
            }
            this.f42525g = g.f42529d;
            this.f42522d.a(((Integer) objArr[1]).intValue(), (String) objArr[2]);
        } else if (intValue == 4 && objArr.length == 2) {
            this.f42525g = g.f42531f;
            this.p.d();
            this.f42522d.a((l) objArr[1]);
        }
    }

    @Override // com.sdk.base.framework.a.b.c
    public final boolean a(long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (this.f42522d != null && this.f42525g != g.f42530e) {
                if (z) {
                    d(2, Long.valueOf(j), Long.valueOf(j2));
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis - this.j >= this.f42522d.a()) {
                        this.j = uptimeMillis;
                        d(2, Long.valueOf(j), Long.valueOf(j2));
                    }
                }
            }
            return this.f42525g != g.f42530e;
        }
        return invokeCommon.booleanValue;
    }
}
