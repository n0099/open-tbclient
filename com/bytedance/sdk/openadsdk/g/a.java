package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.d.b.d;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.l;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.r.n;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0351a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492560486, "Lcom/bytedance/sdk/openadsdk/g/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-492560486, "Lcom/bytedance/sdk/openadsdk/g/a$a;");
                    return;
                }
            }
            a(o.a());
        }

        public static e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? a(l.a(str)) : (e) invokeL.objValue;
        }

        public static void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65540, null, context) == null) {
                l.a(context, new o.a().a(com.bytedance.sdk.component.e.e.a()).a(new c() { // from class: com.bytedance.sdk.openadsdk.g.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.d.c
                    public d a(com.bytedance.sdk.component.d.b.c cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeL = interceptable2.invokeL(1048576, this, cVar)) != null) {
                            return (d) invokeL.objValue;
                        }
                        ab abVar = null;
                        HashMap hashMap = null;
                        try {
                            ab b2 = new w().a(new z.a().a(cVar.a()).a().d()).b();
                            try {
                                if (cVar.b()) {
                                    s g2 = b2.g();
                                    hashMap = new HashMap();
                                    int a2 = g2.a();
                                    for (int i2 = 0; i2 < a2; i2++) {
                                        String a3 = g2.a(i2);
                                        String b3 = g2.b(i2);
                                        if (a3 != null) {
                                            hashMap.put(a3, b3);
                                        }
                                    }
                                }
                                d dVar = new d(b2.c(), b2.h().e(), "", hashMap);
                                if (b2 != null) {
                                    try {
                                        b2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                return dVar;
                            } catch (Throwable th) {
                                th = th;
                                abVar = b2;
                                try {
                                    j.d("ImageLoaderWrapper", th.getMessage());
                                    d dVar2 = new d(0, th, "net failed");
                                    if (abVar != null) {
                                        try {
                                            abVar.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return dVar2;
                                } catch (Throwable th2) {
                                    if (abVar != null) {
                                        try {
                                            abVar.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }).a());
            }
        }

        public static e b(com.bytedance.sdk.openadsdk.core.e.l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, lVar)) == null) ? a(l.a(lVar.a()).a(lVar.b()).b(lVar.c()).a(lVar.g())) : (e) invokeL.objValue;
        }

        public static e a(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) ? n.a() ? eVar.a(new b()) : eVar : (e) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f31208a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public long f31209b;

        /* renamed from: c  reason: collision with root package name */
        public long f31210c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31211d;

        /* renamed from: e  reason: collision with root package name */
        public String f31212e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-492560455, "Lcom/bytedance/sdk/openadsdk/g/a$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-492560455, "Lcom/bytedance/sdk/openadsdk/g/a$b;");
            }
        }

        public b() {
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
            this.f31209b = 0L;
            f31208a++;
            this.f31212e = "image_request_" + f31208a;
        }

        private String c(String str, com.bytedance.sdk.component.d.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, aVar)) == null) {
                if (str != null) {
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1867169789:
                            if (str.equals("success")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case -1584526165:
                            if (str.equals("raw_cache")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case -1428113824:
                            if (str.equals("disk_cache")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -1335717394:
                            if (str.equals("decode")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1281977283:
                            if (str.equals(com.alipay.sdk.util.e.f1966a)) {
                                c2 = '\t';
                                break;
                            }
                            break;
                        case -1076854124:
                            if (str.equals("check_duplicate")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1017400004:
                            if (str.equals("memory_cache")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1478448621:
                            if (str.equals("net_request")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 1718821013:
                            if (str.equals("generate_key")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 2067979407:
                            if (str.equals("cache_policy")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            return "查询缓存策略";
                        case 1:
                            return "解码";
                        case 2:
                            return "检查重复请求";
                        case 3:
                            return "查询Bitmap内存缓存";
                        case 4:
                            return "查询RAW内存缓存";
                        case 5:
                            return "查询文件缓存";
                        case 6:
                            return "生成KEY:" + aVar.e();
                        case 7:
                            return "请求网络";
                        case '\b':
                            return "成功";
                        case '\t':
                            return "失败";
                        default:
                            return str;
                    }
                }
                return str;
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.bytedance.sdk.component.d.k
        public void a(String str, com.bytedance.sdk.component.d.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
                if (!this.f31211d) {
                    j.b("ImageLoaderWrapper", "start " + this.f31212e + " request:" + aVar.a() + ", width:" + aVar.h() + ",height:" + aVar.i());
                    this.f31211d = true;
                }
                this.f31209b = System.currentTimeMillis();
                j.b("ImageLoaderWrapper", this.f31212e + " 开始:" + c(str, aVar));
            }
        }

        @Override // com.bytedance.sdk.component.d.k
        public void b(String str, com.bytedance.sdk.component.d.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f31209b;
                this.f31210c += currentTimeMillis;
                j.b("ImageLoaderWrapper", this.f31212e + " 结束:" + c(str, aVar) + ",耗时：" + currentTimeMillis + " ms， 总计：" + this.f31210c + " ms. url" + Part.CRLF);
            }
        }
    }

    public static e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? C0351a.b(str) : (e) invokeL.objValue;
    }

    public static e a(com.bytedance.sdk.openadsdk.core.e.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lVar)) == null) ? C0351a.b(lVar) : (e) invokeL.objValue;
    }
}
